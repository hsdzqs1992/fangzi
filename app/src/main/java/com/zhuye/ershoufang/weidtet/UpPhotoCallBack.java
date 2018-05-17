package com.zhuye.ershoufang.weidtet;

import com.zhuye.ershoufang.bean.ImgBean;

/**
 * Created by Administrator on 2018/5/12 0012.
 */

public interface UpPhotoCallBack {
    void success(ImgBean imgBean,int code);
    void onError(String msg,int code);
}
