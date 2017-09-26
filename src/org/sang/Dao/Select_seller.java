package org.sang.Dao;

import org.sang.Beans.Seller;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by xpengfei on 2017/5/17.
 */
@Repository
public class Select_seller {
    @Resource
    JdbcTemplate jdbcTemplate;
//    id查找数据信息,数据唯一

    public Seller select_by_Id_Re_All(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT * FROM seller WHERE id=" + id + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map seller_map = (Map) rows.get(0);
        Seller seller = new Seller();
        sql = "" + seller_map.get("id");
        seller.setId(Long.valueOf(sql));
        sql = "" + seller_map.get("phoneNumber");
        seller.setPhonenumber(sql);
        sql = "" + seller_map.get("windowImg");
        seller.setWindowimg(sql);

        sql = "" + seller_map.get("password");
        seller.setPassword(sql);
        sql = "" + seller_map.get("state");
        seller.setState(Long.valueOf(sql));
        sql = "" + seller_map.get("sellerName");
        seller.setSellername(sql);
        sql = "" + seller_map.get("windowName");
        seller.setWindowname(sql);
        return seller;
    }

    public String select_by_Id_Re_phoneNumber(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT phoneNumber FROM seller WHERE id=" + id + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map seller_map = (Map) rows.get(0);
        sql = "phoneNumber:" + seller_map.get("phoneNumber");
        return sql;
    }

    public String select_by_Id_Re_state(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT state FROM seller WHERE id=" + id + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map seller_map = (Map) rows.get(0);
        sql = "state:" + seller_map.get("state");
        return sql;
    }

    public String select_by_Id_Re_password(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT password FROM seller WHERE id=" + id + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map seller_map = (Map) rows.get(0);
        sql = "password:" + seller_map.get("password");
        return sql;
    }

    public String select_by_Id_Re_sellerName(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT sellerName FROM seller WHERE id=" + id + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map seller_map = (Map) rows.get(0);
        sql = "" + seller_map.get("sellerName");
        return sql;
    }

    public String select_by_Id_Re_windowName(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT windowName FROM seller WHERE id=" + id + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map seller_map = (Map) rows.get(0);
        sql = "" + seller_map.get("windowName");
        return sql;
    }

    public String select_by_Id_Re_windowImg(int id) {
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        String sql = "SELECT windowImg FROM seller WHERE id=" + id + "";
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map seller_map = (Map) rows.get(0);
        sql = "windowImg:" + seller_map.get("windowImg");
        return sql;
    }

    //    电话号码查找数据信息,号码唯一
    public Seller select_by_phoneNumber_Re_All(String phoneNumber) {
        String sql = "SELECT * FROM seller WHERE phoneNumber='" + phoneNumber + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Map seller_map = (Map) rows.get(0);
        Seller seller = new Seller();
        sql = "" + seller_map.get("id");
        seller.setId(Long.valueOf(sql));
        sql = "" + seller_map.get("phoneNumber");
        seller.setPhonenumber(sql);
        sql = "" + seller_map.get("windowImg");
        seller.setWindowimg(sql);

        sql = "" + seller_map.get("password");
        seller.setPassword(sql);
        sql = "" + seller_map.get("state");
        seller.setState(Long.valueOf(sql));
        sql = "" + seller_map.get("sellerName");
        seller.setSellername(sql);
        sql = "" + seller_map.get("windowName");
        seller.setWindowname(sql);
        return seller;
    }

    public String select_by_phoneNumber_Re_id(String phoneNumber) {
        String sql = "SELECT id FROM seller WHERE phoneNumber='" + phoneNumber + "'";
        List rows = jdbcTemplate.queryForList(sql);
        if(!rows.isEmpty()) {
            Map seller_map = (Map) rows.get(0);
            sql = "" + seller_map.get("id");
            return sql;
        }
        return null;
    }

    public String select_by_phoneNumber_Re_password(String phoneNumber) {
        String sql = "SELECT password FROM seller WHERE phoneNumber='" + phoneNumber + "'";
        List rows = jdbcTemplate.queryForList(sql);
        if(!rows.isEmpty()) {
            Map seller_map = (Map) rows.get(0);
            sql = "" + seller_map.get("password");
            return sql;
        }
        return null;
    }

    public String select_by_phoneNumber_Re_sellerName(String phoneNumber) {
        String sql = "SELECT sellerName FROM seller WHERE phoneNumber='" + phoneNumber + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Map seller_map = (Map) rows.get(0);
        sql = "sellerName:" + seller_map.get("sellerName");
        return sql;
    }

    public String select_by_phoneNumber_Re_windowName(String phoneNumber) {
        String sql = "SELECT windowName FROM seller WHERE phoneNumber='" + phoneNumber + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Map seller_map = (Map) rows.get(0);
        sql = "windowName:" + seller_map.get("windowName");
        return sql;
    }

    public String select_by_phoneNumber_Re_state(String phoneNumber) {
        String sql = "SELECT state FROM seller WHERE phoneNumber='" + phoneNumber + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Map seller_map = (Map) rows.get(0);
        sql = "state:" + seller_map.get("state");
        return sql;
    }

    public String select_by_phoneNumber_Re_windowImg(String phoneNumber) {
        String sql = "SELECT windowImg FROM seller WHERE phoneNumber='" + phoneNumber + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Map seller_map = (Map) rows.get(0);
        sql = "windowImg:" + seller_map.get("windowImg");
        return sql;
    }


    //    sellerName查找数据信息
    public List<Seller> select_by_sellerName_Re_All(String sellerName) {
        List<Seller> result = new ArrayList<>();
        String sql = "SELECT * FROM seller WHERE sellerName='" + sellerName + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator = rows.iterator();
        while (iterator.hasNext()) {
            Map seller_map = (Map) iterator.next();
            Seller seller = new Seller();
            sql = "" + seller_map.get("id");
            seller.setId(Long.valueOf(sql));
            sql = "" + seller_map.get("phoneNumber");
            seller.setPhonenumber(sql);
            sql = "" + seller_map.get("windowImg");
            seller.setWindowimg(sql);

            sql = "" + seller_map.get("password");
            seller.setPassword(sql);
            sql = "" + seller_map.get("state");
            seller.setState(Long.valueOf(sql));
            sql = "" + seller_map.get("sellerName");
            seller.setSellername(sql);
            sql = "" + seller_map.get("windowName");
            seller.setWindowname(sql);
            result.add(seller);
        }
        return result;
    }

    public List<String> select_by_sellerName_Re_id(String sellerName) {
        List<String> result = new ArrayList<>();
        String sql = "SELECT id FROM seller WHERE sellerName='" + sellerName + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator = rows.iterator();
        while (iterator.hasNext()) {
            Map seller_map = (Map) iterator.next();
            sql = "id:" + seller_map.get("id");
            result.add(sql);
        }
        return result;
    }

    public List<String> select_by_sellerName_Re_phoneNumber(String sellerName) {
        List<String> result = new ArrayList<>();
        String sql = "SELECT phoneNumber FROM seller WHERE sellerName='" + sellerName + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator = rows.iterator();
        while (iterator.hasNext()) {
            Map seller_map = (Map) iterator.next();
            sql = "phoneNumber:" + seller_map.get("phoneNumber");
            result.add(sql);
        }
        return result;
    }

    public List<String> select_by_sellerName_Re_windowName(String sellerName) {
        List<String> result = new ArrayList<>();
        String sql = "SELECT windowName FROM seller WHERE sellerName='" + sellerName + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator = rows.iterator();
        while (iterator.hasNext()) {
            Map seller_map = (Map) iterator.next();
            sql = "windowName:" + seller_map.get("windowName");
            result.add(sql);
        }
        return result;
    }

    public List<String> select_by_sellerName_Re_state(String sellerName) {
        List<String> result = new ArrayList<>();
        String sql = "SELECT state FROM seller WHERE sellerName='" + sellerName + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator = rows.iterator();
        while (iterator.hasNext()) {
            Map seller_map = (Map) iterator.next();
            sql = "state:" + seller_map.get("state");
            result.add(sql);
        }
        return result;
    }

    public List<String> select_by_sellerName_Re_windowImg(String sellerName) {
        List<String> result = new ArrayList<>();
        String sql = "SELECT windowImg FROM seller WHERE sellerName='" + sellerName + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator = rows.iterator();
        while (iterator.hasNext()) {
            Map seller_map = (Map) iterator.next();
            sql = "windowImg:" + seller_map.get("windowImg");
            result.add(sql);
        }
        return result;
    }

    //    windowName查找数据信息
    public List<Seller> select_by_windowName_Re_All(String windowName) {
        List<Seller> result = new ArrayList<>();
        String sql = "SELECT * FROM seller WHERE windowName='" + windowName + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator = rows.iterator();
        while (iterator.hasNext()) {
            Map seller_map = (Map) iterator.next();
            Seller seller = new Seller();
            sql = "" + seller_map.get("id");
            seller.setId(Long.valueOf(sql));
            sql = "" + seller_map.get("phoneNumber");
            seller.setPhonenumber(sql);
            sql = "" + seller_map.get("windowImg");
            seller.setWindowimg(sql);

            sql = "" + seller_map.get("password");
            seller.setPassword(sql);
            sql = "" + seller_map.get("state");
            seller.setState(Long.valueOf(sql));
            sql = "" + seller_map.get("sellerName");
            seller.setSellername(sql);
            sql = "" + seller_map.get("windowName");
            seller.setWindowname(sql);
            result.add(seller);
        }
        return result;
    }

    //    state查询数据信息
    public List<Seller> select_by_state_Re_All(String state) {
        List<Seller> result = new ArrayList<>();
        String sql = "SELECT * FROM seller WHERE windowName='" + state + "'";
        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator = rows.iterator();
        while (iterator.hasNext()) {
            Map seller_map = (Map) iterator.next();
            Seller seller = new Seller();
            sql = "" + seller_map.get("id");
            seller.setId(Long.valueOf(sql));
            sql = "" + seller_map.get("phoneNumber");
            seller.setPhonenumber(sql);
            sql = "" + seller_map.get("windowImg");
            seller.setWindowimg(sql);

            sql = "" + seller_map.get("password");
            seller.setPassword(sql);
            sql = "" + seller_map.get("state");
            seller.setState(Long.valueOf(sql));
            sql = "" + seller_map.get("sellerName");
            seller.setSellername(sql);
            sql = "" + seller_map.get("windowName");
            seller.setWindowname(sql);
            result.add(seller);
        }
        return result;
    }

}

