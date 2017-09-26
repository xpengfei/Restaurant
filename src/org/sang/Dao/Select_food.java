package org.sang.Dao;

import org.sang.Beans.Food;
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
public class Select_food {
    @Resource
    JdbcTemplate jdbcTemplate;


//    返回含有表中所有属性的数据

    //返回全部
    public List<Food> select_by_all_Re_All() {
        List<Food>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT * FROM food order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Food food=new Food();
            Map food_map = (Map) iterator.next();
            sql = "" +food_map.get("id");
            food.setId(Long.parseLong(sql));
            sql = "" + food_map.get("foodImg");
            food.setFoodimg(sql);
            sql = "" +food_map.get("foodPrice");
            food.setFoodprice(sql);
            sql = "" + food_map.get("foodName");
            food.setFoodname(sql);
            sql = "" +food_map.get("priceType");
            food.setPricetype(sql);
            sql = "" + food_map.get("sellerId") ;
            food.setSellerid(Long.parseLong(sql));
            result.add(food);
        }
        return result;
    }

//    根据food的ID信息查找数据,food的ID是唯一的，返回一条数据
    public Food select_by_Id_Re_All(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT * FROM food   WHERE id=" + id + " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Food food=new Food();
        Map food_map = (Map) rows.get(0);
        sql = "" +food_map.get("id");
        food.setId(Long.parseLong(sql));
        sql = "" + food_map.get("foodImg");
        food.setFoodimg(sql);
        sql = "" +food_map.get("foodPrice");
        food.setFoodprice(sql);
        sql = "" + food_map.get("foodName");
        food.setFoodname(sql);
        sql = "" +food_map.get("priceType");
        food.setPricetype(sql);
        sql = "" + food_map.get("sellerId") ;
        food.setSellerid(Long.parseLong(sql));
        return food;
    }
//    根据价格信息查询数据；
    public List<Food> select_by_foodPrice_Re_All(int foodPrice) {
        List<Food>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT * FROM food  WHERE foodPrice=" +foodPrice+ " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Food food=new Food();
            Map food_map = (Map) iterator.next();
            sql = "" +food_map.get("id");
            food.setId(Long.parseLong(sql));
            sql = "" + food_map.get("foodImg");
            food.setFoodimg(sql);
            sql = "" +food_map.get("foodPrice");
            food.setFoodprice(sql);
            sql = "" + food_map.get("foodName");
            food.setFoodname(sql);
            sql = "" +food_map.get("priceType");
            food.setPricetype(sql);
            sql = "" + food_map.get("sellerId") ;
            food.setSellerid(Long.parseLong(sql));
            result.add(food);
        }
        return result;
    }
//    根据foodName查找数据信息，可以有多家店重名的情况，存在多条数据
    public List<Food> select_by_foodName_Re_All(String foodName) {
        List<Food>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT * FROM food  WHERE foodName='" + foodName + "'order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Food food=new Food();
            Map food_map = (Map) iterator.next();
            sql = "" +food_map.get("id");
            food.setId(Long.parseLong(sql));
            sql = "" + food_map.get("foodImg");
            food.setFoodimg(sql);
            sql = "" +food_map.get("foodPrice");
            food.setFoodprice(sql);
            sql = "" + food_map.get("foodName");
            food.setFoodname(sql);
            sql = "" +food_map.get("priceType");
            food.setPricetype(sql);
            sql = "" + food_map.get("sellerId") ;
            food.setSellerid(Long.parseLong(sql));
            result.add(food);
        }
        return result;
    }

    public List<Food> select_by_priceType_Re_All(String priceType) {
        List<Food>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT * FROM food  WHERE priceType='" +priceType+ "'order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Food food=new Food();
            Map food_map = (Map) iterator.next();
            sql = "" +food_map.get("id");
            food.setId(Long.parseLong(sql));
            sql = "" + food_map.get("foodImg");
            food.setFoodimg(sql);
            sql = "" +food_map.get("foodPrice");
            food.setFoodprice(sql);
            sql = "" + food_map.get("foodName");
            food.setFoodname(sql);
            sql = "" +food_map.get("priceType");
            food.setPricetype(sql);
            sql = "" + food_map.get("sellerId") ;
            food.setSellerid(Long.parseLong(sql));
            result.add(food);
        }
        return result;
    }
    //    根据sellerID查询，也存在多条数据，每个卖家会有多个商品；
    public List<Food> select_by_sellerId_Re_All(int sellerId) {
        List<Food>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT * FROM food   WHERE sellerId=" +sellerId+ " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            Food food=new Food();
            sql =""+ food_map.get("foodImg");
            food.setFoodimg(sql);
            sql =""+food_map.get("foodPrice");
            food.setFoodprice(sql);
            sql =""+ food_map.get("foodName");
            food.setFoodname(sql);
            sql =""+food_map.get("priceType");
            food.setPricetype(sql);
            sql =""+ food_map.get("sellerId") ;
            food.setSellerid(Long.parseLong(sql));
            sql =""+ food_map.get("id") ;
            food.setId(Long.parseLong(sql));
            result.add(food);
        }
        return result;
    }

//    返回仅含有单个属性的数据

//    根据ID查找数据信息,数据唯一
    public String select_by_Id_Re_foodImg(int id) {
        String sql = "SELECT foodImg FROM food  WHERE id=" + id + " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map food_map = (Map) rows.get(0);
        sql = ""+food_map.get("foodImg");
        return sql;
}
    public String select_by_Id_Re_foodPrice(int id) {
         String sql = "SELECT foodPrice FROM food   WHERE id=" + id + " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map food_map = (Map) rows.get(0);
        sql = "foodPrice:"+food_map.get("foodPrice");
        return sql;
    }
    public String select_by_Id_Re_foodName(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT foodName FROM food  WHERE id=" + id + " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map food_map = (Map) rows.get(0);
        sql = "" + food_map.get("foodName");
        return sql;
    }
    public String select_by_Id_Re_priceType(int id) {
        String sql = "SELECT priceType FROM food  WHERE id=" + id + " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map food_map = (Map) rows.get(0);
        sql = "priceType:"+food_map.get("priceType");
        return sql;
    }
    public String select_by_Id_Re_sellerId(int id) {
        String sql = "SELECT sellerId FROM food  WHERE id=" + id + " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map food_map = (Map) rows.get(0);
        sql = "" + food_map.get("sellerId") ;
        return sql;
    }


//    根据食物价格查找数据信息，返回数据有多条；

    public List<String> select_by_foodPrice_Re_id(int foodPrice) {
    List<String>result=new ArrayList<>();
    String sql = "SELECT id FROM food  WHERE foodPrice=" +foodPrice+ " order by id desc";
    List rows = jdbcTemplate.queryForList(sql);
    Iterator iterator=rows.iterator();
    while(iterator.hasNext()){
//        通过map对象获取表中信息；
        Map food_map = (Map) iterator.next();
        sql = "id:" +food_map.get("id");
        result.add(sql);
    }
    return result;
}
    public List<String> select_by_foodPrice_Re_foodImg(int foodPrice) {
        List<String>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT foodImg FROM food  WHERE foodPrice=" +foodPrice+ " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            sql = "foodImg:" + food_map.get("foodImg");
            result.add(sql);
        }
        return result;
    }
    public List<String> select_by_foodPrice_Re_foodName(int foodPrice) {
        List<String>result=new ArrayList<>();
        String sql = "SELECT foodName FROM food   WHERE foodPrice=" +foodPrice+ " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            sql = "foodName:" + food_map.get("foodName");
            result.add(sql);
        }
        return result;
    }
    public List<String> select_by_foodPrice_Re_priceType(int foodPrice) {
        List<String>result=new ArrayList<>();
        String sql = "SELECT priceType FROM food  WHERE foodPrice=" +foodPrice+ " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            sql = "priceType:"+food_map.get("priceType");
            result.add(sql);
        }
        return result;
    }
    public List<String> select_by_foodPrice_Re_sellerId(int foodPrice) {
        List<String>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT sellerId FROM food  WHERE foodPrice=" +foodPrice+ " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            sql = "sellerId:" + food_map.get("sellerId") ;
            result.add(sql);
        }
        return result;
    }


//    根据食物名称查找数据信息；

    public List<String> select_by_foodName_Re_id(String foodName) {
    List<String>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
    String sql = "SELECT id FROM food   WHERE foodName='" +foodName+ "'order by id desc";

    List rows = jdbcTemplate.queryForList(sql);
    Iterator iterator=rows.iterator();
    while(iterator.hasNext()){
//        通过map对象获取表中信息；
        Map food_map = (Map) iterator.next();
        sql = "id:" +food_map.get("id");
        result.add(sql);
    }
    return result;
}
    public List<String> select_by_foodName_Re_foodImg(String foodName) {
        List<String>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT foodImg FROM food   WHERE foodName='" + foodName + "'order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            sql = "foodImg:" + food_map.get("foodImg");
            result.add(sql);
        }
        return result;
    }
    public List<String> select_by_foodName_Re_foodPrice(String foodName) {
        List<String>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT foodPrice FROM food    WHERE foodName='" + foodName + "'order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            sql = "foodPrice:"+food_map.get("foodPrice");
            result.add(sql);
        }
        return result;
    }
    public List<String> select_by_foodName_Re_priceType(String foodName) {
        List<String>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT priceType FROM food    WHERE foodName='" + foodName + "'order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            sql = "priceType:"+food_map.get("priceType");
            result.add(sql);
        }
        return result;
    }
    public List<String> select_by_foodName_Re_sellerId(String foodName) {
        List<String>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT sellerId FROM food  WHERE foodName='" + foodName + "'order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            sql = "sellerId:" + food_map.get("sellerId") ;
            result.add(sql);
        }
        return result;
    }



    //    根据计价方式查找食物信息，返回数据可能多条；

    public List<String> select_by_priceType_Re_id(String priceType) {
    List<String>result=new ArrayList<>();
    String sql = "SELECT id FROM food   WHERE priceType='" +priceType+ "'order by id desc";
    List rows = jdbcTemplate.queryForList(sql);
    Iterator iterator=rows.iterator();
    while(iterator.hasNext()){
//        通过map对象获取表中信息；
        Map food_map = (Map) iterator.next();
        sql = "id:" +food_map.get("id") ;
        result.add(sql);
    }
    return result;
}
    public List<String> select_by_priceType_Re_foodImg(String priceType) {
        List<String>result=new ArrayList<>();
        String sql = "SELECT foodImg FROM food  WHERE priceType='" +priceType+ "'order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            sql = "foodImg:" + food_map.get("foodImg");
            result.add(sql);
        }
        return result;
    }
    public List<String> select_by_priceType_Re_foodName(String priceType) {
        List<String>result=new ArrayList<>();
        String sql = "SELECT foodName FROM food   WHERE priceType='" +priceType+ "'order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            sql = "foodName:" + food_map.get("foodName");
            result.add(sql);
        }
        return result;
    }
    public List<String> select_by_priceType_Re_foodPrice(String priceType) {
        List<String>result=new ArrayList<>();
        String sql = "SELECT foodPrice FROM food   WHERE priceType='" +priceType+ "'order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            sql = "foodPrice:"+food_map.get("foodPrice");
            result.add(sql);
        }
        return result;
    }
    public List<String> select_by_priceType_Re_sellerId(String priceType) {
        List<String>result=new ArrayList<>();
        String sql = "SELECT sellerId FROM food  WHERE priceType='" +priceType+ "'order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
//        通过map对象获取表中信息；
            Map food_map = (Map) iterator.next();
            sql = "sellerId:" + food_map.get("sellerId") ;
            result.add(sql);
        }
        return result;
    }

//    根据sellerId查找数据信息；

    public List<String> select_by_sellerId_Re_id(int sellerId) {
    List<String>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
    String sql = "SELECT id FROM food   WHERE sellerId=" +sellerId+ " order by id desc";
    List rows = jdbcTemplate.queryForList(sql);
    Iterator iterator=rows.iterator();
    while(iterator.hasNext()){
        Map food_map = (Map) iterator.next();
        sql = "id:" +food_map.get("id") ;
        result.add(sql);
    }
    return result;
}
    public List<String> select_by_sellerId_Re_foodImg(int sellerId) {
        List<String>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT foodImg FROM food   WHERE sellerId=" +sellerId+ " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map food_map = (Map) iterator.next();
            sql = "foodImg:" + food_map.get("foodImg");
            result.add(sql);
        }
        return result;
    }
    public List<String> select_by_sellerId_Re_foodPrice(int sellerId) {
        List<String>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT foodPrice FROM food   WHERE sellerId=" +sellerId+ " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map food_map = (Map) iterator.next();
            sql = "foodPrice:"+food_map.get("foodPrice");
            result.add(sql);
        }
        return result;
    }
    public List<String> select_by_sellerId_Re_foodName(int sellerId) {
        List<String>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT foodName FROM food   WHERE sellerId=" +sellerId+ " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map food_map = (Map) iterator.next();
            sql = "foodName:" + food_map.get("foodName");
            result.add(sql);
        }
        return result;
    }
    public List<String> select_by_sellerId_Re_priceType(int sellerId) {
        List<String>result=new ArrayList<>();
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT priceType FROM food   WHERE sellerId=" +sellerId+ " order by id desc";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map food_map = (Map) iterator.next();
            sql = "priceType:"+food_map.get("priceType");
            result.add(sql);
        }
        return result;
    }
}
