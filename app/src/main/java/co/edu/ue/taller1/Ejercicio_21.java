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

    private CheckBox chPantalon;
    private CheckBox chCorbata;
    private CheckBox chCamisa;
    private CheckBox chChaqueta;
    private CheckBox chBuso;
    private CheckBox chZapato;
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
        chCamisa = findViewById(R.id.chCamisa);
        chPantalon = findViewById(R.id.chPantalon);
        chChaqueta = findViewById(R.id.chChaqueta);
        chBuso = findViewById(R.id.chBuso);
        chCorbata = findViewById(R.id.chCorbata);
        chZapato= findViewById(R.id.chZapato);
        btnSiguiente = findViewById(R.id.btnSG);
    }

    private String ObtenerProductosSeleccionados() {
        StringBuilder seleccionProductos = new StringBuilder();

        if (chPantalon.isChecked()) {
            seleccionProductos.append("Pantalon, ");
        }
        if (chChaqueta.isChecked()) {
            seleccionProductos.append("Chaqueta, ");
        }
        if (chCorbata.isChecked()) {
            seleccionProductos.append("Corbata, ");
        }
        if (chBuso.isChecked()) {
            seleccionProductos.append("Buso, ");
        }
        if (chZapato.isChecked()) {
            seleccionProductos.append("Zapato, ");
        }
        if (chCamisa.isChecked()) {
            seleccionProductos.append("Camisa, ");
        }


        if (seleccionProductos.length() > 0) {
            seleccionProductos.setLength(seleccionProductos.length() - 2);
        }

        return seleccionProductos.toString();
    }
}
