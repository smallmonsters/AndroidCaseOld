package com.example.androidcase;

import android.view.View;

public interface Router {
  String TextViewCase = "TextViewCase";
  String ButtonCase = "ButtonCase";
  String Notification = "Notification";
  String ProcessBar = "ProcessBar";
  String ImageCase = "ImageCase";
  String EditViewCase = "EditViewCase";
  String AlertDialog = "AlertDialog";
  String PopupWindow = "PopupWindow";

  String getTitle();

  View.OnClickListener getClickListener();
}
