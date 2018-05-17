package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/17 0017.
 */

public class WenDadetailBean {
    /**
     * id : 问题id
     * question : 问题标题
     * intro : 问题描述
     * create_time : 创建时间
     * answer : [{"content":"回答内容","create_time":"回答时间","nickname":"昵称","face":"头像"}]
     */

    private String id;
    private String question;
    private String intro;
    private String create_time;
    private List<AnswerBean> answer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public List<AnswerBean> getAnswer() {
        return answer;
    }

    public void setAnswer(List<AnswerBean> answer) {
        this.answer = answer;
    }

    public static class AnswerBean {
        /**
         * content : 回答内容
         * create_time : 回答时间
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
}
