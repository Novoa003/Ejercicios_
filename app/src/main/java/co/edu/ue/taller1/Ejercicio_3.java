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
                new Pregunta("¿Cuál es el plato típico de Colombia que consiste en una sopa espesa hecha a base de papas y guiso de pollo o carne?",
                        new String[]{"Ajiaco", "Cuchuco", "Maruchan", "Sancocho"}, 0),

                new Pregunta("¿Cuál es el baile tradicional colombiano que se caracteriza por movimientos rápidos de los pies y las caderas?",
                        new String[]{"Cumbia", "Salsa", "Ballenato"}, 2),

                new Pregunta("¿Cuál es el río más largo de Colombia que atraviesa varios países de América del Sur, incluyendo Colombia, Brasil y Perú?",
                        new String[]{"Río Amazonas", " Río Orinoco", "Río Cauca"}, 0),

                new Pregunta("¿Quién es el famoso pintor y escultor colombiano conocido por su estilo único y colorido, y es considerado uno de los artistas más importantes de América Latina?",
                        new String[]{" Fernando Botero", "Diego Rivera", " Frida Kahlo"}, 0),

                        new Pregunta("¿Qué famoso escritor colombiano ganó el Premio Nobel de Literatura en 1982?",
                        new String[]{"Gabriel García Márquez", "Jorge Luis Borges", "Pablo Neruda"}, 1),
                new Pregunta("¿Cuál es la ciudad colombiana conocida por su arquitectura colonial, especialmente por las coloridas casas en la ladera de una montaña?",
                        new String[]{"Cartagena", " Medellín", "Cali"}, 2),



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
