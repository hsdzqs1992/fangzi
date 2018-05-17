package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/7 0007.
 */

public class HomeJinBean {
    /**
     * user_id : 用户id
     * face : 头像
     * true_name : 姓名
     * shop : 店铺
     * area_id : 区域id
     * score : 评分
     * area_name : 区域名
     * tese : ["特色"]
     */

    private String user_id;
    private String face;
    private String true_name;
    private String shop;
    private String area_id;
    private String score;
    private String area_name;
    private List<String> tese;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getTrue_name() {
        return true_name;
    }

    public void setTrue_name(String true_name) {
        this.true_name = true_name;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public List<String> getTese() {
        return tese;
    }

    public void setTese(List<String> tese) {
        this.tese = tese;
    }
}
