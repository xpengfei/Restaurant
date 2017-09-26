package org.sang.Controller;

import org.sang.Beans.ResponseBean;
import org.sang.Beans.Seller;
import org.sang.Dao.Select_seller;
import org.sang.Service.SellerService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Komachi on 2017/5/19.
 */
@Controller
@RequestMapping("/admin")//窄化请求
public class adminController {
    @Resource
    SellerService sellerService;
    @Resource
    Select_seller select_seller;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean register(HttpServletRequest req) throws UnsupportedEncodingException{
        req.setCharacterEncoding("UTF-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        //设置上传文件的大小限制
        servletFileUpload.setFileSizeMax(30 * 1024 * 1024);
        servletFileUpload.setSizeMax(50 * 1024 * 1024);
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            Seller seller = new Seller();
            for (FileItem fileItem : fileItems) {
                //System.out.println("start3!!\n");
                if (!(fileItem.isFormField())) {
                    //上传的是文件
                    UUID uuid = UUID.randomUUID();
                    //获取文件名称
                    String fileName = fileItem.getName();
                    fileName = uuid + "_" + fileName;
                    String windowimg = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/img/" + fileName;
                    seller.setWindowimg(windowimg);
                    //System.out.println(windowimg);
                    fileItem.write(new File(req.getServletContext().getRealPath("/img"), fileName));
                } else {
                    String fieldName = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    if ("phoneNumber".equals(fieldName)) {
                        seller.setPhonenumber(value);
                    } else if ("windowImg".equals(fieldName)) {
                        seller.setWindowimg(value);
                    } else if ("password".equals(fieldName)) {
                        seller.setPassword(value);
                    } else if ("username".equals(fieldName)) {
                        seller.setSellername(value);
                    } else if ("windowName".equals(fieldName)) {
                        seller.setWindowname(value);
                    }
                }
            }

            seller.setState((long)0);

            //检测提交的数据中是否存在非法危险字符
            String []danger = {"/","<",">",",","(",")","|","&"};
            int len = danger.length;
            boolean judge = false;
            for(int i=0;i<len;i++)
            {
                if(seller.getSellername().contains(danger[i]))
                {
                    judge = true;
                    break;
                }
                if(seller.getPassword().contains(danger[i]))
                {
                    judge = true;
                    break;
                }
                if(seller.getPhonenumber().contains(danger[i]))
                {
                    judge = true;
                    break;
                }
                if(seller.getWindowname().contains(danger[i]))
                {
                    judge = true;
                    break;
                }
            }
            if(judge){
                ResponseBean responseBean = new ResponseBean();
                responseBean.setState("error");
                responseBean.setMsg("输入内容存在非法字符，请仔细检查");
                return  responseBean;
            }

            //密码采用MD5加密
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(seller.getPassword().getBytes());
            StringBuilder sb = new StringBuilder(40);
            for(byte x:bs)
            {
                if((x&0xff)>>4 == 0)
                    sb.append("0").append(Integer.toHexString(x&0xff));
                else
                    sb.append(Integer.toHexString(x&0xff));
            }
            String pwmd5 = sb.toString();//加密后的密码
            seller.setPassword(pwmd5);

            //查数据表检测手机是否已被注册
            String result;
            result = select_seller.select_by_phoneNumber_Re_id(seller.getPhonenumber());
            if(result != null)
            {
                ResponseBean responseBean = new ResponseBean();
                responseBean.setState("error");
                responseBean.setMsg("该手机号码已被注册");
                return  responseBean;
            }

            int reg = sellerService.register(seller);
            ResponseBean responseBean = new ResponseBean();
            if (reg == 1) {
                //注册成功
                responseBean.setState("ok");
                responseBean.setMsg("注册成功");
            } else {
                responseBean.setState("error");
                responseBean.setMsg("注册失败");
            }

            return responseBean;
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean dologin(HttpServletRequest req) throws UnsupportedEncodingException{
        String phonenumber=req.getParameter("phonenumber");
        String password=req.getParameter("password");
//        密码进行MD5加密；
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            byte[]bs=md5.digest(password.getBytes());
            StringBuilder stringBuilder=new StringBuilder(40);
            for (byte x:bs){
                if ((x&0xff)>>4==0){
                    stringBuilder.append("0").append(Integer.toHexString(x&0xff));
                }else{
                    stringBuilder.append(Integer.toHexString(x&0xff));
                }
            }
//            获得原密码经MD5加密后的密码；
            password=stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //  调用select_by_phoneNumber_Re_password获取数据库中存储的加密后的密码
        String getSqlPwd=select_seller.select_by_phoneNumber_Re_password(phonenumber);
//       session中传入的state便于ResponseBean中设置msg；
        if(getSqlPwd.equals(password)){
//            登陆成功，获取sellerId传到session中,根据传的result可以用于提示用户
            String id_str = select_seller.select_by_phoneNumber_Re_id(phonenumber);
            int sellerId = Integer.parseInt(id_str);
            HttpSession session=req.getSession();
            session.setAttribute("sellerId",sellerId);
            session.setAttribute("result","OK");
//            登陆成功返回登录状态
            ResponseBean responseBean = new ResponseBean();
            responseBean.setState("ok");
            responseBean.setMsg("登录成功");

            return responseBean;
        }else{
            // System.out.println("start6!!!");
//            登陆失败，将sellerId传入session，赋值为0；返回登录界面
            HttpSession session=req.getSession();
            session.setAttribute("sellerId",0);
            session.setAttribute("result","Error");

            ResponseBean responseBean = new ResponseBean();
            responseBean.setState("error");
            responseBean.setMsg("登录失败");

            return responseBean;
        }

    }

}
