package co.edu.ue.taller1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio_21 extends AppCompatActivity {

    private CheckBox chLapiz;
    private CheckBox chCorrector;
    private CheckBox chCuaderno;
    private CheckBox chBorrador;
    private CheckBox chEsfero;
    private CheckBox chMarcador;
    private Button btnSiguiente;

    private String nombres;
    private String apellidos;
    private String direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio21);


        nombres = getIntent().getStringExtra("Nombres");
        apellidos = getIntent().getStringExtra("Apellidos");
        direccion = getIntent().getStringExtra("Direccion");


        Iniciar();

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String seleccionProductos = ObtenerProductosSeleccionados();

                Intent intent = new Intent(Ejercicio_21.this, Factura.class);
                intent.putExtra("Nombres", nombres);
                intent.putExtra("Apellidos", apellidos);
                intent.putExtra("Direccion", direccion);
                intent.putExtra("ProductosSeleccionados", seleccionProductos);
                startActivity(intent);

            }
        });
    }

    private void Iniciar() {
        chCuaderno = findViewById(R.id.chCuaderno);
        chLapiz = findViewById(R.id.chLapiz);
        chBorrador = findViewById(R.id.chBorrador);
        chEsfero = findViewById(R.id.chEsfero);
        chCorrector = findViewById(R.id.chCorrector);
        chMarcador = findViewById(R.id.chMarcador);
        btnSiguiente = findViewById(R.id.btnSG);
    }

    private String ObtenerProductosSeleccionados() {
        StringBuilder seleccionProductos = new StringBuilder();

        if (chLapiz.isChecked()) {
            seleccionProductos.append("Lapiz, ");
        }
        if (chBorrador.isChecked()) {
            seleccionProductos.append("Borrador, ");
        }
        if (chCorrector.isChecked()) {
            seleccionProductos.append("Corrector, ");
        }
        if (chEsfero.isChecked()) {
            seleccionProductos.append("Esfero, ");
        }
        if (chMarcador.isChecked()) {
            seleccionProductos.append("Marcador, ");
        }
        if (chCuaderno.isChecked()) {
            seleccionProductos.append("Cuaderno, ");
        }


        if (seleccionProductos.length() > 0) {
            seleccionProductos.setLength(seleccionProductos.length() - 2);
        }

        return seleccionProductos.toString();
    }
}
