package com.example.turking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Baslangic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baslangic);

        Button anasayfa= findViewById(R.id.anasayfaa);

        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Baslangic.this, anasayfa_activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void hayvanplay(View view) {
        Intent intent = new Intent(Baslangic.this, HayvanlarActivity.class);
        startActivity(intent);
        finish();

    }
    public void renklerplay(View view) {
        Intent intentx = new Intent(Baslangic.this, RenklerActivity.class);
        startActivity(intentx);
        finish();

    }

    public void meyvelerplay(View view) {
        Intent intenty = new Intent(Baslangic.this, MeyvelerActivity.class);
        startActivity(intenty);
        finish();
    }

}