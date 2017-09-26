package org.sang.Controller;

import org.sang.Beans.User_manage;
import org.sang.Dao.Insert_User_manage;
import org.sang.Dao.Select_User_manage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Komachi on 2017/5/21.
 */
@Controller
public class userController {
    @Resource
    Select_User_manage select_user_manage;
    @Resource
    Insert_User_manage insert_user_manage;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public void register(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {

        //获取out对象
        PrintWriter out;
        try {
            out = resp.getWriter();
           // out.print("<script language='javascript'>window.alert('用户名或密码错误');");
            //out.print("window.location.href='UserReg.html';</script>");

            req.setCharacterEncoding("UTF-8");
            //获取参数
            String phonenumber = req.getParameter("username");
            String password = req.getParameter("passwd");
            String email = req.getParameter("email");

        User_manage user_manage = new User_manage();
        user_manage.setEmail(email);
        user_manage.setPassword(password);
        user_manage.setPhonenumber(phonenumber);
        user_manage.setState((long)0);

        //检测提交的数据中是否存在非法危险字符
        String []danger = {"/","<",">",",","(",")","|","&"};
        int len = danger.length;
        boolean judge = false;
        for(int i=0;i<len;i++)
        {
            if(user_manage.getEmail().contains(danger[i]))
            {
                judge = true;
                break;
            }
            if(user_manage.getPassword().contains(danger[i])) {
                judge = true;
                break;
            }
            if(user_manage.getPhonenumber().contains(danger[i]))
            {
                judge = true;
                break;
            }
        }
        if(judge){
            out.print("<script language='javascript'>window.alert('输入存在危险字符');");
            out.print("window.location.href='UserReg.html';</script>");
        }
           // System.out.println("21111");

            //密码采用MD5加密
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(user_manage.getPassword().getBytes());
            StringBuilder sb = new StringBuilder(40);
            for(byte x:bs)
            {
                if((x&0xff)>>4 == 0)
                    sb.append("0").append(Integer.toHexString(x&0xff));
                else
                    sb.append(Integer.toHexString(x&0xff));
            }
            String pwmd5 = sb.toString();//加密后的密码
            user_manage.setPassword(pwmd5);

            //查数据表检测手机是否已被注册
            String result;
            result = select_user_manage.select_by_phonenumber_Re_password(user_manage.getPhonenumber());
            System.out.println("21111");
            if(result != null)
            {
                out.print("<script language='javascript'>window.alert('该手机号已被注册');");
                out.print("window.location.href='UserReg.html';</script>");
            }

            System.out.println("31111");

            int reg = insert_user_manage.add_user(user_manage);
            if (reg == 1) {
                //注册成功
                out.print("<script language='javascript'>window.alert('注册成功');");
                out.print("window.location.href='UserLogin.html';</script>");
            } else {
                out.print("<script language='javascript'>window.alert('注册失败');");
                out.print("window.location.href='UserLogin.html';</script>");
            }
        }catch (Exception e){}
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public void dologin(HttpServletRequest req, HttpServletResponse resp){
        //获取out对象
        try {
            PrintWriter out = resp.getWriter();

        String phonenumber=req.getParameter("username");
        String password=req.getParameter("passwd");
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
        String getSqlPwd=select_user_manage.select_by_phonenumber_Re_password(phonenumber);
//       session中传入的state便于ResponseBean中设置msg；
        if(getSqlPwd.equals(password)){
//            登陆成功，获取sellerId传到session中,根据传的result可以用于提示用户
            String id_str = select_user_manage.select_by_phoneNumber_Re_id(phonenumber);
            int sellerId = Integer.parseInt(id_str);
            HttpSession session=req.getSession();
            session.setAttribute("userId",sellerId);
            session.setAttribute("result","userOK");
//            登陆成功跳转
            out.print("<script language='javascript'>window.alert('登录成功');");
            out.print("window.location.href='Userindex.html';</script>");

        }else{
            // System.out.println("start6!!!");
//            登陆失败，将sellerId传入session，赋值为0；返回登录界面
            HttpSession session=req.getSession();
            session.setAttribute("userId",0);
            session.setAttribute("result","userError");

            //登陆失败跳转回登录界面
            out.print("<script language='javascript'>window.alert('登录失败');");
            out.print("window.location.href='UserLogin.html';</script>");

        }
        }
        catch (Exception e){e.printStackTrace();}
    }
}
