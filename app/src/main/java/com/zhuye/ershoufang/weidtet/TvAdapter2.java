package com.zhuye.ershoufang.weidtet;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class TvAdapter2 extends BaseQuickAdapter<String,BaseViewHolder> {

    public TvAdapter2(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        ImageView imageView=  helper.getView(R.id.image);
//        imageView.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(mContext,item)));
        helper.setText(R.id.item,item);
    }
}
