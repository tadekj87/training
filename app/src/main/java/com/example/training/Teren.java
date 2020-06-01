package com.example.training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Teren extends AppCompatActivity {

    int i=0;
    CountDownTimer mCountDownTimer;
    //ProgressBar mProgressBar=findViewById(R.id.progressBar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teren);


       // mProgressBar.setProgress(i);
        /*mCountDownTimer=new CountDownTimer(5000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress"+ i+ millisUntilFinished);
                i++;
               // mProgressBar.setProgress((int)i*100/(5000/1000));

            }

            @Override
            public void onFinish() {
                //Do what you want
                i++;
                //mProgressBar.setProgress(100);
            }
        };
        mCountDownTimer.start();*/
    }


}
