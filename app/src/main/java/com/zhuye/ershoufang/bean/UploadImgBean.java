package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class UploadImgBean extends Base {


    /**
     * data : {"face":"2018/03/28/thumb_5abb450483215.jpg"}
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
         * face : 2018/03/28/thumb_5abb450483215.jpg
         */

        private String face;

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }
    }
}
