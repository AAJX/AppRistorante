package com.android.itfs.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.itfs.myapplication.R;
import com.android.itfs.myapplication.model.UtenteLoggato;

/**
 * Created by francesca on 01/03/18.
 */

public class ProfiloFragment extends AppCompatActivity {



    TextView nome;
    TextView cognome;
    TextView telefono;
    TextView email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo);

        nome=findViewById(R.id.nome);
        cognome= findViewById(R.id.cog);
        telefono= findViewById((R.id.mail));
        email= findViewById((R.id.tel));


        nome.setText(UtenteLoggato.getInstance().getUtente().getNome());
        cognome.setText(UtenteLoggato.getInstance().getUtente().getCognome());
        email.setText(UtenteLoggato.getInstance().getUtente().getEmail());
        telefono.setText(UtenteLoggato.getInstance().getUtente().getNumero_telefono());




    }





}
