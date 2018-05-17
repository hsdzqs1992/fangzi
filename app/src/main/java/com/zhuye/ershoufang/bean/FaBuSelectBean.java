package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class FaBuSelectBean extends Base {

    /**
     * data : {"单选多选名称":[{"attr_id":"id","attr_name":"单选|多选值"},{"attr_id":"22","attr_name":"商务公寓"},{"attr_id":"21","attr_name":"普通公寓"},{"attr_id":"20","attr_name":"普通住宅"}],"朝向":[{"attr_id":"230","attr_name":"南北"},{"attr_id":"229","attr_name":"东南"},{"attr_id":"228","attr_name":"南北"},{"attr_id":"227","attr_name":"东西"}],"装修程度":[{"attr_id":"30","attr_name":"毛坯房"},{"attr_id":"29","attr_name":"精装修"},{"attr_id":"28","attr_name":"简装修"}],"年代":[{"attr_id":"240","attr_name":"其他"},{"attr_id":"239","attr_name":"2017年"},{"attr_id":"238","attr_name":"2016年"},{"attr_id":"237","attr_name":"2015年"},{"attr_id":"236","attr_name":"2014年"}],"房源优劣":[{"attr_id":"105","attr_name":"特价房"},{"attr_id":"104","attr_name":"学区房"},{"attr_id":"103","attr_name":"地铁房"},{"attr_id":"102","attr_name":"交通便利"},{"attr_id":"101","attr_name":"繁华地段"}]}
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
        private List<单选多选名称Bean> 单选多选名称;
        private List<朝向Bean> 朝向;
        private List<装修程度Bean> 装修程度;
        private List<年代Bean> 年代;
        private List<房源优劣Bean> 房源优劣;

        public List<房屋类型Bean> get房屋类型() {
            return 房屋类型;
        }

        public void set房屋类型(List<房屋类型Bean> 房屋类型) {
            this.房屋类型 = 房屋类型;
        }

        private List<房屋类型Bean> 房屋类型;
        public List<单选多选名称Bean> get单选多选名称() {
            return 单选多选名称;
        }

        public void set单选多选名称(List<单选多选名称Bean> 单选多选名称) {
            this.单选多选名称 = 单选多选名称;
        }

        public List<朝向Bean> get朝向() {
            return 朝向;
        }

        public void set朝向(List<朝向Bean> 朝向) {
            this.朝向 = 朝向;
        }

        public List<装修程度Bean> get装修程度() {
            return 装修程度;
        }

        public void set装修程度(List<装修程度Bean> 装修程度) {
            this.装修程度 = 装修程度;
        }

        public List<年代Bean> get年代() {
            return 年代;
        }

        public void set年代(List<年代Bean> 年代) {
            this.年代 = 年代;
        }

        public List<房源优劣Bean> get房源优劣() {
            return 房源优劣;
        }

        public void set房源优劣(List<房源优劣Bean> 房源优劣) {
            this.房源优劣 = 房源优劣;
        }

        public static class 单选多选名称Bean {
            /**
             * attr_id : id
             * attr_name : 单选|多选值
             */

            private String attr_id;
            private String attr_name;

            public String getAttr_id() {
                return attr_id;
            }

            public void setAttr_id(String attr_id) {
                this.attr_id = attr_id;
            }

            public String getAttr_name() {
                return attr_name;
            }

            public void setAttr_name(String attr_name) {
                this.attr_name = attr_name;
            }
        }

        public static class 房屋类型Bean {
            /**
             * attr_id : 230
             * attr_name : 南北
             */

            private String attr_id;
            private String attr_name;

            public String getAttr_id() {
                return attr_id;
            }

            public void setAttr_id(String attr_id) {
                this.attr_id = attr_id;
            }

            public String getAttr_name() {
                return attr_name;
            }

            public void setAttr_name(String attr_name) {
                this.attr_name = attr_name;
            }
        }
        public static class 朝向Bean {
            /**
             * attr_id : 230
             * attr_name : 南北
             */

            private String attr_id;
            private String attr_name;

            public String getAttr_id() {
                return attr_id;
            }

            public void setAttr_id(String attr_id) {
                this.attr_id = attr_id;
            }

            public String getAttr_name() {
                return attr_name;
            }

            public void setAttr_name(String attr_name) {
                this.attr_name = attr_name;
            }
        }

        public static class 装修程度Bean {
            /**
             * attr_id : 30
             * attr_name : 毛坯房
             */

            private String attr_id;
            private String attr_name;

            public String getAttr_id() {
                return attr_id;
            }

            public void setAttr_id(String attr_id) {
                this.attr_id = attr_id;
            }

            public String getAttr_name() {
                return attr_name;
            }

            public void setAttr_name(String attr_name) {
                this.attr_name = attr_name;
            }
        }

        public static class 年代Bean {
            /**
             * attr_id : 240
             * attr_name : 其他
             */

            private String attr_id;
            private String attr_name;

            public String getAttr_id() {
                return attr_id;
            }

            public void setAttr_id(String attr_id) {
                this.attr_id = attr_id;
            }

            public String getAttr_name() {
                return attr_name;
            }

            public void setAttr_name(String attr_name) {
                this.attr_name = attr_name;
            }
        }

        public static class 房源优劣Bean {
            /**
             * attr_id : 105
             * attr_name : 特价房
             */

            private String attr_id;
            private String attr_name;

            public String getAttr_id() {
                return attr_id;
            }

            public void setAttr_id(String attr_id) {
                this.attr_id = attr_id;
            }

            public String getAttr_name() {
                return attr_name;
            }

            public void setAttr_name(String attr_name) {
                this.attr_name = attr_name;
            }
        }
    }
}
