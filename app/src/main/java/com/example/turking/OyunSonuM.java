package com.example.turking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OyunSonuM extends AppCompatActivity {

    TextView tvPointsM, tvPersonalBestM;
    SharedPreferences sharedPreferencesM;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_sonum);
        int puanM = getIntent().getExtras().getInt("puanM");
        tvPointsM = findViewById(R.id.tvPointsM);
        tvPersonalBestM = findViewById(R.id.tvPersonalBestM);
        tvPointsM.setText("" + puanM);
        sharedPreferencesM = getSharedPreferences("prefM", 0);
        int pointsSM = sharedPreferencesM.getInt("pointsSM", 0);
        SharedPreferences.Editor editor = sharedPreferencesM.edit();
        if(puanM > pointsSM){
            pointsSM = puanM;
            editor.putInt("pointsSM", pointsSM);
            editor.commit();
        }
        tvPersonalBestM.setText("" + pointsSM);
    }

    public void restart(View view) {
        Intent intent = new Intent(OyunSonuM.this, MeyvelerActivity.class);
        startActivity(intent);
        finish();
    }
    public void geridon(View view) {
        Intent intent = new Intent(OyunSonuM.this, Baslangic.class);
        startActivity(intent);
        finish();
    }


    public void exit(View view) {
        finish();
    }
}