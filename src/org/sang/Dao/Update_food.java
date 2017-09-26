package org.sang.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by xpengfei on 2017/5/18.
 */
@Repository
public class Update_food {
    @Resource
    JdbcTemplate jdbcTemplate;
    //    根据ID删除数据
    public int delete_by_id(int id){
        String sql="DELETE FROM food WHERE id="+id+"";
        return jdbcTemplate.update(sql);
    }
//    根据id更新foodImg
    public void update_foodImg_by_id(String foodImg,int id ){
        String sql="UPDATE food SET foodImg='"+foodImg+"'WHERE id="+id+"";
        jdbcTemplate.update(sql);
    }
    //    根据id更新foodPrice
    public void update_foodPrice_by_id(String foodPrice,int id ){
        String sql="UPDATE food SET foodPrice="+foodPrice+"WHERE id="+id+"";
        jdbcTemplate.update(sql);
    }
    //    根据id更新foodName
    public void update_foodName_by_id(String foodName,int id ){
        String sql="UPDATE food SET foodName='"+foodName+"'WHERE id="+id+"";
        jdbcTemplate.update(sql);
    }
    //    根据id更新priceType
    public void update_priceType_by_id(String priceType,int id ){
        String sql="UPDATE food SET priceType='"+priceType+"'WHERE id="+id+"";
        jdbcTemplate.update(sql);
    }

}
