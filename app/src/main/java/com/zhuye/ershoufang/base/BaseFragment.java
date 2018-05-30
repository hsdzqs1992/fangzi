package com.zhuye.ershoufang.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.data.BaseView;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;
import com.zhuye.ershoufang.weidtet.CustomProgressDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zzzy on 2017/11/20.
 */

public abstract class BaseFragment<T> extends Fragment implements BaseView {

    protected final static int REFRESHBASE = 10000;
    protected final static int LOADMOREBASE = 10001;
    protected CommonListBean<T> listData;
    protected  List<T> list = new ArrayList<>();



    private CustomProgressDialog dialog;
    public View rootView;
    Unbinder unbinder;
   // protected BaseRecycleAdapter adapter;
    //protected View emptyview;
    protected View errorview;
    protected View lodingview;
    protected RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    protected BaseQuickAdapter adapte;

    protected RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(requestBefore()){

        }else{
            View view = View.inflate(getActivity(),getResId(),null);
            //initView();
            unbinder = ButterKnife.bind(this, view);
            rootView = view;
        };

        initView();
        dialog = new CustomProgressDialog(getActivity(), "加载中");
        dialog.setCanceledOnTouchOutside(false);
        lodingview = View.inflate(getActivity(), R.layout.loding,null);
        errorview = LayoutInflater.from(getActivity()).inflate(R.layout.error,null);

        return rootView;
    }

    protected Boolean requestBefore() {
        return false;
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

    public Boolean checkArray(List et, String content){
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

    public String getString(TextView tv){
        return tv.getText().toString().trim();
    }


    public String getString(EditText tv){
        return tv.getText().toString().trim();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        initListener();
    }


    @Override
    public void success(int requestcode, Base o) {

    }

    protected void initListener() {
    }

    protected void initData() {
    }

    protected abstract void initView();

    protected abstract int getResId() ;


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    protected String getToken(){
        return SharedPreferencesUtil.getInstance().getString("token2");
    }

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    @Override
    public void loding() {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        },1000);
    }

    @Override
    public void finishLoding() {

    }

    @Override
    public void error(Base o) {
        Base base = (Base) o;
        toast(base.getMessage());
    }

    @Override
    public void empty() {

    }

    public void toast(String content){
        ((BaseActivity) getActivity()).toast(content);
    }

    public void start(Class cls,String... args){
        start(cls,false,args);
    }


    public void start(Class cls, boolean b,String... args){
        Intent intent = new Intent(this.getActivity(),cls);
        for(String arg :  args){
            int i = 0;
            intent.putExtra("arg"+i,arg);
            ++i;
        }
        startActivity(intent);
        if(b){
            this.getActivity().finish();
        }
    }


    public void hide(View view){
        view.setVisibility(View.GONE);
    }

    public void setText(TextView tv,String content){
        tv.setText(content);
    }

    public String getQuId(){
        return "12743";
    }
//    public String getQuId(){
//        return SharedPreferencesUtil.getInstance().getString("qu_id");
//    }
}
