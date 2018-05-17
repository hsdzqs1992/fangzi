package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class FangChanBean {
    /**
     * account : 账号
     * shop : 房产商
     * card_img : 身份证图片
     * license : 营业执照图片
     */

    private String account;
    private String shop;
    private String card_img;
    private String license;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
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
