package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/17 0017.
 */

public class AnswerBean<T> {
    public List<T> getAnswer() {
        return answer;
    }

    public void setAnswer(List<T> answer) {
        this.answer = answer;
    }

    private List<T> answer;


}
