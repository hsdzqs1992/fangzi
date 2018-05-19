package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.zhuye.ershoufang.bean.FaBuSelectBean;
import com.zhuye.ershoufang.bean.ImgBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.utils.FilesUtil;
import com.zhuye.ershoufang.utils.WindowUtils;
import com.zhuye.ershoufang.weidtet.MySelectPhotoView;
import com.zhuye.ershoufang.weidtet.MySelectTvView;
import com.zhuye.ershoufang.weidtet.UpPhotoCallBack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class AddShangPuActivity extends BaseActivity  implements UpPhotoCallBack {

    private static final int XIAJI = 145;
    private static final int QU = 102;
    private static final int JIEDAO = 103;
    private static final int PROVINCE = 101;
    private static final int TIJIAO = 104;
    private static final int SELECT = 108;
    private static final int JIAOTONG = 109;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.mingcheng1)
    TextView mingcheng1;
    @BindView(R.id.title)
    EditText title;
    @BindView(R.id.dianhuowu)
    LinearLayout dianhuowu;
    @BindView(R.id.zhongliang1)
    TextView zhongliang1;
    @BindView(R.id.shoujia)
    EditText shoujia;
    @BindView(R.id.zhongliangwu)
    TextView zhongliangwu;
    @BindView(R.id.dianzhongliang)
    RelativeLayout dianzhongliang;
    @BindView(R.id.shifa1)
    TextView shifa1;
    @BindView(R.id.mianji)
    EditText mianji;
    @BindView(R.id.mianjia)
    TextView mianjia;
    @BindView(R.id.dianshifa)
    RelativeLayout dianshifa;
    @BindView(R.id.shifa15)
    TextView shifa15;
    @BindView(R.id.miankuan)
    EditText miankuan;
    @BindView(R.id.modi1)
    TextView modi1;
    @BindView(R.id.modi2)
    EditText modi2;
    @BindView(R.id.dianmudi)
    RelativeLayout dianmudi;
    @BindView(R.id.cheliang1)
    TextView cheliang1;
    @BindView(R.id.cheliang2)
    EditText cheliang2;
    @BindView(R.id.diancheliang)
    RelativeLayout diancheliang;
    @BindView(R.id.zhuangtai)
    TextView zhuangtai;
    @BindView(R.id.yafu)
    TextView yafu;
    @BindView(R.id.jiceng)
    EditText jiceng;
    @BindView(R.id.gong)
    EditText gong;
    @BindView(R.id.fangjia1)
    TextView fangjia1;
    @BindView(R.id.fangjia)
    RelativeLayout fangjia;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.dizhi2)
    TextView dizhi2;
    @BindView(R.id.dizhi3)
    TextView dizhi3;
    @BindView(R.id.dizhi4)
    TextView dizhi4;
    @BindView(R.id.lianxiren)
    EditText lianxiren;
    @BindView(R.id.dianhua)
    EditText dianhua;
    @BindView(R.id.shineitu)
    RecyclerView shineitu;
    @BindView(R.id.fabu)
    Button fabu;
    @BindView(R.id.cenggao)
    EditText cenggao;
    @BindView(R.id.wuyefei)
    EditText wuyefei;
    @BindView(R.id.mingcheng)
    EditText mingcheng;
    @BindView(R.id.jutidizhi)
    EditText jutidizhi;
    @BindView(R.id.miaoshu)
    EditText miaoshu;
    @BindView(R.id.peizhiba)
    MySelectTvView peizhiba;
    @BindView(R.id.renqun)
    MySelectTvView renqun;
    @BindView(R.id.jiaotong)
    MySelectPhotoView jiaotong;

    private ArrayList<String> photos;

    @Override
    protected int getResId() {
        return R.layout.activity_add_shang_pu;
    }

    TextView inputtitle;
    EditText inputcontent;
    Button inputquxiao;
    Button inputqueding;
    View vie;
    View input;

    ImageAdapter adapter;
    ImageAdapter adapter2;
    ImageAdapter adapter3;

    List<String> neituimg = new ArrayList();
    List<String> huxingtuimg = new ArrayList();
    List<String> huanjingimg = new ArrayList();


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
                        .start(AddShangPuActivity.this, PhotoPicker.REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
//            if (data != null) {
//                photos =
//                        data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
//                neituimg.clear();
//                neituimg.addAll(photos);
//                neituimg.add("");
//                adapter.addData(neituimg);
//            }
//        }

        ArrayList<String> photos = new ArrayList<>();
        if (data != null) {
            photos =
                    data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
        }
        switch (requestCode) {
            case 105:
                jiaotong.setPhoto(photos);
                break;
        }
    }


    @Override
    protected void initView() {
        super.initView();
        setText(ttitle, "新增商铺");
        hide(subtitle);
        vie = View.inflate(AddShangPuActivity.this, R.layout.picker, null);

        // 初始化输入框的view
        input = View.inflate(AddShangPuActivity.this, R.layout.input_text, null);
        inputtitle = input.findViewById(R.id.title);
        inputcontent = input.findViewById(R.id.input);
        inputquxiao = input.findViewById(R.id.quxiao);
        inputqueding = input.findViewById(R.id.queding);

        adapter = new ImageAdapter(R.layout.image);
        adapter2 = new ImageAdapter(R.layout.image);
        adapter3 = new ImageAdapter(R.layout.image);
        shineitu.setAdapter(adapter);
        shineitu.setLayoutManager(new GridLayoutManager(this, 3));
        neituimg.add("");
        adapter.addData(neituimg);

//        huxingtu.setAdapter(adapter2);
//        huxingtu.setLayoutManager(new GridLayoutManager(this,3));
//        huxingtuimg.add("");
//        adapter2.addData(huxingtuimg);
//
//        huanjing.setAdapter(adapter3);
//        huanjing.setLayoutManager(new GridLayoutManager(this,3));
//        huanjingimg.add("");
        adapter3.addData(huanjingimg);
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().province(AddShangPuActivity.this, PROVINCE, false);
        CommonApi.getInstance().select(3, AddShangPuActivity.this, SELECT, false);
        jiaotong.REQUESTCODE = 105;
    }

    PopupWindow popupWindow;

    CityBean cityBean;
    CityBean xiaji;
    CityBean qu;
    CityBean jiedao;
    private int selectIndex;

//    private String getIndex(CityBean bean, String value) {
//        String id = "";
//        for (int i = 0; i < bean.getData().size(); i++) {
//            if (bean.getData().get(i).getName().equals(value)) {
//                id = bean.getData().get(i).getId();
//            }
//        }
//        return id;
//    }


    private void editLeiXing(TextView target, String title, int type) {
        selectIndex = -1;
        popupWindow = new PopupWindow(AddShangPuActivity.this);
        popupWindow.setContentView(vie);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        // 背景的处理
        WindowUtils.setBackgroundAlpha(AddShangPuActivity.this, 0.5f);//设置屏幕透明度
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
                        CommonApi.getInstance().xiaji(getIndex(cityBean, mOptionsItems.get(selectIndex)), AddShangPuActivity.this, XIAJI, false);
                    } else if (type == 7) {
                        CommonApi.getInstance().xiaji(getIndex(xiaji, mOptionsItems.get(selectIndex)), AddShangPuActivity.this, QU, false);
                    } else if (type == 8) {
                        CommonApi.getInstance().xiaji(getIndex(qu, mOptionsItems.get(selectIndex)), AddShangPuActivity.this, JIEDAO, false);

                    }
                }

            }
        });

        List<String> data = new ArrayList<>();
        switch (type) {
            case 1:
//                for (int i = 0; i < faBuSelectBean.getData().get房屋类型().size(); i++) {
//                    data.add(faBuSelectBean.getData().get房屋类型().get(i).getAttr_name());
//                }
                break;
            case 2:
//                for (int i = 0; i < faBuSelectBean.getData().get装修程度().size(); i++) {
//                    data.add(faBuSelectBean.getData().get装修程度().get(i).getAttr_name());
//                }
                break;
            case 3:
                for (int i = 0; i < faBuSelectBean.getData().get年代().size(); i++) {
                    data.add(faBuSelectBean.getData().get年代().get(i).getAttr_name());
                }
                break;
            case 4:
                for (int i = 0; i < faBuSelectBean.getData().get朝向().size(); i++) {
                    data.add(faBuSelectBean.getData().get朝向().get(i).getAttr_name());
                }
                break;
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
                WindowUtils.setBackgroundAlpha(AddShangPuActivity.this, 1.0f);
            }
        });
    }


//    @OnClick({R.id.back, R.id.ttitle, R.id.subtitle, R.id.mingcheng1, R.id.title, R.id.zhongliang1, R.id.shoujia, R.id.zhongliangwu, R.id.dianzhongliang, R.id.shifa1, R.id.mianji, R.id.mianjia, R.id.dianshifa, R.id.modi1, R.id.modi2, R.id.dianmudi, R.id.cheliang1, R.id.cheliang2, R.id.diancheliang, R.id.niamdai, R.id.chaoxiang, R.id.danyuan, R.id.cneg, R.id.fangjia1, R.id.fangjia, R.id.wuyefei, R.id.dizhi, R.id.dizhi2, R.id.dizhi3, R.id.dizhi4, R.id.lianxiren, R.id.dianhua, R.id.shineitu, R.id.fabu})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.back:
//                finish();
//
//                break;
//            case R.id.ttitle:
//                break;
//            case R.id.subtitle:
//                break;
//            case R.id.mingcheng1:
//                break;
//            case R.id.title:
//                break;
//            case R.id.zhongliang1:
//                break;
//            case R.id.shoujia:
//                break;
//            case R.id.zhongliangwu:
//                break;
//            case R.id.dianzhongliang:
//                break;
//            case R.id.shifa1:
//                break;
//            case R.id.mianji:
//                break;
//            case R.id.mianjia:
//                break;
//            case R.id.dianshifa:
//                break;
//            case R.id.modi1:
//                break;
//            case R.id.modi2:
//                break;
//            case R.id.dianmudi:
//                break;
//            case R.id.cheliang1:
//                break;
//            case R.id.cheliang2:
//                break;
//            case R.id.diancheliang:
//                break;
//            case R.id.niamdai:
//                break;
//            case R.id.chaoxiang:
//                break;
//            case R.id.danyuan:
//                break;
//            case R.id.cneg:
//                break;
//            case R.id.fangjia1:
//                break;
//            case R.id.fangjia:
//                break;
//            case R.id.wuyefei:
//                break;
//            case R.id.dizhi:
//                editLeiXing((TextView) view, "请输入朝向", 6);
//                break;
//            case R.id.dizhi2:
//                editLeiXing((TextView) view, "请输入朝向", 7);
//                break;
//            case R.id.dizhi3:
//                editLeiXing((TextView) view, "请输入朝向", 8);
//                break;
//            case R.id.dizhi4:
//                editLeiXing((TextView) view, "请输入朝向", 9);
//                break;
//            case R.id.lianxiren:
//                break;
//            case R.id.dianhua:
//                break;
//            case R.id.shineitu:
//                break;
//            case R.id.fabu:
////                if (checkEmpty(title, "请输入标题") &&
////                        checkEmpty(shoujia, "请输入售价") &&
////                        checkEmpty(mianji, "请输入面积") &&
////                        checkEmpty(danweifangjia, "请输入单位房价") &&
////                        checkEmpty(miaoshu, "请输入房源描述") &&
////                        checkArray(photos, "请上传室内图")&&
////                        checkEql(dizhi,"请输入省份","请输入省份")&&
////                        checkEql(dizhi2,"请输入市","请输入市")&&
////                        checkEql(dizhi3,"请输入区","请输入区")&&
////                        checkEmpty(lianxiren,"请输入联系人姓名")&&
////                        checkEmpty(dianhua,"请输入联系人电话")&&
////                        checkEmpty(xiaoqu,"请输入具体地址")&&
////                        checkEql(dizhi4,"请输入街道","请输入街道")) {
////                    handleshiNei();
////                }
//                break;
//        }
//    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
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
            case TIJIAO:
                toast(base.getMessage());
                break;
            case SELECT:
                faBuSelectBean = (FaBuSelectBean) base;
                break;
        }
    }

    FaBuSelectBean faBuSelectBean;



    PopupWindow popupWindow2;

    private void editLeiXingin(TextView target, String title, int type) {
        selectIndex = -1;
        popupWindow2 = new PopupWindow(AddShangPuActivity.this);
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

    @OnClick({R.id.zhuangtai, R.id.yafu, R.id.back, R.id.jiceng, R.id.gong, R.id.fangjia1, R.id.fangjia, R.id.wuyefei, R.id.dizhi, R.id.dizhi2, R.id.dizhi3, R.id.dizhi4, R.id.lianxiren, R.id.dianhua, R.id.shineitu, R.id.fabu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhuangtai:
                // editLeiXing((TextView) view, "请输入朝向", 4);
                //editLeiXingin((TextView) view, "请输入状态", 2);
                editLeiXing((TextView) view, "请输入年代", 3);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.yafu:
                // editLeiXing((TextView) view, "请输入朝向", 4);
                //editLeiXingin((TextView) view, "请输入押付", 2);
                editLeiXing((TextView) view, "请输入朝向", 4);
                break;
            case R.id.jiceng:
                break;
            case R.id.gong:
                break;
            case R.id.fangjia1:
                break;
            case R.id.fangjia:
                break;
            case R.id.wuyefei:
                break;
            case R.id.dizhi:
                editLeiXing((TextView) view, "请输入朝向", 6);
                break;
            case R.id.dizhi2:
                if(xiaji==null){
                    toast("请选择市");
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 7);
                break;
            case R.id.dizhi3:
                if(qu==null){
                    toast("请选择区");
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 8);
                break;
            case R.id.dizhi4:
                if(jiedao==null){
                    toast("请选择街道");
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 9);
                break;
            case R.id.lianxiren:
                break;
            case R.id.dianhua:
                break;
            case R.id.shineitu:
                break;
            case R.id.fabu:
                // mvvm 格式
                if (checkEmpty(title, "请输入标题") &&
                        checkEmpty(shoujia, "请输入售价") &&
                        checkEmpty(mianji, "请输入面积") &&
                       // checkEmpty(miankuan, "请输入面宽") &&
                        peizhiba.hasPhoto()&&
                        renqun.hasPhoto()&&
                        checkEql(zhuangtai, "年代", "请输入年代") &&
                        checkEql(yafu, "朝向", "请输入朝向") &&

                        checkEmpty(mingcheng, "请输入楼盘名称") &&


                        checkEmpty(jiceng, "请输入楼层") &&
                        checkEmpty(gong, "请输入楼层") &&

                        checkEmpty(cenggao, "请输入单位房价") &&
                        checkEmpty(wuyefei, "请输入物业费") &&
                        checkEql(dizhi, "请输入省份", "请输入省份") &&
                        checkEql(dizhi2, "请输入市", "请输入市") &&
                        checkEql(dizhi3, "请输入区", "请输入区") &&
                        checkEql(dizhi4, "请输入街道", "请输入街道")&&
                        checkEmpty(jutidizhi, "请输入具体地址") &&
//                        checkArray(photos, "请上传室内图") &&
                        checkEmpty(lianxiren, "请输入联系人姓名") &&
                        checkEmpty(dianhua, "请输入联系人电话")&&
                          checkEmpty(miaoshu, "请输入房源描述") &&
                        jiaotong.hasPhoto()
                        ) {
                    //handleshiNei();
                    jiaotong.upimg(AddShangPuActivity.this, JIAOTONG);
                }
                break;
        }
    }

    ImgBean imgBeannei;

    private void handleshiNei() {
        if (photos != null && photos.size() > 0) {
            List<File> data = new ArrayList<>();
            for (String item : photos) {
                data.add(FilesUtil.getSmallBitmap(AddShangPuActivity.this, item));
            }
            // CommonApi.getInstance().img(getToken(),neituimg,AddErShouActivity.this,NEITUIMG);

            OkGo.<String>post(NetWorkUrl.BASE + NetWorkUrl.IMG).params("token2", getToken())
                    .addFileParams("file[]", data).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    Log.i("ad", response.body());
                    try {
                        imgBeannei = new Gson().fromJson(response.body(), ImgBean.class);
                        submit();
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




    private void submit() {
        CommonApi.getInstance().fabu(
                getToken(),
                getString(title),
                7,
                getIndex(xiaji, dizhi2.getText().toString().trim()),
                getIndex(qu, dizhi3.getText().toString().trim()),
                getIndex(jiedao, dizhi4.getText().toString().trim()),
                getSpData("longitude"),
                getSpData("latitude"),
                dizhi.getText().toString().trim() + dizhi2.getText().toString().trim() +
                        dizhi3.getText().toString().trim() + dizhi4.getText().toString().trim(),
                "",
                getString(lianxiren),
                getString(dianhua),
                getString(cenggao),
                getString(wuyefei),
                "", "",
                getString(shoujia),
                getString(mianji),
                "", "",
                "",
                getString(jiceng),
                "", "",
                peizhiba.getPhoto(),
                renqun.getPhoto(),
                "",
                "",
                getString(miaoshu),
                "",
                jiaotong.getPhoto2(),
                "",
                "",
                AddShangPuActivity.this, TIJIAO);
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

    @Override
    public void success(ImgBean imgBean, int code) {
        switch (code){
            case JIAOTONG:
                submit();
                break;
        }
    }

    @Override
    public void onError(String msg, int code) {

    }
}
