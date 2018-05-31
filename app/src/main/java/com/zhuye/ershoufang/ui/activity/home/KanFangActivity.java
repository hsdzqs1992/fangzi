package com.zhuye.ershoufang.ui.activity.home;

import com.zhuye.ershoufang.ui.activity.WebActivity;

public class KanFangActivity extends WebActivity {

//    @BindView(R.id.back)
//    ImageView back;
//    @BindView(R.id.ttitle)
//    TextView ttitle;
//    @BindView(R.id.subtitle)
//    TextView subtitle;
//    @BindView(R.id.recycle)
//    RecyclerView recycle;
//    @BindView(R.id.refresh)
//    SmartRefreshLayout refresh;
//
//    @Override
//    protected int getResId() {
//        return R.layout.common;
//    }
//
//
//    @Override
//    protected void initView() {
//        super.initView();
//        subtitle.setVisibility(View.GONE);
//        ttitle.setText("免费看房");
//
//    }

    @Override
    public String getUrlName() {
        return "mianfei";
    }

    @Override
    protected void javashoucang() {

    }

    @Override
    protected void initData() {
        super.initData();

    }


    //    @Override
//    protected void initData() {
//        super.initData();
//        adapter = new KanFangAdapter(R.layout.kanfang_item);
//        recycle.setAdapter(adapter);
//        recycle.setLayoutManager(layoutManager);
//    }
//
//    @OnClick(R.id.back)
//    public void onViewClicked() {
//        finish();
//    }
}
