package com.zhuye.ershoufang.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.ErFangAdapter;
import com.zhuye.ershoufang.adapter.home.HomeJingJiAdapter2;
import com.zhuye.ershoufang.adapter.home.HomefenleiAdapter;
import com.zhuye.ershoufang.adapter.home.XiHuanAdapter;
import com.zhuye.ershoufang.adapter.home.ZuFangAdapter2;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.FenLeiBean;
import com.zhuye.ershoufang.bean.HomeBean;
import com.zhuye.ershoufang.city.ChooseAddressActivity;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.one.MyMultipleItem;
import com.zhuye.ershoufang.one.XinFangAdapter4;
import com.zhuye.ershoufang.ui.activity.MessageActivity;
import com.zhuye.ershoufang.ui.activity.SearchActivity;
import com.zhuye.ershoufang.ui.activity.home.ErShouFangActivity;
import com.zhuye.ershoufang.ui.activity.home.ErShouFangDetailActivity;
import com.zhuye.ershoufang.ui.activity.home.FangDaiJiSuanActivity;
import com.zhuye.ershoufang.ui.activity.home.GangXuActivity;
import com.zhuye.ershoufang.ui.activity.home.GongYechangFangActivity;
import com.zhuye.ershoufang.ui.activity.home.GuJiaActivity;
import com.zhuye.ershoufang.ui.activity.home.HomeWenDaActivity;
import com.zhuye.ershoufang.ui.activity.home.JiaJuActivity;
import com.zhuye.ershoufang.ui.activity.home.JingJiRenActivity;
import com.zhuye.ershoufang.ui.activity.home.JingJiRenDetailActivity;
import com.zhuye.ershoufang.ui.activity.home.JingMaiActivity;
import com.zhuye.ershoufang.ui.activity.home.KanFangActivity;
import com.zhuye.ershoufang.ui.activity.home.LookXiaoQuActivity;
import com.zhuye.ershoufang.ui.activity.home.MapZhaoFangActivity;
import com.zhuye.ershoufang.ui.activity.home.QuShiActivity;
import com.zhuye.ershoufang.ui.activity.home.XieZiLouActivity;
import com.zhuye.ershoufang.ui.activity.home.XinFangActivity;
import com.zhuye.ershoufang.ui.activity.home.XinFangDetailActivity;
import com.zhuye.ershoufang.ui.activity.home.XuQiuDaTingActivity;
import com.zhuye.ershoufang.ui.activity.home.YouHuiActivity;
import com.zhuye.ershoufang.ui.activity.home.ZhuangXiuActivity;
import com.zhuye.ershoufang.ui.activity.home.ZuFangActivity;
import com.zhuye.ershoufang.weidtet.CustomLinearLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;

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
    @BindView(R.id.banner)
    BGABanner banner;
    Unbinder unbinder2;
    @BindView(R.id.jinjikanmore)
    TextView jinjikanmore;
    @BindView(R.id.dizhi)
    TextView dizhi;
    private RecyclerView fenleirv;

    XinFangAdapter4 adapter3;
    ErFangAdapter erFangAdapter;
    HomeJingJiAdapter2 homeJingJiAdapter2;
    ZuFangAdapter2 adapter2;
    XiHuanAdapter xiHuanAdapter;

    CommonObjectBean<HomeBean> bean;
    List<MyMultipleItem<Common5Bean>> xindata = new ArrayList<>();

    private void doListener() {
        adapter3.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), XinFangDetailActivity.class);
                intent.putExtra("id", bean.getData().getNewhouse().get(position).getId());
                startActivity(intent);
            }
        });

        erFangAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), ErShouFangDetailActivity.class);
                intent.putExtra("id", bean.getData().getSell().get(position).getLife_id());
                startActivity(intent);
            }
        });

        homeJingJiAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), JingJiRenDetailActivity.class);
                intent.putExtra("id", bean.getData().getAgent().get(position).getUser_id());
                startActivity(intent);
            }
        });

        adapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), ErShouFangDetailActivity.class);
                intent.putExtra("id", bean.getData().getRenting().get(position).getLife_id());
                startActivity(intent);
            }
        });

        xiHuanAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), ErShouFangDetailActivity.class);
                intent.putExtra("id", bean.getData().getLove().get(position).getLife_id());
                startActivity(intent);
            }
        });

        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(XinFangActivity.class);
            }
        });

        footer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(ErShouFangActivity.class);
            }
        });

        footer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(ZuFangActivity.class);
            }
        });

        footer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2018/5/23 0023  喜欢
            }
        });
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case INDEX:
                bean = (CommonObjectBean<HomeBean>) o;
                for (String item : bean.getData().getAdv()) {
                }
                banner.setData(Arrays.asList(NetWorkUrl.IMAGEURL + bean.getData().getAdv().get(0), NetWorkUrl.IMAGEURL + bean.getData().getAdv().get(1)), Arrays.asList("", ""));

                for (Common5Bean b : bean.getData().getNewhouse()) {
                    xindata.add(new MyMultipleItem<>(MyMultipleItem.FIRST_TYPE, b));
                }
                adapter3.addData(xindata);

                //   二手房
                erFangAdapter.addData(bean.getData().getSell());

                homeJingJiAdapter2.addData(bean.getData().getAgent());

                adapter2.addData(bean.getData().getRenting());

                xiHuanAdapter.addData(bean.getData().getLove());
                break;
        }
    }

    View footer;
    View footer1;
    View footer2;
    View footer3;
    TextView more;

    @Override
    protected void initView() {
        footer = LayoutInflater.from(getActivity()).inflate(R.layout.footer, null);
        footer1 = LayoutInflater.from(getActivity()).inflate(R.layout.footer, null);
        footer2 = LayoutInflater.from(getActivity()).inflate(R.layout.footer, null);
        footer3 = LayoutInflater.from(getActivity()).inflate(R.layout.footer, null);
        more = footer.findViewById(R.id.more);

        this.fenleirv = rootView.findViewById(R.id.fenleirv);

        adapter3 = new XinFangAdapter4(null);
        tuijianxinfang.setAdapter(adapter3);
        tuijianxinfang.setLayoutManager(new CustomLinearLayoutManager(getActivity()));

        adapter3.addFooterView(footer);

        erFangAdapter = new ErFangAdapter(R.layout.home_xinfang_item3);
        tuijianershoufang.setAdapter(erFangAdapter);
        tuijianershoufang.setLayoutManager(new CustomLinearLayoutManager(getActivity()));

        erFangAdapter.addFooterView(footer1);

        homeJingJiAdapter2 = new HomeJingJiAdapter2(R.layout.home_jinji_item);
        jingjiren.setAdapter(homeJingJiAdapter2);
        jingjiren.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));


        adapter2 = new ZuFangAdapter2(R.layout.home_xinfang_item3);
        tuijianzufang.setAdapter(adapter2);
        tuijianzufang.setLayoutManager(new CustomLinearLayoutManager(getActivity()));

        adapter2.addFooterView(footer2);

        xiHuanAdapter = new XiHuanAdapter(R.layout.home_xinfang_item3);
        cainixihuan.setAdapter(xiHuanAdapter);
        cainixihuan.setLayoutManager(new CustomLinearLayoutManager(getActivity()));

        xiHuanAdapter.addFooterView(footer3);
    }


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
        String qu_id = getQuId();
        if (qu_id != null && !TextUtils.isEmpty(qu_id)) {
//            CommonApi.getInstance().homeindex(qu_id, HomeFragment.this, INDEX)
//            .map(new Function() {
//                @Override
//                public Object apply(Object o) throws Exception {
//                    return o;
//                }
//            });
            CommonApi.getInstance().homeindex(qu_id, HomeFragment.this, INDEX);
        }


        banner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                Glide.with(getActivity())
                        .load(model)
                        .into(itemView);
            }
        });
    }


    @Override
    protected void initListener() {
        super.initListener();
        //首页分类处理

        doListener();


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
//                asdafsdfsdafhhhhhhhasdf
//                sdfasdfasdfasdfs
            }
        });
    }


    @Override
    protected int getResId() {
        return R.layout.fragment_home;
    }


    @OnClick({R.id.dizhi,R.id.jinjikanmore, R.id.jingjiren_go, R.id.search, R.id.ditu, R.id.message, R.id.message_go, R.id.home_youhui, R.id.home_jingji, R.id.home_gangxu, R.id.home_zhaoxiaoqu, R.id.wenda, R.id.jisuan, R.id.qushi, R.id.gujia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dizhi:
                startActivity(new Intent(getActivity(),ChooseAddressActivity.class));
                break;
            case R.id.jinjikanmore:
            case R.id.jingjiren_go:
                start(JingJiRenActivity.class);
                break;
            case R.id.search:
                start(SearchActivity.class);
                break;
            case R.id.ditu:
                start(MapZhaoFangActivity.class);
                break;
            case R.id.message:
                //start(VuActivity.class);
               start(MessageActivity.class);
                // start(ConversationListActivity.class);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder2 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder2.unbind();
    }
}
