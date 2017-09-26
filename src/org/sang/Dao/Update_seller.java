package org.sang.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by xpengfei on 2017/5/18.
 */
@Repository
public class Update_seller {
    @Resource
    JdbcTemplate jdbcTemplate;
    //    根据ID删除数据
    public int delete_by_id(int id){
        String sql="DELETE FROM seller WHERE id="+id+"";
        return jdbcTemplate.update(sql);
    }
//    根据id更新phoneNumber
    public int update_phoneNumber_by_id(String phoneNumber,int id){
        String sql="UPDATE seller SET phoneNumber='"+phoneNumber+"'WHERE id="+id+"";
        return jdbcTemplate.update(sql);
    }
    //    根据id更新windowImg
    public int update_windowImg_by_id(String windowImg,int id){
        String sql="UPDATE seller SET windowImg='"+windowImg+"'WHERE id="+id+"";
        return jdbcTemplate.update(sql);
    }
    //    根据id更新password
    public void update_password_by_id(String password,int id){
        String sql="UPDATE seller SET password='"+password+"'WHERE id="+id+"";
        jdbcTemplate.update(sql);
    }
    //    根据id更新sellerName
    public void update_sellerName_by_id(String sellerName,int id){
        String sql="UPDATE seller SET sellerName='"+sellerName+"'WHERE id="+id+"";
        jdbcTemplate.update(sql);
    }
    //    根据id更新windowName
    public int update_windowName_by_id(String windowName,int id){
        String sql="UPDATE seller SET windowName='"+windowName+"'WHERE id="+id+"";
        return jdbcTemplate.update(sql);
    }

}
