package org.sang.Controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.sang.Beans.ResponseBean;
import org.sang.Beans.Seller;
import org.sang.Dao.Update_seller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.List;
import java.util.UUID;

/**
 * Created by Komachi on 2017/5/19.
 */
@Controller
public class updatesellerController {
    @Resource
    Update_seller update_seller;

    @RequestMapping("/Restaurant/updateseller")
    @ResponseBody
    public ResponseBean register(HttpServletRequest req) throws UnsupportedEncodingException {

        //获取session
        HttpSession session = req.getSession();
        //获取登录用户的ID
        int sellerid = (int)session.getAttribute("sellerId");
        int result = 0;

        req.setCharacterEncoding("UTF-8");

        String phonenumber = req.getParameter("phonenumber");
        String wname = req.getParameter("wname");

        //检测提交的数据中是否存在非法危险字符
        String []danger = {"/","<",">",",","(",")","|","&"};
        int len = danger.length;
        boolean judge = false;
        for(int i=0;i<len;i++)
        {
            if(phonenumber != null)
                if(phonenumber.contains(danger[i]))
                {
                   judge = true;
                   break;
                }
            if(wname != null)
             if(wname.contains(danger[i]))
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

        try {
            if (phonenumber != null) {
                result = update_seller.update_phoneNumber_by_id(phonenumber,sellerid);
            } else if (wname != null) {
                result = update_seller.update_windowName_by_id(wname,sellerid);
            }

            ResponseBean responseBean = new ResponseBean();
            if (result == 1) {
                //注册成功
                responseBean.setState("ok");
                responseBean.setMsg("修改成功");
            } else {
                responseBean.setState("error");
                responseBean.setMsg("修改失败");
            }

            return responseBean;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
