package com.example.pruebaandroid2.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebaandroid2.R;

public class dashboard extends AppCompatActivity {

    GridLayout mygrid;
    Button addmos;
    TextView mostrar;
    ProgressBar pogrebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mygrid = (GridLayout)findViewById(R.id.grid_resultado);
        addmos = (Button)findViewById(R.id.btn_mostrar);



        addmos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostraralgo();

            }
        });
    }

    public void mostraralgo()
            {
                mostrar = new TextView(this);
                final Bundle datosT = this.getIntent().getExtras();
                String  nombrecri = datosT.getString("Criterios_Nombre");
                String  valorcri = datosT.getString("Criterios_Valor");
                String  nombrealt = datosT.getString("Alternativa_Nombre");
                String  valoralt = datosT.getString("Alternativa_Valor");
                mostrar.setText(""+ nombrealt+","+valoralt);

                mygrid.addView(mostrar);
            }
    public void finalizar(View view) {
        finish();
    }

}
