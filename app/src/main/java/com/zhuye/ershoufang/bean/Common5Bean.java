package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/21 0021.
 */

public class Common5Bean {

    private String id;
    /**
     * id : 1
     * title : 经典楼盘
     * area_id : 12743
     * business_id : 46424
     * price : 900
     * mianji : 0
     * select : 1
     * is_onsale : 1
     * photo : ["2017/05/23/thumb_59241f31df65f.png","2017/05/23/thumb_59241f39514cf.png","2017/05/23/thumb_59241f4099c7a.png"]
     */

    private String area;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    private String business;
    private String area_name;
    private String business_name;

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

    private String title;
    private String area_id;
    private String business_id;
    private String price;
    private String mianji;
    private String select;
    private String is_onsale;
    private List<String> photo;

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

    public List<String> getPhoto() {
        return photo;
    }

    public void setPhoto(List<String> photo) {
        this.photo = photo;
    }

}
