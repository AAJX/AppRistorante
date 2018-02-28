package com.android.itfs.myapplication.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.itfs.myapplication.Explore;
import com.android.itfs.myapplication.R;

import static android.support.v4.content.ContextCompat.startActivity;


public class LoginDialog extends Dialog {

    TextView username;
    TextView password;
    Button accediDialog;
    Button registrati;
    Dialog logindialog;




    public LoginDialog(@NonNull Context context) {
        super(context);



}

    public LoginDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoginDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    //private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        logindialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        username = (TextView) findViewById(R.id.mail);

        password = (TextView) findViewById(R.id.pwd);

        registrati = (Button) findViewById(R.id.registrati);

        accediDialog = (Button) findViewById(R.id.accediDialog);
        accediDialog.setOnClickListener(new View.OnClickListener()

          {
              @Override
              public void onClick(View v)
              {
                  Intent i = new Intent(v.getContext(), Explore.class);
               v.getContext().startActivity(i);
              }


          }
        );

    }

}
