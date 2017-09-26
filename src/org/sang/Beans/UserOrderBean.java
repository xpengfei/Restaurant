package org.sang.Beans;

/**
 * Created by Komachi on 2017/5/21.
 */
public class UserOrderBean {
    private Long foodid;
    private String foodname;
    private Long foodnumber;
    private String getfoodtime;
    private String foodimg;
    private String foodprice;
    private String pricetype;
    private String sellername;
    private Long id;

    public UserOrderBean(){}

    public UserOrderBean(Long foodid, String foodname, Long foodnumber, String getfoodtime, String foodimg, String foodprice, String pricetype, String sellername, Long id) {
        this.foodid = foodid;
        this.foodname = foodname;
        this.foodnumber = foodnumber;
        this.getfoodtime = getfoodtime;
        this.foodimg = foodimg;
        this.foodprice = foodprice;
        this.pricetype = pricetype;
        this.sellername = sellername;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFoodid() {
        return foodid;
    }

    public void setFoodid(Long foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Long getFoodnumber() {
        return foodnumber;
    }

    public void setFoodnumber(Long foodnumber) {
        this.foodnumber = foodnumber;
    }

    public String getGetfoodtime() {
        return getfoodtime;
    }

    public void setGetfoodtime(String getfoodtime) {
        this.getfoodtime = getfoodtime;
    }

    public String getFoodimg() {
        return foodimg;
    }

    public void setFoodimg(String foodimg) {
        this.foodimg = foodimg;
    }

    public String getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(String foodprice) {
        this.foodprice = foodprice;
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername;
    }
}
