package com.example.androidcase;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.processbarcase.ProcessBarMainActivity;

public class Route implements Router {
  private final String type;
  Context context;

  public Route(String s, Context c) {
    type = s;
    context = c;
  }

  public String getTitle() {
    return type;
  }

  public void toTextViewCase(View view) {
    Intent intent = new Intent(view.getContext(), TextViewCaseActivity.class);
    context.startActivity(intent);
  }

  public void toButtonCase(View view) {
    Intent intent = new Intent(view.getContext(), ButtonViewCase.class);
    context.startActivity(intent);
  }

  public void toEditViewCase(View view) {
    Intent intent = new Intent(view.getContext(), EditViewCase.class);
    context.startActivity(intent);
  }

  public void toImageCase(View view) {
    Intent intent = new Intent(view.getContext(), ImageCase.class);
    context.startActivity(intent);
  }

  public void toProcessBar(View view) {
    Intent intent = new Intent(view.getContext(), ProcessBarMainActivity.class);
    context.startActivity(intent);
  }

  public void toNotification(View view) {
    Intent intent = new Intent(view.getContext(), NotificaitionCase.class);
    context.startActivity(intent);

  }

  public void toAlertDialog(View view) {
    Intent intent = new Intent(view.getContext(), AlertDialogCase.class);
    context.startActivity(intent);

  }

  public View.OnClickListener getClickListener() {
    return new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        switch (type) {
          case Router.TextViewCase:
            toTextViewCase(view);
            break;
          case Router.ButtonCase:
            toButtonCase(view);
            break;
          case Router.EditViewCase:
            toEditViewCase(view);
            break;
          case Router.ImageCase:
            toImageCase(view);
            break;
          case Router.ProcessBar:
            toProcessBar(view);
            break;
          case Router.Notification:
            toNotification(view);
            break;
          case Router.AlertDialog:
            toAlertDialog(view);
            break;
          default:
            Toast.makeText(context, "路由类型错了", Toast.LENGTH_SHORT).show();
        }

      }
    };
  }
}
