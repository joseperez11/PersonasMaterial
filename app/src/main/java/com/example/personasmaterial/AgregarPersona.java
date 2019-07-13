package com.example.personasmaterial;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;

public class AgregarPersona extends AppCompatActivity {

    private ArrayList<Integer>fotos;
private EditText nombre, apellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);
        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
        nombre = findViewById(R.id.txtNombre);
        nombre = findViewById(R.id.txtApellido);


    }

    public void guardar(View v){
        String nom, apell, id;
        int foto;
        id = Datos.getId();
        nom = nombre.getText().toString();
        apell = apellidos.getText().toString();
        foto = this.fotoAleatoria();
        Persona p =new Persona(id,foto,nom,apell);
        p.guardar();
        limpiar ();
        Snackbar.make(v,getString(R.string.mensaje),Snackbar.LENGTH_SHORT).show();

    }
    public void limpiar(View v){
        limpiar();
    }
    public void limpiar(){
        nombre.setText("");
        apellidos.setText("");
        nombre.requestFocus();
    }

    public int fotoAleatoria(){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarPersona.this,MainActivity.class);
        startActivity(i);
    }
}
