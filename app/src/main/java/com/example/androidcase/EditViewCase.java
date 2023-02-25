package com.example.androidcase;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditViewCase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_view_case);
        EditText editCase = findViewById(R.id.edit_case);
        Drawable textDrawable = getResources().getDrawable(R.drawable.edit_text_case);
        // NOTE: left：左边的边离原始位置偏离多少 top：上边的边离原始位置偏离多少 right：右边的边离原始位置偏离多少 bottom：下边的边离原始位置偏离多少
        textDrawable.setBounds(50, -20, 110, 40);
        editCase.setCompoundDrawables(textDrawable,null,null,null);
    }
}