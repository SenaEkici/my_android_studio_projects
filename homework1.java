package com.example.lenovo.odev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button b1;
    Button b2;



    @Override
    public void onClick(View view) {
        LayoutInflater myInflater = LayoutInflater.from(this);
        view = myInflater.inflate(R.layout.activity_main, null);
        Toast mytoast = new Toast(this);
        mytoast.setView(view);
        mytoast.setDuration(Toast.LENGTH_LONG);


        if (view.equals(b1)) {
            mytoast.setText("merhaba");
            mytoast.show();
            // Toast.makeText(getApplicationContext(),"merhaba\n dunya",Toast.LENGTH_LONG).show();burda carpım tablosu yapılack.odev
        }
        else {
            mytoast.setText("cık burdan");
            mytoast.show();
            // Toast.makeText(getApplicationContext(),"tıklama dedim ya -220 iq musun",Toast.LENGTH_LONG).show();
        }
    }
}
