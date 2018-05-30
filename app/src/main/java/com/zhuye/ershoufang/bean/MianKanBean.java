package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class MianKanBean {
    /**
     * view_id : 免费看房id'
     * title : 标题
     * photo : 图片
     * loupan_id : 楼盘id
     * area : 区域
     * business : 街道
     * price : 价格
     * select : 房源种类 1住宅 2商铺 3写字楼 4工业厂房
     * is_onsale : 房源类型 1期房未售 2期房在售 3期房已售完
     */
    private String view_id;
    private String title;
    private String photo;
    private String loupan_id;
    private String area;
    private String business;
    private String price;
    private String select;
    private String is_onsale;

    public String getView_id() {
        return view_id;
    }

    public void setView_id(String view_id) {
        this.view_id = view_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLoupan_id() {
        return loupan_id;
    }

    public void setLoupan_id(String loupan_id) {
        this.loupan_id = loupan_id;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
}
