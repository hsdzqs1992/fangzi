package com.zhuye.ershoufang.base;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.zhuye.ershoufang.adapter.CommonBaseQuickAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CityBean;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.data.BaseView;
import com.zhuye.ershoufang.receiver.NetworkChangeReceiver;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;
import com.zhuye.ershoufang.weidtet.CustomProgressDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T> extends AppCompatActivity implements BaseView {
    protected Integer type;
    private CustomProgressDialog dialog;
    protected static final int LIST = 200;
    public Gson gson;
    protected static final int ADD = 202;
    protected String[] titles;
    protected static final int INIT = 10023;
    protected final static int REFRESHBASE = 10000;
    protected final static int LOADMOREBASE = 10001;

    protected CommonListBean<T> listData;
    protected  List<T> list = new ArrayList<>();
    protected BaseQuickAdapter adapter;
    protected CommonBaseQuickAdapter adapter2;
    protected LinearLayoutManager layoutManager = new LinearLayoutManager(this) ;

    protected Handler mHandler = new Handler();
    public int page = 1;



    public String getIndex(CityBean bean, String value) {
        String id = "";
        for (int i = 0; i < bean.getData().size(); i++) {
            if (bean.getData().get(i).getName().equals(value)) {
                id = bean.getData().get(i).getId();
            }
        }
        return id;
    }

    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        getWindow().setAttributes(lp);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestBefore();
        setContentView(getResId());
        unbinder=  ButterKnife.bind(this);
        dialog = new CustomProgressDialog(this, "加载中");
        dialog.setCanceledOnTouchOutside(false);
        initView();
        initData();
        initListener();
        regeist();
    }

    protected void requestBefore() {
    }

    protected  void initListener(){

    }

    protected  void initData(){

    }

    /**
     * 按顺序取出传递的参数f
     */
    //返回数据类型不确定
    protected Object getTData(int type , int positon){
        Object t = null ;
        switch (type){
            case 0:
                t = getIntent().getStringExtra("arg"+positon);
                break;
            case 1:
                t =  Integer.parseInt(getIntent().getStringExtra("arg"+positon)) ;
                break;
            case 2:
                t =  Boolean.parseBoolean(getIntent().getStringExtra("arg"+positon));//getIntent().getBooleanExtra("arg"+positon,false);
                break;
        }
        //getTData(Integer.class,0);
       return t;
    }

    public String getToken(){
        return getSpData("token2");
    }

    public String getSpData(String key){
        return SharedPreferencesUtil.getInstance().getString(key);
    }

    public void setSpData(String key,String value){
        SharedPreferencesUtil.getInstance().putString(key,value);
    }

    protected Object getTData(Class type , int positon){
       // type t  ;
        // TODO: 2018/3/27 0027
//        switch (type){
//            case 0:
//                t = getIntent().getStringExtra("arg"+positon);
//                break;
//            case 1:
//                t =  getIntent().getIntExtra("arg"+positon,0);
//                break;
//            case 2:
//                t =  getIntent().getBooleanExtra("arg"+positon,false);
//                break;
//        }
        return null;
    }

    protected void initView() {
    }

    protected Unbinder unbinder;


    protected abstract int getResId();

    public void toast(String content){
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
    }

    public Boolean isEmpty(EditText et){
        if(TextUtils.isEmpty(et.getText().toString().trim())){
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkEmpty( EditText et, String content){
        if(isEmpty(et)){
            toast(content);
            return false;
        }else {
            return true;
        }
    }

    public Boolean checkArray( List et, String content){
        if(et==null || et.size()==0){
            toast(content);
            return false;
        }else {
            return true;
        }
    }

    public Boolean checkEql( TextView et ,String con, String content){
        if(et.getText().toString().trim().equals(con)){
            toast(content);
            return false;
        }else {
            return true;
        }
    }
    public Boolean checkNull( Object object, String content){
        if(object == null){
            toast(content);
            return false;
        }else {
            return true;
        }

    }
    public Boolean isEmpty(String et){
        if(TextUtils.isEmpty(et.trim())){
            return true;
        }else {
            return false;
        }
    }

    public String  getString(EditText et){
        return et.getText().toString().trim();
    }
    public String getString(TextView tv){
        return tv.getText().toString().trim();
    }

    @Override
    public void loding() {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void finishLoding() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void error(Base o) {
        Base base = (Base) o;
        toast(base.getMessage());
    }

    @Override
    public void success(int requestcode, Base base) {

    }

    @Override
    public void empty() {

    }

    protected void hide(View view){
        view.setVisibility(View.GONE);
    }

    protected void show(View view){
        view.setVisibility(View.VISIBLE);
    }

    protected void setText(TextView view,String content){
        view.setText(content);
    }

    //List<>

    /**
     * 新建了一个activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activitys != null && activitys.size() > 0) {
            if(!activitys.contains(activity)){
                activitys.add(activity);
            }
        }else{
            activitys.add(activity);
        }
    }


    public void start(Class cls,String... args){
          start(cls,false,args);
    }

    public void start(Class cls, boolean b,String... args){
        Intent intent = new Intent(this,cls);
        int i = 0;
        for(String arg :  args){
            intent.putExtra("arg"+i,arg);
            ++i;
        }
        startActivity(intent);
        if(b){
            this.finish();
        }
    }

    /**
     * 结束指定的Activity
     *
     * @param activity
     */
//    public void finishActivity(Activity activity) {
//        if (activity != null) {
//            this.activities.remove(activity);
//            activity.finish();
//            activity = null;
//        }
//    }

    /*
   *给临时Activitys
   * 添加activity
   * */
    public void addTemActivity(Activity activity) {
        activitys.add(activity);
    }

    public void finishTemActivity(Activity activity) {
        if (activity != null) {
            this.activitys.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /*
    * 退出指定的Activity
    * */
    public void exitActivitys() {
        for (Activity activity : activitys) {
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /**
     * 应用退出，结束所有的activity
     */
    public void exit() {
        for (Activity activity : activitys) {
            if (activity != null) {
                activity.finish();
            }
        }
        System.exit(0);
    }

    //记录当前栈里所有activity
    //private List<Activity> activities = new ArrayList<Activity>();
    //记录需要一次性关闭的页面
    private static final List<Activity> activitys = new ArrayList<Activity>();

    private void regeist() {
//        IntentFilter filter = new IntentFilter();
//        //监听wifi连接（手机与路由器之间的连接）
//        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
//        //监听互联网连通性（也就是是否已经可以上网了），当然只是指wifi网络的范畴
//        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
//        //这个是监听网络状态的，包括了wifi和移动网络。
//        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
//        receiver= new NetworkChangeReceiver();
//        registerReceiver(receiver, filter);
    }

    NetworkChangeReceiver receiver;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregisterReceiver(receiver);
    }

    public String getQuId(){
        return "12743";
    }
//    public String getQuId(){
//        return SharedPreferencesUtil.getInstance().getString("qu_id");
//    }
}
