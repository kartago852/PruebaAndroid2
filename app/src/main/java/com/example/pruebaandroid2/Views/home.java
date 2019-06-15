package com.example.pruebaandroid2.Views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import com.example.pruebaandroid2.Model.Criterio;
import com.example.pruebaandroid2.Presenter.DynamicViews;
import com.example.pruebaandroid2.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class home extends AppCompatActivity {

    public static final String user = "names";
    TextView txtUser;
    private Button btnalternativas;
    int con=0;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    GridLayout mlayout;
    Button addcri;
    Button addbuton;
    EditText ingrecri;
    Spinner valorcri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnalternativas = (Button)findViewById(R.id.IrAlternativa);
        btnalternativas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencion=  new Intent(getApplication(), vistaAlternativas.class);
                intencion.putExtra(vistaAlternativas.user, user);
                intencion.putExtra("Criterios_Nombre", ingrecri.getText().toString());
                intencion.putExtra("Criterios_Valor",valorcri.getSelectedItem().toString());
                startActivity(intencion);
            }
        });

        txtUser = (TextView)findViewById(R.id.txt_User);
        String user = getIntent().getStringExtra("names");
        txtUser.setText("!Bienvenido " + user + "!");
        mlayout = (GridLayout)findViewById(R.id.mylayout);
        addcri = (Button)findViewById(R.id.AgregarCri);

            addcri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        addbuton();
                }
            });


    }

    public void InicializarFire()
    {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }

    public void addbuton(){

        addbuton = new Button(this);
        ingrecri = new EditText(this);
        valorcri = new Spinner(this);

        String[] listaCri1 = {"1", "3", "5", "7", "9"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaCri1);
        valorcri.setAdapter(arrayAdapter);
        ingrecri.setHint("Ingrese Criterio");
        addbuton.setText("Criterio N°" + ++con);
        mlayout.addView(addbuton);
        mlayout.addView(ingrecri);
        mlayout.addView(valorcri);

        addbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InicializarFire();
                String id = databaseReference.push().getKey();
                String in = ingrecri.getText().toString();
                String va = valorcri.getSelectedItem().toString();
                Criterio c = new Criterio();
                c.setNombreCri(in);
                c.setValorCri(va);
                databaseReference.child("Criterio" + con).child(id).setValue(c);
                Toast.makeText(getApplicationContext(), "Se creo el Criterio " + con, Toast.LENGTH_SHORT).show();
                addbuton.setEnabled(false);

            }
        });

    }

}
