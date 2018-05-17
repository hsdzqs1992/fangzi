package com.zhuye.ershoufang.data;

import com.zhuye.ershoufang.bean.Base;

/**
 * Created by Administrator on 2018/1/10 0010.
 */

public interface BaseView<T extends Base>  {
    void loding();
    void finishLoding();
    void error(T t);
    void success(int requestcode, T t);
    void empty();
}
