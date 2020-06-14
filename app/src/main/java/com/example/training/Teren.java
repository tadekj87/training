package com.example.training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Teren extends AppCompatActivity {

    private TextView Moc;
    private TextView Kadencja;
    private TextView AktualnaMoc;
    private TextView AktualnaKadencja;
    private SeekBar UstawionaMocBar;
    private SeekBar UstawionaKadencjaBar;

    private RatingBar SredniaMocRatingBar;
    private RatingBar SredniaKadencjaRatingBar;
    Handler handler = new Handler(); //Do timera
    Runnable runnable; //do timera
    int delay=1*1000; //do timera, odswiezanie wartosci sredniej
    private float SredniaMocfloat, SredniaKadencjafloat;
    private int licznik;
    private Button Trening1Button;
    private Button Trening2Button;
    int CzasTreningu = 600000;//10000minut

    private ProgressBar CzasTreninguBar;

    int i=0;
    CountDownTimer mCountDownTimer;
    //ProgressBar mProgressBar=findViewById(R.id.progressBar);


    int pStatus = 0; //do progressbar
    private Handler progressbarhandler = new Handler();
    TextView procent;

    @Override
    protected void onResume() {
        SredniaMocRatingBar = findViewById(R.id.AvgMoc_ratingBar);
        SredniaKadencjaRatingBar = findViewById(R.id.AvgKadencja_ratingBar);
        AktualnaMoc = findViewById(R.id.AktualnaMoc_textView);
        SredniaMocfloat = 0;
        licznik = 0;
        SredniaKadencjafloat = 0;

        handler.postDelayed( runnable = new Runnable() {
            public void run() {
                SredniaMocfloat = SredniaMocfloat + Integer.valueOf(UstawionaMocBar.getProgress());
                SredniaKadencjafloat = SredniaKadencjafloat + Integer.valueOf(UstawionaKadencjaBar.getProgress());
                licznik++;
                SredniaMocRatingBar.setRating((SredniaMocfloat/licznik)/200);
                SredniaKadencjaRatingBar.setRating((SredniaKadencjafloat/licznik)/20);
                handler.postDelayed(runnable,delay);
            }
        },delay);
        super.onResume();
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(runnable); //zatrzymaj gdy aplikacja niewidoczna
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teren);

        Resources res = getResources(); //do progressbar
        Drawable drawable = res.getDrawable(R.drawable.circular);
        final ProgressBar mProgress = (ProgressBar) findViewById(R.id.progressBar);
        mProgress.setProgress(0);
        mProgress.setSecondaryProgress(100);
        mProgress.setMax(100);
        mProgress.setProgressDrawable(drawable);
        // CzasTreninguBar = findViewById(R.id.progressBar);
        // CzasTreninguBar.setProgress(35);
        Trening1Button = findViewById(R.id.Trening1);
        Trening2Button = findViewById(R.id.Trening2);

        procent= (TextView) findViewById(R.id.ProcentTreningu_textView);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(pStatus<CzasTreningu) {
                    pStatus+=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgress.setProgress(100*pStatus/CzasTreningu);
                            procent.setText(100*pStatus/CzasTreningu + "%");

                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Trening1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pStatus=0;
                CzasTreningu=180;//3 minuty
                SredniaMocfloat = 0;
                SredniaKadencjafloat = 0;
                licznik=0;
            }
        });

        Trening2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pStatus=0;
                CzasTreningu=600;//10 minut
                SredniaMocfloat = 0;
                SredniaKadencjafloat = 0;
                licznik=0;
            }
        });

        Moc = findViewById(R.id.Moc_textView);
        Kadencja = findViewById(R.id.Kadencja_textView);
        AktualnaKadencja = findViewById(R.id.AktualnaKadencja_textView);
        AktualnaMoc = findViewById(R.id.AktualnaMoc_textView);
        UstawionaMocBar = findViewById(R.id.Moc_seekBar);
        UstawionaKadencjaBar = findViewById(R.id.Kadencja_seekBar);



        // SredniaMocRatingBar.setNumStars();

        AktualnaMoc.setText(String.valueOf(UstawionaMocBar.getProgress()));
        UstawionaMocBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                AktualnaMoc.setText(String.valueOf(UstawionaMocBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //  ProcentSeekBar=ProcentNapiwkuBar.getProgress();
            }
        });

        AktualnaKadencja.setText(String.valueOf(UstawionaKadencjaBar.getProgress()));
        UstawionaKadencjaBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                AktualnaKadencja.setText(String.valueOf(UstawionaKadencjaBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //  ProcentSeekBar=ProcentNapiwkuBar.getProgress();
            }
        });

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
