package com.example.androidcase;

import android.view.View;

public class MyData {
  private final String title;
  private final View.OnClickListener onClickListener;
  private String description;

  public MyData(String title, View.OnClickListener onClickListener) {
    this.title = title;
    this.onClickListener = onClickListener;
  }

  public MyData(Router route) {
    this.title = route.getTitle();
    this.onClickListener = route.getClickListener();
  }

  public String getTitle() {
    return title;
  }

  public View.OnClickListener getOnClickListener() {
    return onClickListener;
  }

}
