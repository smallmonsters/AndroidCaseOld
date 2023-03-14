package com.example.androidcase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<MyData> {

  private final int layoutId;

  public MyListAdapter(Context context, int layoutId, ArrayList<MyData> dataList) {
    super(context, 0, dataList);
    this.layoutId = layoutId;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View listItemView = convertView;
    if (listItemView == null) {
      listItemView = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);
    }

    MyData currentData = this.getItem(position);

    TextView textViewTitle = listItemView.findViewById(R.id.textViewTitle);
    textViewTitle.setText(currentData.getTitle());

    if (currentData.getOnClickListener() != null) {
      listItemView.setOnClickListener(currentData.getOnClickListener());
    }

    return listItemView;
  }
}

