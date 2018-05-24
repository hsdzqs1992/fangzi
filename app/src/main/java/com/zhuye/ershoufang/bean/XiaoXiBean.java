package com.zhuye.ershoufang.bean;

/**
 * Created by Administrator on 2018/5/23 0023.
 */

public class XiaoXiBean {
    /**
     * id : id
     * xiaoxi_id : 消息id
     * message : 消息内容
     * create_time : 时间
     */

    private String id;
    private String xiaoxi_id;
    private String message;
    private String create_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXiaoxi_id() {
        return xiaoxi_id;
    }

    public void setXiaoxi_id(String xiaoxi_id) {
        this.xiaoxi_id = xiaoxi_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
