package com.example.androidcase;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import java.util.Map;

public class MyHandlerThread extends HandlerThread {
  private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
  private Handler mHandler;

  public MyHandlerThread(String name) {
    super(name);
  }

  public static int getValue() {
    return threadLocal.get();
  }

  public static void setValue(int value) {
    threadLocal.set(value);
  }

  public static void removeValue() {
    threadLocal.remove();
  }

  public void prepareHandler() {
    mHandler = new Handler(getLooper()) {
      @Override
      public void handleMessage(Message msg) {
        // 在后台线程中处理消息
        // ...
      }
    };
  }

  public Handler getHandler() {
    return mHandler;
  }
}
