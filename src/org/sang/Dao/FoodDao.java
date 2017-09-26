package org.sang.Dao;

import org.sang.Beans.Food;
import org.sang.Beans.FoodMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xpengfei on 2017/5/21.
 */
@Repository
public class FoodDao {
    @Resource
    JdbcTemplate jdbcTemplate;
    private static int sellerId;
//    获取指定selllerId商家的food信息；
    public List<Food> getFoodByPage(Long page, Long rows,int sellerId) {
        System.out.println("getFoodByPage:---"+sellerId);
        return jdbcTemplate.query("select * from food where sellerId ="+sellerId+" order by id desc limit ?,?", new FoodMapper(),(page-1)*rows,rows);

    }
    //查询总记录数
    public int getFoodCount(int sellerId) {
        System.out.println("getFoodCount:---"+sellerId);
        return jdbcTemplate.queryForObject("select count(*) from food where sellerId ="+sellerId+"", Integer.class);
    }
}
