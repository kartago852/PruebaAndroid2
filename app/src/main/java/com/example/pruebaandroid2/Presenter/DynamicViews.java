package com.example.pruebaandroid2.Presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pruebaandroid2.Model.Criterio;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.pruebaandroid2.Model.Criterio;

public class DynamicViews {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Context ctx;



    public DynamicViews(Context ctx) {
        this.ctx = ctx;



    }

    public EditText IngresarCri(Context context) {
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        final EditText editText = new EditText(context);
        int id = 0;
        editText.setId(id);
        editText.setHint("Ingrese Criterio");
        String nombreCri = editText.getText().toString();
        return editText;
    }

    public Spinner ImportanciaCri(Context context){

        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        final Spinner spinner = new Spinner(context);
        final String[] listaCri1 = {"1", "3", "5", "7", "9"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listaCri1);
        spinner.setAdapter(arrayAdapter);
        return spinner;
    }

    public Button ValidarCri(final Context context)
    {

        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        final Button button = new Button(context);
        InicializarFire();
        button.setText("Valide Criterio");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Criterio c = new Criterio();

                c.setNombreCri("HOLA");
                databaseReference.child("Criterio").child(c.getNombreCri()).setValue(c);
                Toast.makeText(context,"Registrado en la Base de datos",Toast.LENGTH_SHORT).show();
                button.setEnabled(false);
            }
        });
        return button;
    }

    public void InicializarFire()
    {
        FirebaseApp.initializeApp(ctx);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }




}
