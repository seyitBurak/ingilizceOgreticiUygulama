package com.example.turking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OyunSonuR extends AppCompatActivity {

    TextView tvPointsR, tvPersonalBestR;
    SharedPreferences sharedPreferencesR;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_sonur);
        int puanR = getIntent().getExtras().getInt("puanR");
        tvPointsR = findViewById(R.id.tvPointsR);
        tvPersonalBestR = findViewById(R.id.tvPersonalBestR);
        tvPointsR.setText("" + puanR);
        sharedPreferencesR = getSharedPreferences("prefR", 0);
        int pointsSR = sharedPreferencesR.getInt("pointsSR", 0);
        SharedPreferences.Editor editor = sharedPreferencesR.edit();
        if(puanR > pointsSR){
            pointsSR = puanR;
            editor.putInt("pointsSR", pointsSR);
            editor.commit();
        }
        tvPersonalBestR.setText("" + pointsSR);
    }

    public void restart(View view) {
        Intent intent = new Intent(OyunSonuR.this, RenklerActivity.class);
        startActivity(intent);
        finish();
    }

    public void geridon(View view) {
        Intent intent = new Intent(OyunSonuR.this, Baslangic.class);
        startActivity(intent);
        finish();
    }


    public void exit(View view) {
        finish();
    }
}