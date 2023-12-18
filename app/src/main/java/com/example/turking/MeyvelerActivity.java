package com.example.turking;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MeyvelerActivity extends AppCompatActivity {
    TextView tvZamanM;
    ImageView ResimM;
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> meyveListe = new ArrayList<>();
    int indexM;
    Button btn1M, btn2M, btn3M, btn4M;
    TextView tvPointsM;
    int pointsM;
    CountDownTimer countDownTimer;
    long millisUntilFinished;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meyveler);
        tvZamanM = findViewById(R.id.tvZamanM);
        ResimM = findViewById(R.id.ResimM);
        btn1M = findViewById(R.id.btn1M);
        btn2M= findViewById(R.id.btn2M);
        btn3M= findViewById(R.id.btn3M);
        btn4M= findViewById(R.id.btn4M);
        tvPointsM = findViewById(R.id.tvPointsM);
        indexM = 0;
        meyveListe.add("APPLE");
        meyveListe.add("BANANA");
        meyveListe.add("MELON");
        meyveListe.add("WATERMELON");
        meyveListe.add("RASPBERRY");
        meyveListe.add("STRAWBERRY");
        meyveListe.add("MANDARIN");
        meyveListe.add("PINEAPPLE");
        meyveListe.add("PEAR");
        meyveListe.add("PEACH");
        meyveListe.add("KIWI");
        meyveListe.add("GRAPE");
        meyveListe.add("COCONUT");
        meyveListe.add("CHERRY");
        meyveListe.add("LEMON");
        meyveListe.add("WALNUT");
        meyveListe.add("HAZELNUT");
        meyveListe.add("GRAPEFRUIT");
        meyveListe.add("POMEGRANATE");
        meyveListe.add("BLUEBERRIES");
        map.put(meyveListe.get(0), R.drawable.elma);
        map.put(meyveListe.get(1), R.drawable.muz);
        map.put(meyveListe.get(2), R.drawable.kavun);
        map.put(meyveListe.get(3), R.drawable.karpuz);
        map.put(meyveListe.get(4), R.drawable.ahududu);
        map.put(meyveListe.get(5), R.drawable.cilek);
        map.put(meyveListe.get(6), R.drawable.mandalina);
        map.put(meyveListe.get(7), R.drawable.ananas);
        map.put(meyveListe.get(8), R.drawable.armut);
        map.put(meyveListe.get(9), R.drawable.seftali);
        map.put(meyveListe.get(10), R.drawable.kivi);
        map.put(meyveListe.get(11), R.drawable.grape);
        map.put(meyveListe.get(12), R.drawable.coconut);
        map.put(meyveListe.get(13), R.drawable.kiraz);
        map.put(meyveListe.get(14), R.drawable.limon);
        map.put(meyveListe.get(15), R.drawable.ceviz);
        map.put(meyveListe.get(16), R.drawable.findik);
        map.put(meyveListe.get(17), R.drawable.greyfurt);
        map.put(meyveListe.get(18), R.drawable.nar);
        map.put(meyveListe.get(19), R.drawable.yabanmersini);

        Collections.shuffle(meyveListe);
        millisUntilFinished = 10000;
        pointsM = 0;
        startGame();
    }

    private void startGame() {
        millisUntilFinished = 10000;
        tvZamanM.setText("" + (millisUntilFinished / 1000) + "s");
        tvPointsM.setText(pointsM + " / " + meyveListe.size());
        generateQuestions(indexM);
        countDownTimer = new CountDownTimer(millisUntilFinished, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvZamanM.setText("" + (millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                indexM++;
                if (indexM >  meyveListe.size() - 1){
                    ResimM.setVisibility(View.GONE);
                    btn1M.setVisibility(View.GONE);
                    btn2M.setVisibility(View.GONE);
                    btn3M.setVisibility(View.GONE);
                    btn4M.setVisibility(View.GONE);
                    Intent intent2 = new Intent(MeyvelerActivity.this, OyunSonuM.class);
                    intent2.putExtra("puanM", pointsM);
                    startActivity(intent2);
                    finish();
                } else {
                    countDownTimer = null;
                    startGame();
                }
            }
        }.start();
    }

    private void generateQuestions(int indexM) {
        ArrayList<String> meyveListe2 = (ArrayList<String>) meyveListe.clone();
        String correctAnswer = meyveListe.get(indexM);
        meyveListe2.remove(correctAnswer);
        Collections.shuffle(meyveListe2);
        ArrayList<String> newList = new ArrayList<>();
        newList.add(meyveListe2.get(0));
        newList.add(meyveListe2.get(1));
        newList.add(meyveListe2.get(2));
        newList.add(correctAnswer);
        Collections.shuffle(newList);
        btn1M.setText(newList.get(0));
        btn2M.setText(newList.get(1));
        btn3M.setText(newList.get(2));
        btn4M.setText(newList.get(3));
        ResimM.setImageResource(map.get(meyveListe.get(indexM)));
    }

    public void nextQuestion(View view) {
        btn1M.setBackgroundColor(Color.parseColor("#FBC02D"));
        btn2M.setBackgroundColor(Color.parseColor("#FBC02D"));
        btn3M.setBackgroundColor(Color.parseColor("#FBC02D"));
        btn4M.setBackgroundColor(Color.parseColor("#FBC02D"));
        btn1M.setEnabled(true);
        btn2M.setEnabled(true);
        btn3M.setEnabled(true);
        btn4M.setEnabled(true);
        countDownTimer.cancel();
        indexM++;
        if (indexM > meyveListe.size() - 1){
            ResimM.setVisibility(View.GONE);
            btn1M.setVisibility(View.GONE);
            btn2M.setVisibility(View.GONE);
            btn3M.setVisibility(View.GONE);
            btn4M.setVisibility(View.GONE);
            Intent intentaa = new Intent(MeyvelerActivity.this, OyunSonuM.class);
            intentaa.putExtra("puanM", pointsM);
            startActivity(intentaa);
            finish();
        } else {
            countDownTimer = null;
            startGame();
        }
    }

    public void answerSelected(View view) {
        btn1M.setEnabled(false);
        btn2M.setEnabled(false);
        btn3M.setEnabled(false);
        btn4M.setEnabled(false);
        countDownTimer.cancel();
        String answer = ((Button) view).getText().toString().trim();
        String correctAnswer = meyveListe.get(indexM);
        if(answer.equals(correctAnswer)){
            pointsM++;
            tvPointsM.setText(pointsM + " / " + meyveListe.size());
            view.setBackgroundColor(Color.parseColor("#9600FF00"));
        } else {
            view.setBackgroundColor(Color.parseColor("#96FF0000"));
        }
    }
}