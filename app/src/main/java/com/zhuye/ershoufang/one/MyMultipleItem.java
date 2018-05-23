package com.zhuye.ershoufang.one;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class MyMultipleItem<T>  implements MultiItemEntity {
    public static final int FIRST_TYPE = 1;
    public static final int SECOND_TYPE = 2;
    public static final int NORMAL_TYPE = 3;

    private int itemType;
    private T data;

    public MyMultipleItem(int itemType, T data) {
        this.itemType = itemType;
        this.data = data;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public T getData(){
        return data;
    }
}

