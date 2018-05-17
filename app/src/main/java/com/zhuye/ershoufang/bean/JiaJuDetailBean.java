package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/7 0007.
 */

public class JiaJuDetailBean {
    /**
     * id : 产品id
     * user_id : 商户id
     * photo : 产品图片
     * title : 标题
     * intro : 介绍
     * shop_name : 家具商名称
     */

    private String id;
    private String user_id;
    private String photo;
    private String title;
    private String intro;
    private String shop_name;

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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }
}
