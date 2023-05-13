package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

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


    EditText usuario, contraseña, recontra;
    Button signup, signin;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        usuario=findViewById(R.id.usuario);
        contraseña=findViewById(R.id.contraseña);
        recontra=findViewById(R.id.confirmarcontraseña);
        signup=findViewById(R.id.registro);
        signin=findViewById(R.id.login);
        db = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario.getText().toString();
                String pass = contraseña.getText().toString();
                String re = recontra.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(re))
                    Toast.makeText(MainActivity.this,"Todos los campos son requeridos",Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(re)){
                        Boolean checku = db.checkusername(user);
                        if(checku==false){
                            Boolean insert = db.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Acceder.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this, "Registro fallido", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Usuario ya existente", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "La contraseña no concuerda", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent uwu = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(uwu);
            }
        });
    }


}