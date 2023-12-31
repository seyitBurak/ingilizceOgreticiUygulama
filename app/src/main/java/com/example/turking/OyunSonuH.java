package com.example.turking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OyunSonuH extends AppCompatActivity {

    TextView tvPoints, tvPersonalBestH;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_sonuh);
        int points = getIntent().getExtras().getInt("points");
        tvPoints = findViewById(R.id.tvPoints);
        tvPersonalBestH = findViewById(R.id.tvPersonalBestH);
        tvPoints.setText("" + points);
        sharedPreferences = getSharedPreferences("pref", 0);
        int pointsSP = sharedPreferences.getInt("pointsSP", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(points > pointsSP){
            pointsSP = points;
            editor.putInt("pointsSP", pointsSP);
            editor.commit();
        }
        tvPersonalBestH.setText("" + pointsSP);
    }

    public void restart(View view) {
        Intent intent = new Intent(OyunSonuH.this, HayvanlarActivity.class);
        startActivity(intent);
        finish();
    }

    public void geridon(View view) {
        Intent intent = new Intent(OyunSonuH.this, Baslangic.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view) {
        finish();
    }
}