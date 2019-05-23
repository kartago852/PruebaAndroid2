package com.example.pruebaandroid2.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pruebaandroid2.R;

import static com.example.pruebaandroid2.Views.home.user;

public class vistaAlternativas extends AppCompatActivity {

    public static final String user = "names";
    TextView txtUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_alternativas);

        txtUser = (TextView)findViewById(R.id.txt_User);
        String user = getIntent().getStringExtra("names");
        txtUser.setText("!Bienvenido " + user + "!");
    }


}
