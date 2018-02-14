package com.android.itfs.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.android.itfs.myapplication.controller.LoginController;


public class Welcome extends AppCompatActivity {


    private VideoView videoview;

    private Button login;

    private Dialog loginDialog;
    private Button accediDialog;
    private Button esploraB;
    private EditText mail;
    private EditText pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        videoview = findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+ R.raw.foodvid480);
        videoview.setVideoURI(uri);
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        esploraB = (Button)findViewById(R.id.esploraB);
        esploraB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openExploreNL = new Intent(Welcome.this, ExploreNotLogged.class);
                startActivity(openExploreNL);

            }
        });






        login = (Button) findViewById(R.id.signin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginDialog= new Dialog(view.getContext());
                loginDialog.setContentView(R.layout.activity_login);

                mail = (EditText) loginDialog.findViewById(R.id.mail);
                pwd = (EditText) loginDialog.findViewById(R.id.pwd);

                //eventualmente imposta come shared preferences

                accediDialog = (Button) loginDialog.findViewById(R.id.accediDialog);
                accediDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String email = mail.getText().toString().trim();
                        final String password = pwd.getText().toString().trim();

                        if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                            if(password.length()>6){

                                //Utility.lockscreen-> schermo non cliccabile
                                //progressBar.setVisibility(View.VISIBLE);
                                

                            }
                        }
                    }
                });


                loginDialog.show();
            }
        });

        videoview.start();



    }



}
