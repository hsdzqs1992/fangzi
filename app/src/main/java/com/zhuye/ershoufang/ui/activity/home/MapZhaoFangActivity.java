package com.zhuye.ershoufang.ui.activity.home;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.zhuye.ershoufang.Event.MapEventListener;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MapZhaoFangActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.xinfang)
    TextView xinfang;
    @BindView(R.id.ershoufang)
    TextView ershoufang;
    @BindView(R.id.zufang)
    TextView zufang;
    @BindView(R.id.quyu)
    TextView quyu;
    @BindView(R.id.jiage)
    TextView jiage;
    @BindView(R.id.huxing)
    TextView huxing;
    @BindView(R.id.bmapView)
    MapView bmapView;

    @Override
    protected int getResId() {
        return R.layout.activity_map_zhao_fang;
    }

    public void choose(TextView textView, TextView textView1, TextView textView2) {
        int white = getResources().getColor(R.color.white);
        Drawable whitebg = getResources().getDrawable(R.drawable.shape_tuijian);
        int pramy = getResources().getColor(R.color.colorPrimary);
        Drawable pramybg = getResources().getDrawable(R.drawable.shape_tuijian2);
        textView.setTextColor(pramy);
        textView.setBackground(whitebg);

        textView1.setTextColor(white);
        textView1.setBackground(pramybg);
        textView2.setTextColor(white);
        textView2.setBackground(pramybg);
    }


    @OnClick({R.id.back, R.id.xinfang, R.id.ershoufang, R.id.zufang, R.id.quyu, R.id.jiage, R.id.huxing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.xinfang:
                choose(xinfang, ershoufang, zufang);
                break;
            case R.id.ershoufang:
                choose(ershoufang, xinfang, zufang);
                break;
            case R.id.zufang:
                choose(zufang, ershoufang, xinfang);
                break;
            case R.id.quyu:
                break;
            case R.id.jiage:

                break;
            case R.id.huxing:
                break;
        }
    }




    @Override
    protected void requestBefore() {
        super.requestBefore();
        //
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        bmapView.onDestroy();
        mSearch.destroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        bmapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        bmapView.onPause();
    }

    private BaiduMap mBaiduMap;
    @Override
    protected void initView() {
        super.initView();
        mBaiduMap = bmapView.getMap();
        setUserMapCenter();

        getCenter();
    }
    GeoCoder mSearch;
    private void getCenter() {
        mSearch = GeoCoder.newInstance();
        mSearch.setOnGetGeoCodeResultListener(listener);
//        mSearch.geocode(new GeoCodeOption()
//                .city(SharedPreferencesUtil.getInstance().getString("city"))
//                .address(SharedPreferencesUtil.getInstance().getString("addr")));
//        建德市人大常委会
                mSearch.geocode(new GeoCodeOption()
                .city("建德市")
                .address("建德市人大常委会"));
    }

    OnGetGeoCoderResultListener listener = new OnGetGeoCoderResultListener() {
        public void onGetGeoCodeResult(GeoCodeResult result) {
            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有检索到结果
                mSearch.geocode(new GeoCodeOption()
                        .city(SharedPreferencesUtil.getInstance().getString("city"))
                        .address(SharedPreferencesUtil.getInstance().getString("addr")));
                return;
            }
            lat =result.getLocation().latitude;
            lon =result.getLocation().longitude;
            setUserMapCenter();
            //获取地理编码结果
           // Log.i("asdf",result.getLocation().longitude+"");
            MapEventListener listener = new MapEventListener();
            mBaiduMap.setOnMapStatusChangeListener(listener);
            mBaiduMap.setOnMarkerClickListener(listener);
        }

        @Override

        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {

            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有找到检索结果
            }
            //获取反向地理编码结果
        }
    };


    double lat;
    double lon;
    private void setUserMapCenter() {
      //  Log.v("pcw","setUserMapCenter : lat : "+ lat+" lon : " + lon);
//        double lat =Double.parseDouble(SharedPreferencesUtil.getInstance().getString("latitude"));
//        double lon =Double.parseDouble(SharedPreferencesUtil.getInstance().getString("longitude"));
        LatLng cenpt = new LatLng(lat,lon);
        //定义地图状态
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(cenpt)
                .zoom(15)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        //改变地图状态
        mBaiduMap.setMapStatus(mMapStatusUpdate);
    }


    /**
     * 添加marker
     */
    private void setMarker() {
       // Log.v("pcw","setMarker : lat : "+ lat+" lon : " + lon);
        //定义Maker坐标点
//        LatLng point = new LatLng(lat, lon);
//        //构建Marker图标
//        BitmapDescriptor bitmap = BitmapDescriptorFactory
//                .fromResource(R.drawable.location_marker);
//        //构建MarkerOption，用于在地图上添加Marker
//        OverlayOptions option = new MarkerOptions()
//                .position(point)
//                .icon(bitmap);
//        //在地图上添加Marker，并显示
//        mBaiduMap.addOverlay(option);
    }
}

