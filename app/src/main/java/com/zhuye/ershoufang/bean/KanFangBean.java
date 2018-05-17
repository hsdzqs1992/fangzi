package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class KanFangBean {
    /**
     * id : 看房id
     * title : 标题
     * addr : 地址
     * start_time : 开始时间戳
     * photo : 图片
     * loupan_id : 楼盘id
     * youlie : ["优劣"]
     * price : 单价
     * is_onsale : 房源类型 1期房未收 2期房在售 3期房已售完
     * count : 报名人数
     */

    private String id;
    private String title;
    private String addr;
    private String start_time;
    private String photo;
    private String loupan_id;
    private String price;
    private String is_onsale;
    private String count;
    private List<String> youlie;

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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIs_onsale() {
        return is_onsale;
    }

    public void setIs_onsale(String is_onsale) {
        this.is_onsale = is_onsale;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<String> getYoulie() {
        return youlie;
    }

    public void setYoulie(List<String> youlie) {
        this.youlie = youlie;
    }
}
