package com.zhuye.ershoufang.chat;

import android.net.Uri;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseFragment;

import java.io.File;

import io.rong.imkit.RongIM;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class MyFragmentWithMap extends BaseFragment{
    @Override
    protected void initView() {

    }

    @Override
    protected int getResId() {
        return R.layout.chat3;
    }

    private void enterFragment() {
//        if(fragment ==null){
//            fragment = (ConversationListFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.conversationlist);
//        }

        ConversationListFragment fragment = (ConversationListFragment) getChildFragmentManager().findFragmentById(R.id.conversationlist);

        Uri uri = Uri.parse("rong://" + getActivity().getApplicationInfo().packageName).buildUpon()
                .appendPath("conversationlist")
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话非聚合显示
                .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false")//设置群组会话聚合显示
                .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName(), "false")//设置讨论组会话非聚合显示
                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "false")//设置系统会话非聚合显示
                .build();
        fragment.setUri(uri);


//        List<String> da = new ArrayList<>();
//        da.add("sss");
//        da.add("sss");
//        da.add("sss");
//        da.add("sss");
//        da.add("sss");
//
//        Observable.fromArray(da)
//                .subscribe(new Consumer<List<String>>() {
//                    @Override
//                    public void accept(List<String> strings) throws Exception {
//                        Log.i("asss", strings.toString());
//                    }
//                });

        RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {
            @Override
            public UserInfo getUserInfo(String s) {
                return new UserInfo("10","name",Uri.fromFile(new File("aa")));
            }
        },true);

    }
}
