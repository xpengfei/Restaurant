package org.sang.Controller;


import org.sang.Beans.Comment;
import org.sang.Beans.Food;
import org.sang.Beans.Foodorder;
import org.sang.Service.FoodOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Komachi on 2017/5/19.
 */
@Controller
public class testDao {
    @Resource
    FoodOrderService foodOrderService;
    @Resource
    getAllFoodListController getAllFoodListController;
    @Resource
    getCommentListController getCommentListController;

    @RequestMapping("/hello")
    @ResponseBody
    public void hello(HttpServletRequest req){

        //return getCommentListController.getCommentList(req);
       // return getAllFoodListController.getAllFoodList();
        //List<String> re = selectfoodDao.select_by_sellerId_Re_All(321);
        //re += selectfoodDao.select_by_Id_Re_foodName(123)+" ";
        //re += selectfoodDao.select_by_Id_Re_foodPrice(123)+" ";
       // re += selectfoodDao.select_by_Id_Re_foodType(123)+" ";
        //re += selectfoodDao.select_by_Id_Re_food(123);
        //return selectfoodDao.select_by_sellerId_Re_All(321);
    }
}
