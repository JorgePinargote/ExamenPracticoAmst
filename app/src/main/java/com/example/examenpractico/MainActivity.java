package com.example.examenpractico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void empezar(View view){

        //////REEMPLAZAR CON ACTIVITY TRIVIA////////////////////////////////////////////////////////////////
        Intent intent = new Intent(this,GanadorActivity.class);
        startActivity(intent);

    }
}