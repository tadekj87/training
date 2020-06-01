package com.example.training;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton DomButton = findViewById(R.id.imageButton2);
        ImageButton TerenButton = findViewById(R.id.imageButton);

        DomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  int NumerTelefonu = Integer.parseInt(Numer.getText().toString());

                Intent intent = new Intent(MainActivity.this, Dom.class);
                //    intent.putExtra("numer", NumerTelefonu);

                startActivityForResult(intent, 1);
            }
        });

        TerenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Teren.class);

                startActivityForResult(intent, 1);
            }
        });


    }



}
