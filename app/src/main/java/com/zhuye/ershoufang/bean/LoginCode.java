package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class LoginCode extends Base {


    /**
     * data : {"token":"用户唯一标识token","type":"0普通用户 1经纪人 2房产商 3家居商 4装修商"}
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
         * token : 用户唯一标识token
         * type : 0普通用户 1经纪人 2房产商 3家居商 4装修商
         */

        private String token;
        private String type;
        private String data;
        private String rongyun;

        public String getRongyun() {
            return rongyun;
        }

        public void setRongyun(String rongyun) {
            this.rongyun = rongyun;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
