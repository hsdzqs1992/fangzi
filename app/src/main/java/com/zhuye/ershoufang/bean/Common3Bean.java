package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/21 0021.
 */

public class Common3Bean{

    /**
     * life_id : 房屋id
     * title : 名称
     * cate_id : 3二手房 4租房
     * area_id : 区域名称
     * business_id : 街道名称
     * num1 : 售价|租金
     * num2 : 面积
     * select1 : 二手房：房屋类型 出租：房屋类型
     * select5 : ["二手房--房源优劣 租房-配套设施",null]
     * photo : 2016/12/22/thumb_585bb72299109.jpg
     * xiaoqu :  蒲类景观小区
     * fj_select5 : null
     */

    private String life_id;
    private String title;
    private String cate_id;
    private String area_id;
    private String business_id;
    private String num1;
    private String num2;
    private String select1;
    private String photo;
    private String xiaoqu;
    private Object fj_select5;
    private List<String> select5;

    public String getLife_id() {
        return life_id;
    }

    public void setLife_id(String life_id) {
        this.life_id = life_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getSelect1() {
        return select1;
    }

    public void setSelect1(String select1) {
        this.select1 = select1;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public Object getFj_select5() {
        return fj_select5;
    }

    public void setFj_select5(Object fj_select5) {
        this.fj_select5 = fj_select5;
    }

    public List<String> getSelect5() {
        return select5;
    }

    public void setSelect5(List<String> select5) {
        this.select5 = select5;
    }
}
