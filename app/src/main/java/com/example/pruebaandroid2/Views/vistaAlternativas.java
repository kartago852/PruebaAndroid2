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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebaandroid2.Model.Alternativa;
import com.example.pruebaandroid2.Model.Criterio;
import com.example.pruebaandroid2.Presenter.DynamicViews;
import com.example.pruebaandroid2.Presenter.DynamicViewsAlt;
import com.example.pruebaandroid2.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.pruebaandroid2.Views.home.user;

public class vistaAlternativas extends AppCompatActivity {

    public static final String user = "names";
    TextView txtUser;
    int con=0;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button addAlt;
    Button btn_Dash;
    GridLayout mlayoutAlt;
    Button addbuton;
    EditText ingrealt;
    Spinner valoralt;
    Criterio c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_alternativas);
        Intent recibir = getIntent();
        txtUser = (TextView)findViewById(R.id.txt_User);
        String user = recibir.getStringExtra("names");
        txtUser.setText("!Bienvenido " + user + "!");
        Bundle datos = this.getIntent().getExtras();


        btn_Dash = (Button)findViewById(R.id.btn_Dash);
        btn_Dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irDash = new Intent(getApplicationContext(),dashboard.class);
                startActivity(irDash);
            }
        });

        mlayoutAlt = (GridLayout)findViewById(R.id.mylayoutAlt);
        addAlt = (Button)findViewById(R.id.AgregarAlt);

        addAlt.setOnClickListener(new View.OnClickListener() {
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
        ingrealt = new EditText(this);
        valoralt = new Spinner(this);

        ingrealt.setHint("Ingrese Alternativa");
        addbuton.setText("Alternativa N°" + ++con);
        mlayoutAlt.addView(addbuton);
        mlayoutAlt.addView(ingrealt);

        addbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InicializarFire();
                String id = databaseReference.push().getKey();
                String in = ingrealt.getText().toString();

                Alternativa a = new Alternativa();
                a.setNombreAlt(in);

                databaseReference.child("Alterantiva" + con).child(id).setValue(a);
                Toast.makeText(getApplicationContext(), "Se creo La alternativa " + con, Toast.LENGTH_SHORT).show();
                addbuton.setEnabled(false);
                ingrealt.setEnabled(false);

            }
        });

    }

}
