package com.example.turking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class anasayfa_activity extends gericikma {

    Button test, resim, not, kelime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        test = findViewById(R.id.testet);
        resim = findViewById(R.id.resimleogren);
        not = findViewById(R.id.notdefteri);
        kelime = findViewById(R.id.kelimeogren);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ıntent = new Intent(getApplicationContext(), notgoster_activity.class);
                startActivity(ıntent);
                finish();
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), seviye1.class);
                startActivity(intent);
                finish();
            }
        });
        resim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Baslangic.class);
                startActivity(intent);
                finish();
            }
        });
        kelime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Kelimeanasayfa.class);
                startActivity(intent);
                finish();
            }
        });


    }
}