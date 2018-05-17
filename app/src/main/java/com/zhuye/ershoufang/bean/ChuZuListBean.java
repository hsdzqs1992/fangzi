package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class ChuZuListBean  extends Base {
    /**
     * data : [{"life_id":"房源id","title":"标题","photo":"图片","area_name":"区域","business_name":"街道","num1":"租金","num2":"面积","select3_name":"压付方式"},{"life_id":"92","title":"亲水湾","photo":"default.jpg","area_name":"库尔勒市","business_name":"团结街道","num1":"2500","num2":"80.0","select3_name":null}]
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
         * life_id : 房源id
         * title : 标题
         * photo : 图片
         * area_name : 区域
         * business_name : 街道
         * num1 : 租金
         * num2 : 面积
         * select3_name : 压付方式
         */

        private String life_id;
        private String title;
        private String photo;
        private String area_name;
        private String business_name;
        private String num1;
        private String num2;
        private String select3_name;

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

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public String getBusiness_name() {
            return business_name;
        }

        public void setBusiness_name(String business_name) {
            this.business_name = business_name;
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

        public String getSelect3_name() {
            return select3_name;
        }

        public void setSelect3_name(String select3_name) {
            this.select3_name = select3_name;
        }
    }
}
