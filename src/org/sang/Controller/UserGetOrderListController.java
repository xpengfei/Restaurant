package org.sang.Controller;

import org.sang.Beans.Food;
import org.sang.Beans.Foodorder;
import org.sang.Beans.OrderBean;
import org.sang.Beans.UserOrderBean;
import org.sang.Dao.Select_food;
import org.sang.Dao.Select_foodorder;
import org.sang.Dao.Select_seller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Komachi on 2017/5/21.
 */
@Controller
public class UserGetOrderListController {
    @Resource
    Select_food select_food;
    @Resource
    Select_foodorder select_foodorder;
    @Resource
    Select_seller select_seller;

    @RequestMapping("/user/getOrderList")
    @ResponseBody
    public List<UserOrderBean> getFoodList(HttpServletRequest req){
        //获取session
        HttpSession session = req.getSession();
        //获取登录用户的ID
        int userid = (int)session.getAttribute("userId");
       // int userid = 222;

        List<Foodorder> orderList = select_foodorder.select_by_userId_Re_All(String.valueOf(userid));
        List<UserOrderBean> orderBeanList = new ArrayList<UserOrderBean>();

        for(int i=0;i<orderList.size();i++)
        {
            //获取创建orderBean的参数
            Foodorder foodorder = orderList.get(i);
            int foodid = Integer.parseInt(String.valueOf(foodorder.getFoodid()));
            Food food = select_food.select_by_Id_Re_All(foodid);
            String sellername = select_seller.select_by_Id_Re_windowName(Integer.parseInt(String.valueOf(foodorder.getSellerid())));
            //创建orderBean
            UserOrderBean userOrderBean = new UserOrderBean((long)foodid,food.getFoodname(),foodorder.getFoodnumber(),foodorder.getGetfoodtime(),food.getFoodimg(),food.getFoodprice(),food.getPricetype(),sellername,foodorder.getId());
            //将orderBean加入到list中
            System.out.println(userOrderBean.getId());
            orderBeanList.add(userOrderBean);
        }

        return orderBeanList;
    }
}
