package com.zhuye.ershoufang.ui.fragment.fabu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.AddErShouActivity;
import com.zhuye.ershoufang.ui.fragment.SelectCityFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class QiuZuFragment extends SelectCityFragment {
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
    TextView zujin;
    @BindView(R.id.zhongliangwu11)
    TextView zhongliangwu11;
    @BindView(R.id.fukuan)
    TextView fukuan;
    @BindView(R.id.chuzu)
    TextView chuzu;

    @BindView(R.id.jingmai)
    Button jingmai;
    @BindView(R.id.fabu)
    Button fabu;
    @BindView(R.id.summit)
    Button summit;
    Unbinder unbinder;
    @BindView(R.id.zujina)
    EditText zujina;
    Unbinder unbinder1;
    @BindView(R.id.lianxiren)
    EditText lianxiren;
    @BindView(R.id.dianhua)
    EditText dianhua;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.dizhi2)
    TextView dizhi2;
    @BindView(R.id.dizhi3)
    TextView dizhi3;
    @BindView(R.id.dizhi4)
    TextView dizhi4;
    Unbinder unbinder2;
    @BindView(R.id.xiangxi)
    EditText xiangxi;

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getResId() {
        return R.layout.qiuzu_fragment;
    }


    @OnClick({R.id.zhuangxiu, R.id.dizhi, R.id.dizhi2, R.id.dizhi3, R.id.dizhi4, R.id.zhongliangwu, R.id.zhongliangwu11, R.id.fukuan, R.id.chuzu, R.id.zujin, R.id.jingmai, R.id.fabu, R.id.summit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhuangxiu:
                editLeiXingin((TextView) view, "请输入装修状况", 2);
                break;
            case R.id.dizhi:
                if(cityBean==null){
                    CommonApi.getInstance().province(QiuZuFragment.this, PROVINCE, false);
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 6);
                break;
            case R.id.dizhi2:
                if (xiaji == null) {
                    toast("请选择市");
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 7);
                break;
            case R.id.dizhi3:
                if (qu == null) {
                    toast("请选择区");
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 8);
                break;
            case R.id.dizhi4:
                if (jiedao == null) {
                    toast("请选择街道");
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 9);
                break;

            case R.id.zhongliangwu:
                break;
            case R.id.zhongliangwu11:
                break;
            case R.id.fukuan:
                editLeiXingin((TextView) view, "请输入付款金额", 2);
                break;
            case R.id.chuzu:
                editLeiXingin((TextView) view, "请输入租期", 2);
                break;
            case R.id.zujin:
                editLeiXingin((TextView) view, "请输入租金", 2);
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

    private void tijiao(String type) {
        if (checkEmpty(xiaoqu, "请输入小区名称") && checkEmpty(mianji, "请输入房屋面积") &&
                checkEmpty(shi, "请输入室") &&
                checkEmpty(ceng, "请输入层") &&
                checkEmpty(jiceng, "请输入楼层") &&
                checkEmpty(gong, "请输入总楼层") &&
                checkEmpty(zujina, "请输入租金") &&
                checkEql(dizhi, "请输入省份", "请输入省份") &&
                checkEql(dizhi2, "请输入市", "请输入市") &&
                checkEql(dizhi3, "请输入区", "请输入区") &&
                checkEql(dizhi4, "请输入街道", "请输入街道") &&
                checkEmpty(xiangxi, "请输入详细地址") &&
                checkEql(zhuangxiu, "装修情况", "请输入装修情况") &&
                checkEql(fukuan, "付款方式", "请输入付款方式") &&
                checkEql(zujin, "租期", "请输入租期") &&
                checkEql(chuzu, "出租方式", "请输入出租方式")
                && checkEmpty(lianxiren, "请输入联系人")
            // && CheckUtil.isMobile(getActivity(),getString(dianhua)

                ) {
            CommonApi.getInstance().qzu(getToken(), getString(mianji), getString(xiaoqu)
                    , getString(shi), getString(ceng), getString(wei), getString(zujina), getString(jiceng), getString(gong),
                    getString(zhuangxiu), getString(fukuan), getString(chuzu), getString(zujin), getIndex(xiaji, dizhi2.getText().toString().trim()),
                    getIndex(qu, dizhi3.getText().toString().trim()), getIndex(jiedao, dizhi4.getText().toString().trim()),
                    getString(lianxiren), getString(dianhua), type, getString(xiangxi),QiuZuFragment.this, FABU,true);
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
