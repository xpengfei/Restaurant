package org.sang.Dao;

import org.sang.Beans.User_manage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by xpengfei on 2017/5/21.
 */
@Repository
public class Select_User_manage {
    @Resource
    JdbcTemplate jdbcTemplate;

    //    通过用户id信息，查询用户所有信息，id唯一，返回值唯一；
    public User_manage select_by_Id_Re_All(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT * FROM user_manage WHERE id=" + id + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map user_mana_map = (Map) rows.get(0);
        User_manage user_mana=new User_manage();

        sql = "" + user_mana_map.get("id");
        user_mana.setId(Long.valueOf(sql));

        sql = "" + user_mana_map.get("phonenumber");
        user_mana.setPhonenumber(sql);

        sql = "" +user_mana_map.get("email");
        user_mana.setEmail(sql);

        sql = "" + user_mana_map.get("password");
        user_mana.setPassword(sql);

        sql = "" + user_mana_map.get("state");
        user_mana.setState(Long.valueOf(sql));

        return user_mana;
    }

    //    返回密码，用于找回密码（用处不大，可直接在update中修改密码）；
    public String select_by_Id_Re_password(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT password FROM user_manage WHERE id=" + id + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map user_mana_map = (Map) rows.get(0);
        sql = "" +user_mana_map.get("password");

        return sql;
    }

    //    返回phoneNumber便于联系；
    public String select_by_Id_Re_phoneNumber(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT  phonenumber FROM user_manage WHERE id=" + id + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map user_mana_map = (Map) rows.get(0);
        sql = "" +user_mana_map.get("phonenumber");

        return sql;
    }

    //    返回email便于联系；
    public String select_by_Id_Re_email(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT  email FROM user_manage WHERE id=" + id + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map user_mana_map = (Map) rows.get(0);
        sql = "" +user_mana_map.get("email");

        return sql;
    }

    //    通过ID查询，返回state；
    public String select_by_Id_Re_state(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT  state FROM user_manage WHERE id=" + id + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map user_mana_map = (Map) rows.get(0);
        sql = "" +user_mana_map.get("state");

        return sql;
    }


    //    通过用户phonenumber信息，查询用户所有信息，电话号码唯一，返回值唯一；
    public User_manage select_by_phonenumber_Re_All(String  phonenumber){
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT * FROM user_manage WHERE phonenumber='" + phonenumber + "'";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map user_mana_map = (Map) rows.get(0);
        User_manage user_mana=new User_manage();

        sql = "" + user_mana_map.get("id");
        user_mana.setId(Long.valueOf(sql));

        sql = "" + user_mana_map.get("phonenumber");
        user_mana.setPhonenumber(sql);

        sql = "" +user_mana_map.get("email");
        user_mana.setEmail(sql);

        sql = "" + user_mana_map.get("password");
        user_mana.setPassword(sql);

        sql = "" + user_mana_map.get("state");
        user_mana.setState(Long.valueOf(sql));

        return user_mana;
    }

    //    通过phonenumber获取密码
    public String select_by_phonenumber_Re_password(String  phonenumber){
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT password FROM user_manage WHERE phonenumber='" + phonenumber + "'";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        if(!rows.isEmpty()){
            Map user_mana_map = (Map) rows.get(0);
            sql = "" + user_mana_map.get("password");
            return sql;
        }
        return null;
    }

    public String select_by_phoneNumber_Re_id(String phoneNumber) {
        String sql = "SELECT id FROM user_manage WHERE phonenumber='" + phoneNumber + "'";
        List rows = jdbcTemplate.queryForList(sql);
        if(!rows.isEmpty()) {
            Map seller_map = (Map) rows.get(0);
            sql = "" + seller_map.get("id");
            return sql;
        }
        return null;
    }


    //    通过用户state信息，查询某个state状态的用户；
    public List<User_manage> select_by_state_Re_All(int state){
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List<User_manage>result=new ArrayList<>();
        String sql = "SELECT * FROM user_manage WHERE state=" + state + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){

            Map user_mana_map = (Map) iterator.next();
            User_manage user_mana=new User_manage();

            sql = "" + user_mana_map.get("id");
            user_mana.setId(Long.valueOf(sql));

            sql = "" + user_mana_map.get("phonenumber");
            user_mana.setPhonenumber(sql);

            sql = "" +user_mana_map.get("email");
            user_mana.setEmail(sql);

            sql = "" + user_mana_map.get("password");
            user_mana.setPassword(sql);

            sql = "" + user_mana_map.get("state");
            user_mana.setState(Long.valueOf(sql));
            result.add(user_mana);
        }
        return result;
    }

}
