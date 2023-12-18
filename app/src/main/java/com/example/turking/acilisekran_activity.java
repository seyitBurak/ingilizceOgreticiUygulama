package com.example.turking;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class acilisekran_activity extends gericikma {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acilisekran);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent ıntent=new Intent(acilisekran_activity.this,anasayfa_activity.class);
                startActivity(ıntent);
                finish();

            }
        },2000);
    }
}