package com.example.listtext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {

  private final Context context;
  private final int layoutResourceId;
  private final ArrayList<MyData> data;
  private final MyData.OnItemClickListener listener;

  public MyListAdapter(Context context, int layoutResourceId, ArrayList<MyData> data, MyData.OnItemClickListener listener) {
    this.context = context;
    this.layoutResourceId = layoutResourceId;
    this.data = data;
    this.listener = listener;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(layoutResourceId, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    MyData myData = data.get(position);
    holder.textViewTitle.setText(myData.getTitle());
    holder.textViewDescription.setText(myData.getDescription());
    holder.textViewDescription.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        listener.onItemClick(myData);
      }
    });
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewTitle;
    public TextView textViewDescription;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      textViewTitle = itemView.findViewById(R.id.textViewTitle);
      textViewDescription = itemView.findViewById(R.id.textViewDescription);
    }
  }
}
