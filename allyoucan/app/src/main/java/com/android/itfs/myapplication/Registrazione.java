package com.android.itfs.myapplication;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Registrazione extends AppCompatActivity {

    private com.crust87.texturevideoview.widget.TextureVideoView videoview ;
    private EditText txtnom;
    private EditText txtcog;
    private EditText txtemail;
    private EditText pwd;
    private EditText confpwd;
    private EditText tel;

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


    }
}
