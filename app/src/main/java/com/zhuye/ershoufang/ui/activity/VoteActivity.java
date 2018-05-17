package com.zhuye.ershoufang.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.VoteAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.ui.fragment.home.BaoMingActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class VoteActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.search)
    TextView search;
    @BindView(R.id.zuixin)
    TextView zuixin;
    @BindView(R.id.zongpaiming)
    TextView zongpaiming;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.baoming)
    Button baoming;

    @Override
    protected int getResId() {
        return R.layout.activity_vote;
    }


    @Override
    protected void initData() {
        super.initData();
        adapter = new VoteAdapter<>(R.layout.vote_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(layoutManager);
    }
    @OnClick({R.id.back, R.id.search, R.id.zuixin, R.id.zongpaiming, R.id.baoming})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.search:

                break;
            case R.id.zuixin:
                break;
            case R.id.zongpaiming:
                break;
            case R.id.baoming:
                start(BaoMingActivity.class);
                break;
        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                
            }
        });
    }
}
