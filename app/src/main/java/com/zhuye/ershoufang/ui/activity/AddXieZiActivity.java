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

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
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
import com.zhuye.ershoufang.bean.ImgBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.utils.FilesUtil;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;
import com.zhuye.ershoufang.utils.WindowUtils;
import com.zhuye.ershoufang.weidtet.MySelectPhotoView;
import com.zhuye.ershoufang.weidtet.UpPhotoCallBack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class AddXieZiActivity extends BaseActivity  implements UpPhotoCallBack {


    private static final int PROVINCE = 300;
    private static final int XIAJI = 301;
    private static final int QU = 302;
    private static final int JIEDAO = 303;
    private static final int TIJIAO = 305;
    private static final int JIAOTONG = 366;
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
    @BindView(R.id.xiaoqu)
    EditText xiaoqu;
    @BindView(R.id.fangwuleixing)
    TextView fangwuleixing;
    @BindView(R.id.fangjia1)
    TextView fangjia1;
    @BindView(R.id.fangjia)
    RelativeLayout fangjia;
    @BindView(R.id.yuegong1)
    TextView yuegong1;
    @BindView(R.id.yuegong)
    RelativeLayout yuegong;
    @BindView(R.id.maidian)
    EditText maidian;
    @BindView(R.id.xintai)
    EditText xintai;
    @BindView(R.id.cheliang1)
    TextView cheliang1;
    @BindView(R.id.cheliang2)
    EditText cheliang2;
    @BindView(R.id.diancheliang)
    RelativeLayout diancheliang;
    @BindView(R.id.neitu)
    RecyclerView neitu;
    @BindView(R.id.fabu)
    Button fabu;
    @BindView(R.id.weituo)
    Button weituo;
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
    @BindView(R.id.jiaotong)
    MySelectPhotoView jiaotong;
    private ArrayList<String> photos;

    @Override
    protected int getResId() {
        return R.layout.activity_add_xie_zi;
    }

    PopupWindow popupWindow;

    CityBean cityBean;
    CityBean xiaji;
    CityBean qu;
    CityBean jiedao;

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
        }
    }

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
        popupWindow = new PopupWindow(AddXieZiActivity.this);
        popupWindow.setContentView(vie);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        // 背景的处理
        WindowUtils.setBackgroundAlpha(AddXieZiActivity.this, 0.5f);//设置屏幕透明度
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
                        CommonApi.getInstance().xiaji(getIndex(cityBean, mOptionsItems.get(selectIndex)), AddXieZiActivity.this, XIAJI, false);
                    } else if (type == 7) {
                        CommonApi.getInstance().xiaji(getIndex(xiaji, mOptionsItems.get(selectIndex)), AddXieZiActivity.this, QU, false);
                    } else if (type == 8) {
                        CommonApi.getInstance().xiaji(getIndex(qu, mOptionsItems.get(selectIndex)), AddXieZiActivity.this, JIEDAO, false);

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
//                for (int i = 0; i < faBuSelectBean.getData().get年代().size(); i++) {
//                    data.add(faBuSelectBean.getData().get年代().get(i).getAttr_name());
//                }
                break;
            case 4:
//                for (int i = 0; i < faBuSelectBean.getData().get朝向().size(); i++) {
//                    data.add(faBuSelectBean.getData().get朝向().get(i).getAttr_name());
//                }
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
                WindowUtils.setBackgroundAlpha(AddXieZiActivity.this, 1.0f);
            }
        });
    }

    @OnClick({R.id.dizhi, R.id.dizhi2, R.id.dizhi3, R.id.dizhi4, R.id.back, R.id.ttitle, R.id.subtitle, R.id.mingcheng1, R.id.title, R.id.dianhuowu, R.id.zhongliang1, R.id.shoujia, R.id.zhongliangwu, R.id.dianzhongliang, R.id.shifa1, R.id.mianji, R.id.mianjia, R.id.dianshifa, R.id.xiaoqu, R.id.fangwuleixing, R.id.fangjia1, R.id.fangjia, R.id.yuegong1, R.id.yuegong, R.id.maidian, R.id.xintai, R.id.cheliang1, R.id.cheliang2, R.id.diancheliang, R.id.neitu, R.id.fabu, R.id.weituo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dizhi:
                editLeiXing((TextView) view, "请输入朝向", 6);
                break;
            case R.id.dizhi2:
                if(xiaji==null){
                    toast("请选择省");
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 7);
                break;
            case R.id.dizhi3:
                if(qu==null){
                    toast("请选择省");
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 8);
                break;
            case R.id.dizhi4:
                if(jiedao==null){
                    toast("请选择省");
                    return;
                }
                editLeiXing((TextView) view, "请输入朝向", 9);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.ttitle:
                break;
            case R.id.subtitle:
                break;
            case R.id.mingcheng1:
                break;
            case R.id.title:
                break;
            case R.id.dianhuowu:
                break;
            case R.id.zhongliang1:
                break;
            case R.id.shoujia:
                break;
            case R.id.zhongliangwu:
                break;
            case R.id.dianzhongliang:
                break;
            case R.id.shifa1:
                break;
            case R.id.mianji:
                break;
            case R.id.mianjia:
                break;
            case R.id.dianshifa:
                break;
            case R.id.xiaoqu:
                break;
            case R.id.fangwuleixing:
                editLeiXingin((TextView) view, "请输入月供", 2);
                break;
            case R.id.fangjia1:
                editLeiXingin((TextView) view, "请输入房价", 2);
                break;
            case R.id.fangjia:
                break;
            case R.id.yuegong1:
                editLeiXingin((TextView) view, "请输入物业费", 2);
                break;
            case R.id.yuegong:
                break;
            case R.id.maidian:
                break;
            case R.id.xintai:
                break;
            case R.id.cheliang1:
                break;
            case R.id.cheliang2:
                break;
            case R.id.diancheliang:
                break;
            case R.id.neitu:
                break;
            case R.id.fabu:
                mSearch.geocode(new GeoCodeOption()
                        .city(dizhi2.getText().toString().trim())
                        .address(dizhi3.getText().toString().trim()+dizhi4.getText().toString().trim()));

                if (checkEmpty(title, "请输入标题") &&
                        checkEmpty(shoujia, "请输入售价") &&
                        checkEmpty(mianji, "请输入面积") &&
                        checkEmpty(xiaoqu, "请输入楼盘名称") &&
                        checkEql(fangwuleixing, "底层", "请输入楼层") &&
                        checkEql(fangjia1, "万元", "请输入房价") &&
                        checkEql(yuegong1, "万元", "请输入物业费") &&
                        checkEmpty(maidian, "请输入具体地址") &&
                        checkEmpty(xintai, "请输入房源描述") &&
                        //checkArray(photos, "请上传室内图") &&
                        jiaotong.hasPhoto()&&
                        checkEql(dizhi, "请输入省份", "请输入省份") &&
                        checkEql(dizhi2, "请输入市", "请输入市") &&
                        checkEql(dizhi3, "请输入区", "请输入区") &&
                        checkEmpty(lianxiren, "请输入联系人姓名") &&
                        checkEmpty(dianhua, "请输入联系人电话") &&
                        checkEql(dizhi4, "请输入街道", "请输入街道")) {
                    //checkArray(photos,"请上传室内图")&&
                   // handleshiNei();

                    jiaotong.upimg(AddXieZiActivity.this, JIAOTONG);
                }
                break;
            case R.id.weituo:
                break;
        }
    }

    ImgBean imgBeannei;

    private void handleshiNei() {
        if (photos != null && photos.size() > 0) {
            List<File> data = new ArrayList<>();
            for (String item : photos) {
                data.add(FilesUtil.getSmallBitmap(AddXieZiActivity.this, item));
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
        CommonApi.getInstance().fabu(
                SharedPreferencesUtil.getInstance().getString("token2"),
                getString(title),
                6,
                getIndex(xiaji, dizhi2.getText().toString().trim()),
                getIndex(qu, dizhi3.getText().toString().trim()),
                getIndex(jiedao, dizhi4.getText().toString().trim()),
                getSpData("longitude"),
                getSpData("latitude"),
                dizhi.getText().toString().trim() + dizhi2.getText().toString().trim() +
                        dizhi3.getText().toString().trim() + dizhi4.getText().toString().trim(),
                getString(xiaoqu),
                getString(lianxiren), getString(dianhua),
                getString(xiaoqu),
                "",
                "", "",
                getString(shoujia),
                getString(mianji),
                getString(yuegong1),
                getString(fangjia1),
                getString(fangwuleixing),
                "",
                "",
                "",
                "",
                "",
                "",
                "", getIndex(xiaji, getString(maidian)), getIndex(xiaji, getString(xintai)),
//                arraytoString(imgBeannei.getData().getPhoto()),
                jiaotong.getPhoto2(),
                "",
                "",
                AddXieZiActivity.this, TIJIAO);
    }

    PopupWindow popupWindow2;

    private int selectIndex;

    private void editLeiXingin(TextView target, String title, int type) {
        selectIndex = -1;
        popupWindow2 = new PopupWindow(AddXieZiActivity.this);
        popupWindow2.setContentView(input);
        popupWindow2.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow2.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.setFocusable(true);

        // 背景的处理
        WindowUtils.setBackgroundAlpha(AddXieZiActivity.this, 0.5f);//设置屏幕透明度
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
                WindowUtils.setBackgroundAlpha(AddXieZiActivity.this, 1.0f);
            }
        });
    }

    View vie;
    ImageAdapter adapter;
    ImageAdapter adapter2;
    ImageAdapter adapter3;

    List<String> neituimg = new ArrayList();


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
                        .start(AddXieZiActivity.this, PhotoPicker.REQUEST_CODE);
            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
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
//    }

    View input;
    TextView inputtitle;
    EditText inputcontent;
    Button inputquxiao;
    Button inputqueding;

    @Override
    protected void initView() {
        super.initView();
        setText(ttitle, "新增写字楼");
        hide(subtitle);
        vie = View.inflate(AddXieZiActivity.this, R.layout.picker, null);

        // 初始化输入框的view
        input = View.inflate(AddXieZiActivity.this, R.layout.input_text, null);
        inputtitle = input.findViewById(R.id.title);
        inputcontent = input.findViewById(R.id.input);
        inputquxiao = input.findViewById(R.id.quxiao);
        inputqueding = input.findViewById(R.id.queding);

        adapter = new ImageAdapter(R.layout.image);
        adapter2 = new ImageAdapter(R.layout.image);
        adapter3 = new ImageAdapter(R.layout.image);
        neitu.setAdapter(adapter);
        neitu.setLayoutManager(new GridLayoutManager(this, 3));
        neituimg.add("");
        adapter.addData(neituimg);

    }

    GeoCoder mSearch;
    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().province(AddXieZiActivity.this, PROVINCE, false);
        jiaotong.REQUESTCODE = 105;
        mSearch = GeoCoder.newInstance();
        mSearch.setOnGetGeoCodeResultListener(listener);
    }

    OnGetGeoCoderResultListener listener = new OnGetGeoCoderResultListener() {
        public void onGetGeoCodeResult(GeoCodeResult result) {

            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有检索到结果
            }
            GeoCodeResult result1 = result;
            Log.i("as",result1.getLocation().longitude+"");

            //获取地理编码结果
        }

        @Override
        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {
            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                //没有找到检索结果
            }

            //获取反向地理编码结果
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearch.destroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("asd", requestCode + "");
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
    public void success(ImgBean imgBean, int code) {
        switch (code){
            case JIAOTONG:
                tijiao();
                break;
        }
    }

    @Override
    public void onError(String msg, int code) {

    }
}
