package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
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
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CityBean;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.FaBuSelectBean;
import com.zhuye.ershoufang.bean.ImgBean;
import com.zhuye.ershoufang.bean.XiaoQuBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.common.CommonAddActivity;
import com.zhuye.ershoufang.utils.FilesUtil;
import com.zhuye.ershoufang.weidtet.MyInputView;
import com.zhuye.ershoufang.weidtet.MyLinTv2View;
import com.zhuye.ershoufang.weidtet.MySelectPhotoView;
import com.zhuye.ershoufang.weidtet.MySelectTvView;
import com.zhuye.ershoufang.weidtet.UpPhotoCallBack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class AddErShouActivity extends CommonAddActivity implements UpPhotoCallBack {

    private static final int TIJIAO = 200;
    private static final int SELECT = 201;
    private static final int PROVINCE = 202;
    private static final int XIAJI = 203;
    private static final int QU = 204;
    private static final int JIEDAO = 205;
    private static final int NEITUIMG = 206;
    private static final int SELECTADAPTER = 207;
    private static final int SELECTADAPTER3 = 208;
    private static final int XIAOQU = 2046;
    private static final int JIAOTONG = 2055;
    private static final int HUXINGTUT = 2056;
    private static final int HUANJINGTU = 2057;
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
    @BindView(R.id.xiaoqumingc)
    TextView xiaoqumingc;
    @BindView(R.id.fangwuleixing)
    TextView fangwuleixing;
    @BindView(R.id.zhuangxiuleixing)
    TextView zhuangxiuleixing;
    @BindView(R.id.niamdai)
    TextView niamdai;
    @BindView(R.id.jiceng)
    EditText jiceng;
    @BindView(R.id.gong)
    EditText gong;
    @BindView(R.id.danyuan)
    TextView danyuan;
    @BindView(R.id.cneg)
    TextView cneg;
    @BindView(R.id.shoufu2)
    TextView shoufu2;
    @BindView(R.id.shoufu)
    RelativeLayout shoufu;
    @BindView(R.id.fangjia1)
    TextView fangjia1;
    @BindView(R.id.fangjia)
    RelativeLayout fangjia;
    @BindView(R.id.yuegong1)
    TextView yuegong1;
    @BindView(R.id.yuegong)
    RelativeLayout yuegong;
    @BindView(R.id.chaoxiang1)
    TextView chaoxiang1;
    @BindView(R.id.chaoxiang)
    RelativeLayout chaoxiang;
    @BindView(R.id.modi1)
    TextView modi1;
    @BindView(R.id.modi2)
    EditText modi2;
    @BindView(R.id.youshi)
    RelativeLayout youshi;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.dizhi2)
    TextView dizhi2;
    @BindView(R.id.dizhi3)
    TextView dizhi3;
    @BindView(R.id.dizhi4)
    TextView dizhi4;
    @BindView(R.id.maidian)
    EditText maidian;
    @BindView(R.id.xintai)
    EditText xintai;
    @BindView(R.id.lianxiren)
    EditText lianxiren;
    @BindView(R.id.dianhua)
    EditText dianhua;
    @BindView(R.id.cheliang1)
    TextView cheliang1;
    @BindView(R.id.cheliang2)
    EditText cheliang2;
    @BindView(R.id.diancheliang)
    RelativeLayout diancheliang;
    @BindView(R.id.neitu)
    RecyclerView neitu;
    @BindView(R.id.huxingtu)
    RecyclerView huxingtu;
    @BindView(R.id.huanjing)
    RecyclerView huanjing;
    @BindView(R.id.fabu)
    Button fabu;
    @BindView(R.id.weituo)
    Button weituo;
    @BindView(R.id.shoufut)
    MyInputView shoufut;
    @BindView(R.id.danweifangjiat)
    MyInputView danweifangjiat;
    @BindView(R.id.yuegongt)
    MyInputView yuegongt;
//    @BindView(R.id.fangyuanyoushi)
//    MySelectTvView fangyuanyoushi;
    @BindView(R.id.hexinmaidt)
    MyLinTv2View hexinmaidt;
    @BindView(R.id.yezhuxintait)
    MyLinTv2View yezhuxintait;
    @BindView(R.id.shineitut)
    MySelectPhotoView shineitut;
    @BindView(R.id.huxingtut)
    MySelectPhotoView huxingtut;
    @BindView(R.id.huanjingtu)
    MySelectPhotoView huanjingtu;
    @BindView(R.id.fangyuanyoushia)
    MySelectTvView fangyuanyoushia;


    @Override
    protected int getResId() {
        return R.layout.activity_add_er_shou;
    }

    View vie;
    ImageAdapter adapter;
    ImageAdapter adapter2;
    ImageAdapter adapter3;

    List<String> neituimg = new ArrayList();
    List<String> huxingtuimg = new ArrayList();
    List<String> huanjingimg = new ArrayList();

    View input;
    TextView inputtitle;
    EditText inputcontent;
    Button inputquxiao;
    Button inputqueding;

    @Override
    protected void initView() {
        super.initView();
        setText(ttitle, "委托房源");
        hide(subtitle);
        vie = View.inflate(AddErShouActivity.this, R.layout.picker, null);
        // 初始化输入框的view
        input = View.inflate(AddErShouActivity.this, R.layout.input_text, null);
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

        huxingtu.setAdapter(adapter2);
        huxingtu.setLayoutManager(new GridLayoutManager(this, 3));
        huxingtuimg.add("");
        adapter2.addData(huxingtuimg);

        huanjing.setAdapter(adapter3);
        huanjing.setLayoutManager(new GridLayoutManager(this, 3));
        huanjingimg.add("");
        adapter3.addData(huanjingimg);
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
                        .start(AddErShouActivity.this, PhotoPicker.REQUEST_CODE);
            }
        });

        adapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                PhotoPicker.builder()
                        .setPhotoCount(6)
                        .setShowCamera(true)
                        .setShowGif(true)
                        .setPreviewEnabled(false)
                        .start(AddErShouActivity.this, SELECTADAPTER);
            }
        });

        adapter3.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                PhotoPicker.builder()
                        .setPhotoCount(6)
                        .setShowCamera(true)
                        .setShowGif(true)
                        .setPreviewEnabled(false)
                        .start(AddErShouActivity.this, SELECTADAPTER3);
            }
        });
    }

    ArrayList<String> photos;
    ArrayList<String> photos2;
    ArrayList<String> photos3;

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
//        } else if (resultCode == RESULT_OK && requestCode == SELECTADAPTER) {
//            if (data != null) {
//                photos2 =
//                        data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
//                huxingtuimg.clear();
//                huxingtuimg.addAll(photos2);
//                huxingtuimg.add("");
//                adapter2.addData(huxingtuimg);
//            }
//        } else if (resultCode == RESULT_OK && requestCode == SELECTADAPTER3) {
//            if (data != null) {
//                photos3 =
//                        data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
//                huanjingimg.clear();
//                huanjingimg.addAll(photos3);
//                huanjingimg.add("");
//                adapter3.addData(huanjingimg);
//
//            }
//        }
        ArrayList<String> photos = new ArrayList<>();
        if (data != null) {
            photos =
                    data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
        }
        switch (requestCode) {
            case 1000:
                shineitut.setPhoto(photos);
                break;
            case 1001:
                huxingtut.setPhoto(photos);
                break;
            case 1002:
                huanjingtu.setPhoto(photos);
                break;
        }
    }

    ImgBean imgBeannei;
    ImgBean imgBeanhuxing;
    ImgBean imgBeanhuanjing;

    @OnClick({R.id.xiaoqumingc, R.id.dizhi4, R.id.dizhi2, R.id.dizhi3, R.id.chaoxiang1, R.id.yuegong1, R.id.fangjia1, R.id.shoufu2, R.id.niamdai, R.id.zhuangxiuleixing, R.id.fangwuleixing, R.id.back, R.id.modi1, R.id.modi2, R.id.youshi, R.id.dizhi, R.id.maidian, R.id.xintai, R.id.fabu, R.id.weituo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xiaoqumingc:
                editLeiXing((TextView) view, "请输入朝向", 11);
                break;
            case R.id.dizhi:
                if(cityBean==null){
                    CommonApi.getInstance().province(AddErShouActivity.this, PROVINCE, false);
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
            case R.id.chaoxiang1:
                editLeiXing((TextView) view, "请输入朝向", 4);
                break;
            case R.id.yuegong1:
                editLeiXingin((TextView) view, "请输入月供", 2);
                break;
            case R.id.fangjia1:
                editLeiXingin((TextView) view, "请输入房价", 3);
                break;
            case R.id.shoufu2:
                editLeiXingin((TextView) view, "请输入首付款", 4);
                break;
//            case R.id.danyuan:
//                editLeiXingin((TextView) view, "请输入楼层单元", 5);
//                break;
            case R.id.niamdai:
                editLeiXing((TextView) view, "请输入年代", 3);
                break;
            case R.id.zhuangxiuleixing:
                editLeiXing((TextView) view, "请输入装修类型", 2);
                break;
            case R.id.fangwuleixing:
                editLeiXing((TextView) view, "请输入房屋类型", 1);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.modi1:
                break;
            case R.id.modi2:
                break;
            case R.id.youshi:
                break;
            case R.id.maidian:
                break;
            case R.id.xintai:
                break;
            case R.id.fabu:

                mSearch.geocode(new GeoCodeOption()
                        .city(dizhi2.getText().toString())
                        .address(dizhi2.getText().toString()+dizhi3.getText().toString()+dizhi4.getText().toString()));
//                       String a=  getString(xiaoqu);
//                        String b =  getIndex(xiaoquadata, dizhi3.getText().toString().trim());

                //  handleshiNei();
                if (checkEmpty(title, "请输入标题") &&
                        checkEmpty(shoujia, "请输入价格") &&
                        checkEmpty(mianji, "请输入面积") &&
                        checkEql(xiaoqumingc, "小区名称", "请输入小区名称") &&
                        checkEql(fangwuleixing, "房屋类型", "请输入房屋类型") &&
                        checkEql(zhuangxiuleixing, "装修类型", "请输入装修类型") &&
                        checkEql(niamdai, "年代", "请输入年代") &&
                        checkEql(chaoxiang1, "朝向", "请输入朝向") &&
                        checkEmpty(jiceng, "请输入楼层") &&
                        checkEmpty(gong, "请输入总楼层") &&
                        shoufut.getString() &&
                        danweifangjiat.getString() &&
                        yuegongt.getString() &&

                        checkEql(dizhi, "请输入省份", "请输入省份") &&
                        checkEql(dizhi2, "请输入市", "请输入市") &&
                        checkEql(dizhi3, "请输入区", "请输入区") &&
                        checkEql(dizhi4, "请输入街道", "请输入街道") &&
                        checkEmpty(xiaoqu, "请输入详细地址") &&
                        fangyuanyoushia.hasPhoto() &&
                        hexinmaidt.getString() &&
                        yezhuxintait.getString() &&
                        checkEmpty(lianxiren, "请输入联系人姓名") &&
                        checkEmpty(dianhua, "请输入联系人电话") &&

//                        checkEql(shoufu2, "万元", "请输入首付价格") &&
//                        checkEql(fangjia1, "万元", "请输入单位价格") &&
//                        checkEql(yuegong1, "万元", "请输入月供金额") &&
                        shineitut.hasPhoto() &&
                        huxingtut.hasPhoto() &&
                        huanjingtu.hasPhoto()
                        ) {
                    //   handleshiNei();
                    shineitut.upimg(AddErShouActivity.this, JIAOTONG);
                }
                break;
            case R.id.weituo:
                break;
        }
    }

    private void handleshiNei() {
        if (photos != null && photos.size() > 0) {
            List<File> data = new ArrayList<>();
            for (String item : photos) {
                data.add(FilesUtil.getSmallBitmap(AddErShouActivity.this, item));
            }
            // CommonApi.getInstance().img(getToken(),neituimg,AddErShouActivity.this,NEITUIMG);

            OkGo.<String>post(NetWorkUrl.BASE + NetWorkUrl.IMG).params("token2", getToken())
                    .addFileParams("file[]", data).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    Log.i("ad", response.body());
                    try {
                        imgBeannei = new Gson().fromJson(response.body(), ImgBean.class);
                        handlehuxing();
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

    private void handlehuxing() {
        if (photos2 != null && photos2.size() > 0) {
            List<File> data = new ArrayList<>();
            for (String item : photos2) {
                data.add(FilesUtil.getSmallBitmap(AddErShouActivity.this, item));
            }
            // CommonApi.getInstance().img(getToken(),neituimg,AddErShouActivity.this,NEITUIMG);

            OkGo.<String>post(NetWorkUrl.BASE + NetWorkUrl.IMG).params("token2", getToken())
                    .addFileParams("file[]", data).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    // Log.i("ad",response.body());
                    imgBeanhuxing = new Gson().fromJson(response.body(), ImgBean.class);
                    handlehuanjing();
                }

                @Override
                public void onError(Response<String> response) {
                    super.onError(response);
                    // Log.i("ad",response.body());
                }
            });
        }
    }

    private void handlehuanjing() {
        if (photos3 != null && photos3.size() > 0) {
            List<File> data = new ArrayList<>();
            for (String item : photos3) {
                data.add(FilesUtil.getSmallBitmap(AddErShouActivity.this, item));
            }
            // CommonApi.getInstance().img(getToken(),neituimg,AddErShouActivity.this,NEITUIMG);

            OkGo.<String>post(NetWorkUrl.BASE + NetWorkUrl.IMG).params("token2", getToken())
                    .addFileParams("file[]", data).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    // Log.i("ad",response.body());
                    imgBeanhuanjing = new Gson().fromJson(response.body(), ImgBean.class);
                    //提交了两次
                    submit();
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
//        String token,  String title,
//        int cate_id,  String city_id,
//                String area_id,  String business_id,
//                String lng,  String lat,
//                String addr,  String xiaoqu,
//                String contact, String mobile,
//                String text1,  String text2,
//                String text3,  String text4,
//                String num1, String num2,
//                String num3, String num4,
//                String select1, String select2,
//                String select3,  String select4,
//                String select5,  String select6,
//                String fj_select5,  String fj_select6,
//                String detail,  String dd,
//                String photo,  String ph,
//                String pph
//        OkGo.<String>post(NetWorkUrl.BASE+NetWorkUrl.FABU)
//                .params("token",getToken())
//                .params("title", getString(title))
//                .params("cate_id",3)
//                .params("city_id",getIndex(xiaji, dizhi2.getText().toString().trim()))
//                .params("area_id",getIndex(jiedao, dizhi4.getText().toString().trim()))
//                .params("business_id",getIndex(xiaji, dizhi2.getText().toString().trim()))
//                .params("lng",getSpData("longitude"))
//                .params("lat",getSpData("latitude"))
//                .params("addr",dizhi.getText().toString().trim() + dizhi2.getText().toString().trim() +
//                        dizhi3.getText().toString().trim() + dizhi4.getText().toString().trim())
//                .params("xiaoqu",getString(xiaoqu))
//                .params("contact",getString(lianxiren))
//                .params("mobile",getString(dianhua))
//                .params("text1",getIndex(xiaji, ""))
//                .params("text2",getIndex(xiaji, ""))
//                .params("text3",getIndex(xiaji, ""))
//                .params("text4",getIndex(xiaji, ""))
//                .params("num1",getIndex(xiaji, ""))
//                .params("num2",getIndex(xiaji, ""))
//                .params("num3",getIndex(xiaji, ""))
//                .params("num4",getIndex(xiaji, ""))
//                .params("select1",getIndex(xiaji, ""))
//                .params("select2",getIndex(xiaji, ""))
//                .params("select3",getIndex(xiaji, ""))
//                .params("select4",getIndex(xiaji, ""))
//                .params("select5",getIndex(xiaji, ""))
//                .params("select6",getIndex(xiaji, ""))
//                .params("fj_select5",getIndex(xiaji, ""))
//                .params("fj_select6",getIndex(xiaji, ""))
//                .params("detail",getIndex(xiaji, getString(maidian)))
//                .params("dd",getIndex(xiaji, getString(xintai)))
//                .params("photo",arraytoString(imgBeannei.getData().getPhoto()))
//                .params("ph",getIndex(xiaji,arraytoString(imgBeanhuxing.getData().getPhoto())))
//                .params("pph",  arraytoString(imgBeanhuanjing.getData().getPhoto()))
//              .execute(new StringCallback() {
//                  @Override
//                  public void onSuccess(Response<String> response) {
//                      Log.i("ad",response.body());
//                  }
//
//                  @Override
//                  public void onError(Response<String> response) {
//                      super.onError(response);
//                      Log.i("ad",response.body());
//                  }
//              });

//        CommonApi.getInstance().fabu(
//                SharedPreferencesUtil.getInstance().getString("token2"), getString(title),
//                3, getIndex(xiaji, dizhi2.getText().toString().trim()),
//                getIndex(qu, dizhi3.getText().toString().trim()),
//                getIndex(jiedao, dizhi4.getText().toString().trim()), getSpData("longitude"),
//                getSpData("latitude"),
//                dizhi.getText().toString().trim() + dizhi2.getText().toString().trim() +
//                        dizhi3.getText().toString().trim() + dizhi4.getText().toString().trim(),
//                getString(xiaoqu),
//                getString(lianxiren), getString(dianhua),
//                "", "", "", "", "",
//                "", "", "",
//                "", "", "", "",
//                "", "", "",
//                "", getIndex(xiaji, getString(maidian)), getIndex(xiaji, getString(xintai)),
//                arraytoString(imgBeannei.getData().getPhoto()),
//                arraytoString(imgBeanhuxing.getData().getPhoto()),
//                arraytoString(imgBeanhuanjing.getData().getPhoto()),
//                AddErShouActivity.this, TIJIAO);
//
        CommonApi.getInstance().esfabu(
                getToken(),
                getString(title),
                getString(xiaoqu),
                getIndex(xiaoquadata, xiaoqumingc.getText().toString().trim()),
                getString(lianxiren)
                , getString(dianhua),
                danweifangjiat.getContent(),
                getString(jiceng)
                , getString(gong),
                "",
                getString(shoujia),
                getString(mianji),
                shoufut.getContent(),
                yuegongt.getContent(),

                getIndex(faBuSelectBean, 1, getString(fangwuleixing)),
                getIndex(faBuSelectBean, 2, getString(chaoxiang1)),
                getIndex(faBuSelectBean, 3, getString(zhuangxiuleixing)),
                getIndex(faBuSelectBean, 4, getString(niamdai)),

                fangyuanyoushia.getPhoto(), "",
                getString(maidian),
                getString(xintai),
                shineitut.getPhoto2(),
                huxingtut.getPhoto2(),
                huanjingtu.getPhoto2(),
                AddErShouActivity.this, TIJIAO);
    }

    public String getIndex(FaBuSelectBean bean, int pos, String value) {
        String id = "";
        switch (pos) {
            case 1:
                for (int i = 0; i < bean.getData().get房屋类型().size(); i++) {
                    if (bean.getData().get房屋类型().get(i).getAttr_name().equals(value)) {
                        id = bean.getData().get房屋类型().get(i).getAttr_id();
                    }
                }
                break;
            case 2:
                for (int i = 0; i < bean.getData().get朝向().size(); i++) {
                    if (bean.getData().get朝向().get(i).getAttr_name().equals(value)) {
                        id = bean.getData().get朝向().get(i).getAttr_id();
                    }
                }
                break;
            case 3:
                for (int i = 0; i < bean.getData().get装修程度().size(); i++) {
                    if (bean.getData().get装修程度().get(i).getAttr_name().equals(value)) {
                        id = bean.getData().get装修程度().get(i).getAttr_id();
                    }
                }
                break;
            case 4:
                for (int i = 0; i < bean.getData().get年代().size(); i++) {
                    if (bean.getData().get年代().get(i).getAttr_name().equals(value)) {
                        id = bean.getData().get年代().get(i).getAttr_id();
                    }
                }
                break;
        }

        return id;
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

    PopupWindow popupWindow;
    PopupWindow popupWindow2;

    private int selectIndex = -1;

    private void editLeiXingin(TextView target, String title, int type) {
        selectIndex = -1;
        popupWindow2 = new PopupWindow(AddErShouActivity.this);
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


    private void editLeiXing(TextView target, String title, int type) {
        selectIndex = -1;
        popupWindow = new PopupWindow(AddErShouActivity.this);
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
                        CommonApi.getInstance().xiaji(getIndex(cityBean, mOptionsItems.get(selectIndex)), AddErShouActivity.this, XIAJI, false);
                    } else if (type == 7) {
                        CommonApi.getInstance().xiaji(getIndex(xiaji, mOptionsItems.get(selectIndex)), AddErShouActivity.this, QU, false);
                    } else if (type == 8) {
                        CommonApi.getInstance().xiaji(getIndex(qu, mOptionsItems.get(selectIndex)), AddErShouActivity.this, JIEDAO, false);
                    }
                }

            }
        });

        List<String> data = new ArrayList<>();
        switch (type) {
            case 1:
                for (int i = 0; i < faBuSelectBean.getData().get房屋类型().size(); i++) {
                    data.add(faBuSelectBean.getData().get房屋类型().get(i).getAttr_name());
                }
                break;
            case 2:
                for (int i = 0; i < faBuSelectBean.getData().get装修程度().size(); i++) {
                    data.add(faBuSelectBean.getData().get装修程度().get(i).getAttr_name());
                }
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

            case 11:
                for (int i = 0; i < xiaoquadata.getData().size(); i++) {
                    data.add(xiaoquadata.getData().get(i).getXiaoqu());
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
                setBackgroundAlpha(1.0f);
            }
        });
    }

    public String getIndex(CommonListBean<XiaoQuBean> T, String value) {
        String id = "";
        for (int i = 0; i < T.getData().size(); i++) {
            if (T.getData().get(i).getXiaoqu().equals(value)) {
                id = T.getData().get(i).getId();
            }
        }
        return id;
    }

//    public <T> String getIndex(CommonListBean<T> T, String value) {
//        String id = "";
//        for (int i = 0; i < T.getData().size(); i++) {
//            if (T.getData().get(i)..equals(value)) {
//                id = bean.getData().get(i).getId();
//            }
//        }
//        return id;
//    }


    public String getIndex(CityBean bean, String value) {
        String id = "";
        for (int i = 0; i < bean.getData().size(); i++) {
            if (bean.getData().get(i).getName().equals(value)) {
                id = bean.getData().get(i).getId();
            }
        }
        return id;
    }
//    private void editLeiXing(TextView target,String title) {
//        popupWindow = new PopupWindow(AddErShouActivity.this);
//        popupWindow.setContentView(vie);
//        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
//        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
//        popupWindow.setOutsideTouchable(true);
//        popupWindow.setFocusable(true);
//
//        TextView titl = vie.findViewById(R.id.title);
//
//        EditText et = vie.findViewWithTag(R.id.input);
//        Button quixa = vie.findViewById(R.id.quxiao);
//        Button queding = vie.findViewById(R.id.queding);
//
//
//        quixa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(popupWindow.isShowing()){
//                    popupWindow.dismiss();
//                }
//            }
//        });
//
//        queding.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(checkEmpty(et,"请输入标题")){
//                    if(popupWindow.isShowing()){
//                        popupWindow.dismiss();
//                    }
//                    target.setText(et.getText().toString().trim());
//                }
//            }
//        });
//
//        titl.setText(title);
//
//
//        // 背景的处理
//        setBackgroundAlpha(0.5f);//设置屏幕透明度
//
//
////        vie.findViewById(R.id.gongyechang).setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                if (popupWindow.isShowing()) {
////                    popupWindow.dismiss();
////                }
////                start(AddGongChangActivity.class);
////            }
////        });
//        //popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
//        popupWindow.showAtLocation(vie, Gravity.CENTER, 0, 0);
//        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
//        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                // popupWindow隐藏时恢复屏幕正常透明度
//                setBackgroundAlpha(1.0f);
//            }
//        });
//    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha 屏幕透明度0.0-1.0 1表示完全不透明
     */
    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        getWindow().setAttributes(lp);
    }

    FaBuSelectBean faBuSelectBean;
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

            case SELECT:
                faBuSelectBean = (FaBuSelectBean) base;
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

            case XIAOQU:
                xiaoquadata = (CommonListBean<XiaoQuBean>) base;

                break;
        }
    }

    CommonListBean<XiaoQuBean> xiaoquadata;

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().select(3, AddErShouActivity.this, SELECT, false);
        CommonApi.getInstance().province(AddErShouActivity.this, PROVINCE, false);
        CommonApi.getInstance().xiaoqu(AddErShouActivity.this, XIAOQU, false);
        shineitut.REQUESTCODE = 1000;
        huxingtut.REQUESTCODE = 1001;
        huanjingtu.REQUESTCODE = 1002;
    }


    @Override
    public void success(ImgBean imgBean, int code) {
        switch (code) {
            case JIAOTONG:
                huxingtut.upimg(AddErShouActivity.this, HUXINGTUT);
                break;
            case HUXINGTUT:
                huanjingtu.upimg(AddErShouActivity.this, HUANJINGTU);
                break;
            case HUANJINGTU:
                submit();
                break;
        }
    }

    @Override
    public void onError(String msg, int code) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
