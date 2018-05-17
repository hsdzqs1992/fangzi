package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class FaBuListBean extends Base {

    /**
     * data : [{"life_id":"房源id","title":"房源名称","photo":"房源图片","area_name":"房源区域","business_name":"房源街道","num1":"售价","num2":"面积","select1_name":"其他介绍"}]
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
         * title : 房源名称
         * photo : 房源图片
         * area_name : 房源区域
         * business_name : 房源街道
         * num1 : 售价
         * num2 : 面积
         * select1_name : 其他介绍
         */

        private String life_id;
        private String title;
        private String photo;
        private String area_name;
        private String business_name;
        private String num1;
        private String num2;
        private String select1_name;

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

        public String getSelect1_name() {
            return select1_name;
        }

        public void setSelect1_name(String select1_name) {
            this.select1_name = select1_name;
        }
    }
}
