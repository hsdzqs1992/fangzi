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
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.one.MyMultipleItem;
import com.zhuye.ershoufang.one.XinFangAdapter3;

import butterknife.BindView;
import butterknife.OnClick;

public class XinFangActivity extends CommonHomeActivity<Common5Bean> {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.smartferesh)
    SmartRefreshLayout smartferesh;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.ll3)
    LinearLayout ll3;

    @Override
    protected int getResId() {
        return R.layout.activity_xin_fang;
    }

    @Override
    protected void initView() {
        super.initView();
        ttitle.setText("新房");
        subtitle.setVisibility(View.GONE);
//     adapter = new XinFangAdapter(R.layout.home_xinfang_item);
//       // adapter = new XinFangAdapter(list);
//        recycle.setAdapter(adapter);
//        recycle.setLayoutManager(layoutManager);
        //createAdapter(null);
        adapter = new XinFangAdapter3(datas);
        // adapter = new XinFangAdapter(list);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void doList() {
        datas.clear();
//        for (Common5Bean bean:list){
//            if(bean.getPhoto().size()==3){
//                datas.add(new MyMultipleItem(MyMultipleItem.SECOND_TYPE,bean));
//            }else {
//                datas.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE,bean));
//            }
//
//         }
         for (int i = 0;i<list.size();i++){
            if(list.size()>2){
                if(i==1){
                    datas.add(new MyMultipleItem(MyMultipleItem.SECOND_TYPE,list.get(i)));
                }else {
                    datas.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE,list.get(i)));
                }
            }else {
                datas.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE,list.get(i)));
            }
         }
    }

    @Override
    protected void createAdapter(CommonListBean<Common5Bean> data) {
        super.createAdapter(data);

//        datas.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE,new Common5Bean()));
//        datas.add(new MyMultipleItem(MyMultipleItem.SECOND_TYPE,new Common5Bean()));
    }

    //    @Override
//    protected void createAdapter() {
//        super.createAdapter();
//        adapter = new XinFangAdapter2(R.layout.home_xinfang_item);
//       // adapter = new XinFangAdapter(list);
//        recycle.setAdapter(adapter);
//        recycle.setLayoutManager(layoutManager);
//    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return smartferesh;
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //进入新房详情页
                Intent intent = new Intent(XinFangActivity.this, XinFangDetailActivity.class);
                intent.putExtra("id",list.get(position).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().indexnewhouse2(qu_id,business_id,prce1,prce2,1,++page,"",XinFangActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().indexnewhouse2(qu_id,business_id,prce1,prce2,1,1,"",XinFangActivity.this,REFRESHBASE);
    }


//    CityBean jiadao;
//    @Override
//    public void success(int requestcode, Base o) {
//        super.success(requestcode, o);
//        switch (requestcode){
//            case GETDATA:
//                jiadao = (CityBean) o;
//                break;
//        }
//    }


    @Override
    protected void initData() {
        super.initData();
        //qu_id = SharedPreferencesUtil.getInstance().getString("qu_id");
        CommonApi.getInstance().indexnewhouse2(qu_id,business_id,prce1,prce2,1,page,"",XinFangActivity.this,LIST);
        //CommonApi.getInstance().xiaji(qu_id,XinFangActivity.this,GETDATA,false);
    }


    @OnClick({R.id.ttitle,R.id.back,R.id.ll1,R.id.ll2,R.id.ll3})
    public void onViewClicked(View view) {
        dat.clear();
        switch (view.getId()) {
            case R.id.ttitle:
                Intent intent = new Intent(XinFangActivity.this, XinFangDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.ll1:
               clickJieDao(view);
                break;
            case R.id.ll2:
//                dat.add("从高到低");
//                dat.add("从低到高");
//                alertWindow(view, dat, 10);
                alertjiageWindow(view,100);
                break;
            case R.id.ll3:
                clickLeiXing(view);
                break;
        }
    }




    private String prce1;
    private String prce2;
    private int selet = 1;
    @Override
    public void getClickPrice(String price1, String price2) {
        super.getClickPrice(price1, price2);
        prce2 = price2;
        prce1 = price1;
        CommonApi.getInstance().indexnewhouse2(qu_id,business_id,prce1,prce2,selet,page,"",XinFangActivity.this,REFRESHBASE);
    }

    @Override
    protected void onItemClick(View view, int position, int rescode) {
        super.onItemClick(view, position, rescode);
        switch (rescode){
            case 9:
                business_id = jiadao.getData().get(position).getId();
                //CommonApi.getInstance().indexnewhouse2(qu_id,business_id,prce1,prce2,1,page,XinFangActivity.this,REFRESHBASE);
                break;
            case 10:
                //toast(dat.get(position));
                // CommonApi.getInstance().indexnewhouse2(qu_id,business_id,prce1,prce2,1,page,XinFangActivity.this,REFRESHBASE);
                break;
            case 11:
                // toast(dat.get(position));
                // CommonApi.getInstance().indexnewhouse2(qu_id,business_id,prce1,prce2,1,page,XinFangActivity.this,REFRESHBASE);
                break;
        }
    }
}
