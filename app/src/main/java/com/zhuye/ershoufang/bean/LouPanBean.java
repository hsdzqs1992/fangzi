package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class LouPanBean {
    /**
     * id : 楼盘id
     * title : 楼盘名称
     * uid : 发布者id
     * area_id : 区id
     * business_id : 街道id
     * price : 单价
     * mianji : 面积
     * select : 房源种类 1住宅 2别墅 3商业 4复式
     * is_onsale : 房源类型 1期房未收 2期房在售 3期房已售完
     * area_name : 区
     * business_name : 街道
     * shop : 房产商
     * img : 图片
     */

    private String id;
    private String title;
    private String uid;
    private String area_id;
    private String business_id;
    private String price;
    private String mianji;
    private String select;
    private String is_onsale;
    private String area_name;
    private String business_name;
    private String shop;
    private String img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMianji() {
        return mianji;
    }

    public void setMianji(String mianji) {
        this.mianji = mianji;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getIs_onsale() {
        return is_onsale;
    }

    public void setIs_onsale(String is_onsale) {
        this.is_onsale = is_onsale;
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

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
