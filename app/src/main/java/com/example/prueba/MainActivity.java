package com.example.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.prueba.EjemploListasClase.Genero;
import com.example.prueba.EjemploListasClase.Pelicula;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        //EJEMPLO onClickListener.
//        Button btn1 = findViewById(R.id.button); //Puntero al boton en la pantalla de la app.
//        TextView textPrueba = findViewById(R.id.textView);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //REGISTRO LOS EVENTOS AQUÍ.
//                textPrueba.setText("Hola" + Instant.now());
//            }
//        });

//        //PODEMOS GESTIONAR LOS EVENTOS CON UN SWITCH:
//        @Override;
//        View v;
//        public void onClick(View v){
//            switch(v.getId()) {
//                case R.id.button:
//                    //EVENTO.
//                    Break;
//                    // Y ASI CON TODOS LOS ELEMENTOS.
//            }
//        }

//        //CREAR UN SPINNER
//        final String[] opciones = {"Java", "Kotlin", "C++"};
//        Spinner spinner;
//        ArrayAdapter<CharSequence> adapter;
//        //Obtengo el spinner de la pantalla.
//        spinner = (Spinner) findViewById(R.id.spinner);
//        adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, opciones);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        //MANEJAR LOS EVENTOS DE UN SPINNER. TOMAR POR EJEMPLO UN ELEMENTO SELECCIONADO Y MOSTRARLO EN UN TEXTVIEW.
//        TextView textoSeleccionado = findViewById(R.id.textoSeleccionado);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                CharSequence txtSeleccionado = adapter.getItem(i);
//                textoSeleccionado.setText("Eligio: "+txtSeleccionado);
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

    }
}