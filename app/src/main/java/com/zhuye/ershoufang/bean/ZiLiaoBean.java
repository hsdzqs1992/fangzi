package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/3/28 0028.
 */

public class ZiLiaoBean extends Base {


    /**
     * data : {"mobile":"手机号","nickname":"昵称","face":"头像","sex":"1男 2女","bd":"1表示已绑定 0未绑定"}
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
         * mobile : 手机号
         * nickname : 昵称
         * face : 头像
         * sex : 1男 2女
         * bd : 1表示已绑定 0未绑定
         */

        private String mobile;
        private String nickname;
        private String face;
        private String sex;
        private String bd;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBd() {
            return bd;
        }

        public void setBd(String bd) {
            this.bd = bd;
        }
    }
}
