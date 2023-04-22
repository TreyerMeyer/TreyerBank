package com.example.treyerbank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity implements View.OnClickListener{
    Button btnEditar, btnEliminar, btnMostrar, btnSalir;
    TextView nombre;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        nombre = (TextView) findViewById(R.id.nombreUsuario);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        Bundle b=getIntent().getExtras();
        id=b.getInt("Id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);

        //nombre.setText(u.getNombre()+" "+u.getApellidos());

        final Button btnPagos = (Button)findViewById(R.id.btnPagos);

        //Implemento el evento click de Boton Pagos
        btnPagos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Creo el Intent
                Intent intent = new Intent(Inicio.this, Pagos.class);

                //Creo la informacion que se pasara entre las actividades
                Bundle b = new Bundle();

                //Comienzo el activity
                startActivity(intent);


                Toast.makeText(Inicio.this, "Selecciona tus pagos", Toast.LENGTH_SHORT).show();

            }

        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEditar:
                Intent a = new Intent(Inicio.this, Editar.class);
                a.putExtra("id", id);
                startActivity(a);
                break;
            case R.id.btnEliminar:
                //Dialogo para eliminar registro
                AlertDialog.Builder b=new AlertDialog.Builder(this);
                b.setMessage("Estas seguro de eliminar tu cuenta?");
                b.setCancelable(false);
                b.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        if (dao.deleteUsuario(id)){
                            Toast.makeText(Inicio.this, "Se elimino correctamente", Toast.LENGTH_SHORT).show();
                            Intent a = new Intent(Inicio.this, Main.class);
                            startActivity(a);
                            finish();
                        }else{
                            Toast.makeText(Inicio.this, "ERROR: No se elimino cuenta", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
                    }
                });
                b.show();
                break;
            case R.id.btnMostrar:
                Intent c=new Intent(Inicio.this,Mostrar.class);
                startActivity(c);
                break;
            case R.id.btnSalir:
                Intent i2=new Intent(Inicio.this,Main.class);
                startActivity(i2);
                finish();
                break;

        }

    }

}