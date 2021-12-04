package com.example.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    EditText ed_1,ed_2,ed_3;
    RadioButton rd_1,rd_2;
    CheckBox   chk_1,chk_2,chk_3,chk_4;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_1=(EditText) findViewById(R.id.edt_nombre);
        ed_2=(EditText) findViewById(R.id.edt_edad);
        ed_3=(EditText) findViewById(R.id.edt_email);
        rd_1=(RadioButton) findViewById(R.id.hombre);
        rd_2=(RadioButton) findViewById(R.id.mujer);
        chk_1=(CheckBox) findViewById(R.id.chck1);
        chk_2=(CheckBox) findViewById(R.id.chck2);
        chk_3=(CheckBox) findViewById(R.id.chck3);
        chk_4=(CheckBox) findViewById(R.id.chck4);
        btn1=(Button) findViewById(R.id.inciar);
        btn2=(Button) findViewById(R.id.salir);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCampos();


            }
        });
       btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getApplicationContext(),"Saliste de la aplicacion...",Toast.LENGTH_SHORT).show();
               finish();
           }
       });

    }

    private void validarCampos() {
        String nombre="",edad="",email="",error="";
        nombre=ed_1.getText().toString();
        edad=ed_2.getText().toString();
        email=ed_3.getText().toString();
        if(nombre.equals("")||edad.equals("")||email.equals(""))
            error="--No puedes dejar campos vacios";
        if(!rd_1.isChecked()&&!rd_2.isChecked())
            error+="--Debes seleccionar tu genero";
        if(!chk_1.isChecked()&&!chk_2.isChecked()&&!chk_3.isChecked()&&!chk_4.isChecked())
            error+="--Debes seleccioanr al menos un hobbie";

        if(!error.equals(""))
            Toast.makeText(getApplicationContext(),"ERROR: "+error,Toast.LENGTH_LONG).show();
        else{
          guardarDatos(nombre,edad,email,rd_1.isChecked());
         Intent i = new Intent(getApplicationContext(),Bienvenida.class);
         startActivity(i);
        }
    }

    private void guardarDatos(String name, String age, String mail, boolean hombre) {
        preferences=getSharedPreferences("formulario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("nombre",name);
        editor.putString("edad",age);
        editor.putString("email",mail);
        if(hombre)
              editor.putString("genero","masculino");
        else
              editor.putString("genero","femenino");
        editor.commit();
    }
}