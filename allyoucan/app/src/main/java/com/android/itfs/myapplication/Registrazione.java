package com.android.itfs.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.itfs.myapplication.Utils.VolleySingleton;
import com.android.itfs.myapplication.dialog.LoginDialog;
import com.android.itfs.myapplication.model.Utente;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Registrazione extends AppCompatActivity {

    private com.crust87.texturevideoview.widget.TextureVideoView videoview ;
    private EditText nome;
    private EditText cognome;
    private EditText mail;
    private EditText pwd;
    private EditText confpwd;
    private EditText tel;
    private Button signupB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        videoview = findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+ R.raw.foodvid);
        videoview.setVideoURI(uri);
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {


            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        videoview.start();


       final EditText nome = (EditText)findViewById(R.id.txtnom);
       final EditText cognome = (EditText)findViewById(R.id.txtcogn);
      final EditText mail = (EditText)findViewById(R.id.txtmail);
      final EditText pwd = (EditText)findViewById(R.id.txtpwd);
      final EditText tel = (EditText)findViewById(R.id.txttel);
      final EditText confpwd = (EditText)findViewById(R.id.txtpwd2);


        //eventualmente imposta come shared preferences -> creare alert dialog "vuoi ricordare..."


        signupB = (Button)findViewById(R.id.signupB);
        signupB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String name = nome.getText().toString().trim();
                final String surname = cognome.getText().toString().trim();
               final String phone = tel.getText().toString().trim();
               final String confirm = confpwd.getText().toString().trim();
                final String email = mail.getText().toString().trim();
                final String password = pwd.getText().toString().trim();

                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (password.length() > 6) {

                        String url = "http://192.168.1.128:8080/AppRistorantiWeb/nuovoAccount";

                        StringRequest loginReq = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {

                                       Toast.makeText(Registrazione.this, "registrazione in corso", Toast.LENGTH_LONG).show();

                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        error.printStackTrace();
                                        Toast.makeText(Registrazione.this, "errore", Toast.LENGTH_LONG).show();

                                    }
                                }
                        ) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<>();
                                // the POST parameters:
                                params.put("nome", name);
                                params.put("cognome", surname);
                                params.put("numeroTelefono", phone);
                                params.put("email", email);
                                params.put("password", password);
                                return params;
                            }
                        };

                        VolleySingleton.getInstance(Registrazione.this).addToRequestQueue(loginReq);

                        Intent i = new Intent(Registrazione.this, Explore.class);
                        startActivity(i);
                    }

                    }
                }

            });
    }
}
