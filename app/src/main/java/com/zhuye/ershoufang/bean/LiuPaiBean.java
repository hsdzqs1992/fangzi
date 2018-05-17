package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/2 0002.
 */

public class LiuPaiBean extends Base{
    /**
     * data : {"id":"竞拍id","cate_id":"1新房 2二手房 3商铺写字楼 4工业厂房","city_id":"市id","area_id":"区id","business_id":"街道id","lng":"经度","lat":"纬度","addr":"详细地址","num1":"面积","bz_money":"保证金","jia_money":"加价幅度","pg_money":"评估价格","qp_money":"起拍价","ys_time":"延时周期","jp_time":"竞拍周期","start_time":"开始时间","xiaoqu":"小区","city_name":"市名","area_name":"区名","business_name":"街道","photo":["图片"]}
     * message :
     * code : 200
     */

    private DataBean data;


    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 竞拍id
         * cate_id : 1新房 2二手房 3商铺写字楼 4工业厂房
         * city_id : 市id
         * area_id : 区id
         * business_id : 街道id
         * lng : 经度
         * lat : 纬度
         * addr : 详细地址
         * num1 : 面积
         * bz_money : 保证金
         * jia_money : 加价幅度
         * pg_money : 评估价格
         * qp_money : 起拍价
         * ys_time : 延时周期
         * jp_time : 竞拍周期
         * start_time : 开始时间
         * xiaoqu : 小区
         * city_name : 市名
         * area_name : 区名
         * business_name : 街道
         * photo : ["图片"]
         */

        private String id;
        private String cate_id;
        private String city_id;
        private String area_id;
        private String business_id;
        private String lng;
        private String lat;
        private String addr;
        private String num1;
        private String bz_money;
        private String jia_money;
        private String pg_money;
        private String qp_money;
        private String ys_time;
        private String jp_time;
        private String start_time;
        private String xiaoqu;
        private String city_name;
        private String area_name;
        private String business_name;
        private List<String> photo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
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

        public String getBusiness_id() {
            return business_id;
        }

        public void setBusiness_id(String business_id) {
            this.business_id = business_id;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getNum1() {
            return num1;
        }

        public void setNum1(String num1) {
            this.num1 = num1;
        }

        public String getBz_money() {
            return bz_money;
        }

        public void setBz_money(String bz_money) {
            this.bz_money = bz_money;
        }

        public String getJia_money() {
            return jia_money;
        }

        public void setJia_money(String jia_money) {
            this.jia_money = jia_money;
        }

        public String getPg_money() {
            return pg_money;
        }

        public void setPg_money(String pg_money) {
            this.pg_money = pg_money;
        }

        public String getQp_money() {
            return qp_money;
        }

        public void setQp_money(String qp_money) {
            this.qp_money = qp_money;
        }

        public String getYs_time() {
            return ys_time;
        }

        public void setYs_time(String ys_time) {
            this.ys_time = ys_time;
        }

        public String getJp_time() {
            return jp_time;
        }

        public void setJp_time(String jp_time) {
            this.jp_time = jp_time;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getXiaoqu() {
            return xiaoqu;
        }

        public void setXiaoqu(String xiaoqu) {
            this.xiaoqu = xiaoqu;
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

        public List<String> getPhoto() {
            return photo;
        }

        public void setPhoto(List<String> photo) {
            this.photo = photo;
        }
    }
}
