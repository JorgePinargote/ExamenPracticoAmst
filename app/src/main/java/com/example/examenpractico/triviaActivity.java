package com.example.examenpractico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class triviaActivity extends AppCompatActivity {
    private ImageView img_trivia;
    private TextView txt_title;
    private Button btn_opt1, btn_opt2, btn_opt3, btn_opt4;

    String[] imagenes  =  new String[5];
    String[] preguntas = new String[5];
    List<String[]> opciones = new LinkedList<>();
    int[] correctas = new int[5];

    int contadorCorrectas = 0;

    /*pregunta
    *
    *
    * pregunta
    * cuatro opciones
    * correct
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        preguntas[0] = "Como se llama el personaje principal de frozen";
        correctas[0] = 0;
        imagenes[0] = "frozen.png";
        String[] ops1 = {"Elsa","Betty","Anita","Olaf"};

        preguntas[1] = "Cual es el actor principal de la pelicula no se Aceptan devoluciones";
        correctas[1] = 1;
        imagenes[0] = "devoluciones.png";
        String[] ops2 = {"Brad pitt","Eugenio Derbez","Doraemon","Vegeta"};

        preguntas[2] = "Cual de estos es un personaje de harry potter";
        correctas[2] = 0;
        imagenes[0] = "harry.png";
        String[] ops3 = {"Voldemort", "moltres", "goku", "toreto el mago"};

        preguntas[3] = "En que año se estreno titanic";
        correctas[3] = 3;
        imagenes[0] = "titanic.png";
        String[] ops4 = {"1992","1995","1998","1997"};

        preguntas[4] = "Actor principal del a saga de rambo";
        correctas[4] = 0;
        imagenes[0] = "rambo.png";
        String[] ops5 = {"Silvester Stalone","Arnold Sauces9","Rene Garcia","Leonardo Di carprio"};

        opciones.add(ops1);
        opciones.add(ops2);
        opciones.add(ops3);
        opciones.add(ops4);
        opciones.add(ops5);

        //componentes
        img_trivia = (ImageView) findViewById(R.id.img_trivia);

        txt_title = (TextView) findViewById(R.id.txt_title);
        btn_opt1 = (Button) findViewById(R.id.btn_opt1);
        btn_opt2 = (Button) findViewById(R.id.btn_opt2);
        btn_opt3 = (Button) findViewById(R.id.btn_opt3);
        btn_opt4 = (Button) findViewById(R.id.btn_opt4);

        //set
        img_trivia.setImageResource(R.drawable.ic_action_default);
        txt_title.setText(preguntas[0]);
        btn_opt1.setText(opciones.get(0)[0]);
        btn_opt2.setText(opciones.get(0)[1]);
        btn_opt3.setText(opciones.get(0)[2]);
        btn_opt4.setText(opciones.get(0)[3]);

        btn_opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleChoose(1);
            }
        });

        btn_opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleChoose(2);
            }
        });

        btn_opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleChoose(3);
            }
        });

        btn_opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleChoose(4);
            }
        });
    }


    private void handleChoose(int selected){
        String pregunta = txt_title.getText().toString();
        int i;
        for(i = 0; i < preguntas.length; i++){
            if(preguntas[i].equals(pregunta))break;
        }
        if(selected == correctas[i])contadorCorrectas++;
        updatePreguntas(i);
    }

    private void updatePreguntas(int i) {
        i=i+1;
        if(i >= preguntas.length){
            if(contadorCorrectas == preguntas.length){
                Intent intent = new Intent(this, GanadorActivity.class);
                startActivity(intent);
            }else {
                Intent intent = new Intent(this, PerdedorActivity.class);
                intent.putExtra("info_correctas",contadorCorrectas);
                startActivity(intent);
            }
        }else{
            img_trivia.setImageResource(R.drawable.ic_action_default);
            txt_title.setText(preguntas[i]);
            btn_opt1.setText(opciones.get(i)[0]);
            btn_opt2.setText(opciones.get(i)[1]);
            btn_opt3.setText(opciones.get(i)[2]);
            btn_opt4.setText(opciones.get(i)[3]);
        }
    }
}