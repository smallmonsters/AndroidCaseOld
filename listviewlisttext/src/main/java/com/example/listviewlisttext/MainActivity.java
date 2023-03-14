package com.example.listviewlisttext;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setContentView 应该在所有视图相关的操作之前调用
    setContentView(R.layout.activity_main);
    ListView myListView = (ListView) findViewById(R.id.myListView);
    // 创建一个包含列表项数据的ArrayList
    ArrayList<MyData> myDataList = new ArrayList<>();
    myDataList.add(new MyData("Item 1"));
    myDataList.add(new MyData("Item 2"));
    myDataList.add(new MyData("Item 3"));
    // 创建一个自定义适配器对象，将数据与ListView关联起来
    MyListAdapter adapter = new MyListAdapter(this, R.layout.list_text, myDataList);
    // 为整个item设置点击监听器
    myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MyData myData = (MyData) parent.getItemAtPosition(position);
        Toast.makeText(MainActivity.this, myData.getTitle(), Toast.LENGTH_SHORT).show();
      }
    });

    // 将适配器对象设置给ListView控件
    myListView.setAdapter(adapter);

  }

}
