package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/23 0023.
 */

public class XiaoQuBean2 {
    /**
     * id : 小区id
     * xiaoqu : 名称
     * price : 单价
     * area_id : 区域id
     * business_id : 街道id
     * area_name : 区
     * business_name : 街道
     * photo : 图片
     * count : 房源数目
     */

    private String id;
    private String xiaoqu;
    private String price;
    private String area_id;
    private String business_id;
    private String area_name;
    private String business_name;
    private String photo;
    private String count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
