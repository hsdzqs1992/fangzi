package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class AreaBean extends Base {
    /**
     * data : [{"id":"区域id","name":"区域名称"},{"id":"14","name":"西城区"},{"id":"22","name":"崇文区"},{"id":"301","name":"密云县"},{"id":"2","name":"市辖区"}]
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
         * id : 区域id
         * name : 区域名称
         */

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
