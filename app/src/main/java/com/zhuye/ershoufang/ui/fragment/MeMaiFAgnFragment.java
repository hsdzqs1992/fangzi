package com.zhuye.ershoufang.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.MaiFangItemAdapter;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.FaBuListBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.me.EditErShouActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

import static com.zhuye.ershoufang.utils.PageUtils.REFRESH;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MeMaiFAgnFragment extends BaseFragment {
    private static final int LIST = 200;
    private static final int DELETE = 201;
    private static final int LOADMORE = 202;
    @BindView(R.id.header)
    ClassicsHeader header;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;


    MaiFangItemAdapter adapter;
    @BindView(R.id.tvv)
    TextView tvv;
    Unbinder unbinder1;

    @Override
    protected void initView() {
        adapter = new MaiFangItemAdapter(R.layout.me_maifang_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this.getActivity()));
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_maifang;
    }


    private int cate_id = 3;

    public void setId(int cate_id) {
        this.cate_id = cate_id;
    }

    public void setData(int position) {
       CommonApi.getInstance().sellhouselists(getToken(), 1, cate_id, MeMaiFAgnFragment.this, LIST);
      //  tvv.setText(position+"");


//        OkGo.<String>post(NetWorkUrl.BASE+NetWorkUrl.SELLHOUSELISTS)
//                .params("token",getToken())
//                .params("cate_id",3)
//                .params("page",1).execute(new StringCallback() {
//            @Override
//            public void onSuccess(Response<String> response) {
//                Log.i("as",response.body());
//            }
//
//            @Override
//            public void onError(Response<String> response) {
//                super.onError(response);
//                Log.i("as",response.body());
//            }
//        });
    }

    @Override
    protected void initData() {
        super.initData();
    }

    FaBuListBean bean;

    List<FaBuListBean.DataBean>  dataBeans = new ArrayList<>();
    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case LIST:
                bean = (FaBuListBean) o;

                dataBeans.addAll(bean.getData());
                adapter.addData(bean.getData());
                break;

            case DELETE:
                toast(o.getMessage());
                break;
            case REFRESH:
                FaBuListBean faBuListBean = (FaBuListBean) o;
                dataBeans.clear();
                dataBeans.addAll(faBuListBean.getData());
                adapter.replaceData(dataBeans);
                refresh.finishRefresh();
                break;
            case LOADMORE:
                FaBuListBean faBuListB = (FaBuListBean) o;
                dataBeans.addAll(faBuListB.getData());
                adapter.replaceData(dataBeans);
                refresh.finishLoadmore();
                break;
        }
    }

public int page = 1;
    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.delete:
                        CommonApi.getInstance().del_house(getToken(),cate_id,MeMaiFAgnFragment.this,DELETE);
                        break;
                    case R.id.edit:
//                        start(EditErShouActivity.class);
                        Intent intent = new Intent(getActivity(), EditErShouActivity.class);
                        intent.putExtra("life_id",bean.getData().get(position).getLife_id());
                        startActivity(intent);
                        break;

                    case R.id.zhiding:

                        break;
                }
            }
        });

        refresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                CommonApi.getInstance().sellhouselists(getToken(),++page , cate_id, MeMaiFAgnFragment.this, LOADMORE);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                CommonApi.getInstance().sellhouselists(getToken(), 1, cate_id, MeMaiFAgnFragment.this, REFRESH);
            }
        });
    }
}
