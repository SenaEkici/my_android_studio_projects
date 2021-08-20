package com.example.lenovo.odev2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b_imsi, b_imei, b_sim, b_mac, b_hepsi, b_cikis;
    TelephonyManager telefon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_imsi = (Button) findViewById(R.id.b_imsi);
        b_imei = (Button) findViewById(R.id.b_imei);
        b_sim = (Button) findViewById(R.id.b_sim);
        b_mac = (Button) findViewById(R.id.b_mac);
        b_hepsi = (Button) findViewById(R.id.b_hepsi);
        b_cikis = (Button) findViewById(R.id.b_cikis);
        b_imsi.setOnClickListener(this);
        b_imei.setOnClickListener(this);
        b_sim.setOnClickListener(this);
        b_mac.setOnClickListener(this);
        b_hepsi.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        telefon = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (view.equals(b_imsi)) {
            Intent gir = new Intent(this, Main2Activity.class);

                String imsi = telefon.getSubscriberId().toString();


            startActivity(gir);
        }
    }
}
