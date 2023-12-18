package com.example.turking;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Locale;

public class noteekle_activity extends gericikma {

    int saat, dakika;
    int y, g, a, seçilentarihid;
    CalendarView takvims;
    EditText türkçe, ingilizce, not;
    Button butonsaat, buttonkaydet;
    Button anasayfagit, notekle;
    String seçilensaat, seçilentarih, seçilengün;
    notveritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noteekle);

        vt = new notveritabani(this);
        not = findViewById(R.id.not_icerik);
        türkçe = findViewById(R.id.Turkce);
        ingilizce = findViewById(R.id.ingilizce);
        takvims = findViewById(R.id.takvim);
        butonsaat = findViewById(R.id.buttonsaat);
        buttonkaydet = findViewById(R.id.kaydet);

        anasayfagit = findViewById(R.id.ansfy);
        notekle = findViewById(R.id.kayıt);

        anasayfagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ıntent = new Intent(getApplicationContext(), anasayfa_activity.class);
                startActivity(ıntent);
                finish();
            }
        });
        notekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntents = new Intent(getApplicationContext(), notgoster_activity.class);
                startActivity(ıntents);
                finish();
            }
        });


        takvims.setOnDateChangeListener((view, yıl, ay, gun) -> {

            y = yıl;
            g = gun;
            a = ay + 1;

            String birlesik = String.valueOf(g) + String.valueOf(a) + String.valueOf(y);
            seçilentarihid = Integer.valueOf(birlesik);
            seçilentarih = g + "/" + a + "/" + y;


        });

    }

    public void popTİmePicker(View view) {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int secilensaat, int secilendakika) {
                saat = secilensaat;
                dakika = secilendakika;
                butonsaat.setText(String.format(Locale.getDefault(), "%02d:%02d", saat, dakika));
                seçilensaat = butonsaat.getText().toString();
            }
        };

        int style = AlertDialog.BUTTON_POSITIVE;
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, saat, dakika, true);
        timePickerDialog.setTitle("Saat Seçiniz");
        timePickerDialog.show();

    }

    public void Kaydet(View view) {


        SQLiteDatabase db = vt.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("id", seçilentarihid + saat + dakika);
        cv.put("note", not.getText().toString());
        cv.put("trk", türkçe.getText().toString());
        cv.put("ing", ingilizce.getText().toString());
        cv.put("tarih", seçilentarih);
        cv.put("saat", seçilensaat);

        db.insert("notdefteri", null, cv);

        not.setText("");
        türkçe.setText("");
        ingilizce.setText("");
        butonsaat.setText("Saat");

        Intent ıntent = new Intent(getApplicationContext(), notgoster_activity.class);
        startActivity(ıntent);
        finish();


    }


}