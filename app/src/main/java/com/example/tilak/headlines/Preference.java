package com.example.tilak.headlines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class Preference extends AppCompatActivity {

    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8;
    public ArrayList<String> sources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        sources=new ArrayList<>();
        //sources.add("the-new-york-times");

        checkBox1=findViewById(R.id.checkBox00);
        checkBox2=findViewById(R.id.checkBox01);
        checkBox3=findViewById(R.id.checkBox02);
        checkBox4=findViewById(R.id.checkBox03);
        checkBox5=findViewById(R.id.checkBox04);
        checkBox6=findViewById(R.id.checkBox05);
        checkBox7=findViewById(R.id.checkBox06);
        checkBox8=findViewById(R.id.checkBox07);

    }


    public void done(View v){
        checkString();
        Intent i=new Intent(Preference.this,MainActivity.class);
        i.putExtra("sourceString",sources);
        startActivity(i);
    }

    public void checkString(){
        /*if(v.getId()==R.id.checkBox00 && ((CheckBox) v).isChecked()){
            sources.add("business-insider");
        }*/

        if(checkBox1.isChecked()){
            sources.add("business-insider");
        }

        if(checkBox2.isChecked()){
            sources.add("cnn");
        }

        if(checkBox3.isChecked()){
            sources.add("the-economist");
        }

        if(checkBox4.isChecked()){
            sources.add("espn");
        }

        if(checkBox5.isChecked()){
            sources.add("google-news");
        }

        if(checkBox6.isChecked()){
            sources.add("the-hindu");
        }
        if(checkBox7.isChecked()){
            sources.add("national-geographic");
        }
        if(checkBox8.isChecked()){
            sources.add("tech-crunch");
        }
    }
}
