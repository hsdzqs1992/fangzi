package com.zhuye.ershoufang.chat;

import android.app.Activity;
import android.util.Log;

import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.BaseView;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;

/**
 * Created by Administrator on 2018/5/25 0025.
 */

public class GlobalListener  implements RongIMClient.OnReceiveMessageListener ,BaseView {

    private static GlobalListener instance  = null;
    Activity context;
    private GlobalListener(Activity context){
        this.context = context;
        RongIM.setOnReceiveMessageListener(this);
    }

    public static GlobalListener init(Activity context){
        if(instance==null){
            instance = new GlobalListener(context);
        }
        return instance;
    }


    @Override
    public boolean onReceived(Message message, int i) {
        //message.getContent().getMentionedInfo().getMentionedContent();
        //Toast.makeText(context,message.getContent().getMentionedInfo().getMentionedContent(),Toast.LENGTH_LONG).show();
       // Toast.makeText(context,"sdfasdf",Toast.LENGTH_LONG).show();
        Log.i("ass",message.getSenderUserId());
       // CommonApi.getInstance().getUserInfo(message.getSenderUserId(),this,200);

//        Alerter.create(context)
//                .setTitle("zhangss")
//                .setText("Alert text...")
//                .setDuration(1000)
//               // .setIconColorFilter(0) // Optional - Removes white tint
//                .setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(context, ConversationActivity.class);
//                        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,  intent, PendingIntent.FLAG_CANCEL_CURRENT);
//                    }
//                })
//                .show();
        return false;
    }

    @Override
    public void loding() {

    }

    @Override
    public void finishLoding() {

    }

    @Override
    public void error(Base base) {

    }

    @Override
    public void success(int requestcode, Base base) {
        switch (requestcode){
            case 200:

                break;
        }
    }

    @Override
    public void empty() {

    }
}
