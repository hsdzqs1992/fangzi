package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/15 0015.
 */

public class Common2Bean {
    /**
     * id : 新房id
     * title : 标题
     * area_id : 区域id
     * business_id : 街道id
     * price : 单价
     * mianji : 面积
     * select : 房源种类 1住宅 2商铺 3写字楼 4工业厂房
     * is_onsale : 1期房未收 2期房在售 3期房已售完
     * photo : ["图片","2017/05/23/thumb_59241f39514cf.png","2017/05/23/thumb_59241f4099c7a.png"]
     */

    private String id;
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
