package com.example.pruebaandroid2.Views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.pruebaandroid2.Presenter.DynamicViews;
import com.example.pruebaandroid2.Presenter.DynamicViewsAlt;
import com.example.pruebaandroid2.R;

import static com.example.pruebaandroid2.Views.home.user;

public class vistaAlternativas extends AppCompatActivity {

    public static final String user = "names";
    TextView txtUser;
    private GridLayout mlayoutAlt;
    private Button addAlt;
    Context context;
    DynamicViewsAlt dna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_alternativas);

        txtUser = (TextView)findViewById(R.id.txt_User);
        String user = getIntent().getStringExtra("names");
        txtUser.setText("!Bienvenido " + user + "!");

        mlayoutAlt = (GridLayout)findViewById(R.id.mylayoutAlt);
        addAlt = (Button)findViewById(R.id.AgregarAlt);

        addAlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dna = new DynamicViewsAlt(context);

                mlayoutAlt.addView(dna.IngresarAlt(getApplicationContext()));
                mlayoutAlt.addView(dna.ImportanciaAlt(getApplicationContext()));
                mlayoutAlt.addView(dna.ValidarAlt(getApplicationContext()));

            }
        });


    }


}
