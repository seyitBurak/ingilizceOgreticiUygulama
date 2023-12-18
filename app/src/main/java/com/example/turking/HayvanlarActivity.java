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

public class HayvanlarActivity extends AppCompatActivity {
    TextView tvZaman;
    ImageView Resim;
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> hayvanListe = new ArrayList<>();
    int indexH;
    Button btn1, btn2, btn3, btn4;
    TextView tvPoints;
    int points;
    CountDownTimer countDownTimer;
    long millisUntilFinished;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayvanlar);
        tvZaman = findViewById(R.id.tvZamanM);
        Resim = findViewById(R.id.Resim);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        tvPoints = findViewById(R.id.tvPoints);
        indexH = 0;
        hayvanListe.add("Cat");
        hayvanListe.add("Dog");
        hayvanListe.add("LION");
        hayvanListe.add("Butterfly");
        hayvanListe.add("Horse");
        hayvanListe.add("Bear");
        hayvanListe.add("Gazelle");
        hayvanListe.add("TIGER");
        hayvanListe.add("Shark");
        hayvanListe.add("Monkey");
        hayvanListe.add("Parrot");
        hayvanListe.add("SQUIRREL");
        hayvanListe.add("CHICKEN");
        hayvanListe.add("Wolf");
        hayvanListe.add("Snake");
        map.put(hayvanListe.get(0), R.drawable.kedi);
        map.put(hayvanListe.get(1), R.drawable.kopek);
        map.put(hayvanListe.get(2), R.drawable.aslan);
        map.put(hayvanListe.get(3), R.drawable.kelebek);
        map.put(hayvanListe.get(4), R.drawable.at);
        map.put(hayvanListe.get(5), R.drawable.ayi);
        map.put(hayvanListe.get(6), R.drawable.ceylan);
        map.put(hayvanListe.get(7), R.drawable.kaplan);
        map.put(hayvanListe.get(8), R.drawable.kopekbaligi);
        map.put(hayvanListe.get(9), R.drawable.maymun);
        map.put(hayvanListe.get(10), R.drawable.papagan);
        map.put(hayvanListe.get(11), R.drawable.sincap);
        map.put(hayvanListe.get(12), R.drawable.tavuk);
        map.put(hayvanListe.get(13), R.drawable.wolf);
        map.put(hayvanListe.get(14), R.drawable.yilan);

        Collections.shuffle(hayvanListe);
        millisUntilFinished = 10000;
        points = 0;
        startGame();
    }

    private void startGame() {
        millisUntilFinished = 10000;
        tvZaman.setText("" + (millisUntilFinished / 1000) + "s");
        tvPoints.setText(points + " / " + hayvanListe.size());
        generateQuestions(indexH);
        countDownTimer = new CountDownTimer(millisUntilFinished, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvZaman.setText("" + (millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                indexH++;
                if (indexH > hayvanListe.size() - 1){
                    Resim.setVisibility(View.GONE);
                    btn1.setVisibility(View.GONE);
                    btn2.setVisibility(View.GONE);
                    btn3.setVisibility(View.GONE);
                    btn4.setVisibility(View.GONE);
                    Intent intentbb = new Intent(HayvanlarActivity.this, OyunSonuH.class);
                    intentbb.putExtra("points", points);
                    startActivity(intentbb);
                    finish();
                } else {
                    countDownTimer = null;
                    startGame();
                }
            }
        }.start();
    }

    private void generateQuestions(int indexH) {
        ArrayList<String> hayvanListe2 = (ArrayList<String>) hayvanListe.clone();
        String correctAnswer = hayvanListe.get(indexH);
        hayvanListe2.remove(correctAnswer);
        Collections.shuffle(hayvanListe2);
        ArrayList<String> newList = new ArrayList<>();
        newList.add(hayvanListe2.get(0));
        newList.add(hayvanListe2.get(1));
        newList.add(hayvanListe2.get(2));
        newList.add(correctAnswer);
        Collections.shuffle(newList);
        btn1.setText(newList.get(0));
        btn2.setText(newList.get(1));
        btn3.setText(newList.get(2));
        btn4.setText(newList.get(3));
        Resim.setImageResource(map.get(hayvanListe.get(indexH)));
    }

    public void nextQuestion(View view) {
        btn1.setBackgroundColor(Color.parseColor("#FBC02D"));
        btn2.setBackgroundColor(Color.parseColor("#FBC02D"));
        btn3.setBackgroundColor(Color.parseColor("#FBC02D"));
        btn4.setBackgroundColor(Color.parseColor("#FBC02D"));
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        countDownTimer.cancel();
        indexH++;
        if (indexH > hayvanListe.size() - 1){
            Resim.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
            Intent intent1 = new Intent(HayvanlarActivity.this, OyunSonuH.class);
            intent1.putExtra("points", points);
            startActivity(intent1);
            finish();
        } else {
            countDownTimer = null;
            startGame();
        }
    }

    public void answerSelected(View view) {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        countDownTimer.cancel();
        String answer = ((Button) view).getText().toString().trim();
        String correctAnswer = hayvanListe.get(indexH);
        if(answer.equals(correctAnswer)){
            points++;
            tvPoints.setText(points + " / " + hayvanListe.size());
            view.setBackgroundColor(Color.parseColor("#9600FF00"));
        } else {
            view.setBackgroundColor(Color.parseColor("#96FF0000"));
        }
    }
}