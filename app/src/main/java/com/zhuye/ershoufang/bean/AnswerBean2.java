package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/17 0017.
 */

public class AnswerBean2 {

    /**
     * content : 回答
     * create_time : 时间
     * nickname : 昵称
     * face : 头像
     */

    private String content;
    private String create_time;
    private String nickname;
    private String face;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
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
