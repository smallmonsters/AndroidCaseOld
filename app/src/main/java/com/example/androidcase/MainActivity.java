package com.example.androidcase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setContentView 应该在所有视图相关的操作之前调用
    setContentView(R.layout.activity_main);
    ListView myListView = findViewById(R.id.myListView);
    // 创建一个包含列表项数据的ArrayList
    ArrayList<MyData> myDataList = new ArrayList<>();
    //方法一
    myDataList.add(new MyData(Router.TextViewCase, new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //两种方法都可以，
        // toTextViewCase(view);
        MainActivity.this.toTextViewCase(view);
      }
    }));
    //方法二
    myDataList.add(new MyData(new Route(Router.ButtonCase, this)));
    myDataList.add(new MyData(new Route(Router.EditViewCase, this)));
    myDataList.add(new MyData(new Route(Router.ImageCase, this)));
    myDataList.add(new MyData(new Route(Router.ProcessBar, this)));
    myDataList.add(new MyData(new Route(Router.Notification, this)));

    // 创建一个自定义适配器对象，将数据与ListView关联起来
    MyListAdapter adapter = new MyListAdapter(this, R.layout.list_text, myDataList);
    // 将适配器对象设置给ListView控件
    myListView.setAdapter(adapter);

  }

  public void toTextViewCase(View view) {
    Intent intent = new Intent(this, TextViewCaseActivity.class);
    startActivity(intent);
  }

  public void toLoginCase(View view) {
    // Intent intent = new Intent(this, Login_MainActivity.class);
    // startActivity(intent);
  }

}
