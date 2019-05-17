package com.example.pruebaandroid2;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DynamicViews {

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

    public Button btnAgregarCri(Context context)
    {
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        final Button btn = new Button(context);

        return btn;
    }


}
