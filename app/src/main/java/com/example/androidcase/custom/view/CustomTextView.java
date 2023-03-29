package com.example.androidcase.custom.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.androidcase.R;

public class CustomTextView extends View {
  private int mBackgroundColor;
  private boolean mIsEnabled;
  private float mLineWidth;
  private Drawable mIcon;

  public CustomTextView(Context context) {
    super(context);
  }

  public CustomTextView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyCustomView, 0, 0);
    try {
      mBackgroundColor = a.getColor(R.styleable.MyCustomView_backgroundColor, Color.WHITE);
      mIsEnabled = a.getBoolean(R.styleable.MyCustomView_enabled, true);
      mLineWidth = a.getDimension(R.styleable.MyCustomView_lineWidth, 1.0f);
    } finally {
      a.recycle();
    }
  }
}
