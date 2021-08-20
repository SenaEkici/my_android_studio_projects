package com.example.lenovo.projem;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OyunSayfasi extends AppCompatActivity implements View.OnClickListener{



    Button a1,a2,a3,b1,b2,b3,c1,c2,c3,bNewGame;
    Button [] bArray;//butonları array dizisine atadık
    boolean turn=true;//X-true,O-false
    int turn_count=0;//kac tane butona tıklandığını saymak için.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_sayfasi);


        //butonlarımızı activity deki butonlarla eşleştirdik.
        a1=(Button) findViewById(R.id.button1);
        a2=(Button) findViewById(R.id.button2);
        a3=(Button) findViewById(R.id.button3);
        b1=(Button) findViewById(R.id.button4);
        b2=(Button) findViewById(R.id.button5);
        b3=(Button) findViewById(R.id.button6);
        c1=(Button) findViewById(R.id.button7);
        c2=(Button) findViewById(R.id.button8);
        c3=(Button) findViewById(R.id.button9);
        bNewGame=(Button)findViewById(R.id.bNewGame);

        //butonlarımızı dinledik.
        bNewGame.setOnClickListener(this);
        bArray=new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};
        for(Button b: bArray)
        {
            b.setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View view) {
        Button b=(Button) view;
        buttonClicked(b);//butonclicked methodunu butonlarmıza tıklayıp tıklanılmadığını anlamak için tanımladık.
        if(view.equals(bNewGame)){
            turn=true;
            turn_count=0;
            butonlari_kapat(true);
        }
    }

    //her bir butona tıklayınca sırayla X ve O açılacak ve açıldığında butonun rengi değişecek.
    public void buttonClicked(Button b){
        if(turn){
            b.setText("X");
        }else{
           b.setText("O");
        }
        turn_count++;//açılan buton sayısını artıracak.
        b.setClickable(false);//tıkladığımız butona bir daha tıklanmayacak.
        b.setBackgroundColor(Color.LTGRAY);//tıklandığında rengi değişecek.
        turn=!turn;//sıra karşı tafa geçecek.
        kimkazandi();//kazanan varmı kontrol edecek.
    }

    public void kimkazandi()
    {
        boolean kazanan_var=false;//ilk olarak kazanan yok.

        //yatayda kazanan varmı kontrol
        if(a1.getText()==a2.getText() && a2.getText()==a3.getText()&& !a1.isClickable())
           kazanan_var=true;
        if(b1.getText()==b2.getText() && b2.getText()==b3.getText()&& !b1.isClickable())
            kazanan_var=true;
        if(c1.getText()==c2.getText() && c2.getText()==c3.getText()&& !c1.isClickable())
            kazanan_var=true;


        //dikey kontrol
        if(a1.getText()==b1.getText() && b1.getText()==c1.getText()&& !a1.isClickable())
            kazanan_var=true;
        if(a2.getText()==b2.getText() && b2.getText()==c2.getText()&& !b2.isClickable())
            kazanan_var=true;
        if(a3.getText()==b3.getText() && b3.getText()==c3.getText()&& !c3.isClickable())
            kazanan_var=true;


        //capraz kontrol
        if(a1.getText()==b2.getText() && b2.getText()==c3.getText()&& !a1.isClickable())
            kazanan_var=true;
        if(a3.getText()==b2.getText() && b2.getText()==c1.getText()&& !b2.isClickable())
            kazanan_var=true;

        //eger kazanan varsa toast mesajı olarak kazanan yazılacak.
        if(kazanan_var){
            if(!turn){
                Toast.makeText(getApplicationContext(),"X kazandı",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"O kazandı",Toast.LENGTH_LONG).show();
            }
            butonlari_kapat(false);
        }else if(turn_count==9){//kartların hepsi açıldığında toast mesajı yazdıracak.
            Toast.makeText(getApplicationContext(),"BERABERE",Toast.LENGTH_LONG).show();
        }
    }

    private void butonlari_kapat(boolean enabled) {
        for(Button b:bArray){
            b.setClickable(enabled);
            if(enabled) {
                b.setBackgroundColor(Color.parseColor("#33b5e5"));
                b.setText("");
            }
            else {
                b.setBackgroundColor(Color.LTGRAY);
            }
        }
    }



}
