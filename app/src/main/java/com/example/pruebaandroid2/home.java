package com.example.pruebaandroid2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Scanner;

public class home extends AppCompatActivity {

    private LinearLayout parentLinearLayout;

    public static final String user = "names";
    TextView txtUser;

    EditText txtCriteriosE;
    EditText txtNomCrite;
    ListView ListMatriz;
    Button NewBtn;
    LinearLayout Grilla;
    EditText NewCasillaCriterios;
    Spinner ImpoCri;
    EditText txtCriteriosP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtUser = (TextView)findViewById(R.id.txt_User);
        String user = getIntent().getStringExtra("names");
        txtUser.setText("!Bienvenido " + user + "!");

        txtCriteriosE = (EditText)findViewById(R.id.txt_criterios);



        Button btn_addcriterio = (Button)findViewById(R.id.btn_addCriterio);
        btn_addcriterio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addButton();
            }
        });
    }


    public void numeroCri(){

        int ncriterios[];

        //ListMatriz = (ListView)findViewById(R.id.list_matriz);
        ArrayList<String> listaCriterios = new ArrayList<>();

        final String nc = txtCriteriosE.getText().toString().trim();
        int nc1 = Integer.parseInt(nc);

        if(TextUtils.isEmpty(nc))
        {
            Toast.makeText(this,"Falta ingresar el numero de criterios",Toast.LENGTH_LONG).show();
            return;
        }else
            {
                for (int i = 0; i < nc1; i++)
                {
                    listaCriterios.add("Ingrese criterio" + i);
                }
                ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaCriterios);
                ListMatriz.setAdapter(adaptador);
            }
    }

    public void addButton(){
        LinearLayout newGrilla = (LinearLayout)findViewById(R.id.panel_layout);

        txtCriteriosP = (EditText)findViewById(R.id.txt_Cri);
        newGrilla.addView(txtCriteriosP);



    }


    public void Onclick(View view)
    {
        numeroCri();
    }



}
