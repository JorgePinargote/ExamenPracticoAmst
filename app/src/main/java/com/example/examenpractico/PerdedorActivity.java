package com.example.examenpractico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PerdedorActivity extends AppCompatActivity {
    TextView txtAciertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdedor);
        String valor = getIntent().getExtras().getString("aciertos");
        txtAciertos = (TextView)findViewById(R.id.text_inicio);
        String texto = "Ha respondido " + valor + " preguntas";
        txtAciertos.setText(texto);

    }

    public void salir(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void JugarNuevamente(View v){

        /////REEMPLAZAR CON ACTIVITY TRIVIA/////////////////////////////////////////////////////////////
        Intent intent = new Intent(this, GanadorActivity.class);
        startActivity(intent);
    }
}