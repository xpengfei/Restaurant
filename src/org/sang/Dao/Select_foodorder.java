package org.sang.Dao;

import org.sang.Beans.Foodorder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by xpengfei on 2017/5/17.
 */
@Repository
public class Select_foodorder {
    @Resource
    JdbcTemplate jdbcTemplate;
//    通过id查询数据，返回值是唯一的；
    public Foodorder select_by_Id_Re_All(int id) {
        String sql = "SELECT * FROM foodorder    WHERE id=" + id + " order by id desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
        Map foodorder_map = (Map) rows.get(0);
        Foodorder foodorder=new Foodorder();
        sql = "" +foodorder_map.get("id");
        foodorder.setId(Long.valueOf(sql));
        sql = "" + foodorder_map.get("foodId");
        foodorder.setFoodid(Long.valueOf(sql));
        sql = "" +foodorder_map.get("userId");
        foodorder.setUserid(sql);
        sql = "" + foodorder_map.get("foodNumber");
        foodorder.setFoodnumber(Long.valueOf(sql));
        sql = "" +foodorder_map.get("sellerId");
        foodorder.setSellerid(Long.valueOf(sql));
        sql = "" + foodorder_map.get("create_date");
        foodorder.setCreate_date(sql);
        sql = "" +foodorder_map.get("getFoodTime");
        foodorder.setGetfoodtime(sql);
        sql = "" + foodorder_map.get("isFinish");
        foodorder.setIsfinish(Long.valueOf(sql));
        sql = "" + foodorder_map.get("foodCode");
        foodorder.setFoodcode(sql);
        return foodorder;

    }
    //    通过foodId查询数据，返回值是唯一的；
    public Foodorder  select_by_foodId_Re_All(int foodId) {
        String sql = "SELECT * FROM foodorder   WHERE foodId=" + foodId+ " order by id desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
        Map foodorder_map = (Map) rows.get(0);
        Foodorder foodorder=new Foodorder();
        sql = "" +foodorder_map.get("id");
        foodorder.setId(Long.valueOf(sql));
        sql = "" + foodorder_map.get("foodId");
        foodorder.setFoodid(Long.valueOf(sql));
        sql = "" +foodorder_map.get("userId");
        foodorder.setUserid(sql);
        sql = "" + foodorder_map.get("foodNumber");
        foodorder.setFoodnumber(Long.valueOf(sql));
        sql = "" +foodorder_map.get("sellerId");
        foodorder.setSellerid(Long.valueOf(sql));
        sql = "" + foodorder_map.get("create_date");
        foodorder.setCreate_date(sql);
        sql = "" +foodorder_map.get("getFoodTime");
        foodorder.setGetfoodtime(sql);
        sql = "" + foodorder_map.get("isFinish");
        foodorder.setIsfinish(Long.valueOf(sql));
        sql = "" + foodorder_map.get("foodCode");
        foodorder.setFoodcode(sql);
        return foodorder;
    }
    //    通过userId查询数据，返回值是唯一的；
    public List<Foodorder>  select_by_userId_Re_All(String userId) {
        String sql = "SELECT * FROM foodorder   WHERE userId='" + userId+ "'order by id desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List<Foodorder>result=new ArrayList<>();
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map foodorder_map = (Map) iterator.next();
            Foodorder foodorder=new Foodorder();
            sql = "" +foodorder_map.get("id");
            foodorder.setId(Long.valueOf(sql));
            sql = "" + foodorder_map.get("foodId");
            foodorder.setFoodid(Long.valueOf(sql));
            sql = "" +foodorder_map.get("userId");
            foodorder.setUserid(sql);
            sql = "" + foodorder_map.get("foodNumber");
            foodorder.setFoodnumber(Long.valueOf(sql));
            sql = "" +foodorder_map.get("sellerId");
            foodorder.setSellerid(Long.valueOf(sql));
            sql = "" + foodorder_map.get("create_date");
            foodorder.setCreate_date(sql);
            sql = "" +foodorder_map.get("getFoodTime");
            foodorder.setGetfoodtime(sql);
            sql = "" + foodorder_map.get("isFinish");
            foodorder.setIsfinish(Long.valueOf(sql));
            sql = "" + foodorder_map.get("foodCode");
            foodorder.setFoodcode(sql);
            result.add(foodorder);
        }
        return result;

    }
    //    通过sellerId查询订单，返回值有多条；
    public List<Foodorder>  select_by_sellerId_Re_All(int sellerId) {
        List<Foodorder>result=new ArrayList<>();
        String sql = "SELECT * FROM foodorder   WHERE sellerId=" + sellerId+ " order by id desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map foodorder_map = (Map) iterator.next();
            Foodorder foodorder=new Foodorder();
            sql = "" +foodorder_map.get("id");
            foodorder.setId(Long.valueOf(sql));
            sql = "" + foodorder_map.get("foodId");
            foodorder.setFoodid(Long.valueOf(sql));
            sql = "" +foodorder_map.get("userId");
            foodorder.setUserid(sql);
            sql = "" + foodorder_map.get("foodNumber");
            foodorder.setFoodnumber(Long.valueOf(sql));
            sql = "" +foodorder_map.get("sellerId");
            foodorder.setSellerid(Long.valueOf(sql));
            sql = "" + foodorder_map.get("create_date");
            foodorder.setCreate_date(sql);
            sql = "" +foodorder_map.get("getFoodTime");
            foodorder.setGetfoodtime(sql);
            sql = "" + foodorder_map.get("isFinish");
            foodorder.setIsfinish(Long.valueOf(sql));
            sql = "" + foodorder_map.get("foodCode");
            foodorder.setFoodcode(sql);
            result.add(foodorder);
        }
    return result;
    }

    //    通过sellerId查询未完成订单，返回值有多条；
    public List<Foodorder>  select_by_sellerId_Re_All_unfinish(int sellerId) {
        List<Foodorder>result=new ArrayList<>();
        String sql = "SELECT * FROM foodorder   WHERE sellerId=" + sellerId+ ""+" and isFinish=0 order by id desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map foodorder_map = (Map) iterator.next();
            Foodorder foodorder=new Foodorder();
            sql = "" +foodorder_map.get("id");
            foodorder.setId(Long.valueOf(sql));
            sql = "" + foodorder_map.get("foodId");
            foodorder.setFoodid(Long.valueOf(sql));
            sql = "" +foodorder_map.get("userId");
            foodorder.setUserid(sql);
            sql = "" + foodorder_map.get("foodNumber");
            foodorder.setFoodnumber(Long.valueOf(sql));
            sql = "" +foodorder_map.get("sellerId");
            foodorder.setSellerid(Long.valueOf(sql));
            sql = "" + foodorder_map.get("create_date");
            foodorder.setCreate_date(sql);
            sql = "" +foodorder_map.get("getFoodTime");
            foodorder.setGetfoodtime(sql);
            sql = "" + foodorder_map.get("isFinish");
            foodorder.setIsfinish(Long.valueOf(sql));
            sql = "" + foodorder_map.get("foodCode");
            foodorder.setFoodcode(sql);
            result.add(foodorder);
        }
        return result;
    }

    //    通过isFinish查询数据，返回多条数据；
    public List<Foodorder> select_by_isFinish_Re_All(int isFinish) {
       List<Foodorder>result=new ArrayList<>();
        String sql = "SELECT * FROM foodorder WHERE isFinish=" + isFinish+ " order by id desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map foodorder_map = (Map) iterator.next();
            Foodorder foodorder=new Foodorder();
            sql = "" +foodorder_map.get("id");
            foodorder.setId(Long.valueOf(sql));
            sql = "" + foodorder_map.get("foodId");
            foodorder.setFoodid(Long.valueOf(sql));
            sql = "" +foodorder_map.get("userId");
            foodorder.setUserid(sql);
            sql = "" + foodorder_map.get("foodNumber");
            foodorder.setFoodnumber(Long.valueOf(sql));
            sql = "" +foodorder_map.get("sellerId");
            foodorder.setSellerid(Long.valueOf(sql));
            sql = "" + foodorder_map.get("create_date");
            foodorder.setCreate_date(sql);
            sql = "" +foodorder_map.get("getFoodTime");
            foodorder.setGetfoodtime(sql);
            sql = "" + foodorder_map.get("isFinish");
            foodorder.setIsfinish(Long.valueOf(sql));
            sql = "" + foodorder_map.get("foodCode");
            foodorder.setFoodcode(sql);
            result.add(foodorder);
        }
        return result;

    }
}
