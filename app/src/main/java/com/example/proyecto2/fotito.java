package com.example.proyecto2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class fotito extends AppCompatActivity {


    private static final int PERMISSION_CODE = 1000;
    private static final int capturar_imagen = 1001;
    Button mBoton;
    ImageView mImagen;

    Uri image_uri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        mImagen = findViewById(R.id.mImagen);
        mBoton = findViewById(R.id.mBoton);

        mBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(android.Manifest.permission.CAMERA) ==
                            PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                                    PackageManager.PERMISSION_DENIED){
                        String[] permiso = {android.Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

                        requestPermissions(permiso, PERMISSION_CODE);
                    }
                    else{
                        abrirCamara();
                    }
                }
                else{
                    abrirCamara();
                }
            }
        });
    }

    private void abrirCamara() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "Nueva foto");
        values.put(MediaStore.Images.Media.DESCRIPTION, "De la camara");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camara.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(camara, capturar_imagen);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED){
                    abrirCamara();
                }
                else{
                    abrirCamara();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            mImagen.setImageURI(image_uri);
        }
    }
}