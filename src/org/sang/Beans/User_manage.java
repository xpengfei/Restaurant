package org.sang.Beans;

public class User_manage {
  private Long id;
  private String phonenumber;
  private String email;
  private String password;
  private Long state;

  public User_manage() {
  }

  public User_manage(Long id, String phonenumber, String email, String password, Long state) {
    this.id = id;
    this.phonenumber = phonenumber;
    this.email = email;
    this.password = password;
    this.state = state;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
    this.state = state;
  }
}
