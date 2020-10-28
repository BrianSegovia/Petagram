package com.example.mascotasrecyclerviewyactionview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Contacto extends AppCompatActivity {

    EditText ETnombre;
    EditText ETemail;
    EditText ETmensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


        ETnombre      = (EditText) findViewById(R.id.nombre);
        ETemail       = (EditText) findViewById(R.id.correoElectronico);
        ETmensaje     = (EditText) findViewById(R.id.mensaje);
        ImageButton enviar   = (ImageButton) findViewById(R.id.enviar);
        ImageButton regresar = (ImageButton) findViewById(R.id.regresarDesdeAcercaDe);

        regresar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onBackPressed();
            }

        });

    }

    public void enviarEmail(View view){

        String [] mails = new String[1];
        mails [0]     = (String) ETemail.getText().toString();
        String nombre    = (String) ETnombre.getText().toString();
        String mensaje   = "Yo, " + nombre + ", le escribo por el siguiente motivo: " + (String) ETmensaje.getText().toString();

        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL,mails);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,nombre);
        emailIntent.putExtra(Intent.EXTRA_TEXT,mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email"));

    }
}
