package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.ImageAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CityBean;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.IdNameBean;
import com.zhuye.ershoufang.bean.ImgBean;
import com.zhuye.ershoufang.bean.XiaoQuBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.utils.FilesUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class AddPaiMaiActivity extends BaseActivity {


    private static final int TIJIAO = 200;
    private static final int SELECT = 201;
    private static final int PROVINCE = 2020;
    private static final int XIAJI = 203;
    private static final int QU = 204;
    private static final int JIEDAO = 205;
    private static final int NEITUIMG = 206;
    private static final int SELECTADAPTER = 207;
    private static final int SELECTADAPTER3 = 208;
    private static final int XIAOQU = 2041;
    @BindView(R.id.jingmaileixing)
    TextView jingmaileixing;
    @BindView(R.id.suozaidi)
    TextView suozaidi;
    @BindView(R.id.xiqoqu)
    TextView xiqoqu;
    @BindView(R.id.menpai)
    EditText menpai;
    @BindView(R.id.zhongliang1)
    TextView zhongliang1;
    @BindView(R.id.shoujia)
    EditText shoujia;
    @BindView(R.id.zhongliangwu)
    TextView zhongliangwu;
    @BindView(R.id.dianzhongliang)
    RelativeLayout dianzhongliang;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.baozhengjin)
    EditText baozhengjin;
    @BindView(R.id.zhongliang11)
    TextView zhongliang11;
    @BindView(R.id.jiajia)
    EditText jiajia;
    @BindView(R.id.zhongliang12)
    TextView zhongliang12;
    @BindView(R.id.pinggujiage)
    EditText pinggujiage;
    @BindView(R.id.zhongliang13)
    TextView zhongliang13;
    @BindView(R.id.qipaijia)
    EditText qipaijia;
    @BindView(R.id.yanshi)
    TextView yanshi;
    @BindView(R.id.jingpaizhouqi)
    TextView jingpaizhouqi;
    @BindView(R.id.zhongliang14)
    TextView zhongliang14;
    @BindView(R.id.kaipaishijian)
    TextView kaipaishijian;
    @BindView(R.id.shineitu)
    RecyclerView shineitu;
    @BindView(R.id.fabu)
    Button fabu;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.dizhi2)
    TextView dizhi2;
    @BindView(R.id.dizhi3)
    TextView dizhi3;
    @BindView(R.id.dizhi4)
    TextView dizhi4;

    private List<IdNameBean> idNameBeans = new ArrayList<>();

    @Override
    protected int getResId() {
        return R.layout.activity_add_pai_mai;
    }

    ImageAdapter adapter;

    List<String> neituimg = new ArrayList();

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "新增拍卖");

        adapter = new ImageAdapter(R.layout.image);
        shineitu.setAdapter(adapter);
        shineitu.setLayoutManager(new GridLayoutManager(this, 3));
        neituimg.add("");
        adapter.addData(neituimg);
    }


    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case XIAOQU:
                CommonListBean<XiaoQuBean> bean = (CommonListBean<XiaoQuBean>) base;
                break;
            case ADD:
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
        }
    }

    View input;
    TextView inputtitle;
    EditText inputcontent;
    Button inputquxiao;
    Button inputqueding;
    View vie;

    @Override
    protected void initData() {
        super.initData();
        idNameBeans.add(new IdNameBean(1, "新房"));
        idNameBeans.add(new IdNameBean(2, "二手房"));
        idNameBeans.add(new IdNameBean(3, "商铺写字楼"));
        idNameBeans.add(new IdNameBean(4, "工业厂房"));
        CommonApi.getInstance().xiaoqu(AddPaiMaiActivity.this, XIAOQU,true);
        vie = View.inflate(AddPaiMaiActivity.this, R.layout.picker, null);
        input = View.inflate(AddPaiMaiActivity.this, R.layout.input_text, null);
        inputtitle = input.findViewById(R.id.title);
        inputcontent = input.findViewById(R.id.input);
        inputquxiao = input.findViewById(R.id.quxiao);
        inputqueding = input.findViewById(R.id.queding);
    }

    PopupWindow popupWindow2;

    private int selectIndex = -1;

    private void editLeiXingin(TextView target, String title, int type) {
        selectIndex = -1;
        popupWindow2 = new PopupWindow(AddPaiMaiActivity.this);
        popupWindow2.setContentView(input);
        popupWindow2.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow2.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.setFocusable(true);

        // 背景的处理
        setBackgroundAlpha(0.5f);//设置屏幕透明度


        inputtitle.setText(title);

        inputquxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow2.isShowing()) {
                    popupWindow2.dismiss();
                }
            }
        });

        inputqueding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEmpty(inputcontent, "请输入内容")) {
                    if (popupWindow2.isShowing()) {
                        popupWindow2.dismiss();
                        target.setText(getString(inputcontent));
                    }
                }
            }
        });

        popupWindow2.showAtLocation(vie, Gravity.CENTER, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }
    PopupWindow popupWindow;

    CityBean cityBean;
    CityBean xiaji;
    CityBean qu;
    CityBean jiedao;

    private void editLeiXing(TextView target, String title, int type) {
        selectIndex = -1;
        popupWindow = new PopupWindow(AddPaiMaiActivity.this);
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
                        CommonApi.getInstance().xiaji(getIndex(cityBean, mOptionsItems.get(selectIndex)), AddPaiMaiActivity.this, XIAJI,false);
                    } else if (type == 7) {
                        CommonApi.getInstance().xiaji(getIndex(xiaji, mOptionsItems.get(selectIndex)), AddPaiMaiActivity.this, QU,false);
                    } else if (type == 8) {
                        CommonApi.getInstance().xiaji(getIndex(qu, mOptionsItems.get(selectIndex)), AddPaiMaiActivity.this, JIEDAO,false);
                    }
                }

            }
        });

        List<String> data = new ArrayList<>();
        switch (type) {
//            case 1:
//                for (int i = 0; i < faBuSelectBean.getData().get房屋类型().size(); i++) {
//                    data.add(faBuSelectBean.getData().get房屋类型().get(i).getAttr_name());
//                }
//                break;
//            case 2:
//                for (int i = 0; i < faBuSelectBean.getData().get装修程度().size(); i++) {
//                    data.add(faBuSelectBean.getData().get装修程度().get(i).getAttr_name());
//                }
//                break;
//            case 3:
//                for (int i = 0; i < faBuSelectBean.getData().get年代().size(); i++) {
//                    data.add(faBuSelectBean.getData().get年代().get(i).getAttr_name());
//                }
//                break;
//            case 4:
//                for (int i = 0; i < faBuSelectBean.getData().get朝向().size(); i++) {
//                    data.add(faBuSelectBean.getData().get朝向().get(i).getAttr_name());
//                }
//                break;
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

            case 10:
                for (int i = 0; i < idNameBeans.size(); i++) {
                    data.add(idNameBeans.get(i).name);
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
    public String getIndex(CityBean bean, String value) {
        String id = "";
        for (int i = 0; i < bean.getData().size(); i++) {
            if (bean.getData().get(i).getName().equals(value)) {
                id = bean.getData().get(i).getId();
            }
        }
        return id;
    }

    public int getIndex(List<IdNameBean> bean, String value) {
        int id = 1;
        for (int i = 0; i < bean.size(); i++) {
            if (bean.get(i).name.equals(value)) {
                id = bean.get(i).id;
            }
        }
        return id;
    }

    @OnClick({R.id.dizhi4, R.id.dizhi2, R.id.dizhi3,R.id.dizhi,R.id.kaipaishijian, R.id.back, R.id.jingmaileixing, R.id.suozaidi, R.id.xiqoqu, R.id.menpai, R.id.zhongliang1, R.id.shoujia, R.id.zhongliangwu, R.id.dianzhongliang, R.id.tv2, R.id.baozhengjin, R.id.zhongliang11, R.id.jiajia, R.id.zhongliang12, R.id.pinggujiage, R.id.yanshi, R.id.jingpaizhouqi, R.id.shineitu, R.id.fabu})
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
            case R.id.kaipaishijian:
                editLeiXingin((TextView) view, "请输入开拍时间", 2);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.jingmaileixing:
               // editLeiXingin((TextView) view, "请输入竞卖类型", 2);
                editLeiXing((TextView) view, "请输入朝向", 10);
                break;
            case R.id.suozaidi:
                editLeiXingin((TextView) view, "请输入资产所在地", 2);
                break;
            case R.id.xiqoqu:
                editLeiXingin((TextView) view, "请输入所在小区", 2);
                break;
            case R.id.menpai:
                break;
            case R.id.zhongliang1:
                break;
            case R.id.shoujia:
                break;
            case R.id.zhongliangwu:
                break;
            case R.id.dianzhongliang:
                break;
            case R.id.tv2:
                break;
            case R.id.baozhengjin:
                break;
            case R.id.zhongliang11:
                break;
            case R.id.jiajia:
                break;
            case R.id.zhongliang12:
                break;
            case R.id.pinggujiage:
                break;
            case R.id.yanshi:
                editLeiXingin((TextView) view, "请输入延时周期", 2);
                break;
            case R.id.jingpaizhouqi:
                editLeiXingin((TextView) view, "请输入竞拍周期", 2);
                break;
            case R.id.shineitu:
                break;
            case R.id.fabu:


//                Date data = new Date();
//                Long d =  data.getTime();
//                Long dd = SystemClock.currentThreadTimeMillis();
                Log.i("asd",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") .format(new Date())+"");

//                if (checkEmpty(title, "请输入标题") &&
//
//                        checkEmpty(mianji, "请输入面积") &&
//                        checkEmpty(danweifangjia, "请输入单位房价") &&
//                        checkEmpty(miaoshu, "请输入房源描述") &&
//                        checkArray(photos, "请上传室内图")&&
//                        checkEql(dizhi,"请输入省份","请输入省份")&&
//                        checkEql(dizhi2,"请输入市","请输入市")&&
//                        checkEql(dizhi3,"请输入区","请输入区")&&
//                        checkEmpty(lianxiren,"请输入联系人姓名")&&
//                        checkEmpty(dianhua,"请输入联系人电话")&&
             //   Log.i("asd", getIndex(idNameBeans,jingmaileixing.getText().toString().trim())+"");

                if (
                        checkEmpty(menpai, "请输入门牌号") &&
                                checkEmpty(shoujia, "请输入面积") &&
                                checkEmpty(baozhengjin, "请输入面积") &&
                                checkEmpty(jiajia, "请输入加价幅度") &&
//                        checkEmpty(jiajia, "请输入加价幅度") &&
                                checkEmpty(pinggujiage, "请输入评估价格") &&
                                checkEmpty(qipaijia, "请输入起拍价") &&


                                checkEql(yanshi, "延时周期", "请输入延时周期") &&
                                checkEql(jingpaizhouqi, "竞拍周期", "请输入竞拍周期") &&
                                checkEql(kaipaishijian, "开拍时间", "请输入开拍时间") &&

                                checkEql(jingmaileixing, "请输入竞卖类型", "请输入竞卖类型") &&
                                checkEql(suozaidi, "请输入资产所在地", "请输入资产所在地") &&
                                checkEql(xiqoqu, "请输入所在小区", "请输入所在小区") &&
                                checkArray(photos, "请上传图片")) {
                    handleshiNei();
                }
                break;
        }
    }

    private String arraytoString(List<String> photo) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < photo.size() - 1; i++) {
            buffer.append(photo.get(i));
            buffer.append(",");
        }
        buffer.append(photo.get(photo.size() - 1));
        return buffer.toString();
    }


    private void tijiao() {

        // Log.i("asd", getIndex(idNameBeans,jingmaileixing.getText().toString().trim())+"");



        CommonApi.getInstance().bidder_fabu(getToken(), getIndex(xiaji, dizhi2.getText().toString().trim()),
                getIndex(qu, dizhi3.getText().toString().trim()),
                getIndex(jiedao, dizhi4.getText().toString().trim())
                , "", "", getString(menpai), getString(shoujia), getString(baozhengjin), getString(jiajia), getString(pinggujiage)
                ,getString(qipaijia), getString(yanshi), getString(jingpaizhouqi),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") .format(new Date())+""
//                getString(kaipaishijian)
                , arraytoString(imgBeannei.getData().getPhoto()),
                getIndex(idNameBeans,jingmaileixing.getText().toString().trim()), "",
                AddPaiMaiActivity.this, ADD);
    }


    ImgBean imgBeannei;

    private void handleshiNei() {
        if (photos != null && photos.size() > 0) {
            List<File> data = new ArrayList<>();
            for (String item : photos) {
                data.add(FilesUtil.getSmallBitmap(AddPaiMaiActivity.this, item));
            }
            // CommonApi.getInstance().img(getToken(),neituimg,AddErShouActivity.this,NEITUIMG);

            OkGo.<String>post(NetWorkUrl.BASE + NetWorkUrl.IMG).params("token2", getToken())
                    .addFileParams("file[]", data).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    Log.i("ad", response.body());
                    try {
                        imgBeannei = new Gson().fromJson(response.body(), ImgBean.class);
                        //handlehuxing();
                        tijiao();
                    } catch (JsonSyntaxException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onError(Response<String> response) {
                    super.onError(response);
                    // Log.i("ad",response.body());
                }
            });
        }
    }


    @Override
    protected void initListener() {
        super.initListener();
        CommonApi.getInstance().province(AddPaiMaiActivity.this, PROVINCE,false);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                PhotoPicker.builder()
                        .setPhotoCount(6)
                        .setShowCamera(true)
                        .setShowGif(true)
                        .setPreviewEnabled(false)
                        .start(AddPaiMaiActivity.this, PhotoPicker.REQUEST_CODE);
            }
        });
    }

    private ArrayList<String> photos;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                photos =
                        data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                neituimg.clear();
                neituimg.addAll(photos);
                neituimg.add("");
                adapter.addData(neituimg);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
