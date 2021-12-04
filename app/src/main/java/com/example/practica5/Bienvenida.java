package com.example.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Bienvenida extends AppCompatActivity {
TextView bienvenida;
SharedPreferences preferences;
String nombre="",edad="", mail="",masculino="";
ImageView terror,accion,infantil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        bienvenida=(TextView) findViewById(R.id.bienveni);
        terror=(ImageView)findViewById(R.id.terror);
        accion=(ImageView)findViewById(R.id.accion);
        infantil=(ImageView)findViewById(R.id.infantil);
        LeerDatos();
        String cadena="";
        if(masculino.equals("masculino"))
             cadena="Bienvenido ";
        else
            cadena="Bienvenida ";

        cadena+=nombre + " Por tu edad: "+edad+" tienes acceso a todo revisa el email: "+mail;

        bienvenida.setText(cadena);
        Integer age= Integer.valueOf(edad);
        if(age<12) {
            Toast.makeText(getApplicationContext(), "Eres un polluelo", Toast.LENGTH_LONG).show();
            terror.setVisibility(View.INVISIBLE);
            accion.setVisibility(View.INVISIBLE);
        }
        if(age>12&&age<18){
            Toast.makeText(getApplicationContext(), "Eres un puubeerto", Toast.LENGTH_LONG).show();
            terror.setVisibility(View.INVISIBLE);
        }
        if(age>18){
            Toast.makeText(getApplicationContext(), "Eres una persona mayor de edad", Toast.LENGTH_LONG).show();
        }
    }

    private void LeerDatos() {
         preferences=getSharedPreferences("formulario", Context.MODE_PRIVATE);
         nombre=preferences.getString("nombre","No se encuentra");
         edad=preferences.getString("edad","No se encuentra");
         mail=preferences.getString("email","No se encuentra");
         masculino=preferences.getString("genero","No se encuentra");

    }
}