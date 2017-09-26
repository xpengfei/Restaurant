package org.sang.Dao;

import org.sang.Beans.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by xpengfei on 2017/5/18.
 */
@Repository
//注解@Repository的作用是将DAO类声明为Bean,同时将该类抛出的数据访问异常封装为
//spring的数据访问异常类型
public class Insert_comment {
    //            @Resource注解作用
    @Resource
    JdbcTemplate jdbcTemplate;
//    添加评论信息
    public int add_comment(Comment comment){
        return jdbcTemplate.update("INSERT INTO comment(id,foodName,judCon,judTime,userId,foodImg) VALUES (?,?,?,?,?,?)",
                comment.getId(),comment.getFoodname(),comment.getJudcon(),comment.getJudtime(),comment.getUserid(),comment.getFoodimg());
    }
}
