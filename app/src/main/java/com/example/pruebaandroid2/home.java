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
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Scanner;

public class home extends AppCompatActivity {

    private LinearLayout parentLinearLayout;

    public static final String user = "names";
    TextView txtUser;


    private GridLayout mlayout;
    Button addcri;
    EditText txtCriteriosE;
    EditText txtNomCrite;
    ListView ListMatriz;

    DynamicViews  dnv;
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



        Button btn_addcriterio = (Button)findViewById(R.id.AgregarCri);
        btn_addcriterio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dnv = new DynamicViews(context);

                mlayout.addView(dnv.IngresarCri(getApplicationContext()),4);
                mlayout.addView(dnv.ImportanciaCri(getApplicationContext()),5);


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






    }


}
