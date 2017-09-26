package org.sang.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by xpengfei on 2017/5/18.
 */
@Repository
public class Update_comment {
    @Resource
    JdbcTemplate jdbcTemplate;
    //    根据ID删除数据
    public void delete_by_id(int id){
        String sql="DELETE FROM comment WHERE id="+id+"";
        jdbcTemplate.execute(sql);
    }
    //    根据userId删除数据
    public void delete_by_userId(String userId){
        String sql="DELETE FROM comment WHERE userId='"+userId+"'";
        jdbcTemplate.execute(sql);
    }
}
