package org.sang.Beans;

public class Foodorder {
  private Long id;
  private Long foodid;
  private String userid;
  private Long foodnumber;
  private Long sellerid;
  private String create_date;
  private String getfoodtime;
  private Long isfinish;
  private String foodcode;

  public Foodorder() {
  }

  public Foodorder(Long id, Long foodid, String userid, Long foodnumber, Long sellerid, String create_date, String getfoodtime, Long isfinish, String foodcode) {
    this.id = id;
    this.foodid = foodid;
    this.userid = userid;
    this.foodnumber = foodnumber;
    this.sellerid = sellerid;
    this.create_date = create_date;
    this.getfoodtime = getfoodtime;
    this.isfinish = isfinish;
    this.foodcode = foodcode;
  }

  public Long getId() {return id;}

  public void setId(Long id) {
    this.id = id;
  }

  public Long getFoodid() {
    return foodid;
  }

  public void setFoodid(Long foodid) {
    this.foodid = foodid;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public Long getFoodnumber() {
    return foodnumber;
  }

  public void setFoodnumber(Long foodnumber) {
    this.foodnumber = foodnumber;
  }

  public Long getSellerid() {
    return sellerid;
  }

  public void setSellerid(Long sellerid) {
    this.sellerid = sellerid;
  }

  public String getCreate_date() {
    return create_date;
  }

  public void setCreate_date(String create_date) {
    this.create_date = create_date;
  }

  public String getGetfoodtime() {
    return getfoodtime;
  }

  public void setGetfoodtime(String getfoodtime) {
    this.getfoodtime = getfoodtime;
  }

  public Long getIsfinish() {
    return isfinish;
  }

  public void setIsfinish(Long isfinish) {
    this.isfinish = isfinish;
  }

  public String getFoodcode() {
    return foodcode;
  }

  public void setFoodcode(String foodcode) {
    this.foodcode = foodcode;
  }
}
