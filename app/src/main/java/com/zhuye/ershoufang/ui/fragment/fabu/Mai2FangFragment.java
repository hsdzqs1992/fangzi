package com.zhuye.ershoufang.ui.fragment.fabu;

import android.content.Intent;
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

public class Mai2FangFragment extends SelectCityFragment {
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
    @BindView(R.id.shouji)
    EditText shouji;
    @BindView(R.id.zhongliangw)
    TextView zhongliangw;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.dizhi2)
    TextView dizhi2;
    @BindView(R.id.dizhi3)
    TextView dizhi3;
    @BindView(R.id.dizhi4)
    TextView dizhi4;
    @BindView(R.id.next)
    Button next;
    Unbinder unbinder;
    @BindView(R.id.xiangxi)
    EditText xiangxi;
    Unbinder unbinder1;

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getResId() {
        return R.layout.maifang2_fragment;
    }


    @OnClick({R.id.dizhi, R.id.dizhi2, R.id.dizhi3, R.id.dizhi4, R.id.next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dizhi:
                if(cityBean==null){
                    CommonApi.getInstance().province(Mai2FangFragment.this, PROVINCE, false);
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
            case R.id.next:
                if (
                        checkEmpty(mianji, "请输入面积") &&
                                checkEmpty(shi, "请输入室") &&
                                checkEmpty(ceng, "请输入层") &&
                                checkEmpty(wei, "请输入卫") &&

                                checkEmpty(xiaoqu, "请输入小区名称") &&
                                checkEmpty(shouji, "请输入售价") &&

//                        checkEql(fangwuleixing, "房屋类型", "请输入房屋类型") &&
//                        checkEql(zhuangxiuleixing, "装修类型", "请输入装修类型") &&
//                        checkEql(niamdai, "年代", "请输入年代") &&
//                        checkEql(chaoxiang1, "朝向", "请输入朝向") &&
//                        checkEql(shoufu2, "万元", "请输入首付价格") &&
//                        checkEql(fangjia1, "万元", "请输入单位价格") &&
//                        checkEql(yuegong1, "万元", "请输入月供金额") &&
//                        checkEmpty(lianxiren,"请输入联系人姓名")&&
//                        checkEmpty(dianhua,"请输入联系人电话")&&
//                        checkEmpty(maidian, "请输入卖点") &&
//                        checkEmpty(xintai, "请输入业主心态") &&
//                        checkArray(photos,"请上传室内图")&&
//                        checkArray(photos2,"请上传户型图")&&
//                        checkArray(photos3,"请上传环境图")&&
                                checkEql(dizhi, "请输入省份", "请输入省份") &&
                                checkEql(dizhi2, "请输入市", "请输入市") &&
                                checkEql(dizhi3, "请输入区", "请输入区") &&
                                checkEql(dizhi4, "请输入街道", "请输入街道")&&
                                 checkEmpty(xiangxi, "请输入详细地址") ) {
//                    CommonApi.getInstance().wmall_fabu(getToken(),getString(mianji),getString(xiaoqu),getString(shi),getString(ceng)
//                            ,getString(wei),getString(yusuan),getIndex(xiaji, dizhi2.getText().toString().trim()),
//                            getIndex(qu, dizhi3.getText().toString().trim()),
//                            getIndex(jiedao, dizhi4.getText().toString().trim()),MaiFangFragment.this,SUBMIT);

                    Intent intent = new Intent(getActivity(), MaiFang2Activity.class);
                    intent.putExtra("mianji", getString(mianji));
                    intent.putExtra("xiaoqu", getString(xiaoqu));
                    intent.putExtra("shi", getString(shi));
                    intent.putExtra("ceng", getString(ceng));
                    intent.putExtra("wei", getString(wei));
                    intent.putExtra("shouji", getString(shouji));
                    intent.putExtra("xiaji", getIndex(xiaji, dizhi2.getText().toString().trim()));
                    intent.putExtra("qu", getIndex(qu, dizhi3.getText().toString().trim()));
                    intent.putExtra("jiedao",getIndex(jiedao, dizhi4.getText().toString().trim()));
                    intent.putExtra("xiangxi", getString(xiangxi));
                    startActivity(intent);
                }
                break;
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
