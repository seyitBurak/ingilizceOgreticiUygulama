package com.example.turking;

import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class gericikma extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertdialog=new AlertDialog.Builder(this);
        alertdialog.setMessage("Kapatmak istediğinizden emin misiniz?");
        alertdialog.setCancelable(false).setPositiveButton("Evet", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);

            }
        }).setNegativeButton("Hayır", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        AlertDialog alert=alertdialog.create();
        alert.show();
    }
}
