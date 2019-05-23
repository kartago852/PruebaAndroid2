package com.example.pruebaandroid2.Views;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pruebaandroid2.Presenter.DynamicViews;
import com.example.pruebaandroid2.R;

public class home extends AppCompatActivity {

    private LinearLayout parentLinearLayout;

    public static final String user = "names";
    TextView txtUser;


    private GridLayout mlayout;
    Button addcri;
    DynamicViews dnv;
    RelativeLayout containerLayout;
    static int totalEditTexts = 0;
    Button button;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtUser = (TextView)findViewById(R.id.txt_User);
        String user = getIntent().getStringExtra("names");
        txtUser.setText("!Bienvenido " + user + "!");
        mlayout = (GridLayout)findViewById(R.id.mylayout);
        addcri = (Button)findViewById(R.id.AgregarCri);

        addcri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dnv = new DynamicViews(context);

                mlayout.addView(dnv.IngresarCri(getApplicationContext()));
                mlayout.addView(dnv.ImportanciaCri(getApplicationContext()));
                mlayout.addView(dnv.ValidarCri(getApplicationContext()));

            }
        });
    }

}
