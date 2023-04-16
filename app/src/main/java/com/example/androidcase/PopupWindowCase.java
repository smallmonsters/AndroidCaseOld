package com.example.androidcase;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PopupWindowCase extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_popup_window_case);
  }

  public void onOpen(View view) {
    TextView href = findViewById(R.id.href);

    // 创建一个只包含TextView的PopupWindow实例
    TextView textView = new TextView(this);
    textView.setText("Hello, PopupWindow!");
    // ViewGroup.LayoutParams.WRAP_CONTENT是一个常量，表示View的宽度或高度应该根据其内容自适应。focusable: 点击其他地方PopupWindow消失
    PopupWindow popupWindow = new PopupWindow(textView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
    popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_case));
    // popupWindow.setBackgroundDrawable(new ColorDrawable(Color.RED));
    // 设置PopupWindow的阴影效果
    popupWindow.setElevation(10);

    // // 设置PopupWindow的进入和退出动画
    // popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);

    // 监听PopupWindow的隐藏事件
    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
      @Override
      public void onDismiss() {
        Toast.makeText(PopupWindowCase.this, "PopupWindow has been dismissed.", Toast.LENGTH_SHORT).show();
      }
    });
    // 在背景视图上设置触摸监听器，用于监听PopupWindow的触摸事件
    popupWindow.getContentView().setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        // 在PopupWindow被触摸后隐藏PopupWindow
        popupWindow.dismiss();
        return false;
      }
    });

    popupWindow.showAsDropDown(href, 50, 50);


  }
}