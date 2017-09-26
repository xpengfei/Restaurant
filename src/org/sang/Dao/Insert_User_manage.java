package org.sang.Dao;

import org.sang.Beans.User_manage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by xpengfei on 2017/5/21.
 */
@Repository
public class Insert_User_manage {
    @Resource
    JdbcTemplate jdbcTemplate;
    public int add_user(User_manage user_manage){
        return jdbcTemplate.update("INSERT INTO user_manage(phonenumber,email,password,state) VALUES (?,?,?,?)",user_manage.getPhonenumber(),user_manage.getEmail(),user_manage.getPassword(),user_manage.getState());
    }
}
