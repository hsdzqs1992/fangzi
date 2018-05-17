package com.zhuye.ershoufang.weidtet;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class RvAdapter2 extends BaseQuickAdapter<MyRecycleBean,BaseViewHolder> {

    public RvAdapter2(int layoutResId) {
        super(layoutResId);
    }

    public List<BaseViewHolder> da = new ArrayList<>();
    @Override
    protected void convert(BaseViewHolder helper, MyRecycleBean item) {
//        ImageView imageView=  helper.getView(R.id.image);
//        imageView.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(mContext,item)));
       // helper.setText(R.id.item,item);
       // helper.setAdapter(R.id.xiaoguo,RvAdapter2.this);
       // helper.setAdapter(R.id.xiaoguo,helper.get)

        //helper.itemView = helper.getConvertView();
       // helper
        if(!da.contains(helper)){
            da.add(helper);
        }
    }
}
