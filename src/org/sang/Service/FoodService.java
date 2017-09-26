package org.sang.Service;

import org.sang.Beans.Food;
import org.sang.Beans.FoodListRespBean;
import org.sang.Dao.FoodDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Komachi on 2017/5/19.
 */
@Service
public class FoodService {
    @Resource
//    Select_food select_food;
//    //int sellid = 321;       //卖家id
//    public List<Food> getALL(int sellerid){
//        return select_food.select_by_sellerId_Re_All(sellerid);
//    }
    FoodDao foodDao;
    public FoodListRespBean getFoodByPage(Long page, Long rows,int sellerid) {
        FoodListRespBean foodListRespBean = new FoodListRespBean();

        List<Food> foodByPage = foodDao.getFoodByPage(page,rows,sellerid);
        int foodCount = foodDao.getFoodCount(sellerid);
        foodListRespBean.setRows(foodByPage);
        foodListRespBean.setTotal(foodCount + "");
        return foodListRespBean;
    }
}
