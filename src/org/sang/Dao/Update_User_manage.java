package org.sang.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by xpengfei on 2017/5/21.
 */
@Repository
public class Update_User_manage {
    @Resource
    JdbcTemplate jdbcTemplate;
    //    通过用户id删除用户信息；
    public void delete_by_id(int id){
        String sql="DELETE FROM user_manage WHERE id="+id+"";
        jdbcTemplate.execute(sql);
    }
    //    通过id更改用户名phonenumber；
    public void update_phonenumber_by_id(int id,String phonenumber){
        String sql="UPDATE user_manage SET phonenumber='"+phonenumber+"'WHERE id="+id+"";
        jdbcTemplate.update(sql);
    }
    //    通过id更改密码password；
    public void update_password_by_id(int id,String password){
        String sql="UPDATE user_manage SET password='"+password+"'WHERE id="+id+"";
        jdbcTemplate.update(sql);
    }
    //    通过id更改state；
    public void update_state_by_id(int id,int state){
        String sql="UPDATE user_manage SET state="+state+"WHERE id="+id+"";
        jdbcTemplate.update(sql);
    }
    //    通过id更改email；
    public void update_email_by_id(int id,String email){
        String sql="UPDATE user_manage SET email='"+email+"'WHERE id="+id+"";
        jdbcTemplate.update(sql);
    }


    //    通过phoneNumber更改密码password(通过验证码较好，，通过手机号不推荐)；
    public void update_password_by_phoneNumber(String password,String phonenumber){
        String sql="UPDATE user_manage SET phonenumber='"+phonenumber+"'WHERE password='"+password+"'";
        jdbcTemplate.update(sql);
    }
}
