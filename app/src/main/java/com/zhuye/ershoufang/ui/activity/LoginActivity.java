package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zhuye.ershoufang.Applaion;
import com.zhuye.ershoufang.MainActivity;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.LoginCode;
import com.zhuye.ershoufang.bean.LoginCodeBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.GetData;
import com.zhuye.ershoufang.utils.CheckUtil;
import com.zhuye.ershoufang.utils.MD5Utils;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity {


    private static final int LOGINA = 100;
    private static final int QQIOFO = 101;
    private static final int WEIXINIOFO = 102;
    @BindView(R.id.loginname)
    EditText loginname;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.forgetpassword)
    TextView forgetpassword;
    @BindView(R.id.login)
    TextView login;
    @BindView(R.id.regeist)
    TextView regeist;
    @BindView(R.id.san)
    TextView san;
    @BindView(R.id.qqlogin)
    RelativeLayout qqlogin;
    @BindView(R.id.weixin)
    RelativeLayout weixin;

    @Override
    protected int getResId() {
        return R.layout.activity_login;
    }



    @OnClick({R.id.forgetpassword, R.id.login, R.id.regeist, R.id.qqlogin, R.id.weixin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forgetpassword:
                Intent inten = new Intent(LoginActivity.this,ForgetPass1Activity.class);
                startActivity(inten);
                break;
            case R.id.login:
                if(checkEmpty(loginname,"用户名不能为空")&&checkEmpty(password,"密码不能为空")){
                    if(CheckUtil.isMobile(getString(loginname))){
                        toast("手机格式错误");
                        return;
                    }
                    String pass = MD5Utils.MD5(getString(loginname));
                    GetData.login(getString(loginname),getString(password),LoginActivity.this,LOGINA);
                }
                //start(LoginActivity.this,ReGeistActivity.class);
                break;
            case R.id.regeist:
                Intent intent = new Intent(LoginActivity.this,ReGeistActivity.class);
                startActivity(intent);
                break;
            case R.id.qqlogin:
               // ((Applaion)getApplication()).umShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, authListener);
                ((Applaion)getApplication()).umShareAPI.doOauthVerify(LoginActivity.this, SHARE_MEDIA.QQ, authListener);
                break;
            case R.id.weixin:
                ((Applaion)getApplication()).umShareAPI.doOauthVerify(LoginActivity.this, SHARE_MEDIA.WEIXIN, authListener);
                break;
        }
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            // Toast.makeText(getApplication(), platform.getName()+ data.toString(),Toast.LENGTH_LONG).show();
            if("qq".equals(platform.getName())){
//                CommonApi.getInstance().third_logint(2,data.get("openid"),
//                        data.get());
                ((Applaion)getApplication()).umShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, authListener1);
            }else if(platform.getName().equalsIgnoreCase("weixin")){///SHARE_MEDIA.WEIXIN
                ((Applaion)getApplication()).umShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.WEIXIN, authListener1);
            }
           // Log.i("asdf",platform.getName()+ data.toString());
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplication(), "失败：" + t.getMessage(),                                  Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplication(), "取消了", Toast.LENGTH_LONG).show();
        }
    };

    UMAuthListener authListener1 = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {

            // Toast.makeText(getApplication(), platform.getName()+ data.toString(),Toast.LENGTH_LONG).show();
            if("qq".equals(platform.getName())){
                CommonApi.getInstance().third_logint(2,data.get("openid"),
                        data.get("name"),data.get("profile_image_url"),LoginActivity.this,QQIOFO);

//                OkGo.<String>post(NetWorkUrl.BASE+"index.php/app/passport/third_login")
//                        .params("login_type",2)
//                        .params("openid",data.get("openid"))
//                        .params("nickname",data.get("name"))
//                        .params("face",data.get("profile_image_url"))
//                        .execute(new StringCallback() {
//                            @Override
//                            public void onSuccess(Response<String> response) {
//                                Log.i("asdf",platform.getName()+ data.toString());
//                                LoginCodeBean bean =  new Gson().fromJson(response.body(),LoginCodeBean.class);
//                                Log.i("asdf",bean.getData().getToken());
//                            }
//
//                            @Override
//                            public void onError(Response<String> response) {
//                                super.onError(response);
//                                Log.i("asdf",platform.getName()+ data.toString());
//                            }
//                        });
//                ((Applaion)getApplication()).umShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, authListener1);
            }else if(platform.getName().equals(SHARE_MEDIA.WEIXIN)){
                CommonApi.getInstance().third_logint(1,data.get("openid"),
                        data.get("name"),data.get("profile_image_url"),LoginActivity.this,WEIXINIOFO);
            }
           // Log.i("asdf",platform.getName()+ data.toString());
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(getApplication(), "失败：" + t.getMessage(),                                  Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplication(), "取消了", Toast.LENGTH_LONG).show();
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void initView() {
        super.initView();
        if(SharedPreferencesUtil.getInstance().getString("token2")!=null && !TextUtils.isEmpty(SharedPreferencesUtil.getInstance().getString("token2"))){
            start(MainActivity.class,true);
        }
//        if(!isEmpty(SharedPreferencesUtil.getInstance().getString("token2"))){
//            start(MainActivity.class,true);
//        }
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode){
            case LOGINA:
                LoginCode code = (LoginCode) o;
                if(code.getData().getData()!=null){
                    if(code.getData().getData().equals("0")){
                        //todo 去提交资料
                        String type = code.getData().getType();
                        start(JingJiResActivity.class, Integer.parseInt(type) + 1+"");
//                        switch (type){
//                            case "1":
//                                start(JingJIRes2Activity.class);
//                                break;
//                            default:
//                                start(OthersRes3Activity.class, type );
//                                break;
//                        }
                    }else if(code.getData().getData().equals("1")){
                        //toast("登录成功");
                        SharedPreferencesUtil.getInstance().putString("type",code.getData().getType());
                        SharedPreferencesUtil.getInstance().putString("token2",code.getData().getToken());
                        SharedPreferencesUtil.getInstance().putString("rongyun",code.getData().getRongyun());
                        start(MainActivity.class,true);
                    }
                }
                break;
            case QQIOFO:
                LoginCodeBean qqcode = (LoginCodeBean) o;
                SharedPreferencesUtil.getInstance().putString("type",0+"");
                SharedPreferencesUtil.getInstance().putString("token2",qqcode.getData().getToken());
                SharedPreferencesUtil.getInstance().putString("rongyun",qqcode.getData().getRongyun());
                start(MainActivity.class,true);
                break;

            case WEIXINIOFO:
                LoginCodeBean weixin = (LoginCodeBean) o;
                SharedPreferencesUtil.getInstance().putString("type",0+"");
                SharedPreferencesUtil.getInstance().putString("token2",weixin.getData().getToken());
                SharedPreferencesUtil.getInstance().putString("rongyun",weixin.getData().getRongyun());
                start(MainActivity.class,true);
                break;
        }

       // toast(code.getData().getType());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // TODO: 2018/3/29 0029
    }
}
