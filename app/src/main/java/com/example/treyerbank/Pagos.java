package com.example.treyerbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Pagos extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private RadioButton rb1, rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagos);

        et1 = (EditText) findViewById(R.id.txt_valor1);
        et2 = (EditText) findViewById(R.id.txt_valor2);
        tv1 = (TextView) findViewById(R.id.textView);
        rb1 = (RadioButton) findViewById(R.id.rb_sumar);
        rb2 = (RadioButton) findViewById(R.id.rb_restar);
        final Button btnSalirPagos = (Button) findViewById(R.id.btnSalirPagos);

        //Implemento el evento click de Boton Salir
        btnSalirPagos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Creo el Intent
                Intent intent = new Intent(Pagos.this, MainActivity.class);

                //Creo la informacion que se pasara entre las actividades
                Bundle b = new Bundle();

                //Comienzo el activity
                startActivity(intent);


                Toast.makeText(Pagos.this, "Saliendo", Toast.LENGTH_SHORT).show();

            }

        });
    }

    //Metodo para el boton calcular
    public void Calcular(View view) {
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        if (rb1.isChecked() == true) {
            int suma = valor1_int + valor2_int;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
        } else if (rb2.isChecked() == true) {
            int resta = valor1_int - valor2_int;
            String resultado = String.valueOf(resta);
            tv1.setText(resultado);
        }
    }

    //Metodo para el boton Salir
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnSalirPagos:
                Intent i2=new Intent(Pagos.this,MainActivity.class);
                startActivity(i2);
                finish();
                break;

        }

    }

}