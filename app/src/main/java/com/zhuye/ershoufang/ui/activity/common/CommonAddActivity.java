package com.zhuye.ershoufang.ui.activity.common;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.utils.LogUtils;

public abstract class CommonAddActivity extends BaseActivity {


    protected GeoCoder mSearch;



    @Override
    protected void initData() {
        super.initData();
        mSearch = GeoCoder.newInstance();
        mSearch.setOnGetGeoCodeResultListener(listener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearch.destroy();
    }

    protected String latitude;
    protected String longitude;

    OnGetGeoCoderResultListener listener = new OnGetGeoCoderResultListener() {

        public void onGetGeoCodeResult(GeoCodeResult result) {

            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有检索到结果
            }

            //获取地理编码结果
            LogUtils.i(result.getLocation().latitude+"");
            latitude = String.valueOf(result.getLocation().latitude);
            longitude = String.valueOf(result.getLocation().longitude);
        }

        @Override

        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {

            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有找到检索结果
            }

            //获取反向地理编码结果
        }
    };
}
