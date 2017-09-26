package org.sang.Beans;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xpengfei on 2017/5/17.
 */
public class FoodorderMapper implements org.springframework.jdbc.core.RowMapper<Foodorder> {

    @Override
    public Foodorder mapRow(ResultSet resultSet, int i) throws SQLException {
        long id=resultSet.getLong("id");
        long foodId=resultSet.getLong("foodID");
//        userId存储的是用户的昵称
        String userId=resultSet.getString("userId");
        long foodNumber=resultSet.getLong("foodNumber");
        long sellerId=resultSet.getLong("sellerId");
        String create_date=resultSet.getString("create_date");
        String getFoodTime=resultSet.getString("getFoodTime");
        long isFinish=resultSet.getLong("isFinish");
        String foodCode=resultSet.getString("foodCode");
        Foodorder foodorder=new Foodorder(id,foodId,userId,foodNumber,sellerId,create_date,getFoodTime,isFinish,foodCode);
        return foodorder;
    }
}
