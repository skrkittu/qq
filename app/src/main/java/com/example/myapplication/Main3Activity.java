package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    RadioGroup rgg;
    RadioButton r11,r22,r33,rbb;
    Button b11;
    TextView t1;
    SharedPreferences sp;
    RelativeLayout rr;
    int e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        rgg=findViewById(R.id.radioGroup1);
        r11=findViewById(R.id.radioButton22);
        r22=findViewById(R.id.radioButton23);
        r33=findViewById(R.id.radioButton24);
        t1=findViewById(R.id.textView22);
        b11=findViewById(R.id.button12);
        rr=findViewById(R.id.rr);
        sp=getSharedPreferences(MainActivity.Mypreference, Context.MODE_PRIVATE);
        String s1=sp.getString(MainActivity.Name,"");
        e=getIntent().getExtras().getInt("key");
        t1.setText(s1);

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r=rgg.getCheckedRadioButtonId();
                rbb=findViewById(r);
                if (r22==rbb){
                    rr.setBackgroundColor(Color.GREEN);
                    r11.setBackgroundColor(Color.RED);
                    r22.setBackgroundColor(Color.GREEN);
                    r33.setBackgroundColor(Color.RED);
                    e++;
                    Toast.makeText(Main3Activity.this,"CORRECT ANSWER :) Score = "+e,Toast.LENGTH_LONG).show();
                }
                else {
                    rr.setBackgroundColor(Color.RED);
                    r11.setBackgroundColor(Color.RED);
                    r22.setBackgroundColor(Color.GREEN);
                    r33.setBackgroundColor(Color.RED);
                    Toast.makeText(Main3Activity.this,"WRONG ANSWER :( Score = "+e,Toast.LENGTH_LONG).show();
                }


                Intent i=new Intent(Main3Activity.this,Main4Activity.class);
                i.putExtra("key1",e);
                startActivity(i);

            }
        });


    }
}
