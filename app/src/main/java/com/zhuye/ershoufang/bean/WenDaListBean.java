package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class WenDaListBean  extends Base {
    /**
     * data : [{"question_id":"问题id","question":"问题内容","intro":"问题描述","create_time":"发布时间","answer":"回答总数"}]
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
         * question_id : 问题id
         * question : 问题内容
         * intro : 问题描述
         * create_time : 发布时间
         * answer : 回答总数
         */

        private String question_id;
        private String question;
        private String intro;
        private String create_time;
        private String answer;

        public String getQuestion_id() {
            return question_id;
        }

        public void setQuestion_id(String question_id) {
            this.question_id = question_id;
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
