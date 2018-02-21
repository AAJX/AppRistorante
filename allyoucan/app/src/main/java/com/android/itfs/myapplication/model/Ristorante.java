package com.android.itfs.myapplication.model;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by francesca on 16/02/18.
 */

public class Ristorante {

    private String nome;
    private String descrizione;
    private float prezzo;
    private Bitmap foto;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }




}
