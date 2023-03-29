package com.example.toolbarcase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class ToolBarCase extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tool_bar_case);
    getData();
  }

  private void getData() {

    Intent intent = getIntent();
    String pag = intent.getPackage();

    Uri data = getIntent().getData();

    if (data == null)
      return;
    try {
      String scheme = data.getScheme();
      String host = data.getHost();
      List<String> params = data.getPathSegments();
      // 传过来的数据
      String testId = params.get(0);
      String query = data.getQuery();
      String text = "Scheme: " + scheme + "\n" + "host: " + host + "\n" + "params: " + testId + "\n" + query;
      Log.e("Scheme", text);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}