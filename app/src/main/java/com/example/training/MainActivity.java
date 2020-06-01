package com.example.training;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity {

    String arrayName[]={"Dom",
                        "Teren",
                        "Wyjscie"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




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
                                                  Intent intent = new Intent(MainActivity.this, Teren.class);
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
