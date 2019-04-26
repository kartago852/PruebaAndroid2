package com.example.pruebaandroid2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class registerProvider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_provider);
    }


    public void VolverP(View view){
        Intent volverP = new Intent(this, MainActivity.class );
        startActivity(volverP);
    }
}
