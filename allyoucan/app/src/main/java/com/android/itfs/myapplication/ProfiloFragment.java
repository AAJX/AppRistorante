package com.android.itfs.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.itfs.myapplication.R;
import com.android.itfs.myapplication.model.Utente;
import com.android.itfs.myapplication.model.UtenteLoggato;

/**
 * Created by francesca on 01/03/18.
 */

public class ProfiloFragment extends AppCompatActivity {



    TextView name;
    TextView surname;
    TextView phone;
    TextView email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo);


      /*  name=findViewById(R.id.nome);
        surname= findViewById(R.id.cog);
        phone= findViewById((R.id.mail));
        email= findViewById((R.id.tel));




        name.setText(UtenteLoggato.getInstance().getUtente().getNome());
        surname.setText(UtenteLoggato.getInstance().getUtente().getCognome());
        email.setText(UtenteLoggato.getInstance().getUtente().getEmail());
        phone.setText(UtenteLoggato.getInstance().getUtente().getNumero_telefono()); */




    }





}
