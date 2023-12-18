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

public class RenklerActivity extends AppCompatActivity {
    TextView tvZamanR;
    ImageView ResimR;
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> renklerListe = new ArrayList<>();
    int indexR;
    Button btn1R, btn2R, btn3R, btn4R;
    TextView tvPointsR;
    int pointsR;
    CountDownTimer countDownTimer;
    long millisUntilFinished;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renkler);
        tvZamanR = findViewById(R.id.tvZamanR);
        ResimR = findViewById(R.id.ResimR);
        btn1R = findViewById(R.id.btn1R);
        btn2R = findViewById(R.id.btn2R);
        btn3R = findViewById(R.id.btn3R);
        btn4R = findViewById(R.id.btn4R);
        tvPointsR = findViewById(R.id.tvPointsR);
        indexR = 0;
        renklerListe.add("Burgundy");
        renklerListe.add("Gray");
        renklerListe.add("Green");
        renklerListe.add("Purple");
        renklerListe.add("Brown");
        renklerListe.add("Orange");
        renklerListe.add("Yellow");
        renklerListe.add("PINK");
        renklerListe.add("Blue");
        renklerListe.add("Red");
        renklerListe.add("Black");
        map.put(renklerListe.get(0), R.drawable.bordo);
        map.put(renklerListe.get(1), R.drawable.gri);
        map.put(renklerListe.get(2), R.drawable.yesil);
        map.put(renklerListe.get(3), R.drawable.mor);
        map.put(renklerListe.get(4), R.drawable.brown);
        map.put(renklerListe.get(5), R.drawable.turuncu);
        map.put(renklerListe.get(6), R.drawable.sari);
        map.put(renklerListe.get(7), R.drawable.pembe);
        map.put(renklerListe.get(8), R.drawable.mavi);
        map.put(renklerListe.get(9), R.drawable.kirmizi);
        map.put(renklerListe.get(10), R.drawable.siyah);


        Collections.shuffle(renklerListe);
        millisUntilFinished = 10000;
        pointsR = 0;
        startGame();
    }

    private void startGame() {
        millisUntilFinished = 10000;
        tvZamanR.setText("" + (millisUntilFinished / 1000) + "s");
        tvPointsR.setText(pointsR + " / " + renklerListe.size());
        generateQuestions(indexR);
        countDownTimer = new CountDownTimer(millisUntilFinished, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvZamanR.setText("" + (millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                indexR++;
                if (indexR > renklerListe.size() - 1){
                    ResimR.setVisibility(View.GONE);
                    btn1R.setVisibility(View.GONE);
                    btn2R.setVisibility(View.GONE);
                    btn3R.setVisibility(View.GONE);
                    btn4R.setVisibility(View.GONE);
                    Intent intent4 = new Intent(RenklerActivity.this, OyunSonuR.class);
                    intent4.putExtra("puanR", pointsR);
                    startActivity(intent4);
                    finish();
                } else {
                    countDownTimer = null;
                    startGame();
                }
            }
        }.start();
    }

    private void generateQuestions(int indexR) {
        ArrayList<String> renklerListe2 = (ArrayList<String>) renklerListe.clone();
        String correctAnswer = renklerListe.get(indexR);
        renklerListe2.remove(correctAnswer);
        Collections.shuffle(renklerListe2);
        ArrayList<String> newList = new ArrayList<>();
        newList.add(renklerListe2.get(0));
        newList.add(renklerListe2.get(1));
        newList.add(renklerListe2.get(2));
        newList.add(correctAnswer);
        Collections.shuffle(newList);
        btn1R.setText(newList.get(0));
        btn2R.setText(newList.get(1));
        btn3R.setText(newList.get(2));
        btn4R.setText(newList.get(3));
        ResimR.setImageResource(map.get(renklerListe.get(indexR)));
    }

    public void nextQuestion(View view) {
        btn1R.setBackgroundColor(Color.parseColor("#FBC02D"));
        btn2R.setBackgroundColor(Color.parseColor("#FBC02D"));
        btn3R.setBackgroundColor(Color.parseColor("#FBC02D"));
        btn4R.setBackgroundColor(Color.parseColor("#FBC02D"));
        btn1R.setEnabled(true);
        btn2R.setEnabled(true);
        btn3R.setEnabled(true);
        btn4R.setEnabled(true);
        countDownTimer.cancel();
        indexR++;
        if (indexR > renklerListe.size() - 1){
            ResimR.setVisibility(View.GONE);
            btn1R.setVisibility(View.GONE);
            btn2R.setVisibility(View.GONE);
            btn3R.setVisibility(View.GONE);
            btn4R.setVisibility(View.GONE);
            Intent intentcc = new Intent(RenklerActivity.this, OyunSonuR.class);
            intentcc.putExtra("puanR", pointsR);
            startActivity(intentcc);
            finish();
        } else {
            countDownTimer = null;
            startGame();
        }
    }

    public void answerSelected(View view) {
        btn1R.setEnabled(false);
        btn2R.setEnabled(false);
        btn3R.setEnabled(false);
        btn4R.setEnabled(false);
        countDownTimer.cancel();
        String answer = ((Button) view).getText().toString().trim();
        String correctAnswer = renklerListe.get(indexR);
        if(answer.equals(correctAnswer)){
            pointsR++;
            tvPointsR.setText(pointsR + " / " + renklerListe.size());
            view.setBackgroundColor(Color.parseColor("#9600FF00"));
        } else {
            view.setBackgroundColor(Color.parseColor("#96FF0000"));
        }
    }
}