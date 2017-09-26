package org.sang.Beans;

import java.util.List;

/**
 * Created by xpengfei on 2017/5/21.
 */
public class FoodListRespBean {
    private String total;
    private List<Food> rows;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Food> getRows() {
        return rows;
    }

    public void setRows(List<Food> rows) {
        this.rows = rows;
    }
}
