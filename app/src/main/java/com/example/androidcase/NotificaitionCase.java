package com.example.androidcase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificaitionCase extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_notificaition_case);
    NotificationManager notificationManager = getSystemService(NotificationManager.class);
    // 创建通知渠道，是否>= Android 8.0
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      NotificationChannel channel = new NotificationChannel("channel_id", "Channel Name", NotificationManager.IMPORTANCE_HIGH);
      notificationManager.createNotificationChannel(channel);
    }
  }

  public void sendNotification(View view) {
    // TODO: 2023/3/21 点击通知，进入了相关页面A，页面A点击返回怎么回到首页或者调整到指定页面
    // 创建通知点击意图
    Intent intent = new Intent(this, ButtonViewCase.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

    // 创建通知
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel_id")
      .setContentTitle("My Notification")
      .setContentText("Hello World!")
      .setSmallIcon(R.drawable.edit_text_case)
      .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.image1))
      .setContentIntent(pendingIntent)
      .setAutoCancel(true);

    // 发送通知
    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
    notificationManager.notify(1, builder.build());
  }


  public void closeNotification(View view) {
    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
    notificationManager.cancel(1);
  }
}