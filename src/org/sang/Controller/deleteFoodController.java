package org.sang.Controller;

import org.sang.Beans.ResponseBean;
import org.sang.Dao.Update_food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by Komachi on 2017/5/19.
 */
@Controller
public class deleteFoodController {
    @Resource
    Update_food update_food;

    @RequestMapping(value = "/Restaurant/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean deleteFood(HttpServletRequest req) throws UnsupportedEncodingException{
        int result = 0;
        //获取要删除的id
        int deleteid = 0;
        String str = req.getParameter("deleteId");
        //System.out.println(str);
        //System.out.println("haha");
        //处理获取的id字符串，得到若干个id值并执行删除
        String deleteid_str = "";
        for(int i=0;i<str.length();i++) {
             if(str.charAt(i) != ',')
                deleteid_str += str.charAt(i);
             else{
                 deleteid = Integer.parseInt(deleteid_str);
                 //执行删除操作
                 result = update_food.delete_by_id(deleteid);
                 //初始化
                 deleteid_str = "";
                 //System.out.println(deleteid);
             }
        }


        //返回执行结果
        ResponseBean responseBean = new ResponseBean();
        if (result == 1) {
            //删除成功
            responseBean.setState("ok");
            responseBean.setMsg("删除成功");
        } else {
            responseBean.setState("error");
            responseBean.setMsg("删除失败");
        }

        return  responseBean;
    }
}
