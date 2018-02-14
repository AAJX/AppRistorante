package com.android.itfs.myapplication.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.itfs.myapplication.Explore;
import com.android.itfs.myapplication.R;


public class LoginFragment extends AppCompatActivity { TextView username;

    TextView password;
    Button accedi;
    Button registrati;

    //private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        password = (TextView) findViewById(R.id.pwd);
        accedi = (Button) findViewById(R.id.accediDialog);
        registrati = (Button) findViewById(R.id.registrati);

        accedi.setOnClickListener(new View.OnClickListener()

          {
              @Override
              public void onClick(View v)
              {

                      Intent intent = new Intent(LoginFragment.this, Explore.class);
                      startActivity(intent);
              }


          }
        );

    }

}
