package com.zhuye.ershoufang.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

/**
 * Created by Administrator on 2018/3/8 0008.
 */

public class ChatFragment3 extends BaseFragment {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;
    Unbinder unbinder;

    @Override
    public void success(int requestcode, Base o) {

    }

    @Override
    protected void initView() {
        hide(back);
        hide(subtitle);
        setText(ttitle, "微聊");
    }


    @Override
    protected void initData() {
        super.initData();
        try {
            ConversationListFragment  fragment= (ConversationListFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.conversationlist);
            Uri uri = Uri.parse("rong://" + getActivity().getApplicationInfo().packageName).buildUpon()
                    .appendPath("conversationlist")
                    .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话非聚合显示
                    .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false")//设置群组会话聚合显示
                    .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")//设置讨论组会话非聚合显示
                    .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "false")//设置系统会话非聚合显示
                    .build();
            fragment.setUri(uri);
        }catch (Exception e){
            LogUtils.i(e.getMessage());
        }

    }

    @Override
    protected int getResId() {
        return R.layout.fragment_chat2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
//        fragment.onDetach();
        ConversationListFragment  fragment= (ConversationListFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.conversationlist);
        if(fragment !=null ){
            getFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }
}