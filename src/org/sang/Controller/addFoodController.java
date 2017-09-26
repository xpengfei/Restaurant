package org.sang.Controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.sang.Beans.Food;
import org.sang.Beans.ResponseBean;
import org.sang.Beans.Seller;
import org.sang.Dao.Insert_food;
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
public class addFoodController {
    @Resource
    Insert_food insert_food;

    @RequestMapping(value = "/Restaurant/addFood", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean addFood(HttpServletRequest req) throws UnsupportedEncodingException {
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
            Food food = new Food();
            for (FileItem fileItem : fileItems) {
                //System.out.println("start3!!\n");
                if (!(fileItem.isFormField())) {
                    //上传的是文件
                    UUID uuid = UUID.randomUUID();
                    //获取文件名称
                    String fileName = fileItem.getName();
                    fileName = uuid + "_" + fileName;
                    String foodimg = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/img/" + fileName;
                    food.setFoodimg(foodimg);
                    fileItem.write(new File(req.getServletContext().getRealPath("/img"), fileName));
                } else {
                    String fieldName = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    if ("foodPrice".equals(fieldName)) {
                        food.setFoodprice(value);
                    } else if ("priceType".equals(fieldName)) {
                        food.setPricetype(value);
                    } else if ("foodName".equals(fieldName)) {
                       food.setFoodname(value);
                    }
                }
            }

            //对提交的内容进行处理转义，防SQL注入
            String def;
            def = food.getFoodprice();
            def = def.replace("<", "&lt;").replace(">", "&gt;").replace(" ", "&nbsp;").replace("\"", "&quot;").replace("\'", "&apos;").replace("/", "&frasl;");
            food.setFoodprice(def);
            def = food.getFoodname();
            def = def.replace("<", "&lt;").replace(">", "&gt;").replace(" ", "&nbsp;").replace("\"", "&quot;").replace("\'", "&apos;").replace("/", "&frasl;");
            food.setFoodname(def);
            def = food.getPricetype();
            def = def.replace("<", "&lt;").replace(">", "&gt;").replace(" ", "&nbsp;").replace("\"", "&quot;").replace("\'", "&apos;").replace("/", "&frasl;");
            food.setPricetype(def);


            food.setSellerid((long)sellerid);
            result = insert_food.add_food(food);
            ResponseBean responseBean = new ResponseBean();
            if (result == 1) {
                //插入成功
                responseBean.setState("ok");
                responseBean.setMsg("添加成功");
            } else {
                responseBean.setState("error");
                responseBean.setMsg("添加失败");
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
