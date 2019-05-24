package com.example.pruebaandroid2.Presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DynamicViewsAlt {

    Context ctx;

    public DynamicViewsAlt(Context ctx)
    {
        this.ctx = ctx;
    }

    public EditText IngresarAlt(Context context) {
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        final EditText editText = new EditText(context);
        int id = 0;
        editText.setId(id);
        editText.setHint("Ingrese Alternativas");

        return editText;
    }

    public Spinner ImportanciaAlt(Context context){

        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        final Spinner spinner = new Spinner(context);
        final String[] listaAlt = {"1", "3", "5", "7", "9"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listaAlt);
        spinner.setAdapter(arrayAdapter);
        return spinner;
    }

    public Button ValidarAlt(Context context)
    {
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        final Button button = new Button(context);
        button.setText("Valide Alternativa");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setEnabled(false);
            }
        });
        return button;
    }

}
