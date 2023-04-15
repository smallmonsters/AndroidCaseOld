package com.example.androidcase;

import static android.widget.Toast.LENGTH_SHORT;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogCase extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_alert_dialog_case);
  }

  public void openAlertDialog(View view) {
    String[] fruitList = {"Apple", "Banana", "Orange", "Pineapple", "Mango"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fruitList);
    final CharSequence[] items = {"Android", "iOS", "Windows"};
    final boolean[] checkedItems = {false, true, false};

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setIcon(R.drawable.button_case)
      // .setMessage("这是一个弹框")
      .setTitle("警告")
      .setNegativeButton("取消", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          Toast.makeText(builder.getContext(), "取消了", LENGTH_SHORT).show();
        }
      })
      .setPositiveButton("确定", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          Toast.makeText(builder.getContext(), "确定了", LENGTH_SHORT).show();
        }
      })
      .setNeutralButton("跳过", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          Toast.makeText(builder.getContext(), "跳过了", LENGTH_SHORT).show();
        }
      })
      // .setAdapter(adapter, new DialogInterface.OnClickListener() {
      //   @Override
      //   // 每个item点击事件，不能和message 一起使用
      //   public void onClick(DialogInterface dialog, int which) {
      //     String selectedFruit = fruitList[which];
      //     Toast.makeText(builder.getContext(), "You selected: " + selectedFruit, LENGTH_SHORT).show();
      //   }
      // })
      .setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
          checkedItems[which] = isChecked;
        }
      })
      .create()
      .show();

  }
}