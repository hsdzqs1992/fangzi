package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/2 0002.
 */

public class PaiMaiBean extends Base{
    /**
     * data : [{"bidder_id":"竞拍id","money":"我出的价格","photo":"图片","city_name":"城市","area_name":"区","business_name":"街道","addr":"详细地址","end_time":"结束时间","qp_money":"拍卖价格","cj_money":"成交价格"}]
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
         * bidder_id : 竞拍id
         * money : 我出的价格
         * photo : 图片
         * city_name : 城市
         * area_name : 区
         * business_name : 街道
         * addr : 详细地址
         * end_time : 结束时间
         * qp_money : 拍卖价格
         * cj_money : 成交价格
         */

        private String bidder_id;
        private String money;
        private String photo;
        private String city_name;
        private String area_name;
        private String business_name;
        private String addr;
        private String end_time;
        private String qp_money;
        private String cj_money;

        public String getBidder_id() {
            return bidder_id;
        }

        public void setBidder_id(String bidder_id) {
            this.bidder_id = bidder_id;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
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

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getQp_money() {
            return qp_money;
        }

        public void setQp_money(String qp_money) {
            this.qp_money = qp_money;
        }

        public String getCj_money() {
            return cj_money;
        }

        public void setCj_money(String cj_money) {
            this.cj_money = cj_money;
        }
    }
}
