package org.sang.Dao;

import org.sang.Beans.Food;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by xpengfei on 2017/5/18.
 */
@Repository
public class Insert_food {
    @Resource
    JdbcTemplate jdbcTemplate;

    public int add_food(Food food ){
//        String sql="INSERT INTO food(foodImg,foodPrice,foodName,priceType)" +
//                "values("+food.getFoodimg()+","+food.getFoodprice()+","+food.getFoodname()+","+food.getPricetype()+")";
        return jdbcTemplate.update("INSERT INTO food(foodImg,foodPrice,foodName,priceType,sellerId) VALUES (?,?,?,?,?)",
                food.getFoodimg(),food.getFoodprice(),food.getFoodname(),food.getPricetype(),food.getSellerid());
    }
}
