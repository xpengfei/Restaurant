package org.sang.Beans;

public class User_Mana {
  private Long id;
  private String userid;
  private String password;
  private String windowname;
  private String phonenumber;
  private String windowimg;

  public User_Mana() {
  }

  public User_Mana(Long id, String userid, String password, String windowname, String phonenumber, String windowimg) {
    this.id = id;
    this.userid = userid;
    this.password = password;
    this.windowname = windowname;
    this.phonenumber = phonenumber;
    this.windowimg = windowimg;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getWindowname() {
    return windowname;
  }

  public void setWindowname(String windowname) {
    this.windowname = windowname;
  }

  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public String getWindowimg() {
    return windowimg;
  }

  public void setWindowimg(String windowimg) {
    this.windowimg = windowimg;
  }
}
