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
import com.example.pruebaandroid2.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.pruebaandroid2.Model.Criterio;

public class DynamicViews {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Context ctx;

    int cm =0;
    int con = 0;



    public DynamicViews(Context ctx) {
        this.ctx = ctx;

    }

    public EditText IngresarCri(Context context) {
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        final EditText editText = new EditText(context);
        int id = 0;
        editText.setId(id);
        editText.setHint("Ingrese Criterio");
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

    public Button ValidarCri(final Context context) {

            InicializarFire();
            final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            Button button = new Button(context);
                button.setText("Criterio N°" + ++cm);
                button.setContentDescription("Identificattivo");
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Criterio c = new Criterio();

                        c.setNombreCri("HOla");

                        databaseReference.child("Criterio" + con).child(c.getNombreCri()).setValue(c);
                        Toast.makeText(context, "Se creo el Criterio " + ++con, Toast.LENGTH_SHORT).show();


                    }

                });

            Toast.makeText(context,"HOLA" + cm,Toast.LENGTH_SHORT).show();

            return button;
    }


    public void InicializarFire()
    {
        FirebaseApp.initializeApp(ctx);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }




}
