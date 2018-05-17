package com.zhuye.ershoufang.bean;

/**
 * 第一种数据的通用解析类型 对象类型
 */

public class CommonObjectBean<T> extends Base {
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public T data;
}
