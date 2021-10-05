package com.example.prueba.EjemploListasClase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prueba.EjemploListasClase.Genero;
import com.example.prueba.EjemploListasClase.Pelicula;
import com.example.prueba.R;

import java.util.ArrayList;

public class MainListas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //LISTVIEW. --> EJEMPLO CLASE.

        //DECLARACIÓN DE VARIABLES.
        ArrayAdapter<Pelicula> peliculasAdapter;
        ArrayAdapter<Genero> generoAdapter;
        TextView generoSelected;
        ListView listaPeliculas;
        Spinner spinnerGenero;
        Button btnFinalizar;
        Button btnElegirVarias;
        SparseBooleanArray matrizRalaBoolean = new SparseBooleanArray();

        //ASIGNACIÓN DE VARIABLES CON ELEMENTOS DEL LAYOUT.
        spinnerGenero = findViewById(R.id.spinnerGenero);
        listaPeliculas = findViewById(R.id.lvPeliculas);
        generoSelected = findViewById(R.id.txtPeliculaSeleccionada);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnElegirVarias = findViewById(R.id.btnElegirVarias);

        //Crear un arreglo de 2 generos.
        Genero comedia = new Genero( g -> {
            g.setId(2);
            g.setDescripcion("COMEDIA");
        });
        Genero suspenso = new Genero( g -> {
            g.setId(1);
            g.setDescripcion("SUSPENSO");
        });
        ArrayList<Genero> arrayGenero = new ArrayList();
        arrayGenero.add(suspenso);
        arrayGenero.add(comedia);

        //Array de peliculas.
        ArrayList<Pelicula> arrayPeliculas = new ArrayList();
        arrayPeliculas.add(new Pelicula(
                s -> {
                    s.setId(1);
                    s.setNombre("GoT");
                    s.setCalificacion(9);
                    s.setGenero(comedia);
                    s.setVisualizaciones(980);
                }));
        arrayPeliculas.add(new Pelicula(
                s -> {
                    s.setId(2);
                    s.setNombre("Breaking Bad");
                    s.setCalificacion(8);
                    s.setGenero(suspenso);
                    s.setVisualizaciones(800);
                }));
        arrayPeliculas.add(new Pelicula(
                s -> {
                    s.setId(3);
                    s.setNombre("Cualquiera");
                    s.setCalificacion(5);
                    s.setGenero(comedia);
                    s.setVisualizaciones(700);
                }));

        generoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayGenero);

        //PARA SELECCIONAR UNA OPCIÓN ---> NO SE VE LA LISTA SELECCIONADA.
        peliculasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayPeliculas);
        //PARA SELECCIONAR UNA OPCION.
//        peliculasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, arrayPeliculas);
//        listaPeliculas.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE); //---->> ESPECIFICAR PARA QUE SE MARQUE LA SELECCION.
        //PARA SELECCIONAR MULTIPLE OPCIÓN.
        peliculasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, arrayPeliculas);
        listaPeliculas.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE); //---->> ESPECIFICAR PARA QUE SE MARQUEN VARIAS SELECCION.


        spinnerGenero.setAdapter(generoAdapter);
        listaPeliculas.setAdapter(peliculasAdapter);

        //SELECCIONAR FILAS EN UN LISTVIEW.
        TextView peliculaSeleccionada = findViewById(R.id.txtPeliculaSeleccionada);

        ArrayAdapter<Pelicula> finalPeliculasAdapter = peliculasAdapter;
        listaPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Guardar posicion en matriz rala.
                CheckedTextView checkedTextView = (CheckedTextView) view;
                matrizRalaBoolean.put(i, checkedTextView.isChecked());
                //AGREGAR BOTON ELEGIR VARIAS.
                btnElegirVarias.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for(int i=0; i<matrizRalaBoolean.size();i++){
                            if(matrizRalaBoolean.get(i)) {
                                Pelicula peli = finalPeliculasAdapter.getItem(i);
                                stringBuilder.append(peli.getNombre());

                            }
                            else{
                                Toast.makeText(MainListas.this, "Destildo "+i, Toast.LENGTH_LONG);
                            }
                        }
                        peliculaSeleccionada.setText("Eligio: " +stringBuilder.toString());
                    }
                });

                //MOSTRAR SELECCION.
//                Pelicula nueva = (Pelicula) adapterView.getItemAtPosition(i);
//                peliculaSeleccionada.setText("ELIGIO: " + nueva.getNombre());
            }
        });

        //SELECCIONAR VARIOS ELEMENTOS EN LISTVIEW.
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray seleccionadas = listaPeliculas.getCheckedItemPositions();
                int cantidadFilasLista = listaPeliculas.getCount();
                for(int i=0;i<cantidadFilasLista;i++){
                    if(seleccionadas.get(i)){
                        Toast.makeText(MainListas.this,(CharSequence) "Agregar a favoritos: "
                                +listaPeliculas.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });



    }
}