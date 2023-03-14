package com.example.androidcase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;

public class NotificaitionCase extends AppCompatActivity {
  NotificationManager notificationManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_notificaition_case);
    notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
  }

  public void sendNotification(View view) {
//    Notification notification = new Notification.Builder(this)
//      .setContentTitle("New message")
//      .setContentText("You have received a new message.")
//      .build();
//    notificationManager.notify(1, notification);
  }

  public void closeNotification(View view) {
  }
}