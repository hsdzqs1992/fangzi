package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24 0024.
 */

public class ImgBean extends Base {
    /**
     * data : {"photo":["2018/04/24/thumb_5ade8934eb51b.jpg","2018/04/24/thumb_5ade89350af79.jpg"]}
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
        private List<String> photo;

        public List<String> getPhoto() {
            return photo;
        }

        public void setPhoto(List<String> photo) {
            this.photo = photo;
        }
    }
}
