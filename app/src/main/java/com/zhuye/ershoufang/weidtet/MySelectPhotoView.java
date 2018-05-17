package com.zhuye.ershoufang.weidtet;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

import me.iwf.photopicker.PhotoPicker;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class MySelectPhotoView extends LinearLayout {
    public int REQUESTCODE = 100 ;

    public MySelectPhotoView(Context context) {
        this(context,null);
    }

    public MySelectPhotoView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    private Context context;
    TextView title;
    RecyclerView recyclerView;
    ImageView add;
    ImageView add2;
    TextView addname;
    ImageAdapter2 adapter2;
    LinearLayout containers;
    String addna;
    private int linecount = 4;
    public MySelectPhotoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MySelectPhotoView);

        this.context = context;
        int resid =  typedArray.getResourceId(R.styleable.MySelectPhotoView_resids,0);
        String titl = typedArray.getString(R.styleable.MySelectPhotoView_title);
        addna  = typedArray.getString(R.styleable.MySelectPhotoView_addname);
        typedArray.recycle();

        resid = resid==0?R.layout.selectphoto:resid;
        View view = LayoutInflater.from(context).inflate(resid,null);
        title = view.findViewById(R.id.title);
        recyclerView = view.findViewById(R.id.photocontainer);
        add = view.findViewById(R.id.add);
        add2 = view.findViewById(R.id.add2);
        addname = view.findViewById(R.id.addname);
        containers = view.findViewById(R.id.containers);

        title.setText(titl);
        addname.setText(addna);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        addView(view,params);
        adapter2 = new ImageAdapter2(R.layout.image2);

        recyclerView.setAdapter(adapter2);

        // TODO: 2018/5/11 0011 无法控制recycleview 的高度
        MyGridLayoutManager myGridLayoutManager = new MyGridLayoutManager(context,linecount);
        recyclerView.setLayoutManager(myGridLayoutManager);
        myGridLayoutManager.setScrollEnabled(false);

        initListener();


    }

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


        // TODO: 2018/5/11 0011
       // ((Activity) context).onActivityReenter();

        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //onImageCliek.onAddClick(view);
              selectPhoto();
            }
        });

        containers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               // onImageCliek.onAddClick(view);
                selectPhoto();
            }
        });
    }

    private void selectPhoto() {
        PhotoPicker.builder()
                .setPhotoCount(9)
                .setShowCamera(true)
                .setShowGif(true)
                .setPreviewEnabled(false)
                .start((Activity) context, REQUESTCODE);
    }

    private List<String>  photos = new ArrayList<>();

    public void setPhoto(List<String> photo){
        adapter2.addData(photo);
        photos.addAll(photo);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) containers.getLayoutParams();

        int lines = photos.size() / linecount;
        int line = photos.size() % linecount;

        if(photos.size()==0){
            add.setVisibility(VISIBLE);
            recyclerView.setVisibility(INVISIBLE);
            lines = 0;
            line = 1;
            params.topMargin = DensityUtil.dip2px(context,5+lines*70);
            params.leftMargin = DensityUtil.dip2px(context,10+line*80);
        }else {
            add.setVisibility(INVISIBLE);
            recyclerView.setVisibility(VISIBLE);
            params.topMargin = DensityUtil.dip2px(context,5+lines*70);
            params.leftMargin = DensityUtil.dip2px(context,10+line*80);
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
         void onItemClick( View view, int position);
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
