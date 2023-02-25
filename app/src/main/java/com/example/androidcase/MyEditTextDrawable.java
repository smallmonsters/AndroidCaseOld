package com.example.androidcase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;


public class MyEditTextDrawable extends androidx.appcompat.widget.AppCompatEditText {
    //  构造函数在代码里new的时候调用
    //  MyEditTextDrawable et=new MyEditTextDrawable(this)
    public MyEditTextDrawable(Context context) {
        super(context);
    }

    /**
     * 在布局使用
     * <com.example.androidcase.MyEditTextDrawable
     * android:layout_width="match_parent"
     * android:layout_height="200dp"
     * android:hint="自己的editText"
     * />
     */
    @SuppressLint("UseCompatLoadingForDrawables")
    public MyEditTextDrawable(Context context, AttributeSet attrs) {
        super(context, attrs);
        Drawable drawable = context.getResources().getDrawable(R.drawable.edit_text_case);
        drawable.setBounds(0,0,100,100);
        this.setCompoundDrawables(drawable,null,null,null);
    }

    //    在布局里使用，有定义的style
    public MyEditTextDrawable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
