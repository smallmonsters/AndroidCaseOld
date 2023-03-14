package com.example.listtext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    ArrayList<MyData> myDataList = new ArrayList<>();
    myDataList.add(new MyData("Item 1", "Description 1"));
    myDataList.add(new MyData("Item 2", "Description 2"));
    myDataList.add(new MyData("Item 3", "Description 3"));

    MyListAdapter adapter = new MyListAdapter(this, R.layout.list_text, myDataList, new MyData.OnItemClickListener() {
      @Override
      public void onItemClick(MyData myData) {
        Toast.makeText(MainActivity.this, myData.getTitle() + ": " + myData.getDescription(), Toast.LENGTH_SHORT).show();
        // 在这里根据 myData 的不同属性实现不同的点击事件
      }
    });

    recyclerView.setAdapter(adapter);
  }
}
