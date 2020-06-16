package com.example.training;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Dom extends AppCompatActivity {

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

    private Button SilaButton;
    private Button WytrzymaloscButton;
    private TextView ZadanaMoc;
    private TextView ZadanaKadencja;
    private int MocTreningu=0;
    private int KadencjaTreningu=0;
    private ImageButton bckButton;
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
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }
        else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dom);

        bckButton=(ImageButton) findViewById(R.id.imageButton2);

        Moc = findViewById(R.id.Moc_textView);
        Kadencja = findViewById(R.id.Kadencja_textView);
        AktualnaKadencja = findViewById(R.id.AktualnaKadencja_textView);
        AktualnaMoc = findViewById(R.id.AktualnaMoc_textView);
        UstawionaMocBar = findViewById(R.id.Moc_seekBar);
        UstawionaKadencjaBar = findViewById(R.id.Kadencja_seekBar);

        SilaButton= findViewById(R.id.Sila_Button);
        WytrzymaloscButton= findViewById(R.id.Wytrzymalosc_Button);
        ZadanaMoc= findViewById(R.id.ZadanaMoc_TextView);
        ZadanaKadencja= findViewById(R.id.ZadanaKadencja_TextView);

        // SredniaMocRatingBar.setNumStars();

        AktualnaMoc.setText(String.valueOf(UstawionaMocBar.getProgress()));
        UstawionaMocBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                AktualnaMoc.setText(String.valueOf(UstawionaMocBar.getProgress()));
                if (UstawionaMocBar.getProgress()<1.1*MocTreningu &&UstawionaMocBar.getProgress()>0.9*MocTreningu) {
                    AktualnaMoc.setTextColor(Color.GREEN);
                } else {
                    AktualnaMoc.setTextColor(Color.RED);
                }
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
                if (UstawionaKadencjaBar.getProgress()<1.1*KadencjaTreningu &&UstawionaKadencjaBar.getProgress()>0.9*KadencjaTreningu) {
                    AktualnaKadencja.setTextColor(Color.GREEN);
                } else {
                    AktualnaKadencja.setTextColor(Color.RED);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //  ProcentSeekBar=ProcentNapiwkuBar.getProgress();
            }
        });

        SilaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MocTreningu = 300;
                KadencjaTreningu = 80;
                ZadanaMoc.setText("Zadana moc: " + MocTreningu +" W");
                ZadanaKadencja.setText("Zadana kadencja: " + KadencjaTreningu + " obr/min");
                SredniaMocfloat = 0;
                SredniaKadencjafloat = 0;
                licznik=0;
            }
        });

        WytrzymaloscButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MocTreningu = 250;
                KadencjaTreningu = 100;
                ZadanaMoc.setText("Zadana moc: " + MocTreningu +" W");
                ZadanaKadencja.setText("Zadana kadencja: " + KadencjaTreningu + " obr/min");
                SredniaMocfloat = 0;
                SredniaKadencjafloat = 0;
                licznik=0;
            }
        });

        bckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dom.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }



    public void SMS_OnClick(View view) {
        EditText Numer = (EditText) findViewById(R.id.NumerTelefonu_EditText);

        if(Numer.getText().toString().equals(""))
        {
            Toast.makeText(Dom.this, "Nalezy podac numer telefonu", Toast.LENGTH_SHORT).show();
        }  else {
            String NumerSms = "smsto:" + Numer.getText().toString();
            // String TrescSms = sms.getText().toString();
            String TrescSms ="Czas treningu: " + licznik + "s, Srednia moc: "+ SredniaMocfloat/licznik + "W, Srednia kadencja: " + SredniaKadencjafloat/licznik + "obr/min";

            Intent SmsIntent = new Intent(Intent.ACTION_SENDTO);
            SmsIntent.setData(Uri.parse(NumerSms));
            SmsIntent.putExtra("sms_body", TrescSms);
            startActivity(SmsIntent);
        }

    }


}
