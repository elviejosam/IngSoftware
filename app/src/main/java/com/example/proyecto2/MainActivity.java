package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyecto2.ui.gallery.GalleryFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void inIniciar(View view){

        Intent i = new Intent(this, Acceder.class);
        startActivity(i);

    }
    public void inRegistrar(View view){
        Intent i = new Intent(this, RegistrarseActivity.class);
        startActivity(i);
    }

    public void abrirCamara(View view) {
        Intent i = new Intent(this, fotito.class );
        startActivity(i);
    }

}