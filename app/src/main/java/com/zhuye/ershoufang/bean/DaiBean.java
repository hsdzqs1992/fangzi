package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/8 0008.
 */

public class DaiBean {
    /**
     * life_id : id
     * title : 需求
     * mobile : 手机号
     * jd_name : 接单人名
     * jd_mobile : 接单手机号
     */
//{"data":{"life_id":"90","uid":"0","title":"\u53f7","mobile":"13676981716","jd_name":"","jd_mobile":""},"message":"","code":"200"}
    private String life_id;
    private String title;
    private String mobile;
    private String jd_name;
    private String jd_mobile;

    public String getLife_id() {
        return life_id;
    }

    public void setLife_id(String life_id) {
        this.life_id = life_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getJd_name() {
        return jd_name;
    }

    public void setJd_name(String jd_name) {
        this.jd_name = jd_name;
    }

    public String getJd_mobile() {
        return jd_mobile;
    }

    public void setJd_mobile(String jd_mobile) {
        this.jd_mobile = jd_mobile;
    }
}
