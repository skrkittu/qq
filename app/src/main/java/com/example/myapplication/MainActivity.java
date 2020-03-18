package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    Button b1;

    public static final String Mypreference ="MyPref";
    public static final String Name="name";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.textView8);
        b1=findViewById(R.id.button);
        sp=getSharedPreferences(Mypreference, Context.MODE_PRIVATE);


        ed=sp.edit();

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                String a=t1.getText().toString();

                ed.putString(Name,a);
                ed.apply();
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                Toast.makeText(MainActivity.this,"Welcome  "+a,Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });
    }
}
