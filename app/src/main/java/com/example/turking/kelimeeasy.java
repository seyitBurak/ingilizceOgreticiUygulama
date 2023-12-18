package com.example.turking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class kelimeeasy extends AppCompatActivity {
    TextView tv1;
    Button bt4;

    private String kelimeler [] = {"Add   ( Eklemek )","Addition   ( Ek Olarak )","Again   ( Tekrar )","Age      ( Yaş )","After   ( Sonra )","Beautiful   ( Güzel )","Color   ( Renk )","Data    ( Veri )","Die   ( Ölmek )","Dog   ( Köpek )","Eye     ( Göz )","Face    ( Yüz )","Free   ( Ücretsiz )","Garden   ( Bahçe )","Happy   ( Mutlu )","Hair     ( Saç )","Fast   ( Hızlı )","If       ( Eğer )","Finger   ( Parmak )","Item     ( Öğe )","Key   ( Anahtar )","Life    ( Hayat )","Memory    ( Hafıza )","More    ( Daha )","Network     ( Ağ )","Paper   ( Kağıt )","Pretty   ( Güzel )","Race    ( Yarış )","Senior    ( Kıdemli )","Skill    ( Beceri )","Store     ( Mağaza ) ","Success     ( Başarı )","Trade    ( Ticaret )","Time    ( Zaman ) ","Training     ( Eğitim )","Trip   ( Yolculuk )","Window    ( Pencere )","Word    ( Kelime )","Writer   ( Yazar )","Wait   ( Beklemek )","Year   ( Yıl )","Before     ( önce )","Answer    ( Cevap )"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimeeasy);

        tv1 = (TextView) findViewById(R.id.tv1);
        bt4 = (Button) findViewById(R.id.bt4);

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int num =random.nextInt(kelimeler.length);
                tv1.setText(kelimeler[num]);
            }
        });

    }
}