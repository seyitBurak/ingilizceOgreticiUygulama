package com.example.turking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class kelimehard extends AppCompatActivity {

    TextView tv3;
    Button bt6;

    private String kelimeler2 [] = {"Actually    ( Aslında )","Adult     ( Yetişkin )","Budget      ( Bütçe )","Candidate      ( Aday )","Bill      ( Fatura )","Behavior      ( Davranış )","Candidate    (Aday )","Cell      ( Hücre )","Chair     (Sandalye )","Choice    ( Seçim )","Claim     (İddia )","Common (Ortak )","Consumer    ( Tüketici )","Decision     ( Karar )","Degree     ( Derece )","Evidence    ( Delil )","Fact     ( Gerçek )","Fail     ( Başarısız )","Floor     ( Zemin )","Foreign      ( Yabancı )","Government     ( Hükümet )","Interview     ( Röportaj )","Language     ( Dil )","Laugh     ( Gülmek )","Letter     ( Mektup )","Meeting     ( Toplantı )","Method      ( Yöntem )","Might     ( Belki )","Necessary     ( Gerekli )","Notice      ( İhbar )","Official       ( Resmi )","Opportunity      ( Fırsat )","Practice     ( Uygulama )","Production     ( Üretim )","Protect       ( Korumak )","Quality      ( Kalite )","Reach     ( Ulaşmak )","Reason     ( Neden )","Region     ( Bölge )","Rule     ( Kural )","Sell    ( Satmak )","Source     ( Kaynak )","Speech      ( Konuşma )","Street    ( Sokak )","Structure     ( Yapı )","Suddenly     ( Aniden )","Tax    ( Vergi )","Threat     ( Tehdit )","Wrong      ( Yanlış )"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelimehard);

        tv3 = (TextView) findViewById(R.id.tv3);
        bt6 = (Button) findViewById(R.id.bt6);

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int num2 =random.nextInt(kelimeler2.length);
                tv3.setText(kelimeler2[num2]);

            }
        });


    }
}