package com.example.lenovo.odev3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btopla,bfark;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btopla=(Button) findViewById(R.id.btn_topla);
        bfark=(Button) findViewById(R.id.btn_fark);
        ed=(EditText) findViewById(R.id.ed);
        btopla.setOnClickListener(this);
        bfark.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            int snc = Integer.parseInt(ed.getText().toString());
            if (view.equals(btopla)) {
                Toast.makeText(getApplicationContext(), "sonuc" + (snc + 5), Toast.LENGTH_LONG);
            } else if(view.equals(bfark)){
                Toast.makeText(getApplicationContext(), "sonuc" + (snc - 5), Toast.LENGTH_LONG);
            }
    }
}
