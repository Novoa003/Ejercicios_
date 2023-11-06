package co.edu.ue.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Ejercicio_3 extends AppCompatActivity {
    private TextView tvPregunta;
    private RadioGroup rgOpciones;
    private Button btnSiguiente;
    private Button   btnMen;

    private int preguntaActual = 0;
    private int puntaje = 0;

    private Pregunta[] preguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        tvPregunta = findViewById(R.id.tvPregunta);
        rgOpciones = findViewById(R.id.rgOpciones);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnMen = findViewById(R.id.btnMen);

        preguntas = new Pregunta[]{
                new Pregunta("¿Cuál es la capital de Colombia?",
                        new String[]{"Bogotá", "Medellín", "Cali", "Barranquilla"}, 0),

                new Pregunta("¿Cual es el unico mamifero que pone huevos?",
                        new String[]{"Ornitorrinco", "Ballena", "Gallina"}, 2),

                new Pregunta("¿Cual es la figura trigonometrica mas estable?",
                        new String[]{"Triangulo", "Cuadrado", "Circulo"}, 0),

                new Pregunta("¿Super heroe con el poder de la speed force?",
                        new String[]{"Flash", "Batman", "Iron Man"}, 0),

                        new Pregunta("Caballeros del lado luminoso en Star Wars:",
                        new String[]{"Jedis", "Siths", "Mandalorians"}, 1),
                new Pregunta("¿Cual es el villano de la saga señor de los anillos?",
                        new String[]{"Sauron", "Voldemort", "Spiderman"}, 2),



        };

        cargarPregunta(preguntaActual);

        btnMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idOpcionSeleccionada = rgOpciones.getCheckedRadioButtonId();
                if (idOpcionSeleccionada != -1) {
                    RadioButton rbSeleccionada = findViewById(idOpcionSeleccionada);
                    String opcionSeleccionada = rbSeleccionada.getText().toString();
                    Pregunta pregunta = preguntas[preguntaActual];
                    int indiceOpcionCorrecta = pregunta.getRespuestaCorrecta();
                    String opcionCorrecta = pregunta.getOpciones()[indiceOpcionCorrecta];

                    if (opcionSeleccionada.equals(opcionCorrecta)) {
                        puntaje++;
                    }

                    preguntaActual++;
                    if (preguntaActual < preguntas.length) {
                        cargarPregunta(preguntaActual);
                    } else {
                        mostrarPuntaje();
                    }
                }
            }
        });
    }

    private void cargarPregunta(int numPregunta) {
        Pregunta pregunta = preguntas[numPregunta];
        tvPregunta.setText(pregunta.getEnunciado());
        rgOpciones.removeAllViews();

        for (String opcion : pregunta.getOpciones()) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(opcion);
            rgOpciones.addView(radioButton);
        }
    }

    private void mostrarPuntaje() {
        btnSiguiente.setEnabled(false);
        TextView tvPuntaje = findViewById(R.id.tvPuntaje);
        String mensaje = "Puntaje final: " + puntaje + "/" + preguntas.length;
        tvPuntaje.setText(mensaje);
    }


        }
