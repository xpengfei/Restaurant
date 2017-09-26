package org.sang.Controller;


import org.sang.Beans.Foodorder;
import org.sang.Beans.OrderBean;
import org.sang.Dao.Select_food;
import org.sang.Service.FoodOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Komachi on 2017/5/19.
 */
@Controller
public class getOrderListController {
    @Resource
    FoodOrderService foodOrderService;
    @Resource
    Select_food select_food;

    @RequestMapping("/Restaurant/getOrderList")
    @ResponseBody
    public List<OrderBean> user(HttpServletRequest req) {
        //获取session
        HttpSession session = req.getSession();
        //获取登录用户的ID
        int sellerid = (int)session.getAttribute("sellerId");

        List<Foodorder> orderList = foodOrderService.getALL(sellerid);
        List<OrderBean> orderBeanList = new ArrayList<OrderBean>();

        for(int i=0;i<orderList.size();i++)
        {
            //获取创建orderBean的参数
            Foodorder foodorder = orderList.get(i);
            int foodid = Integer.parseInt(String.valueOf(foodorder.getFoodid()));
            String foodname = select_food.select_by_Id_Re_foodName(foodid);
            String foodimg = select_food.select_by_Id_Re_foodImg(foodid);
            //创建orderBean
            OrderBean orderBean = new OrderBean(foodorder.getFoodid(),foodname,foodorder.getFoodnumber(),foodorder.getGetfoodtime(),foodimg);
            //将orderBean加入到list中
            orderBeanList.add(orderBean);
        }

        return orderBeanList;
    }
}
