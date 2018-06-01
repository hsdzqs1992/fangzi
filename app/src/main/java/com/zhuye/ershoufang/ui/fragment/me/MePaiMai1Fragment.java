package com.zhuye.ershoufang.ui.fragment.me;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.MybidderBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.me.EditErShouActivity;
import com.zhuye.ershoufang.ui.fragment.CommonFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public abstract class MePaiMai1Fragment<T> extends CommonFragment<T> {
    private static final int DELETE = 201;
    private static final int GETDATA = 300;
    @BindView(R.id.header)
    ClassicsHeader header;
    @BindView(R.id.recycle)
   protected RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;



    @BindView(R.id.tvv)
    TextView tvv;
    Unbinder unbinder1;



    @Override
    protected int getResId() {
        return R.layout.fragment_maifang;
    }


    private int cate_id = 3;
    public int page=1;
    public int type=1;

    public void setId(int cate_id) {
        this.type = cate_id;
    }

//    public void setData() {
//       //CommonApi.getInstance().sellhouselists(getToken(), 1, cate_id, MePaiMai2Fragment.this, LIST);
//        CommonApi.getInstance().my_bidder(getToken(),page,type,MePaiMai2Fragment.this,LIST);
//
//      //  tvv.setText(position+"");
//
////        OkGo.<String>post(NetWorkUrl.BASE+NetWorkUrl.SELLHOUSELISTS)
////                .params("token",getToken())
////                .params("cate_id",3)
////                .params("page",1).execute(new StringCallback() {
////            @Override
////            public void onSuccess(Response<String> response) {
////                Log.i("as",response.body());
////            }
////
////            @Override
////            public void onError(Response<String> response) {
////                super.onError(response);
////                Log.i("as",response.body());
////            }
////        });
//    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().my_bidder(getToken(),page,getType(),MePaiMai1Fragment.this,LIST);
    }

    protected abstract int getType();

    MybidderBean bean;
    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode) {
//            case LIST:
//                bean = (MybidderBean) o;
//                adapter.addData(bean.getData());
//                break;

            case DELETE:
                toast(o.getMessage());
                break;

//            case GETDATA:
//                bean = (MybidderBean) o;
//                if(bean.getData()==null){
//                    return;
//                }
//                adapter.addData(bean.getData());
//                break;

        }
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapte;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapte.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.delete:
                        CommonApi.getInstance().del_house(getToken(),cate_id,MePaiMai1Fragment.this,DELETE);
                        break;
                    case R.id.edit:
//                        start(EditErShouActivity.class);
                        Intent intent = new Intent(getActivity(), EditErShouActivity.class);
                       //intent.putExtra("life_id",bean.getData().get(position).getLife_id());
                        startActivity(intent);
                        break;
                    case R.id.zhiding:
                        break;
                }
            }
        });
    }

//    @Override
//    protected void onLoadmore() {
//        CommonApi.getInstance().my_bidder(getToken(),++page,type,MePaiMai1Fragment.this,LOADMOREBASE);
//    }
//
//    @Override
//    protected void onRefresh() {
//        CommonApi.getInstance().my_bidder(getToken(),1,type,MePaiMai1Fragment.this,REFRESHBASE);
//    }
}
