package com.zhuye.ershoufang.chat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.Locale;

import io.rong.imlib.model.Conversation;
import io.rong.push.notification.PushMessageReceiver;
import io.rong.push.notification.PushNotificationMessage;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class SealNotificationReceiver  extends PushMessageReceiver {
    /* push 通知到达事件*/
    @Override
    public boolean onNotificationMessageArrived(Context context, PushNotificationMessage message) {
        return false; // 返回 false, 会弹出融云 SDK 默认通知; 返回 true, 融云 SDK 不会弹通知, 通知需要由您自定义。
    }

    /* push 通知点击事件 */
    @Override
    public boolean onNotificationMessageClicked(Context context, PushNotificationMessage message) {
//        Intent intent=new Intent(context, MainActivity.class);
//        intent.putExtra("selectview","1");
//        StorageUtil.setKeyValue(context,"istype","1");
//        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//        RongIM.getInstance().startConversation(context
//                , Conversation.ConversationType.PRIVATE,message.getSenderId(),"");

        Intent intent = new Intent(context,ConversationActivity.class);
        Conversation.ConversationType conversationType = Conversation.ConversationType.PRIVATE;
        String targetId = message.getSenderId();
        String title = "";
        Uri uri = Uri.parse("rong://" + context.getApplicationInfo().processName).buildUpon().appendPath("conversation").appendPath(conversationType.getName().toLowerCase(Locale.US)).appendQueryParameter("targetId", targetId).appendQueryParameter("title", title).build();
        intent.setData(uri);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("type","1");
        context.startActivity(intent);
        return true; // 返回 false, 会走融云 SDK 默认处理逻辑, 即点击该通知会打开会话列表或会话界面; 返回 true, 则由您自定义处理逻辑。
    }
}
