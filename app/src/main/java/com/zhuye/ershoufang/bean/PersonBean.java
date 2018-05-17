package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/17 0017.
 */

public class PersonBean {
    /**
     * true_name : 真实姓名
     * card : 身份证号
     * card_img : 身份证图片
     * license : 营业执照
     */

    private String true_name;
    private String card;
    private String card_img;
    private String license;

    public String getTrue_name() {
        return true_name;
    }

    public void setTrue_name(String true_name) {
        this.true_name = true_name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCard_img() {
        return card_img;
    }

    public void setCard_img(String card_img) {
        this.card_img = card_img;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
