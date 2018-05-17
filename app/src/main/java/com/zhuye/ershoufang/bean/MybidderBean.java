package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/2 0002.
 */

public class MybidderBean {

    /**
     * data : [{"id":"id","city_id":"市id","area_id":"区id","xiaoqu":"小区","addr":"详细地址","qp_money":"怕买价格","start_time":"开始时间","jp_time":"拍卖周期","photo":"图片","city":"市名称","area":"区名称","end_time":"结束时间","money":"成交价格"}]
     * message :
     * code : 200
     */



        /**
         * id : id
         * city_id : 市id
         * area_id : 区id
         * xiaoqu : 小区
         * addr : 详细地址
         * qp_money : 怕买价格
         * start_time : 开始时间
         * jp_time : 拍卖周期
         * photo : 图片
         * city : 市名称
         * area : 区名称
         * end_time : 结束时间
         * money : 成交价格
         */

        private String id;
        private String city_id;
        private String area_id;
        private String xiaoqu;
        private String addr;
        private String qp_money;
        private String start_time;
        private String jp_time;
        private String photo;
        private String city;
        private String area;
        private String end_time;
        private String money;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getXiaoqu() {
            return xiaoqu;
        }

        public void setXiaoqu(String xiaoqu) {
            this.xiaoqu = xiaoqu;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getQp_money() {
            return qp_money;
        }

        public void setQp_money(String qp_money) {
            this.qp_money = qp_money;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getJp_time() {
            return jp_time;
        }

        public void setJp_time(String jp_time) {
            this.jp_time = jp_time;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

}
