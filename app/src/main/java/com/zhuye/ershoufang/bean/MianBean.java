package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/15 0015.
 */

public class MianBean {
    /**
     * id : 免费看房id
     * user_id : 用户id
     * loupan_id : 楼盘id
     * photo : 图片
     * title : 标题
     * youlie : ["优劣"]
     * leixing : [""]
     * mobile : 手机号
     * start_time : 开始时间
     * guize : 规则
     * sm : 免责声明
     * addr : 地址
     * youhui : 优惠
     * create_time : 创建时间
     * loupan : 楼盘名称
     */

    private String id;
    private String user_id;
    private String loupan_id;
    private String photo;
    private String title;
    private String mobile;
    private String start_time;
    private String guize;
    private String sm;
    private String addr;
    private String youhui;
    private String create_time;
    private String loupan;
    private List<String> youlie;
    private List<String> leixing;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLoupan_id() {
        return loupan_id;
    }

    public void setLoupan_id(String loupan_id) {
        this.loupan_id = loupan_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getGuize() {
        return guize;
    }

    public void setGuize(String guize) {
        this.guize = guize;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getYouhui() {
        return youhui;
    }

    public void setYouhui(String youhui) {
        this.youhui = youhui;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getLoupan() {
        return loupan;
    }

    public void setLoupan(String loupan) {
        this.loupan = loupan;
    }

    public List<String> getYoulie() {
        return youlie;
    }

    public void setYoulie(List<String> youlie) {
        this.youlie = youlie;
    }

    public List<String> getLeixing() {
        return leixing;
    }

    public void setLeixing(List<String> leixing) {
        this.leixing = leixing;
    }
}
