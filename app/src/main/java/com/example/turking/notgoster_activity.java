package com.example.turking;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;


public class notgoster_activity extends gericikma {
    ListView lv;
    Button ekle, anasayfa;
    notveritabani vt;
    int image[] = {R.drawable.ic_notdefterisimgesi};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notgoster);

        ekle = findViewById(R.id.ekle);
        lv = findViewById(R.id.list_view);
        anasayfa = findViewById(R.id.notdefter);
        vt = new notveritabani(this);


        SQLiteDatabase dc = vt.getReadableDatabase();
        Cursor cursor = dc.rawQuery("Select * from notdefteri", null);
        ArrayList<String> türks = new ArrayList<String>();
        ArrayList<String> ings = new ArrayList<String>();
        ArrayList<String> nots = new ArrayList<String>();
        ArrayList<String> tarihs = new ArrayList<String>();
        ArrayList<String> saats = new ArrayList<String>();


        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            türks.add(cursor.getString(2));
            ings.add(cursor.getString(3));
            nots.add(cursor.getString(1));
            tarihs.add(cursor.getString(4));
            saats.add(cursor.getString(5));
        }

        ArrayAdapter<String> asd = new
                ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, türks);

        ArrayAdapter<String> asdasd = new
                ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, ings);

        ArrayAdapter<String> asasdad = new
                ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, nots);

        ArrayAdapter<String> asassdd = new
                ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, tarihs);

        ArrayAdapter<String> aadsdsd = new
                ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, saats);


        Myadapter mysadapter = new Myadapter(this, türks, ings, nots, tarihs, saats, image);
        lv.setAdapter(mysadapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder diyalogolusturucu = new AlertDialog.Builder(notgoster_activity.this);


                SQLiteDatabase dboku = vt.getReadableDatabase();
                Cursor cursor = dboku.rawQuery("Select * from notdefteri", null);
                ArrayList<String> idliste = new ArrayList<String>();
                for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    idliste.add(cursor.getString(0));
                }
                ArrayAdapter<String> Adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, idliste);

                String veriid = Adapter.getItem(position);

                diyalogolusturucu.setMessage("Not Silinsin mi?")

                        .setCancelable(false)
                        .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                SQLiteDatabase db = vt.getWritableDatabase();

                                String[] dizi = {veriid};
                                db.delete("notdefteri", "id=?", dizi);
                                finish();
                                startActivity(getIntent());
                                Toast.makeText(notgoster_activity.this, "Not Silindi", Toast.LENGTH_SHORT).show();


                            }
                        }).setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                dialogInterface.dismiss();
                            }
                        });
                diyalogolusturucu.create().show();

            }
        });


        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ıntent = new Intent(getApplicationContext(), noteekle_activity.class);
                startActivity(ıntent);
            }
        });
        anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ıntent = new Intent(getApplicationContext(), anasayfa_activity.class);
                startActivity(ıntent);
            }
        });
    }

    class Myadapter extends ArrayAdapter<String> {

        Context context;
        ArrayList ringilize;
        ArrayList rtürkçe;
        ArrayList rnot;
        ArrayList rtarih;
        ArrayList rsaat;
        int rimg[];

        Myadapter(Context c, ArrayList türkçe, ArrayList ingilize, ArrayList not, ArrayList tarih, ArrayList saat, int imgs[]) {
            super(c, R.layout.listview_ozellestirme, R.id.txttürkce, not);

            this.context = c;
            this.rnot = not;
            this.rtürkçe = türkçe;
            this.ringilize = ingilize;
            this.rtarih = tarih;
            this.rsaat = saat;
            this.rimg = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.listview_ozellestirme, parent, false);
            ImageView images = row.findViewById(R.id.resim);
            TextView mytürkçe = row.findViewById(R.id.txttürkce);
            TextView myingilizce = row.findViewById(R.id.txtingilizce);
            TextView mynot = row.findViewById(R.id.txtnot);
            TextView mytarih = row.findViewById(R.id.txttarih);
            TextView mysaat = row.findViewById(R.id.txtsaat);

            images.setImageResource(rimg[0]);
            mynot.setText((CharSequence) rnot.get(position));
            mytürkçe.setText((CharSequence) rtürkçe.get(position));
            myingilizce.setText((CharSequence) ringilize.get(position));
            mytarih.setText((CharSequence) rtarih.get(position));
            mysaat.setText((CharSequence) rsaat.get(position));

            return (row);


        }
    }
}