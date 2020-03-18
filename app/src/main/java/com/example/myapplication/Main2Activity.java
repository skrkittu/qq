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

public class Main2Activity extends AppCompatActivity {
    RadioButton r1,rb,r2,r3;
    RadioGroup rg;
    Button b1;
    TextView t1;
    SharedPreferences sp;
    RelativeLayout r;
    int val=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rg =findViewById(R.id.radioGroup);
        r=findViewById(R.id.r);
        b1=findViewById(R.id.button2);
        t1=findViewById(R.id.textView2);
        r1=findViewById(R.id.radioButton2);
        r2=findViewById(R.id.radioButton3);
        r3=findViewById(R.id.radioButton4);
        sp=getSharedPreferences(MainActivity.Mypreference, Context.MODE_PRIVATE);
        String s1=sp.getString(MainActivity.Name,"");
        t1.setText(s1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioid=rg.getCheckedRadioButtonId();
                rb=findViewById(radioid);
                if (r1 == rb){
                    r.setBackgroundColor(Color.GREEN);
                    r1.setBackgroundColor(Color.GREEN);
                    r2.setBackgroundColor(Color.RED);
                    r3.setBackgroundColor(Color.RED);
                    val++;
                    Toast.makeText(Main2Activity.this,"CORRECT ANSWER :) Score = "+val,Toast.LENGTH_LONG).show();
                }
                else {
                    r.setBackgroundColor(Color.RED);
                    r2.setBackgroundColor(Color.RED);
                    r3.setBackgroundColor(Color.RED);
                    r1.setBackgroundColor(Color.GREEN);
                    Toast.makeText(Main2Activity.this,"WRONG ANSWER :( Score = "+val,Toast.LENGTH_LONG).show();
                }


                Intent i =new Intent(Main2Activity.this,Main3Activity.class);
                i.putExtra("key",val);
                startActivity(i);

            }
        });
    }
}
