package com.zhuye.ershoufang.adapter;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.utils.FilesUtil;

/**
 * Created by Administrator on 2018/4/23 0023.
 */

public class ImageAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public ImageAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if(!TextUtils.isEmpty(item)){
           ImageView imageView =  helper.getView(R.id.iv);
           imageView.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(mContext,item)));
        }
    }
}
