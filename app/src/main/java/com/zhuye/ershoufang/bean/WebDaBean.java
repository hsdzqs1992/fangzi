package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/25 0025.
 */

public class WebDaBean  extends Base{
    /**
     * data : [{"id":"问题id","question":"问题标题","intro":"问题描述","create_time":"时间","answer":"回答数目"}]
     * message :
     * code : 200
     */


    private List<DataBean> data;


    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 问题id
         * question : 问题标题
         * intro : 问题描述
         * create_time : 时间
         * answer : 回答数目
         */

        private String id;
        private String question;
        private String intro;
        private String create_time;
        private String answer;

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

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }
}
