package com.example.turking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kelimeanasayfa extends AppCompatActivity {

    Button bt1, bt2, bt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimeanasayfa);

        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        Button anasayf = findViewById(R.id.anasayfaaa);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(Kelimeanasayfa.this, kelimeeasy.class);
                startActivity(s);

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(Kelimeanasayfa.this, kelimemedium.class);
                startActivity(d);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f = new Intent(Kelimeanasayfa.this, kelimehard.class);
                startActivity(f);
            }
        });
        anasayf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f = new Intent(Kelimeanasayfa.this, anasayfa_activity.class);
                startActivity(f);
            }
        });


    }
}