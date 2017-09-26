package org.sang.Dao;

import org.sang.Beans.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by xpengfei on 2017/5/17.
 */
@Repository
public class Select_comment {
    @Resource
    JdbcTemplate jdbcTemplate;

    //    通过评论id查找评论的信息,评论ID是唯一的,所以返回一条数据；
    public Comment select_by_Id_Re_All(int id) {
        String sql = "SELECT * FROM comment  WHERE id=" + id + " order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；

        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map comment_map = (Map) rows.get(0);
        Comment comment=new Comment();
        sql = "" + comment_map.get("id");
        comment.setId(Long.parseLong(sql));
        sql = "" + comment_map.get("foodName");
        comment.setFoodname(sql);
        sql = "" +comment_map.get("judCon") ;
        comment.setJudcon(sql);
        sql = "" + comment_map.get("judTime");
        comment.setJudtime(Timestamp.valueOf(sql));
        sql = "" + comment_map.get("userId") ;
        comment.setUserid(sql);
        sql = "" +comment_map.get("foodImg");
        comment.setFoodimg(sql);
        return comment;
    }

    //通过userId查询的话，会出现多条评论信息的情况（注意返回值）,返回的是所有结果的list列表；
    public List<Comment> select_by_userId_Re_All(String userId) {
        List< Comment>result=new ArrayList<>();
        String sql = "SELECT * FROM comment  WHERE userId='" + userId + "'order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map comment_map = (Map)iterator.next();
            Comment comment=new Comment();
            sql = "" + comment_map.get("id") ;
            comment.setId(Long.valueOf(sql));
            sql = "" + comment_map.get("foodName");
            comment.setFoodname(sql);
            sql = "" +comment_map.get("judCon") ;
            comment.setJudcon(sql);
            sql = "" +comment_map.get("judTime");
            comment.setJudtime(Timestamp.valueOf(sql));
            sql = "" +comment_map.get("userId");
            comment.setUserid(sql);
            sql = "" +comment_map.get("foodImg");
            comment.setFoodimg(sql);
           result.add(comment);
        }
       return result;
    }
    //    通过食物名称，查找对应所有评论信息；
    public List<Comment> select_by_foodName_Re_All(String foodName) {
        List< Comment>result=new ArrayList<>();
        String sql = "SELECT * FROM comment  WHERE userId='" +foodName+ "'order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map comment_map = (Map)iterator.next();
            Comment comment=new Comment();
            sql = "" + comment_map.get("id") ;
            comment.setId(Long.valueOf(sql));
            sql = "" + comment_map.get("foodName");
            comment.setFoodname(sql);
            sql = "" +comment_map.get("judCon") ;
            comment.setJudcon(sql);
            sql = "" +comment_map.get("judTime");
            comment.setJudtime(Timestamp.valueOf(sql));
            sql = "" +comment_map.get("userId");
            comment.setUserid(sql);
            sql = "" +comment_map.get("foodImg");
            comment.setFoodimg(sql);
            result.add(comment);
        }
        return result;
    }




//   通过评论ID进行查找，都只有一条数据；

    //    通过评论ID，返回foodName
    public String select_by_Id_Re_foodName(int id) {
        String sql = "SELECT foodName FROM comment  WHERE id=" + id + " order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map comment_map = (Map) rows.get(0);
        sql = "foodName:" + comment_map.get("foodName");
        return sql;
    }
    //    通过评论ID，返回judCon
    public String select_by_Id_Re_judCon(int id) {
        String sql = "SELECT judCon FROM comment WHERE id=" + id + " order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map comment_map = (Map) rows.get(0);
        sql = "\tjudCon:" + comment_map.get("judCon");
        return sql;
    }
    //    通过评论ID，返回judTime
    public String select_by_Id_Re_judTime(int id) {
        String sql = "SELECT judTime FROM comment  WHERE id=" + id + " order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map comment_map = (Map) rows.get(0);
        sql = "judTime:" + comment_map.get("judTime");
        return sql;
    }
    //    通过评论ID，返回userId
    public String select_by_Id_Re_userId(int id) {
        String sql = "SELECT userId FROM comment  WHERE id=" + id + " order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；

        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map comment_map = (Map) rows.get(0);
        sql = "\tuserId:" + comment_map.get("userId");
        return sql;
    }
    //    通过评论ID，返回foodImg
    public String select_by_Id_Re_foodImg(int id) {
        String sql = "SELECT foodImg FROM comment  WHERE id=" + id + " order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Map comment_map = (Map) rows.get(0);
        sql = "foodImg:" + comment_map.get("foodImg");
        return sql;
    }


//    通过userId（用户昵称）查找的数据，对应的会有多条

    public List<String> select_by_userId_Re_id(String userId) {
        List<String>result=new ArrayList<>();
        String sql = "SELECT id FROM comment  WHERE userId='" + userId + "'order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map comment_map = (Map)iterator.next();
            sql = "id:" + comment_map.get("id");
            result.add(sql);
        }
        return result;
    }

    public List<String> select_by_userId_Re_foodName(String userId) {
        List<String>result=new ArrayList<>();
        String sql = "SELECT foodName FROM comment  WHERE userId='" + userId + "'order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map comment_map = (Map)iterator.next();
            sql = "foodName:" + comment_map.get("foodName");
            result.add(sql);
        }
        return result;
    }

    public List<String> select_by_userId_Re_judCon(String userId) {
        List<String>result=new ArrayList<>();
        String sql = "SELECT judCon FROM comment  WHERE userId='" + userId + "'order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map comment_map = (Map)iterator.next();
            sql = "judCon:" + comment_map.get("judCon");
            result.add(sql);
        }
        return result;
    }


    public List<String> select_by_userId_Re_judTime(String userId) {
        List<String>result=new ArrayList<>();
        String sql = "SELECT judTime FROM comment  WHERE userId='" + userId + "'order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map comment_map = (Map)iterator.next();
            sql = "judTime:" + comment_map.get("judTime") ;
            result.add(sql);
        }
        return result;
    }

    public List<String> select_by_userId_Re_foodImg(String userId) {
        List<String>result=new ArrayList<>();
        String sql = "SELECT foodImg FROM comment WHERE userId='" + userId + "'order by judTime desc";
//        返回一个list对象，是表中所有信息，即是返回一个map列表，每一个map是一条数据；
        List rows = jdbcTemplate.queryForList(sql);
//        通过map对象获取表中信息；
        Iterator iterator=rows.iterator();
        while(iterator.hasNext()){
            Map comment_map = (Map)iterator.next();
            sql = "foodImg:" + comment_map.get("foodImg");
            result.add(sql);
        }
        return result;
    }

}
