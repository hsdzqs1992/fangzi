package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/25 0025.
 */

public class JingMaiBean {
    /**
     * id : 竞猜id
     * city_id : 城市id
     * area_id : 区id
     * business_id : 街道id
     * addr : 详细地址
     * photo : 图片
     * qp_money : 启拍加
     * city_name : 市名
     * area_name : 区
     * business_name : 街道
     * chujia : 出价人数
     * money : 最高价
     */

    private String id;
    private String city_id;
    private String area_id;
    private String business_id;
    private String addr;
    private String photo;
    private String qp_money;
    private String city_name;
    private String area_name;
    private String business_name;
    private String chujia;
    private String money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getQp_money() {
        return qp_money;
    }

    public void setQp_money(String qp_money) {
        this.qp_money = qp_money;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getChujia() {
        return chujia;
    }

    public void setChujia(String chujia) {
        this.chujia = chujia;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
