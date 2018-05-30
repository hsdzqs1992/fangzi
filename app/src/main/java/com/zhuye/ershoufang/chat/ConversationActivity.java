package com.zhuye.ershoufang.chat;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConversationActivity extends FragmentActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        ButterKnife.bind(this);





        subtitle.setVisibility(View.GONE);
        ttitle.setText(getIntent().getData().getQueryParameter("title")+
        getIntent().getData().getQueryParameter("targetid"));
        // 得到id
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
