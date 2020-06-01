package com.example.training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Dom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dom);
    }

    public void SMS_OnClick(View view) {
        EditText Numer = (EditText) findViewById(R.id.NumerTelefonu_EditText);
        EditText sms = (EditText) findViewById(R.id.SMS_EditText);
        if(Numer.getText().toString().equals(""))
        {
            Toast.makeText(Dom.this, "Nalezy podac numer telefonu", Toast.LENGTH_SHORT).show();
        } else {
            if (sms.getText().toString().equals("")) {
                Toast.makeText(Dom.this, "Nalezy podac tresc wiadomosci", Toast.LENGTH_SHORT).show();
            } else {
                String NumerSms = "smsto:" + Numer.getText().toString();
                String TrescSms = sms.getText().toString();

                Intent SmsIntent = new Intent(Intent.ACTION_SENDTO);
                SmsIntent.setData(Uri.parse(NumerSms));
                SmsIntent.putExtra("sms_body", TrescSms);
                startActivity(SmsIntent);
            }
        }
    }


}
