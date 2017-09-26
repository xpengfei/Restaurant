package org.sang.Beans;

/**
 * Created by Komachi on 2017/5/19.
 */
public class ResponseBean {
    private String state;
    private String msg;

    public ResponseBean(){
    }

    public ResponseBean(String state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
