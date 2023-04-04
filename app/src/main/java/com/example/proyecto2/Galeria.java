package com.example.proyecto2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class Galeria extends AppCompatActivity {

    private ImageSwitcher imageis;
    private Button btAnterior;
    private Button btSiguiente;
    private Button btPickImagen;

    private ArrayList<Uri> imagesUri;

    private int position;

    private ActivityResultLauncher<Intent> intentLaucher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        initViews();


        imagesUri = new ArrayList<>();

        setUpImage();

        ActivityResult();

        onClicksHandler();
    }

    private void initViews() {

        imageis = findViewById(R.id.imageis);
        btAnterior = findViewById(R.id.btAnterior);
        btSiguiente = findViewById(R.id.btSiguiente);
        btPickImagen = findViewById(R.id.btPickImagen);

    }

    private void pickImages(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);

        intentLaucher.launch(Intent.createChooser(intent, "selecciona imagenes"));
    }

    private void onClicksHandler(){
        btAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position>0){
                    position --;
                    imageis.setImageURI(imagesUri.get(position));
                }else{
                    Toast.makeText(Galeria.this, "sin imagenes", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(position< imagesUri.size()-1){
                    position++;
                    imageis.setImageURI(imagesUri.get(position));
                }else {
                    Toast.makeText(Galeria.this, "no mas imagenes", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btPickImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pickImages();

            }
        });

    }

    private void setUpImage(){
        imageis.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return new ImageView(getApplicationContext());
            }
        });
    }

    private void ActivityResult(){

        intentLaucher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result ->{
            if(result.getResultCode() == Activity.RESULT_OK){

                Uri imageUri;

                if(result.getData().getClipData() != null){


                    int count = result.getData().getClipData().getItemCount();

                    for (int i = 0; i< count;i++){
                        imageUri = result.getData().getClipData().getItemAt(i).getUri();
                        imagesUri.add(imageUri);

                    }

                }else {
                    imageUri = result.getData().getData();
                    imagesUri.add(imageUri);
                }

                imageis.setImageURI(imagesUri.get(0));
                position = 0;

            }
                } );

    }

}