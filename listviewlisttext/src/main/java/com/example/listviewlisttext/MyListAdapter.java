package com.example.listviewlisttext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<MyData> {

  private final ArrayList<MyData> mDataList;
  private final LayoutInflater mInflater;
  private final int _resource;

  public MyListAdapter(Context context, int resource, ArrayList<MyData> dataList) {
    super(context, resource, dataList);
    mDataList = dataList;
    _resource = resource;
    //获取当前应用程序的上下文环境
    mInflater = LayoutInflater.from(context);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // 获取当前位置的数据对象
    MyData data = mDataList.get(position);

    // 解析自定义布局文件为一个View对象
    View itemView = mInflater.inflate(_resource, parent, false);

    // 获取标题和描述TextView控件的引用
    TextView titleTextView = (TextView) itemView.findViewById(R.id.textViewTitle);

    // 填充数据到TextView控件
    titleTextView.setText(data.getTitle());

    return itemView;
  }

}

