package com.zhuye.ershoufang.adapter;

import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;

/**
 * Created by Administrator on 2018/4/23 0023.
 */

public class TvAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public TvAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if(!TextUtils.isEmpty(item)){
//           ImageView imageView =  helper.getView(R.id.iv);
//           imageView.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(mContext,item)));
            helper.setText(R.id.item,item);
        }
    }
}
