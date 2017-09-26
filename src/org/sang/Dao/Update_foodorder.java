package org.sang.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by xpengfei on 2017/5/18.
 */
@Repository
public class Update_foodorder {
    @Resource
    JdbcTemplate jdbcTemplate;
//    根据ID删除数据
    public void delete_by_id(int id){
        String sql="DELETE FROM foodorder WHERE id="+id+"";
        jdbcTemplate.execute(sql);
    }
    //    根据foodId删除数据
    public void delete_by_foodId(int foodId){
        String sql="DELETE FROM foodorder WHERE foodId="+foodId+"";
        jdbcTemplate.execute(sql);
    }
    //    根据userId删除数据
    public void delete_by_userId(int userId){
        String sql="DELETE FROM foodorder WHERE userId="+userId+"";
        jdbcTemplate.execute(sql);
    }
    //    根据sellerId删除数据
    public void delete_by_sellerId(int sellerId){
        String sql="DELETE FROM foodorder WHERE sellerId="+sellerId+"";
        jdbcTemplate.execute(sql);
    }
    //    根据isFinish删除数据
    public void delete_by_isFinish(int isFinish){
        String sql="DELETE FROM foodorder WHERE isFinish="+isFinish+"";
        jdbcTemplate.execute(sql);
    }


//    根据id更新foodNumber
    public void update_foodNumber_by_id(String foodNumber,int id){
        String sql="UPDATE foodorder SET foodNumber='"+foodNumber+"'WHERE id="+id+"";
        jdbcTemplate.update(sql);
    }
    //    根据id更新getFoodTime
    public void update_getFoodTime_by_id(String getFoodTime,int id){
        String sql="UPDATE foodorder SET getFoodTime='"+getFoodTime+"'WHERE id="+id+"";
        jdbcTemplate.update(sql);
    }
    //    根据id更新isFinish
    public int update_isFinish_by_id(int isFinish,int id){
        System.out.println("111:"+id);
        String sql="UPDATE foodorder SET isFinish="+isFinish+" WHERE id="+id+"";
        System.out.println("111:"+id);
        return jdbcTemplate.update(sql);
    }

}
