package com.example.training;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity {

    String arrayQuotes[]={"Jeśli możesz kłaść się spać każdej nocy ze świadomością, że w ciągu dnia dałeś z siebie wszystko, sukces Cię znajdzie – Mason Russell L.",
            "Nigdy nie narzekaj, że masz pod górę, skoro zdecydowałaś się iść na szczyt.",
            "Każdy problem ma rozwiązanie. Jeśli nie ma rozwiązania, to nie ma problemu.",
            "„Kiedyś” to choroba, która każe nam zabrać wszystkie nasze marzenia do grobu – Timothy Ferriss",
            "Myślę pozytywnie...-Wojtek Sokół",
            "Jeśli masz zamiar w coś wątpić, to zacznij wątpić w swoje ograniczenia – Don Ward",
            "Motywacja jest tym, co pozwala zacząć. Nawyk jest tym, co pozwala wytrwać w postanowieniu.",
            "Jeśli myślisz o poddaniu się, przypomnij sobie dlaczego zaczęłaś.",
            "Im bardziej w życiu ma się pod górkę, tym piękniejsze będą później widoki."
    };
    String arrayName[]={"Dom",
            "Teren",
            "Wyjscie"};
    private static int SPLASH_TIME_OUT=4000;


    int OldValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView Quote=(TextView) findViewById(R.id.textViewQuote);
        int random = (int) (Math.random()*arrayQuotes.length);
        if(random==OldValue)
        {random = (int) (Math.random()*arrayQuotes.length);}
        Quote.setText(arrayQuotes[random]);
        OldValue=random;
        //new Handler().postDelayed(new Runnable() {
        //     @Override
        //   public void run() {
        //      Intent homeIntent=new Intent(MainActivity.this,HomeActivity.class);
        //      startActivity(homeIntent);
        //       finish();
        //  }
        //  },SPLASH_TIME_OUT);


        CircleMenu circleMenu=(CircleMenu)findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.icon_menu,R.drawable.icon_cancel)
                .addSubMenu(Color.parseColor("#258CFF"),R.drawable.ic_terrain)
                .addSubMenu(Color.parseColor("#ff0000"),R.drawable.ic_exit)
                .addSubMenu(Color.parseColor("#6d4c41"),R.drawable.ic_domain)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        //   String tekst=String.valueOf(index);
                        //  Toast.makeText(MainActivity.this,tekst,Toast.LENGTH_SHORT).show();
                        if (index == 0) {
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                              public void run() {
                                                  Intent intent = new Intent(MainActivity.this, Teren.class);
                                                  startActivityForResult(intent, 1);
                                              }
                                          }
                                    , 1000);
                        }

                        if(index==2) {
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                              public void run() {
                                                  Intent intent = new Intent(MainActivity.this, Dom.class);
                                                  startActivityForResult(intent, 1);
                                              }
                                          }
                                    , 1000);
                        }
                        if(index==1) {

                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                              public void run() {

                                                  System.exit(0);
                                              }
                                          }
                                    , 1000);
                        }

                    }
                });

    }



}
