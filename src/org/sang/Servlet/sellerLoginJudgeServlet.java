package org.sang.Servlet;

import org.sang.Beans.ResponseBean;
import org.sang.Dao.Select_seller;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xpengfei on 2017/5/20.
 */
public class sellerLoginJudgeServlet extends HttpServlet{

    /*
     *需要配置一下servlet
     *判断seller是否登录成功，如果登录成功则获取其id，登录状态
     * ，将值传入传入session，登陆失败id值为0，根据sellerId可以得知state
     */
    private static int sellerId;
    private static String state;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
//        调用select_by_phoneNumber_Re_password获取数据库中存储的加密后的密码
        System.out.println("start2!!!");
        Select_seller select_seller=new Select_seller();
        String getSqlPwd=select_seller.select_by_phoneNumber_Re_password(phonenumber);
        System.out.println("start2!!!");
//       session中传入的state便于ResponseBean中设置msg；
        if(getSqlPwd.equals(password)){
            System.out.println("start5!!!");
//            登陆成功，获取sellerId传到session中,根据传的result可以用于提示用户
            String id_str = select_seller.select_by_phoneNumber_Re_id(phonenumber);
            sellerId = Integer.parseInt(id_str);
            state="OK";
            System.out.println("start6!!!");
            HttpSession session=req.getSession();
            session.setAttribute("sellerId",sellerId);
            session.setAttribute("result","OK");
//            登陆成功跳转到后台管理界面；
            System.out.println("start7!!!");
            resp.sendRedirect("/SellerIndex.html");
            System.out.println("start8!!!");

        }else{
           // System.out.println("start6!!!");
//            登陆失败，将sellerId传入session，赋值为0；返回登录界面
            HttpSession session=req.getSession();
            session.setAttribute("sellerId",0);
            session.setAttribute("result","Error");
            state="Error";
            resp.sendRedirect("/SellerLogin.html");
        }
    }
//    返回sellerId
    public int re_sellerId(){
        return sellerId;
    }
//    返回responseBean;
    public ResponseBean re_responseBean(){
        ResponseBean responseBean=new ResponseBean();
        if(sellerId!=0){
            responseBean.setState("ok");
            responseBean.setMsg("登陆成功！");
        }else{
            responseBean.setState("error");
            responseBean.setMsg("登陆失败！");
        }
        return responseBean;
    }
}
