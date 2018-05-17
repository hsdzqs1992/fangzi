package com.zhuye.ershoufang.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public class CommonListBean<T> extends Base {

    public List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
