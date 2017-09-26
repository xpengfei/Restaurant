package org.sang.Beans;

public class Comment {
  private Long id;
  private String foodname;
  private String judcon;
  private java.sql.Timestamp judtime;
  private String userid;
  private String foodimg;

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

  public java.sql.Timestamp getJudtime() {
    return judtime;
  }

  public void setJudtime(java.sql.Timestamp judtime) {
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
