package com.example.processbarcase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ProcessBarMainActivity extends AppCompatActivity {
    private ProgressBar pb;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_bar_activity_main);
        pb = findViewById(R.id.processBar);
        onClock();
    }

    private void onClock() {
        ProgressBar process = findViewById(R.id.process);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Log.e("count", String.valueOf(count));
                if (count>10){
                    timer.cancel();
                }
                process.setProgress(++count);
            }
        };
        timer.schedule(task, 0, 1000);
    }

    public void toggleStatus(View view) {
        if (pb.getVisibility() == View.VISIBLE) {
            pb.setVisibility(View.GONE);
        } else {
            pb.setVisibility(View.VISIBLE);
        }
    }

}