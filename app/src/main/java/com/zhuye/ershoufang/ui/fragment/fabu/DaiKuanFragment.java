package com.zhuye.ershoufang.ui.fragment.fabu;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.GetData;
import com.zhuye.ershoufang.ui.activity.AddErShouActivity;
import com.zhuye.ershoufang.ui.fragment.SelectCityFragment;
import com.zhuye.ershoufang.utils.CheckUtil;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class DaiKuanFragment extends SelectCityFragment {
    private static final int CODE = 200;
    private static final int BANZHENG = 1000;
    @BindView(R.id.xuqiu)
    EditText xuqiu;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.send)
    Button send;
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

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode,o);
        switch (requestcode) {
            case CODE:
                toast(o.getMessage());
                break;

            case BANZHENG:
                toast(o.getMessage());
                break;
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getResId() {
        return R.layout.daikuan_fragment;
    }


    @OnClick({R.id.dizhi, R.id.dizhi2, R.id.dizhi3, R.id.dizhi4,R.id.send, R.id.fabu, R.id.summit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dizhi:
                if(cityBean==null){
                    CommonApi.getInstance().province(DaiKuanFragment.this, PROVINCE, false);
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
            case R.id.send:
                if (checkEmpty(xuqiu, "请输入需求") && CheckUtil.isMobile(getActivity(), getString(phone))) {
                    GetData.getCode3(getString(phone), DaiKuanFragment.this, CODE);
                }
                break;
            case R.id.fabu:
                if (checkEmpty(xuqiu, "请输入需求") && CheckUtil.isMobile(getActivity(), getString(phone))) {
                    CommonApi.getInstance().wpermit_fabu(getToken(), "6", getString(phone), getString(xuqiu), getString(code), getIndex(xiaji, dizhi2.getText().toString().trim()),
                            getIndex(qu, dizhi3.getText().toString().trim()), getIndex(jiedao, dizhi4.getText().toString().trim()), "", "1", DaiKuanFragment.this, BANZHENG);
                }
                break;
            case R.id.summit:
                if (checkEmpty(xuqiu, "请输入需求") && CheckUtil.isMobile(getActivity(), getString(phone))) {
                    CommonApi.getInstance().wpermit_fabu(getToken(), "6", getString(phone), getString(xuqiu), getString(code),  getIndex(xiaji, dizhi2.getText().toString().trim()),
                            getIndex(qu, dizhi3.getText().toString().trim()), getIndex(jiedao, dizhi4.getText().toString().trim()), "", "2", DaiKuanFragment.this, BANZHENG);
                }
                break;
        }
    }

}
