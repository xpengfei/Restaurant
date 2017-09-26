package org.sang.Controller;

import org.sang.Beans.Foodorder;
import org.sang.Beans.ResponseBean;
import org.sang.Dao.Insert_foodorder;
import org.sang.Dao.Select_User_manage;
import org.sang.Dao.Select_food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Komachi on 2017/5/21.
 */
@Controller
public class OrderFoodController {
    @Resource
    Insert_foodorder insert_foodorder;
    @Resource
    Select_food select_food;

    @RequestMapping(value = "/user/orderFood",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean orderFood(HttpServletRequest req)throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        //获取session
        HttpSession session = req.getSession();
        //获取登录用户的ID
        int userid_int = (int)session.getAttribute("userId");
        //int userid_int = 222;
        String userid = String.valueOf(userid_int);

        //获取提交的数据
        String foodid_str = req.getParameter("foodId");
        String foodnumber_str = req.getParameter("foodNumber");
        String getfoodtime = req.getParameter("getFoodTime");

        //检测提交的数据中是否存在非法危险字符
        String []danger = {"/","<",">",",","(",")","|","&"};
        int len = danger.length;
        boolean judge = false;
        for(int i=0;i<len;i++)
        {
            if(foodid_str.contains(danger[i]))
            {
                judge = true;
                break;
            }
            if(foodnumber_str.contains(danger[i])) {
                judge = true;
                break;
            }
            if(getfoodtime.contains(danger[i]))
            {
                judge = true;
                break;
            }
        }
        if(judge){
            ResponseBean responseBean = new ResponseBean();
            responseBean.setState("error");
            responseBean.setMsg("输入存在危险字符");
            return responseBean;
        }

        //类型转换
        try{
        int foodid = Integer.parseInt(foodid_str);
        int foodnumber = Integer.parseInt(foodnumber_str);

        int isfinish = 0;
        Date date = new Date();
        Timestamp tt = new Timestamp(date.getTime());
        String creattime = tt.toString();
            System.out.println(foodid);
        String sellerid_str = select_food.select_by_Id_Re_sellerId(foodid);
        int sellerid = Integer.parseInt(sellerid_str);

        Foodorder foodorder = new Foodorder();
        foodorder.setCreate_date(creattime);
        foodorder.setFoodcode(foodid_str);
        foodorder.setFoodnumber((long)foodnumber);
        foodorder.setFoodid((long)foodid);
        foodorder.setGetfoodtime(getfoodtime);
        foodorder.setIsfinish((long)isfinish);
        foodorder.setUserid(userid);
        foodorder.setSellerid((long)sellerid);

        int result = insert_foodorder.add_foodorder(foodorder);
        if(result == 1){
            ResponseBean responseBean = new ResponseBean();
            responseBean.setState("ok");
            responseBean.setMsg("下单成功");
            return responseBean;
        }
        else{
            ResponseBean responseBean = new ResponseBean();
            responseBean.setState("error");
            responseBean.setMsg("下单失败");
            return responseBean;
        }
        }catch (Exception e){
            ResponseBean responseBean = new ResponseBean();
            responseBean.setState("error");
            responseBean.setMsg("输入不规范");
            return responseBean;
        }
    }
}
