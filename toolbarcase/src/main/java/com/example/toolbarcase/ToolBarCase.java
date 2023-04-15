package com.example.toolbarcase;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class ToolBarCase extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tool_bar_case);
    Toolbar tb = findViewById(R.id.my_toolbar);
    tb.setNavigationOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, World!", LENGTH_LONG);
        toast.show();

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
          @Override
          public void run() {
            toast.cancel();
          }
        }, 1000); // 1 秒后手动取消 Toast
        // Toast.makeText(ToolBarCase.this, "点击返回", LENGTH_LONG).show();
      }
    });
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