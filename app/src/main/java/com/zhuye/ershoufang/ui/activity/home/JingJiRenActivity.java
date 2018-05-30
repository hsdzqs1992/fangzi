package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.HomeJingJiAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.HomeJinBean;
import com.zhuye.ershoufang.data.CommonApi;

import butterknife.BindView;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;

//HomeWindowActivity
public class JingJiRenActivity extends CommonHome2Activity<HomeJinBean> {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.quyu)
    LinearLayout quyu;
    @BindView(R.id.jiage)
    LinearLayout jiage;

    @Override
    protected int getResId() {
        return R.layout.common4;
    }
    HomeJingJiAdapter jiAdapter ;
    @Override
    protected void initView() {
        super.initView();
        // hide(subtitle);
        setText(ttitle, "经纪人");
       // setText(subtitle, "区域选择");
        hide(subtitle);
        jiAdapter = new HomeJingJiAdapter(R.layout.home_jingji_item);
        recycle.setAdapter(jiAdapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));

    }



    @OnClick({R.id.jiage,R.id.quyu,R.id.back, R.id.subtitle})
    public void onViewClicked(View view) {
        //List<SelectBean> data = new ArrayList<>();
        dat.clear();
        switch (view.getId()) {
            case R.id.jiage:
//                data.add(new SelectBean("desc","价格从高到底"));
//                data.add(new SelectBean("desc","价格从高到底"));
               // alertjiageWindow(view,100);
                dat.add("价格从低到高");
                dat.add("价格从高到低");
                alertWindow(view, dat, 11);
                break;
            case R.id.quyu:
                clickJieDao(view);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:
                //start(QuYuSelectActivity.class);
                break;
        }
    }


    String paixu = "desc";

    String quid ;
    @Override
    protected void initData() {
        super.initData();
        quid = getQuId();
        CommonApi.getInstance().agent_list(page,quid,paixu,JingJiRenActivity.this,LIST);
    }


    @Override
    public void getClickPrice(String price1, String price2) {
        super.getClickPrice(price1, price2);
    }


    @Override
    protected void onItemClick(View view, int position, int rescode) {
        super.onItemClick(view, position, rescode);
        switch (rescode){
            case 9:
                quid = jiadao.getData().get(position).getId();
                onRefresh();
                break;
            case 11:
                if(position==0){
                    paixu ="desc";
                }else {
                    paixu ="asc";
                }
                onRefresh();
                break;
        }
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
//        switch (requestcode){
//            case LIST:
//                CommonListBean<HomeJinBean> da = (CommonListBean<HomeJinBean>) base;
//                if(da.getData()!=null)
//                jiAdapter.addData(da.getData());
//
//                break;
//        }
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return jiAdapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().agent_list(++page,quid,paixu,JingJiRenActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().agent_list(1,quid,paixu,JingJiRenActivity.this,REFRESHBASE);
    }

    @Override
    protected void initListener() {
        super.initListener();
        jiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(JingJiRenActivity.this,JingJiRenDetailActivity.class);
                intent.putExtra("id",list.get(position).getUser_id());
                startActivity(intent);
            }
        });


        jiAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.chat:
                        RongIM.getInstance().startConversation(
                                JingJiRenActivity.this,
                                Conversation.ConversationType.PRIVATE,
                                list.get(position).getUser_id(),
                                "");
                        break;
                }
            }
        });
    }
}
