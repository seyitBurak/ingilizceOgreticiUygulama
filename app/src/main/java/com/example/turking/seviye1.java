package com.example.turking;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class seviye1 extends gericikma implements View.OnClickListener {

    TextView toplamsoru, sayaç;
    TextView soruyaz;
    Button asikki, bsikki, csikki, dsikki;
    Button devamet;

    int puan = 0;
    int toplamsorusayısı = Sorular.soru1.length;
    int dizi = 0;
    int sorusayacı= 0;
    String secilencevap = "";


    CountDownTimer gerisayım;
    long gerisayımsayacı;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        toplamsoru = findViewById(R.id.toplamsoru);
        soruyaz = findViewById(R.id.sorular);
        asikki = findViewById(R.id.sık_a);
        bsikki = findViewById(R.id.sık_b);
        csikki = findViewById(R.id.sık_c);
        dsikki = findViewById(R.id.sık_d);
        devamet = findViewById(R.id.devam_et);
        sayaç = findViewById(R.id.Sayaç);

        asikki.setOnClickListener(this);
        bsikki.setOnClickListener(this);
        csikki.setOnClickListener(this);
        dsikki.setOnClickListener(this);
        devamet.setOnClickListener(this);


        toplamsoru.setText("Soru:" + toplamsorusayısı);

        Yenisoru();
        gerisayımsayacı = 5000;


        Button anasayffs = findViewById(R.id.buttonanasayfa);

        anasayffs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ıntent = new Intent(getApplicationContext(), anasayfa_activity.class);
                startActivity(ıntent);
            }
        });

    }

    @Override
    public void onClick(View view) {


        asikki.setBackgroundColor(Color.parseColor("#00bfff"));
        bsikki.setBackgroundColor(Color.parseColor("#00bfff"));
        csikki.setBackgroundColor(Color.parseColor("#00bfff"));
        dsikki.setBackgroundColor(Color.parseColor("#00bfff"));

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.devam_et) {
            if (secilencevap.equals(Sorular.cevap1[dizi])) {
                puan++;
            }
            dizi++;
            gerisayım.cancel();
            Yenisoru();


        } else {

            secilencevap = clickedButton.getText().toString();
            if (secilencevap.equals(Sorular.cevap1[dizi])) {
                clickedButton.setBackgroundColor(Color.GREEN);

            } else {
                clickedButton.setBackgroundColor(Color.RED);

            }
            asikki.setEnabled(false);
            bsikki.setEnabled(false);
            csikki.setEnabled(false);
            dsikki.setEnabled(false);


        }

    }

    void Yenisoru() {

        gerisayımsayacı = 5000;
        sayaç.setText("" + (gerisayımsayacı / 1000) + "s");
        gerisayım = new CountDownTimer(gerisayımsayacı, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sayaç.setText("" + (millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                asikki.setBackgroundColor(Color.parseColor("#00bfff"));
                bsikki.setBackgroundColor(Color.parseColor("#00bfff"));
                csikki.setBackgroundColor(Color.parseColor("#00bfff"));
                dsikki.setBackgroundColor(Color.parseColor("#00bfff"));
                dizi++;
                Yenisoru();


            }
        }.start();


        if (dizi == toplamsorusayısı) {
            testbitir();
            gerisayım.cancel();
            return;
        }

        soruyaz.setText(Sorular.soru1[dizi]);
        asikki.setText(Sorular.sıklar1[dizi][0]);
        bsikki.setText(Sorular.sıklar1[dizi][1]);
        csikki.setText(Sorular.sıklar1[dizi][2]);
        dsikki.setText(Sorular.sıklar1[dizi][3]);
        asikki.setEnabled(true);
        bsikki.setEnabled(true);
        csikki.setEnabled(true);
        dsikki.setEnabled(true);
        int a = toplamsorusayısı-sorusayacı;
        sorusayacı++;
        toplamsoru.setText("Soru:" + a);


    }

    void testbitir() {
        String passStatus = "";
        if (puan > toplamsorusayısı * 0.90) {
            passStatus = "Başarılı";
            gerisayım.cancel();
        } else {
            passStatus = "Tekrar Deneyiniz";
        }
        Intent a = new Intent(getApplicationContext(), seviye2.class);
        Intent b = new Intent(getApplicationContext(), anasayfa_activity.class);
        Intent c = new Intent(getApplicationContext(), seviye1.class);

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Puan: " + puan + " Toplam puan: " + toplamsorusayısı)
                .setPositiveButton("Tekrar", (dialogInterface, i) -> tekrardene())
                .setNeutralButton("Ana Menü", (dialogInterface, i) -> startActivity(b))
                .setCancelable(false)
                .show();

        if (puan == 15) {
            new AlertDialog.Builder(this)
                    .setTitle(passStatus)
                    .setMessage("Puan: " + puan + " Toplam puan: " + toplamsorusayısı)
                    .setPositiveButton("Tekrar Dene", (dialogInterface, i) -> startActivity(c))
                    .setNegativeButton("Seviye 2", (dialogInterface, i) -> startActivity(a))
                    .setNeutralButton("Ana Menü", (dialogInterface, i) -> startActivity(b))
                    .setCancelable(false)
                    .show();
            gerisayım.cancel();
        }


    }

    void tekrardene() {
        puan = 0;
        dizi = 0;
        sorusayacı=0;
        Yenisoru();
    }
}