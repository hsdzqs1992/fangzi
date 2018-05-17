package com.zhuye.ershoufang.ui.fragment.fabu;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.ImageAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.fragment.SelectCityFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.iwf.photopicker.PhotoPicker;

/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class ChuZuFragment extends SelectCityFragment {
    protected static final int FABU = 605;
    @BindView(R.id.xiaoqu)
    EditText xiaoqu;
    @BindView(R.id.zhongliang1)
    TextView zhongliang1;
    @BindView(R.id.mianji)
    EditText mianji;
    @BindView(R.id.zhongliangwu)
    TextView zhongliangwu;
    @BindView(R.id.dianzhongliang)
    RelativeLayout dianzhongliang;
    @BindView(R.id.shi)
    EditText shi;
    @BindView(R.id.ceng)
    EditText ceng;
    @BindView(R.id.wei)
    EditText wei;
    @BindView(R.id.jiceng)
    EditText jiceng;
    @BindView(R.id.gong)
    EditText gong;
    @BindView(R.id.zhuangxiu)
    TextView zhuangxiu;
    @BindView(R.id.zujin)
    EditText zujin;
    @BindView(R.id.zhongliangwu11)
    TextView zhongliangwu11;
    @BindView(R.id.fukuan)
    TextView fukuan;
    @BindView(R.id.chuzu)
    TextView chuzu;
    @BindView(R.id.yuan)
    TextView yuan;
    @BindView(R.id.photo)
    RecyclerView photo;
    @BindView(R.id.nima)
    ImageView nima;
    @BindView(R.id.shipin)
    ImageView shipin;
    @BindView(R.id.jingmai)
    Button jingmai;
    @BindView(R.id.fabu)
    Button fabu;
    @BindView(R.id.summit)
    Button summit;
    Unbinder unbinder;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.dizhi2)
    TextView dizhi2;
    @BindView(R.id.dizhi3)
    TextView dizhi3;
    @BindView(R.id.dizhi4)
    TextView dizhi4;
    Unbinder unbinder1;
    @BindView(R.id.lianxiren)
    EditText lianxiren;
    @BindView(R.id.dianhua)
    EditText dianhua;
    @BindView(R.id.xiangxi)
    EditText xiangxi;

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
    }

    protected ImageAdapter adapter;

    @Override
    protected void initView() {
        super.initView();
        adapter = new ImageAdapter(R.layout.image);
        photo.setAdapter(adapter);
        photo.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        neituimg.add("");
        adapter.addData(neituimg);
        // CommonApi.getInstance().province(SelectCityFragment.this, PROVINCE);
    }

    @Override
    protected int getResId() {
        return R.layout.chuzu_fragment;
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                PhotoPicker.builder()
                        .setPhotoCount(6)
                        .setShowCamera(true)
                        .setShowGif(true)
                        .setPreviewEnabled(false)
                        .start(getActivity(), PhotoPicker.REQUEST_CODE);
            }
        });
    }

    @OnClick({R.id.dizhi, R.id.dizhi2, R.id.dizhi3, R.id.dizhi4, R.id.zhuangxiu, R.id.fukuan, R.id.chuzu, R.id.shipin, R.id.jingmai, R.id.fabu, R.id.summit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dizhi4:
                editLeiXing((TextView) view, "请输入朝向", 9);
                break;
            case R.id.dizhi:
                editLeiXing((TextView) view, "请输入朝向", 6);
                break;
            case R.id.dizhi2:
                editLeiXing((TextView) view, "请输入朝向", 7);
                break;
            case R.id.dizhi3:
                editLeiXing((TextView) view, "请输入朝向", 8);
                break;
            case R.id.zhuangxiu:
                editLeiXingin((TextView) view, "请输入装修状况", 2);
                break;
            case R.id.fukuan:
                editLeiXingin((TextView) view, "请输入付款金额", 2);
                break;
            case R.id.chuzu:
                editLeiXingin((TextView) view, "请输入出租方式", 2);
                break;
            case R.id.shipin:
                break;
            case R.id.jingmai:
                break;
            case R.id.fabu:
                tijiao("1");
                break;
            case R.id.summit:
                tijiao("0");
                break;
        }
    }

    private void tijiao(String audit) {

        if (checkEmpty(xiaoqu, "请输入小区名称") && checkEmpty(mianji, "请输入房屋面积") &&
                checkEmpty(shi, "请输入室") &&
                checkEmpty(ceng, "请输入层") &&
                checkEmpty(jiceng, "请输入楼层") &&
                checkEmpty(gong, "请输入总楼层") &&
                checkEmpty(zujin, "请输入租金") &&
                checkEql(dizhi, "请输入省份", "请输入省份") &&
                checkEql(dizhi2, "请输入市", "请输入市") &&
                checkEql(dizhi3, "请输入区", "请输入区") &&
                checkEql(dizhi4, "请输入街道", "请输入街道") &&
                checkEmpty(xiangxi, "请输入详细地址") &&
                checkEql(zhuangxiu, "装修情况", "请输入装修情况") &&
                checkEql(fukuan, "付款方式", "请输入付款方式") &&
                checkEql(chuzu, "出租方式", "请输入出租方式")
                && checkEmpty(lianxiren, "请输入联系人")
            // && CheckUtil.isMobile(getActivity(),getString(dianhua))
                ) {
            CommonApi.getInstance().wsell_fabu(getToken(), getString(xiaoqu), getString(mianji), getString(zujin)
                    , getString(shi), getString(ceng), getString(wei), "", getString(jiceng), getString(gong),
                    getString(chuzu), getString(zhuangxiu), getString(fukuan), getIndex(xiaji, dizhi2.getText().toString().trim()),
                    getIndex(qu, dizhi3.getText().toString().trim()), getIndex(jiedao, dizhi4.getText().toString().trim()),
                    getString(lianxiren), getString(dianhua), audit, "3", "",getString(xiangxi),ChuZuFragment.this, FABU,true);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }
}
