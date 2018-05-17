package com.zhuye.ershoufang.weidtet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
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
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.ImgBean;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.utils.DensityUtil;
import com.zhuye.ershoufang.utils.FilesUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class MySelectTvView extends LinearLayout {
    public int REQUESTCODE = 100 ;

    public MySelectTvView(Context context) {
        this(context,null);
    }

    public MySelectTvView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    private Context context;
    TextView title;
    RecyclerView recyclerView;
    ImageView add;
    ImageView add2;
    TextView addname;
    TvAdapter2 adapter2;
    LinearLayout containers;
    String addna;
    private int linecount = 4;
    public MySelectTvView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MySelectPhotoView);

        this.context = context;
        int resid =  typedArray.getResourceId(R.styleable.MySelectPhotoView_resids,0);
        String titl = typedArray.getString(R.styleable.MySelectPhotoView_title);
        addna  = typedArray.getString(R.styleable.MySelectPhotoView_addname);
        typedArray.recycle();

        resid = resid==0 ? R.layout.selecttv:resid;
        View view = LayoutInflater.from(context).inflate(resid,null);
        title = view.findViewById(R.id.title);
        recyclerView = view.findViewById(R.id.photocontainer);
        add2 = view.findViewById(R.id.add2);
        addname = view.findViewById(R.id.addname);
        containers = view.findViewById(R.id.containers);

        title.setText(titl);
        addname.setText(addna);

        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        addView(view,params);
        adapter2 = new TvAdapter2(R.layout.tv_item);
        recyclerView.setAdapter(adapter2);

        // TODO: 2018/5/11 0011 无法控制recycleview 的高度
        recyclerView.setLayoutManager(new GridLayoutManager(context,linecount));

        initListener();
        input = View.inflate(context, R.layout.input_text, null);
        inputtitle = input.findViewById(R.id.title);
        inputcontent = input.findViewById(R.id.input);
        inputquxiao = input.findViewById(R.id.quxiao);
        inputqueding = input.findViewById(R.id.queding);
    }

    View input;
    TextView inputtitle;
    EditText inputcontent;
    Button inputquxiao;
    Button inputqueding;

    private void initListener() {
        adapter2.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if(onImageCliek!=null)
                onImageCliek.onItemChildClick(view,position);
            }
        });

        adapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(onImageCliek!=null)
                onImageCliek.onItemClick(view,position);
            }
        });


        adapter2.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

                alertDelete(position);
                return true;
            }
        });
        // TODO: 2018/5/11 0011
       // ((Activity) context).onActivityReenter();


        containers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               // onImageCliek.onAddClick(view);
                editLeiXingin(view,"请输入");

            }
        });
    }
    private AlertDialog dialog;
    private void alertDelete(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("删除信息");
        builder.setMessage("确定删除吗?");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(context, "你点击了确定", Toast.LENGTH_LONG).show();
                photos.remove(position);
                adapter2.replaceData(photos);
                dialog.dismiss();
                updateAdd();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(context,"你点击了取消",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        dialog = builder.create();
        dialog.show();
    }

    PopupWindow popupWindow2;

    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity)context).getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        ((Activity)context).getWindow().setAttributes(lp);
    }


    private int selectIndex = -1;
    private void editLeiXingin(View view, String title) {
        selectIndex = -1;
        popupWindow2 = new PopupWindow(context);
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
                if(TextUtils.isEmpty(inputcontent.getText().toString().trim())){
                    Toast.makeText(context,"请输入内容",Toast.LENGTH_SHORT).show();
                }else {
                    if (popupWindow2.isShowing()) {
                        popupWindow2.dismiss();
                        //target.setText(inputcontent.getText().toString().trim());
                        List<String> data = new ArrayList<>();
                        data.add(inputcontent.getText().toString().trim());
                        setPhoto(data);
                    }
                }

            }
        });

        popupWindow2.showAtLocation(view, Gravity.CENTER, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }

    private List<String>  photos = new ArrayList<>();

    public void setPhoto(List<String> photo){
        adapter2.addData(photo);
        photos.addAll(photo);



        updateAdd();
    }

    private void updateAdd() {
        int lines = photos.size() / linecount;
        int line = photos.size() % linecount;
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) containers.getLayoutParams();
        if(photos.size()==0){
            recyclerView.setVisibility(INVISIBLE);
            lines = 0;
            line = 1;
            params.topMargin = DensityUtil.dip2px(context,1+lines*33);
            params.leftMargin = DensityUtil.dip2px(context,5+line*85);
        }else {
            recyclerView.setVisibility(VISIBLE);
            params.topMargin = DensityUtil.dip2px(context,1+lines*33);
            params.leftMargin = DensityUtil.dip2px(context,5+line*85);
        }
//        params.leftMargin = 10+line*70;
//        params.topMargin = 30+lines*70;

        containers.setLayoutParams(params);
    }

    private  OnImageCliek onImageCliek;
    public void setOnImageCliek(OnImageCliek onImageCliek){
        this.onImageCliek = onImageCliek;
    }



    public interface OnImageCliek{
         void onItemClick(View view, int position);
         void onItemChildClick(View view, int position);
         //void onAddClick(View view);
    }

    public Boolean hasPhoto(){
        if(photos.size()==0){
            Toast.makeText(context,"请"+addna,Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
       //return photos.size()!=0;
    }


    ImgBean imgBeanhuanjing;
    public void upimg(UpPhotoCallBack upPhotoCallBack,int code) {
        if (photos != null && photos.size() > 0) {
            List<File> data = new ArrayList<>();
            for (String item : photos) {
                data.add(FilesUtil.getSmallBitmap(context, item));
            }
            OkGo.<String>post(NetWorkUrl.BASE + NetWorkUrl.IMG).params("token2", ((BaseActivity) context).getToken())
                    .addFileParams("file[]", data).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    // Log.i("ad",response.body());
                    imgBeanhuanjing = new Gson().fromJson(response.body(), ImgBean.class);
                    //提交了两次;
                    upPhotoCallBack.success(imgBeanhuanjing,code);
                }

                @Override
                public void onError(Response<String> response) {
                    super.onError(response);
                    // Log.i("ad",response.body());
                    upPhotoCallBack.onError(response.message(),code);
                }
            });
        }else {
            Toast.makeText(context,"请"+addna,Toast.LENGTH_SHORT).show();
        }
    }
    public String getPhoto2(){
        if(imgBeanhuanjing==null){
            return "";
        }
        return arraytoString(imgBeanhuanjing.getData().getPhoto()) ;
    }

    public String getPhoto(){
        return arraytoString(photos);
    }

    public List<String> getPhotoList(){
        return photos;
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
}
