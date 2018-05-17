package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class ChanPinBean {
    /**
     * id : id
     * title : 标题
     * photo : 图片
     */

    private String id;
    private String title;
    private String photo;

    private String intro;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
