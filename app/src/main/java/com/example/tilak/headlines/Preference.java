package com.example.tilak.headlines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class Preference extends AppCompatActivity {

    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8;
    private Button done;
    public ArrayList<String> sources,sourceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        sources=new ArrayList<>();
        sourceText=new ArrayList<>();

        checkBox1=findViewById(R.id.checkBox00);
        checkBox2=findViewById(R.id.checkBox01);
        checkBox3=findViewById(R.id.checkBox02);
        checkBox4=findViewById(R.id.checkBox03);
        checkBox5=findViewById(R.id.checkBox04);
        checkBox6=findViewById(R.id.checkBox05);
        checkBox7=findViewById(R.id.checkBox06);
        checkBox8=findViewById(R.id.checkBox07);

        done=findViewById(R.id.done);

    }


    public void done(View v){
        checkString();
        Intent i=new Intent(Preference.this,MainActivity.class);
        i.putExtra("sourceText",sourceText);
        i.putExtra("sourceString",sources);
        startActivity(i);
    }

    public void checkString(){
        /*if(v.getId()==R.id.checkBox00 && ((CheckBox) v).isChecked()){
            sources.add("business-insider");
        }*/

        if(checkBox1.isChecked()){
            sources.add("business-insider");
            sourceText.add("Business Insider");
        }

        if(checkBox2.isChecked()){
            sources.add("cnn");
            sourceText.add("CNN");
        }

        if(checkBox3.isChecked()){
            sources.add("the-economist");
            sourceText.add("The Economist");
        }

        if(checkBox4.isChecked()){
            sources.add("espn");
            sourceText.add("ESPN");
        }

        if(checkBox5.isChecked()){
            sources.add("google-news");
            sourceText.add("Google News");
        }

        if(checkBox6.isChecked()){
            sources.add("the-hindu");
            sourceText.add("THe Hindu");
        }
        if(checkBox7.isChecked()){
            sources.add("national-geographic");
            sourceText.add("National Geographic");
        }
        if(checkBox8.isChecked()){
            sources.add("tech-crunch");
            sourceText.add("Tech Crunch");
        }
    }


    /*
    * Method to exit the app on pressing the back button
    */
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
    }
}
