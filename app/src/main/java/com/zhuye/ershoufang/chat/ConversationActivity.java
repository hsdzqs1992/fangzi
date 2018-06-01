package com.zhuye.ershoufang.chat;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.Applaion;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.UBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.UserInfo;

public class ConversationActivity extends BaseActivity {

    private static final int GETDATA = 200;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView();
//        ButterKnife.bind(this);
//
//
//
    //}

    @Override
    protected void initView() {
        super.initView();

        String targetid =getIntent().getData().getQueryParameter("targetid");

        subtitle.setVisibility(View.GONE);
//        ttitle.setText(getIntent().getData().getQueryParameter("title")+
//                 getIntent().getData().getQueryParameter("targetid"));


        // 得到id
        String type = getIntent().getStringExtra("type");
        if(type!= null && type.equals("1")){
            connectRongYun();
        }

        RongIM.getInstance().getConversationList(new RongIMClient.ResultCallback<List<Conversation>>() {
            @Override
            public void onSuccess(List<Conversation> conversations) {
                Log.i("as",conversations.toString());
                for (Conversation conversation :conversations){
                    Log.i("as",conversation.getSenderUserId());
                    Log.i("as",conversation.getTargetId());
                    CommonApi.getInstance().msg(conversation.getTargetId(),ConversationActivity.this,GETDATA,false);
                }
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                //   Log.i("as",errorCode+"");
            }
        }, Conversation.ConversationType.PRIVATE);
    }


    CommonObjectBean<UBean>  ubean;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case GETDATA:
                toast(base.getMessage());
                ubean = (CommonObjectBean<UBean>) base;
                RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {
                    @Override
                    public UserInfo getUserInfo(String s) {
                        return new UserInfo(ubean.getData().getUser_id()
                        ,ubean.getData().getNickname(), Uri.parse(ubean.getData().getFace()));
                    }
                },true);
                break;
        }
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

    public String getSpData(String key){
        return SharedPreferencesUtil.getInstance().getString(key);
    }

    @Override
    protected int getResId() {
        return R.layout.activity_conversation;
    }

    public String getrongyun(){
        return getSpData("rongyun");
    }

    private void connectRongYun() {
        String token = getrongyun();
        if (getApplicationInfo().packageName.equals(Applaion.getCurProcessName(getApplicationContext()))) {
            RongIM.connect(token, new RongIMClient.ConnectCallback() {

                /**
                 * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
                 *                  2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
                 */
                @Override
                public void onTokenIncorrect() {
                   // toast("onTokenIncorrect");
                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token 对应的用户 id
                 */
                @Override
                public void onSuccess(String userid) {
                    Log.d("LoginActivity", "--onSuccess" + userid);
                    //startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    //  finish();
                   // toast("onSuccess");

                    //GlobalListener.init(MainActivity.this);


                    RongIM.getInstance().getConversationList(new RongIMClient.ResultCallback<List<Conversation>>() {
                        @Override
                        public void onSuccess(List<Conversation> conversations) {
                            Log.i("as",conversations.toString());
                        }

                        @Override
                        public void onError(RongIMClient.ErrorCode errorCode) {
                            //   Log.i("as",errorCode+"");
                        }
                    });
                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    Log.d("LoginActivity", "--onError" + errorCode);
                   // toast("onError");
                }
            });
        }
    }
}
