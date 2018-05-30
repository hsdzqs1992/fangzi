package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class LoginCodeBean extends Base {

    /**
     * data : {"token":"8e4c60839b2de4b5e045ecd68bf7ec1d","type":0}
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
         * token : 8e4c60839b2de4b5e045ecd68bf7ec1d
         * type : 0
         */

        private String token;
        private int type;
        private String rongyun;

        public String getRongyun() {
            return rongyun;
        }

        public void setRongyun(String rongyun) {
            this.rongyun = rongyun;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
