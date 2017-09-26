package org.sang.Beans;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xpengfei on 2017/5/21.
 */
public class FoodMapper implements org.springframework.jdbc.core.RowMapper<Food> {
    @Override
    public Food mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Food(resultSet.getLong("id"),resultSet.getString("foodImg"),resultSet.getString("foodPrice"),resultSet.getString("foodName"),resultSet.getString("priceType"),resultSet.getLong("sellerId"));
    }
}
