package com.example.lenovo.projem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class KimBasliyacak1 extends AppCompatActivity implements View.OnClickListener {

    Button b_tas,b_kagit,b_makas;
    ImageView img_pc,img_oyuncu;
    String pc_secim,oyuncu_secim;
    Random rnd;
    Intent j;
    boolean kimbaslasin=false;
//true olunca pc baslicak false olunca ouncu baslicak
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kim_basliyacak1);

        b_tas=(Button) findViewById(R.id.btn_tas);
        b_kagit=(Button) findViewById(R.id.btn_kagit);
        b_makas=(Button) findViewById(R.id.btn_makas);
        img_pc=(ImageView) findViewById(R.id.img_pc);
        img_oyuncu=(ImageView) findViewById(R.id.img_oyuncu);
        b_tas.setOnClickListener(this);
        b_kagit.setOnClickListener(this);
        b_makas.setOnClickListener(this);
        rnd=new Random();
    }

    @Override
    public void onClick(View view) {
        if (view.equals(b_tas)){
            oyuncu_secim="tas";
            img_oyuncu.setImageResource(R.drawable.rock);
            kimkazandi();
        }
        if (view.equals(b_kagit)){
            oyuncu_secim="kagit";
            img_oyuncu.setImageResource(R.drawable.paper);
            kimkazandi();
        }
        if (view.equals(b_makas)){
            oyuncu_secim="makas";
            img_oyuncu.setImageResource(R.drawable.scissor);
            kimkazandi();
        }
    }

    private void kimkazandi() {
        int pc=rnd.nextInt(3);
        if (pc==0){
            pc_secim="tas";
            img_pc.setImageResource(R.drawable.rock);
        }else  if(pc==1){
            pc_secim="kagit";
            img_pc.setImageResource(R.drawable.paper);
        }else if (pc==2){
            img_pc.setImageResource(R.drawable.scissor);
            pc_secim="makas";
        }
        if (oyuncu_secim.equals("tas") && pc_secim.equals("kagit")){
            Toast.makeText(getApplicationContext(),"Kaybettin ilk Pc başlıyacak",Toast.LENGTH_LONG).show();
            j=new Intent(KimBasliyacak1.this,OyunSayfasi.class);
            kimbaslasin=true;
            startActivity(j);
        }
        else if (oyuncu_secim.equals("tas") && pc_secim.equals("makas")) {
            Toast.makeText(getApplicationContext(), "Kazandın ilk sen başla", Toast.LENGTH_LONG).show();
            j = new Intent(KimBasliyacak1.this, OyunSayfasi.class);
            kimbaslasin=false;
            startActivity(j);
        }
        else if (oyuncu_secim.equals("kagit") && pc_secim.equals("tas")){
            Toast.makeText(getApplicationContext(),"Kazandın ilk sen başla",Toast.LENGTH_LONG).show();
           j=new Intent(KimBasliyacak1.this,OyunSayfasi.class);
            kimbaslasin=false;
            startActivity(j);
        }
        else if (oyuncu_secim.equals("kagit") && pc_secim.equals("makas")){
            Toast.makeText(getApplicationContext(),"Kaybettin ilk Pc başlıyacak",Toast.LENGTH_LONG).show();
            j=new Intent(KimBasliyacak1.this,OyunSayfasi.class);
            kimbaslasin=true;
            startActivity(j);
        }
        else if (oyuncu_secim.equals("makas") && pc_secim.equals("kagit")){
            Toast.makeText(getApplicationContext(),"Kazandın ilk sen başla",Toast.LENGTH_LONG).show();
            j=new Intent(KimBasliyacak1.this,OyunSayfasi.class);
            kimbaslasin=false;
            startActivity(j);
        }
        else if (oyuncu_secim.equals("makas") && pc_secim.equals("tas")){
            Toast.makeText(getApplicationContext(),"Kaybettin ilk Pc başlıyacak",Toast.LENGTH_LONG).show();
            j=new Intent(KimBasliyacak1.this,OyunSayfasi.class);
            kimbaslasin=true;
            startActivity(j);
        }
        else if (oyuncu_secim.equals("makas") && pc_secim.equals("makas")){
            Toast.makeText(getApplicationContext(),"Berabere bastan seç",Toast.LENGTH_LONG).show();
        }
        else if (oyuncu_secim.equals("kagit") && pc_secim.equals("kagit")){
            Toast.makeText(getApplicationContext(),"Berabere bastan seç",Toast.LENGTH_LONG).show();
        }
        else if (oyuncu_secim.equals("tas") && pc_secim.equals("tas")){
            Toast.makeText(getApplicationContext(),"Berabere bastan seç",Toast.LENGTH_LONG).show();
        }
    }
}
