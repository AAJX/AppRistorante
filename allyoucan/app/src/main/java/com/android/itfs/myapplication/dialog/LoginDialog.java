package com.android.itfs.myapplication.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;

import com.android.itfs.myapplication.R;
import com.android.itfs.myapplication.Utils.VolleySingleton;
import com.android.itfs.myapplication.ProfiloFragment;
import com.android.itfs.myapplication.model.Utente;
import com.android.itfs.myapplication.model.UtenteLoggato;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;


public class LoginDialog extends Dialog {

    EditText email;
    EditText password;
    Button accediDialog;
    Button registrati;
    Dialog logindialog;




    public LoginDialog(@NonNull Context context) {
        super(context);
    }

    //private ProgressBar progressBar;


    public void Login(final String email, final String password){



      /*  email = (EditText) findViewById(R.id.mail);

        password = (EditText) findViewById(R.id.pwd); */

        registrati = (Button) findViewById(R.id.registrati);


        accediDialog = (Button) findViewById(R.id.accediDialog);
       {


               /* final String indirizzo = email.getText().toString();
                final String chiave = password.getText().toString();*/



                String url = "http://192.168.1.128:8080/AppRistorantiWeb/Login";

                StringRequest loginReq = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                           /*   Gson gson = new Gson();
                                Utente u= gson.fromJson(response, Utente.class);
                                UtenteLoggato.getInstance().setUtente(u); */

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        // the POST parameters:
                        params.put("email", email);
                        params.put("password", password);
                        return params;
                    }
                };

                VolleySingleton.getInstance(getContext()).addToRequestQueue(loginReq);

                Intent i = new Intent(getContext(), ProfiloFragment.class);
                getContext().startActivity(i);
            }


    }

}
