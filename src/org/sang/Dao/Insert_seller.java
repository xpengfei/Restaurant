package org.sang.Dao;

import org.sang.Beans.Seller;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by xpengfei on 2017/5/18.
 */
@Repository
public class Insert_seller {
    @Resource
    JdbcTemplate jdbcTemplate;
//    添加卖家信息
    public int add_seller(Seller seller){
        return jdbcTemplate.update("INSERT into seller(phoneNumber, windowImg, password, sellerName, windowName,state) VALUES (?,?,?,?,?,?)",
                seller.getPhonenumber(), seller.getWindowimg(), seller.getPassword(), seller.getSellername(), seller.getWindowname(),seller.getState());
    }
}
