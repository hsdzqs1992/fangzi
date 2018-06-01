package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/6/1 0001.
 */

public class ShareBean {
    /**
     * life_id : 房源id
     * title : 标题
     * url : 分享url
     * photo : 图片
     */

    private String life_id;
    private String title;
    private String url;
    private String photo;

    public String getLife_id() {
        return life_id;
    }

    public void setLife_id(String life_id) {
        this.life_id = life_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
