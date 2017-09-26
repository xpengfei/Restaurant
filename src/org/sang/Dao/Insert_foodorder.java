package org.sang.Dao;

import org.sang.Beans.Foodorder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by xpengfei on 2017/5/18.
 */
@Repository
public class Insert_foodorder {
    @Resource
    JdbcTemplate jdbcTemplate;
//    添加订单信息
    public int add_foodorder(Foodorder foodorder){
        return jdbcTemplate.update("INSERT INTO foodorder(foodId,userId,foodNumber,sellerId,create_date,getFoodTime,isFinish,foodCode) VALUES (?,?,?,?,?,?,?,?)",
                foodorder.getFoodid(),foodorder.getUserid(),foodorder.getFoodnumber(),foodorder.getSellerid(),foodorder.getCreate_date(),foodorder.getGetfoodtime(),foodorder.getIsfinish(),foodorder.getFoodcode());

    }
}
