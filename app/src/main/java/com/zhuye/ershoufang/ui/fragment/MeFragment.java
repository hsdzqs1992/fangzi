package com.zhuye.ershoufang.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.HomefenleiAdapter;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.FenLeiBean;
import com.zhuye.ershoufang.bean.JingJiRenBean;
import com.zhuye.ershoufang.bean.ZiLiaoBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.ChongZhiActivity;
import com.zhuye.ershoufang.ui.activity.FuBuLouPanActivity;
import com.zhuye.ershoufang.ui.activity.JingJiRenZiLiaoActivity;
import com.zhuye.ershoufang.ui.activity.KanFangJiluActivity;
import com.zhuye.ershoufang.ui.activity.MeChanPinActivity;
import com.zhuye.ershoufang.ui.activity.MessageActivity;
import com.zhuye.ershoufang.ui.activity.MianFeiKanActivity;
import com.zhuye.ershoufang.ui.activity.PersonInfoActivity;
import com.zhuye.ershoufang.ui.activity.SettingActivity;
import com.zhuye.ershoufang.ui.activity.ShouCangActivity;
import com.zhuye.ershoufang.ui.activity.WeiTuoActivity;
import com.zhuye.ershoufang.ui.activity.WeiTuoMaiActivity;
import com.zhuye.ershoufang.ui.activity.WenDaActivity;
import com.zhuye.ershoufang.ui.activity.me.ChuZuActivity;
import com.zhuye.ershoufang.ui.activity.me.JiaJuCenterActivity;
import com.zhuye.ershoufang.ui.activity.me.MeFangChanCenterActivity;
import com.zhuye.ershoufang.ui.activity.me.MeJingJiCenterActivity;
import com.zhuye.ershoufang.ui.activity.me.QiTeWeiTuoActivity;
import com.zhuye.ershoufang.ui.activity.me.WeiTuoJingMaiActivity;
import com.zhuye.ershoufang.ui.activity.me.ZhuangXiuKanActivity;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;
import com.zhuye.ershoufang.weidtet.RoundedCornerImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/8 0008.
 */

public class MeFragment extends BaseFragment {

    private static final int JINJIREN = 300;
    private static final int INFO = 301;
    @BindView(R.id.tou)
    RoundedCornerImageView tou;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.me_fangchan_rv)
    RecyclerView meFangchanRv;
    Unbinder unbinder;

    private int[] pics = {R.drawable.porfile_1,
            R.drawable.porfile_2,
            R.drawable.porfile_3,
            R.drawable.porfile_4,
            R.drawable.porfile_5,
            R.drawable.porfile_5,
            R.drawable.porfile_6,
            R.drawable.porfile_7,
            R.drawable.porfile_8,
            R.drawable.porfile_9};


    private int[] jingjirenpics = {R.drawable.porfile_jjr_1,
            R.drawable.porfile_jjr_2,
            R.drawable.porfile_jjr_3,
            R.drawable.porfile_jjr_4,
            R.drawable.porfile_jjr_5,
            R.drawable.porfile_jjr_6,
            R.drawable.porfile_jjr_7,
            R.drawable.porfile_jjr_8,
            R.drawable.porfile_9
            };


    private int[] jiajupics = {R.drawable.porfile_jjv_1,
            R.drawable.porfile_jjv_2,
            R.drawable.porfile_jjv_3,
//            R.drawable.porfile_jjv_4,
            R.drawable.porfile_jjv_5,
            R.drawable.porfile_jjv_6
            };

    private int[] zhuangxiupics = {
            R.drawable.porfile_jjv_1,
            R.drawable.porfile_jjv_3,
            R.drawable.porfile_jjv_4,
            R.drawable.porfile_jjv_5,
            R.drawable.porfile_jjv_6
    };

    private int[] fangchanpics = {R.drawable.porfile_fc_1,
            R.drawable.porfile_fc_2,
            R.drawable.porfile_fc_3,
            R.drawable.porfile_fc_4,
            R.drawable.porfile_fc_5};


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().ziliao(SharedPreferencesUtil.getInstance().getString("token2"),this,INFO);
    }
CommonObjectBean<JingJiRenBean> jingjiren;
    @Override
    public void success(int requestcode, Base o) {
        switch (requestcode){
            case JINJIREN:
                jingjiren = (CommonObjectBean<JingJiRenBean>) o;
                //name.setText(jingjiren.getData().get);
                break;
            case INFO:
                ZiLiaoBean bean = (ZiLiaoBean)o;
                name.setText(bean.getData().getNickname());
                // String se = "男";
//                setText(sex,bean.getData().getSex().equals("1") ?  "男": "女");
//                setText(state,bean.getData().getSex().equals("1") ?  "已绑定": "未绑定");
                // TODO: 2018/5/4 0004 没数据
                setText(name,bean.getData().getNickname());
                if(bean.getData().getFace()!=null){
                    if(bean.getData().getFace().contains("http")){
                        Glide.with(this).load(bean.getData().getFace()).into(tou);
                    }else {
                        Glide.with(this).load(NetWorkUrl.IMAGEURL+bean.getData().getFace()).into(tou);
                    }
                }

                break;
        }
    }
    int type;
    @Override
    protected void initView() {
        List<FenLeiBean.FenBean> data = new ArrayList<>();

        type = Integer.parseInt(SharedPreferencesUtil.getInstance().getString("type"));
        ++type;
      // type = 1;
        switch (type){
            case 1:
                String[] names =  getActivity().getResources().getStringArray(R.array.me_home);
                for (int i = 0;i<10;i++){
                    FenLeiBean.FenBean bean = new FenLeiBean.FenBean();
                    bean.imgRes = pics[i];
                    bean.stringRes = names[i];
                    data.add(bean);
                }
                adapter = new HomefenleiAdapter(R.layout.me_rv,data);
                break;
            case 4:
                String[] namess =  getActivity().getResources().getStringArray(R.array.me_home_jiaju);
                for (int i = 0;i<5;i++){
                    FenLeiBean.FenBean bean = new FenLeiBean.FenBean();
                    bean.imgRes = jiajupics[i];
                    bean.stringRes = namess[i];
                    data.add(bean);
                }
                adapter = new HomefenleiAdapter(R.layout.me_rv,data);
                break;
                case 3:
                    String[] names3 =  getActivity().getResources().getStringArray(R.array.me_home_chanshang);
                    for (int i = 0;i<5;i++){
                        FenLeiBean.FenBean bean = new FenLeiBean.FenBean();
                        bean.imgRes = fangchanpics[i];
                        bean.stringRes = names3[i];
                        data.add(bean);
                    }
                adapter = new HomefenleiAdapter(R.layout.me_rv,data);
                break;
                case 2:
                    String[] names4 =  getActivity().getResources().getStringArray(R.array.me_home_jingjiren);
                    for (int i = 0;i<9;i++){
                        FenLeiBean.FenBean bean = new FenLeiBean.FenBean();
                        bean.imgRes = jingjirenpics[i];
                        bean.stringRes = names4[i];
                        data.add(bean);
                    }
                adapter = new HomefenleiAdapter(R.layout.me_rv,data);
                    //请求数据
                    // CommonApi.getInstance().data(getToken(),MeFragment.this,JINJIREN);
                break;
            case 5:
                String[] names5 =  getActivity().getResources().getStringArray(R.array.me_home_zhuangxiushang);
                for (int i = 0;i<names5.length;i++){
                    FenLeiBean.FenBean bean = new FenLeiBean.FenBean();
                    bean.imgRes = zhuangxiupics[i];
                    bean.stringRes = names5[i];
                    data.add(bean);
                }
                adapter = new HomefenleiAdapter(R.layout.me_rv,data);
                break;
        }
        meFangchanRv.setAdapter(adapter);
        meFangchanRv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        //meFangchanRv.getChildAt(3);
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_me;
    }
    HomefenleiAdapter adapter;
    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (type){
                    case 1:
                        // 用户个人中心
                        jumpMeCenter(position);
                        break;
                    case 4:
                        // 家居商个人中心
                        jumpJiaJuShangCenter(position);
                        break;
                    case 3:
                        // 房产商个人中心
                        jumpFangChanShangCenter(position);
                        break;
                    case 2:
                        // 经纪人个人中心
                        jumpJingJiRenCenter(position);
                        break;
                    case 5:
                        jumpZhuangXiuShangCenter(position);
                        break;
                }
            }
        });
    }

    private void jumpZhuangXiuShangCenter(int position) {
        Intent intent = new Intent();
        switch (position){
            case 0:
                intent.setClass(getActivity(), MessageActivity.class);
                break;
            case 1:
                intent.setClass(getActivity(), WenDaActivity.class);
                break;
            case 2:
                intent.setClass(getActivity(), ZhuangXiuKanActivity.class);
                break;
            case 3:
                intent.setClass(getActivity(), ChongZhiActivity.class);
                break;
            case 4:
                intent.setClass(getActivity(), SettingActivity.class);
                break;
        }
        startActivity(intent);
    }

    private void jumpJingJiRenCenter(int position) {
        Intent intent = new Intent();
        switch (position){
            case 0:
                intent.setClass(getActivity(), MessageActivity.class);
                break;
            case 1:
                intent.setClass(getActivity(), WeiTuoActivity.class);
                break;
            case 2:
                intent.setClass(getActivity(), ChuZuActivity.class);
                break;
            case 3:
                intent.setClass(getActivity(), WeiTuoMaiActivity.class);
                break;
            case 4:
                intent.setClass(getActivity(), WenDaActivity.class);
                break;
            case 5:
                intent.setClass(getActivity(), ShouCangActivity.class);
                break;
            case 6:
                intent.setClass(getActivity(), KanFangJiluActivity.class);
                break;
            case 7:
                intent.setClass(getActivity(), JingJiRenZiLiaoActivity.class);
                break;
            case 8:
                intent.setClass(getActivity(), SettingActivity.class);
                break;
        }
        startActivity(intent);

    }

    private void jumpFangChanShangCenter(int position) {
        Intent intent = new Intent();
        switch (position){
            case 0:
                intent.setClass(getActivity(), FuBuLouPanActivity.class);
                break;
            case 1:
                intent.setClass(getActivity(), MianFeiKanActivity.class);
                break;
            case 2:
                intent.setClass(getActivity(), WenDaActivity.class);
                break;
            case 3:
                intent.setClass(getActivity(), MessageActivity.class);
                break;
            case 4:
                intent.setClass(getActivity(), SettingActivity.class);
                break;
        }
        startActivity(intent);
    }

    private void jumpJiaJuShangCenter(int position) {
        Intent intent = new Intent();
        switch (position){
            case 0:
                intent.setClass(getActivity(), MessageActivity.class);
                break;
            case 1:
                intent.setClass(getActivity(), MeChanPinActivity.class);
                break;
            case 2:
                intent.setClass(getActivity(), WenDaActivity.class);
                break;
//            case 3:
//                intent.setClass(getActivity(), ChaKanJiluActivity.class);
//                break;
            case 3:
                intent.setClass(getActivity(), ChongZhiActivity.class);
                break;
            case 4:
                intent.setClass(getActivity(), SettingActivity.class);
                break;
        }
        startActivity(intent);
    }

    //todo
    private void jumpMeCenter(int position) {
        Intent intent = new Intent();
        switch (position){
            case 0:
                intent.setClass(getActivity(), MessageActivity.class);
                break;
            case 1:
                intent.setClass(getActivity(), WeiTuoMaiActivity.class);
                break;
            case 2:
                intent.setClass(getActivity(), WeiTuoActivity.class);
                break;
            case 3:
                //出租
                intent.setClass(getActivity(),ChuZuActivity.class);
                break;
            case 4:
                //委托竞卖
                intent.setClass(getActivity(), WeiTuoJingMaiActivity.class);
                break;
            case 5:
                //问答
                intent.setClass(getActivity(), QiTeWeiTuoActivity.class);
                break;
            case 6:
                //问答
                intent.setClass(getActivity(), WenDaActivity.class);
                break;
            case 7:
                //我的收藏
                intent.setClass(getActivity(), ShouCangActivity.class);
                break;
            case 8:
                //看房记录
                intent.setClass(getActivity(), KanFangJiluActivity.class);
                break;
            case 9:
                //设置
                intent.setClass(getActivity(), SettingActivity.class);
                break;
        }
        startActivity(intent);
    }

    @OnClick({R.id.tou, R.id.name})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tou:
            case R.id.name:
                switch (type){
                    case 1:
                        Intent intent = new Intent();
                        intent.setClass(getActivity(), PersonInfoActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent in = new Intent();
                        in.setClass(getActivity(), MeJingJiCenterActivity.class);
                        startActivity(in);
                        break;
                    case 3:
                        Intent i = new Intent();
                        i.setClass(getActivity(), MeFangChanCenterActivity.class);
                        startActivity(i);
                        break;
                    case 4:
                        Intent inten = new Intent();
                        inten.setClass(getActivity(), JiaJuCenterActivity.class);
                        startActivity(inten);
                        break;
                    case 5:
                        Intent inte = new Intent();
                        inte.setClass(getActivity(), JiaJuCenterActivity.class);
                        startActivity(inte);
                        break;

                }
                break;
        }
    }
}
