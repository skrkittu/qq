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

public class Main4Activity extends AppCompatActivity {
    SharedPreferences sp;
    Button b1;
    TextView t1;
    RadioButton rrr,r111,r222,r333;
    RadioGroup rgg;
    RelativeLayout rl;
    int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        t1=findViewById(R.id.textView222);
        b1=findViewById(R.id.button172);
        sp=getSharedPreferences(MainActivity.Mypreference, Context.MODE_PRIVATE);
        String s1=sp.getString(MainActivity.Name,"");
        t1.setText(s1);
        rl=findViewById(R.id.rl);
        r111=findViewById(R.id.radioButton222);
        r222=findViewById(R.id.radioButton223);
        r333=findViewById(R.id.radioButton224);
        rgg=findViewById(R.id.radioGroup11);
        r=getIntent().getExtras().getInt("key1");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rr=rgg.getCheckedRadioButtonId();
                rrr=findViewById(rr);

                if(r222 == rrr){
                    rl.setBackgroundColor(Color.GREEN);
                    r222.setBackgroundColor(Color.GREEN);
                    r111.setBackgroundColor(Color.RED);
                    r333.setBackgroundColor(Color.RED);
                    r++;

                    Toast.makeText(Main4Activity.this,"CORRECT ANSWER :) Score = "+r,Toast.LENGTH_LONG).show();

                }
                else
                {
                    rl.setBackgroundColor(Color.RED);
                    r222.setBackgroundColor(Color.GREEN);
                    r111.setBackgroundColor(Color.RED);
                    r333.setBackgroundColor(Color.RED);
                    Toast.makeText(Main4Activity.this,"WRONG ANSWER :( Score = "+r,Toast.LENGTH_LONG).show();
                }

                Intent i2=new Intent(Main4Activity.this,Main5Activity.class);
                i2.putExtra("key2",r);
                startActivity(i2);
            }
        });


    }
}


