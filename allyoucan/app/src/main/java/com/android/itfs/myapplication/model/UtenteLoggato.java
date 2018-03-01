package com.android.itfs.myapplication.model;

/**
 * Created by francesca on 01/03/18.
 */

public class UtenteLoggato {


    private static UtenteLoggato instance;
    private Utente utente;

    private UtenteLoggato(){

    }

    public static UtenteLoggato getInstance(){
        if(instance == null){
            instance = new UtenteLoggato();
        }

        return instance;
    }

    public Utente getUtente(){
        return utente;

    }
    public void setUtente(Utente utente ){
        this.utente = utente;
    }


    }
