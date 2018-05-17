package com.zhuye.ershoufang.ui.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CityBean;
import com.zhuye.ershoufang.data.CommonApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JingJIRes2Activity extends BaseActivity {

    private static final int TIJIAO = 200;
    private static final int SELECT = 201;
    private static final int PROVINCE = 202;
    private static final int XIAJI = 203;
    private static final int QU = 204;
    private static final int JIEDAO = 205;
    private static final int NEITUIMG = 206;
    private static final int SELECTADAPTER = 207;
    private static final int SELECTADAPTER3 = 208;
    @BindView(R.id.loginname)
    EditText loginname;
    @BindView(R.id.gongsi)
    EditText gongsi;
    //    @BindView(R.id.work)
//    EditText work;
    @BindView(R.id.zhuzhai)
    TextView zhuzhai;
    @BindView(R.id.dichan)
    TextView dichan;
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.dizhi2)
    TextView dizhi2;
    @BindView(R.id.dizhi3)
    TextView dizhi3;
    @BindView(R.id.dizhi4)
    TextView dizhi4;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;

    @Override
    protected int getResId() {
        return R.layout.activity_jing_jires2;
    }

    View vie;
    String city_id;
    String scope_work;

    private void editLeiXing(TextView target, String title, int type) {
        selectIndex = -1;
        popupWindow = new PopupWindow(JingJIRes2Activity.this);
        popupWindow.setContentView(vie);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        // 背景的处理
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        WheelView wheelView = vie.findViewById(R.id.wheel);
        TextView queding = vie.findViewById(R.id.queding);

        wheelView.setCyclic(false);

        final List<String> mOptionsItems = new ArrayList<>();

        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                if (selectIndex != -1) {
                    target.setText(mOptionsItems.get(selectIndex));
                    // 是省的类型  且选中状态
                    if (type == 6) {
                        CommonApi.getInstance().xiaji(getIndex(cityBean, mOptionsItems.get(selectIndex)), JingJIRes2Activity.this, XIAJI, false);
                    } else if (type == 7) {
                        city_id = getIndex(xiaji, mOptionsItems.get(selectIndex));
                        CommonApi.getInstance().xiaji(getIndex(xiaji, mOptionsItems.get(selectIndex)), JingJIRes2Activity.this, QU, false);
                    } else if (type == 8) {
                        scope_work = getIndex(qu, mOptionsItems.get(selectIndex));
                        CommonApi.getInstance().xiaji(getIndex(qu, mOptionsItems.get(selectIndex)), JingJIRes2Activity.this, JIEDAO, false);
                    }
                }

            }
        });

        List<String> data = new ArrayList<>();
        switch (type) {
            case 6:
                for (int i = 0; i < cityBean.getData().size(); i++) {
                    data.add(cityBean.getData().get(i).getName());
                }
                break;
            case 7:
                for (int i = 0; i < xiaji.getData().size(); i++) {
                    data.add(xiaji.getData().get(i).getName());
                }
                break;
            case 8:
                if (qu == null) {
                    return;
                }
                for (int i = 0; i < qu.getData().size(); i++) {
                    data.add(qu.getData().get(i).getName());
                }
                break;

            case 9:
                if (jiedao == null) {
                    return;
                }
                for (int i = 0; i < jiedao.getData().size(); i++) {
                    data.add(jiedao.getData().get(i).getName());
                }
                break;

        }


        mOptionsItems.addAll(data);
        wheelView.setAdapter(new ArrayWheelAdapter(mOptionsItems));
        wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                // Toast.makeText(AddErShouActivity.this, "" + mOptionsItems.get(index), Toast.LENGTH_SHORT).show();
                selectIndex = index;
            }
        });
//        vie.findViewById(R.id.gongyechang).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                start(AddGongChangActivity.class);
//            }
//        });
        //popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
        popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }

    PopupWindow popupWindow;
    PopupWindow popupWindow2;

    private int selectIndex = -1;
    private int iszhu = 1;

    @OnClick({R.id.back,R.id.zhuzhai, R.id.dichan, R.id.next, R.id.dizhi4, R.id.dizhi2, R.id.dizhi3, R.id.dizhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
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
            case R.id.zhuzhai:
                zhuzhai.setBackgroundResource(R.drawable.shape_btn);
                zhuzhai.setTextColor(getResources().getColor(R.color.white));
                dichan.setTextColor(getResources().getColor(R.color.three));
                dichan.setBackground(null);
                iszhu = 1;
                break;
            case R.id.dichan:
                dichan.setBackgroundResource(R.drawable.shape_btn);
                dichan.setTextColor(getResources().getColor(R.color.white));
                zhuzhai.setTextColor(getResources().getColor(R.color.three));
                zhuzhai.setBackground(null);
                iszhu = 2;
                break;
            case R.id.next:
//                if (isEmpty(loginname)){
//                    toast("请输入真实姓名");
//                    return;
//                }
//
//                if(isEmpty(gongsi)){
//                    toast("请输入您所在公司名称");
//                    return;
//                }
//
//                if(isEmpty(work)){
//                    toast("请输入您的工作范围");
//                    return;
//                }


                if (checkEmpty(loginname, "请输入真实姓名") && checkEmpty(gongsi, "请输入您所在公司名称")
                        && checkEql(dizhi, "请输入省份", "请输入省份") &&
                        checkEql(dizhi2, "请输入市", "请输入市") &&
                        checkEql(dizhi3, "请输入区", "请输入区") &&
                        checkEql(dizhi4, "请输入街道", "请输入街道")) {
                    start(JingJiRes3Activity.class, getString(loginname), getString(gongsi), city_id, scope_work, iszhu + "");
                }
                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"经纪人注册");
        vie = View.inflate(JingJIRes2Activity.this, R.layout.picker, null);
        CommonApi.getInstance().province(JingJIRes2Activity.this, PROVINCE, false);
    }

    CityBean cityBean;
    CityBean xiaji;
    CityBean qu;
    CityBean jiedao;

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case TIJIAO:
                toast(base.getMessage());
                break;
            case PROVINCE:
                cityBean = (CityBean) base;
                break;

            case XIAJI:
                xiaji = (CityBean) base;

                break;

            case QU:
                qu = (CityBean) base;
                break;

            case JIEDAO:
                jiedao = (CityBean) base;
                break;

            case NEITUIMG:

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
