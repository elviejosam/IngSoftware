package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usuario, contraseña;
    Button login;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario=findViewById(R.id.usuario1);
        contraseña=findViewById(R.id.contraseña1);
        login=findViewById(R.id.ingreso1);
        db = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario.getText().toString();
                String pass = contraseña.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(LoginActivity.this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkpass = db.checkpassword(user,pass);
                    if(checkpass==true){
                        Toast.makeText(LoginActivity.this, "Login exitoso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Acceder.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "El Login fallo", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}