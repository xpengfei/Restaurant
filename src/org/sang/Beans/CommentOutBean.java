package org.sang.Beans;

import java.sql.Timestamp;

/**
 * Created by Komachi on 2017/5/21.
 */
public class CommentOutBean {
    private Long id;
    private String foodname;
    private String judcon;
    private String judtime;
    private String userid;
    private String foodimg;

    public CommentOutBean(){
    }

    public CommentOutBean(Long id, String foodname, String judcon, String judtime, String userid, String foodimg) {
        this.id = id;
        this.foodname = foodname;
        this.judcon = judcon;
        this.judtime = judtime;
        this.userid = userid;
        this.foodimg = foodimg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getJudcon() {
        return judcon;
    }

    public void setJudcon(String judcon) {
        this.judcon = judcon;
    }

    public String getJudtime() {
        return judtime;
    }

    public void setJudtime(String judtime) {
        this.judtime = judtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFoodimg() {
        return foodimg;
    }

    public void setFoodimg(String foodimg) {
        this.foodimg = foodimg;
    }
}
