package com.example.turking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class kelimemedium extends AppCompatActivity {

    TextView tv2;
    Button bt5;

    private String kelimeler1 [] = {"Ability   (  Kabiliyet )","About       ( Hakkında )","Behind   ( Arkasında )","Account     ( Hesap )","Blood   (  Kan )","Believe     ( İnanmak )","Center      ( Merkez )","Crime    ( Suç )","Design     ( Tasarım )","Detail    ( Ayrıntı )","Early      ( Erken )","Enter    ( Girmek )","Event       ( Olay )","Example     ( Örnek )","Fact     ( Gerçek )","Difficult    ( Zor )","Dinner      ( Akşam Yemeği )","Enough    ( Yeterli )","Guess   ( Tahmin )","Heavy     ( Ağır )","Hope     ( Umut )","Important    ( Önemli )","Information    ( Bilgi )","Lawyer        ( Avukat )","Line     ( Çizgi )","Method     ( Yöntem )","Option    ( Seçenek )","Other    ( Diğer )","Peace    (Barış )","Picture     ( Resim )","Plant      ( Bitki )","Product     ( Ürün )","Research     ( Araştırma )","Result     ( Sonuç )","Rest      ( Dinlenme )","Room      ( Oda )","Shoulder     ( Omuz )","Society       ( Toplum )","Stay      ( Kalmak )","Summer      ( Yaz )","Task      ( Görev )","Violence      ( Şiddet )","Yourself      ( Kendi )"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimemedium);

        tv2 = (TextView) findViewById(R.id.tv3);
        bt5 = (Button) findViewById(R.id.bt5);

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int num1 =random.nextInt(kelimeler1.length);
                tv2.setText(kelimeler1[num1]);

            }
        });


    }
}