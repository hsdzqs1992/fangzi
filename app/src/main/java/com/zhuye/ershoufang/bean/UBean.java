package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/6/1 0001.
 */

public class UBean {
    /**
     * user_id : 用户id
     * nickname :  昵称
     * face : 头像
     */

    private String user_id;
    private String nickname;
    private String face;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }
}
