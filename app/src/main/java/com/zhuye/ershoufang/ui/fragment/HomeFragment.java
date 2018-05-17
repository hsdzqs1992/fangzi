package com.zhuye.ershoufang.ui.fragment;


import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.HomefenleiAdapter;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.FenLeiBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.MessageActivity;
import com.zhuye.ershoufang.ui.activity.SearchActivity;
import com.zhuye.ershoufang.ui.activity.home.ErShouFangActivity;
import com.zhuye.ershoufang.ui.activity.home.FangDaiJiSuanActivity;
import com.zhuye.ershoufang.ui.activity.home.GangXuActivity;
import com.zhuye.ershoufang.ui.activity.home.GongYechangFangActivity;
import com.zhuye.ershoufang.ui.activity.home.GuJiaActivity;
import com.zhuye.ershoufang.ui.activity.home.HomeWenDaActivity;
import com.zhuye.ershoufang.ui.activity.home.JiaJuActivity;
import com.zhuye.ershoufang.ui.activity.home.JingJiRenActivity;
import com.zhuye.ershoufang.ui.activity.home.JingMaiActivity;
import com.zhuye.ershoufang.ui.activity.home.KanFangActivity;
import com.zhuye.ershoufang.ui.activity.home.LookXiaoQuActivity;
import com.zhuye.ershoufang.ui.activity.home.MapZhaoFangActivity;
import com.zhuye.ershoufang.ui.activity.home.QuShiActivity;
import com.zhuye.ershoufang.ui.activity.home.XieZiLouActivity;
import com.zhuye.ershoufang.ui.activity.home.XinFangActivity;
import com.zhuye.ershoufang.ui.activity.home.XuQiuDaTingActivity;
import com.zhuye.ershoufang.ui.activity.home.YouHuiActivity;
import com.zhuye.ershoufang.ui.activity.home.ZhuangXiuActivity;
import com.zhuye.ershoufang.ui.activity.home.ZuFangActivity;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/8 0008.
 */

public class HomeFragment extends BaseFragment {

    private static final int INDEX = 900;
    @BindView(R.id.ditu)
    ImageView ditu;
    @BindView(R.id.message)
    ImageView message;
    @BindView(R.id.message1)
    ImageView message1;
    @BindView(R.id.home_message)
    TextView homeMessage;
    @BindView(R.id.message_go)
    ImageView messageGo;
    @BindView(R.id.home_youhui)
    ImageView homeYouhui;
    @BindView(R.id.home_jingji)
    ImageView homeJingji;
    @BindView(R.id.home_gangxu)
    ImageView homeGangxu;
    @BindView(R.id.home_zhaoxiaoqu)
    ImageView homeZhaoxiaoqu;
    @BindView(R.id.wenda)
    LinearLayout wenda;
    @BindView(R.id.jisuan)
    LinearLayout jisuan;
    @BindView(R.id.qushi)
    LinearLayout qushi;
    @BindView(R.id.gujia)
    LinearLayout gujia;
    @BindView(R.id.tuijianxinfang)
    RecyclerView tuijianxinfang;
    @BindView(R.id.tuijianershoufang)
    RecyclerView tuijianershoufang;
    @BindView(R.id.jingjiren_go)
    ImageView jingjirenGo;
    @BindView(R.id.jingjiren)
    RecyclerView jingjiren;
    @BindView(R.id.tuijianzufang)
    RecyclerView tuijianzufang;
    @BindView(R.id.cainixihuan)
    RecyclerView cainixihuan;
    Unbinder unbinder;
    @BindView(R.id.search)
    RelativeLayout search;
    Unbinder unbinder1;
    private RecyclerView fenleirv;


    private int[] pics = {R.drawable.newhouse,
            R.drawable.ershoufang,
            R.drawable.zufang,
            R.drawable.xiezilou,
            R.drawable.changfang,
            R.drawable.jiajuhome,
            R.drawable.zhuangxiua,
            R.drawable.weituo,
            R.drawable.zhaofang,
            R.drawable.xuqiu};

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode,o);
        switch (requestcode){
            case INDEX:

                break;
        }
    }

    @Override
    protected void initView() {
        this.fenleirv = rootView.findViewById(R.id.fenleirv);
    }

    @Override
    protected void initData() {
        super.initData();
        String[] names = getActivity().getResources().getStringArray(R.array.home_feilei);
        List<FenLeiBean.FenBean> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            FenLeiBean.FenBean bean = new FenLeiBean.FenBean();
            bean.imgRes = pics[i];
            bean.stringRes = names[i];
            data.add(bean);
        }
        adapte = new HomefenleiAdapter(R.layout.me_rv, data);
        fenleirv.setAdapter(adapte);
        fenleirv.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        String qu_id = SharedPreferencesUtil.getInstance().getString("qu_id");
        if(qu_id!=null && !TextUtils.isEmpty(qu_id)){
            CommonApi.getInstance().homeindex(qu_id,HomeFragment.this,INDEX);
        }
    }


    @Override
    protected void initListener() {
        super.initListener();
        //首页分类处理
        adapte.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                switch (position) {
                    case 0:
                        //进入新房界面
                        intent.setClass(getActivity(), XinFangActivity.class);
                        break;
                    case 1:
                        //进入二手房界面
                        intent.setClass(getActivity(), ErShouFangActivity.class);
                        break;
                    case 2:
                        //进入租房界面
                        intent.setClass(getActivity(), ZuFangActivity.class);
                        break;
                    case 3:
                        //进入写字楼界面
                        intent.setClass(getActivity(), XieZiLouActivity.class);
                        break;
                    case 4:
                        //进入工业厂房界面
                        intent.setClass(getActivity(), GongYechangFangActivity.class);
                        break;
                    case 5:
                        //进入租房界面
                        intent.setClass(getActivity(), JiaJuActivity.class);
                        break;
                    case 6:
                        //进入租房界面
                        intent.setClass(getActivity(), ZhuangXiuActivity.class);
                        break;
                    case 7:
                        //进入租房界面
                        intent.setClass(getActivity(), JingMaiActivity.class);
                        break;
                    case 8:
                        //进入租房界面
                        intent.setClass(getActivity(), KanFangActivity.class);
                        break;
                    case 9:
                        //进入租房界面
                        intent.setClass(getActivity(), XuQiuDaTingActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_home;
    }


    @OnClick({R.id.search,R.id.ditu, R.id.message, R.id.message_go, R.id.home_youhui, R.id.home_jingji, R.id.home_gangxu, R.id.home_zhaoxiaoqu, R.id.wenda, R.id.jisuan, R.id.qushi, R.id.gujia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search:
                start(SearchActivity.class);
                break;
            case R.id.ditu:
                start(MapZhaoFangActivity.class);
                break;
            case R.id.message:
                start(MessageActivity.class);
                break;
            case R.id.message_go:
                start(MessageActivity.class);
                break;
            case R.id.home_youhui:
                start(YouHuiActivity.class);
                break;
            case R.id.home_jingji:
                start(JingJiRenActivity.class);
                break;
            case R.id.home_gangxu:
                start(GangXuActivity.class);
                break;
            case R.id.home_zhaoxiaoqu:
                start(LookXiaoQuActivity.class);
                break;
            case R.id.wenda:
                start(HomeWenDaActivity.class);
                break;
            case R.id.jisuan:
                start(FangDaiJiSuanActivity.class);
                break;
            case R.id.qushi:
                start(QuShiActivity.class);
                break;
            case R.id.gujia:
                start(GuJiaActivity.class);
                break;
        }
    }
}
