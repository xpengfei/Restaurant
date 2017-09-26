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
import org.springframework.web.bind.annotation.RequestMethod;
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
public class updateImgController {
    @Resource
    Update_seller update_seller;

    @RequestMapping(value = "/Restaurant/updateImg", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean updateImg(HttpServletRequest req) throws UnsupportedEncodingException {
        //获取session
        HttpSession session = req.getSession();
        //获取登录用户的ID
        int sellerid = (int)session.getAttribute("sellerId");
        int result = 0;

        req.setCharacterEncoding("UTF-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        //设置上传文件的大小限制
        servletFileUpload.setFileSizeMax(30 * 1024 * 1024);
        servletFileUpload.setSizeMax(50 * 1024 * 1024);
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem fileItem : fileItems) {
                //System.out.println("start3!!\n");
                if (!(fileItem.isFormField())) {
                    //上传的是文件
                    UUID uuid = UUID.randomUUID();
                    //获取文件名称
                    String fileName = fileItem.getName();
                    fileName = uuid + "_" + fileName;
                    String windowimg = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/img/" + fileName;
                    result = update_seller.update_windowImg_by_id(windowimg,sellerid);
                    //System.out.println(windowimg);
                    fileItem.write(new File(req.getServletContext().getRealPath("/img"), fileName));
                }
            }

            ResponseBean responseBean = new ResponseBean();
            if (result == 1) {
                //修改成功
                responseBean.setState("ok");
                responseBean.setMsg("修改店铺图片成功");
            } else {
                responseBean.setState("error");
                responseBean.setMsg("修改店铺图片失败");
            }

            return responseBean;
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
