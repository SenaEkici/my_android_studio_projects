package com.example.lenovo.projem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Intent i;
    Button b_pc;
    Button b_oyuncu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_pc=(Button) findViewById(R.id.btn_pc);
        b_oyuncu=(Button) findViewById(R.id.btn_oyuncu);
        b_pc.setOnClickListener(this);
        b_oyuncu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(b_pc)) {
            i = new Intent(MainActivity.this, KimBasliyacak1.class);
            startActivity(i);
        }
        else if(view.equals(b_oyuncu)){
            i=new Intent(this,OyunSayfasi.class);
            startActivity(i);
        }
    }
}
