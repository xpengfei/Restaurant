package org.sang.Beans;

/**
 * Created by Komachi on 2017/5/20.
 */
public class OrderBean {
    private Long foodid;
    private String foodname;
    private Long foodnumber;
    private String getfoodtime;
    private String foodimg;

    public OrderBean(){
    }

    public OrderBean(Long foodid, String foodname, Long foodnumber, String getfoodtime, String foodimg) {
        this.foodid = foodid;
        this.foodname = foodname;
        this.foodnumber = foodnumber;
        this.getfoodtime = getfoodtime;
        this.foodimg = foodimg;
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
}
