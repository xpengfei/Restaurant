package org.sang.Controller;

import org.sang.Beans.FoodListRespBean;
import org.sang.Service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Komachi on 2017/5/19.
 */
@Controller
public class getFoodListController {
    @Resource
    FoodService foodService;
    @RequestMapping("/Restaurant/getFoodList")
    @ResponseBody
    public FoodListRespBean getFoodByPage(Long page, Long rows,HttpServletRequest req) {
//        获取前端页面的显示条件，几页、每页显示多少条信息1!
        System.out.println("page:"+page);
        System.out.println("rows:"+rows);
        //获取session
        HttpSession session = req.getSession();
        //获取登录用户的ID
        int sellerid = (int)session.getAttribute("sellerId");
        System.out.println("-------"+sellerid);
        FoodListRespBean bean = foodService.getFoodByPage(page,rows,sellerid);
        return bean;
    }
//    可以获取session
//    public List<Food> user(HttpServletRequest req) {
//    protected static void get_sellerID(HttpServletRequest req) {
//    //获取session
//        HttpSession session = req.getSession();
//        //获取登录用户的ID
//        int sellerid = (int)session.getAttribute("sellerId");
//        System.out.println("-------"+sellerid);
//    }
}
