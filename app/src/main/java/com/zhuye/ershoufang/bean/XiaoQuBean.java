package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/2 0002.
 */

public class XiaoQuBean extends Base{
    /**
     * data : [{"id":"小区id","xiaoqu":"小区名称"},{"id":"2","xiaoqu":"亲亲家园"},{"id":"1","xiaoqu":"兰江公寓"}]
     * message :
     * code : 200
     */


        /**
         * id : 小区id
         * xiaoqu : 小区名称
         */

        private String id;
        private String xiaoqu;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getXiaoqu() {
            return xiaoqu;
        }

        public void setXiaoqu(String xiaoqu) {
            this.xiaoqu = xiaoqu;
        }

}
