package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/4 0004.
 */

public class JingJiRenBean {

    /**
     * data : {"shop":"公司","main_business":"经纪人主营--0住宅 1商业地产","city_id":"城市id","city":"城市","area_id":"区域id","area":"区域","declaration":"宣言","intro":"简介","year":"year","company":"公司门店","xiaoqu":"主营小区","tese":"房源特点","yjbi":"yjbi","jingli":[{"jingli":"经历","zhiwei":"职位"}]}
     * message :
     * code : 200
     */
        /**
         * shop : 公司
         * main_business : 经纪人主营--0住宅 1商业地产
         * city_id : 城市id
         * city : 城市
         * area_id : 区域id
         * area : 区域
         * declaration : 宣言
         * intro : 简介
         * year : year
         * company : 公司门店
         * xiaoqu : 主营小区
         * tese : 房源特点
         * yjbi : yjbi
         * jingli : [{"jingli":"经历","zhiwei":"职位"}]
         */

        private String shop;
        private String main_business;
        private String city_id;
        private String city;
        private String area_id;
        private String area;
        private String declaration;
        private String intro;
        private String year;
        private String company;
        private String xiaoqu;
        private String tese;
        private String yjbi;
        private List<JingliBean> jingli;

        public String getShop() {
            return shop;
        }

        public void setShop(String shop) {
            this.shop = shop;
        }

        public String getMain_business() {
            return main_business;
        }

        public void setMain_business(String main_business) {
            this.main_business = main_business;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getDeclaration() {
            return declaration;
        }

        public void setDeclaration(String declaration) {
            this.declaration = declaration;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getXiaoqu() {
            return xiaoqu;
        }

        public void setXiaoqu(String xiaoqu) {
            this.xiaoqu = xiaoqu;
        }

        public String getTese() {
            return tese;
        }

        public void setTese(String tese) {
            this.tese = tese;
        }

        public String getYjbi() {
            return yjbi;
        }

        public void setYjbi(String yjbi) {
            this.yjbi = yjbi;
        }

        public List<JingliBean> getJingli() {
            return jingli;
        }

        public void setJingli(List<JingliBean> jingli) {
            this.jingli = jingli;
        }

        public static class JingliBean {
            /**
             * jingli : 经历
             * zhiwei : 职位
             */

            private String jingli;
            private String zhiwei;

            public String getJingli() {
                return jingli;
            }

            public void setJingli(String jingli) {
                this.jingli = jingli;
            }

            public String getZhiwei() {
                return zhiwei;
            }

            public void setZhiwei(String zhiwei) {
                this.zhiwei = zhiwei;
            }
        }

}
