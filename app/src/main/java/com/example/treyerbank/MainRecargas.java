package com.example.treyerbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainRecargas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recargas);

        final Button btnRecargar = (Button)findViewById(R.id.btnRecargar);

        //Implemento el evento click de Boton Recargas
        btnRecargar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Creo el Intent
                Intent intent = new Intent(MainRecargas.this, MainActivity.class);

                //Creo la informacion que se pasara entre las actividades
                Bundle b = new Bundle();

                //Comienzo el activity
                startActivity(intent);


                Toast.makeText(MainRecargas.this, "Recarga exitosa", Toast.LENGTH_SHORT).show();

            }

        });

    }
}