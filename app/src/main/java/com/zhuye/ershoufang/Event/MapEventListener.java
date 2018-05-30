package com.zhuye.ershoufang.Event;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;

/**
 * Created by Administrator on 2018/5/26 0026.
 */

public class MapEventListener implements BaiduMap.OnMapStatusChangeListener,BaiduMap.OnMarkerClickListener {


    /**
     * 手势操作地图，设置地图状态等操作导致地图状态开始改变。
     * @param status 地图状态改变开始时的地图状态
     */
    public void onMapStatusChangeStart(MapStatus status){
    }

    /** 因某种操作导致地图状态开始改变。
     * @param status 地图状态改变开始时的地图状态
     * @param reason 表示地图状态改变的原因，取值有：
     * 1：用户手势触发导致的地图状态改变,比如双击、拖拽、滑动底图
     * 2：SDK导致的地图状态改变, 比如点击缩放控件、指南针图标
     * 3：开发者调用,导致的地图状态改变
     */
    public void onMapStatusChangeStart(MapStatus status, int reason) {

    }

    /**
     * 地图状态变化中
     * @param status 当前地图状态
     */
    public void onMapStatusChange(MapStatus status){
    }

    /**
     * 地图状态改变结束
     * @param status 地图状态改变结束后的地图状态
     */
    public void onMapStatusChangeFinish(MapStatus status){
    }



    /**
     * 地图 Marker 覆盖物点击事件监听函数
     * @param marker 被点击的 marker
     */
    public boolean onMarkerClick(Marker marker){

        return true;
    }
}
