package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/16 0016.
 */

public class ZhiDingBean {
    /**
     * id : id
     * num : 置顶次数
     * money : 金额
     */

    private String id;
    private String num;
    private String money;

    public Boolean getChoose() {
        return choose;
    }

    public void setChoose(Boolean choose) {
        this.choose = choose;
    }

    private Boolean choose = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
