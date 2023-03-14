package com.example.listtext;

public class MyData {
  private final String title;
  private final String description;

  public MyData(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public interface OnItemClickListener {
    void onItemClick(MyData myData);
  }
}

