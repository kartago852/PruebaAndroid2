package com.example.pruebaandroid2.Views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebaandroid2.Model.Alternativa;
import com.example.pruebaandroid2.Model.Criterio;
import com.example.pruebaandroid2.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class dashboard extends AppCompatActivity {

    GridLayout mygrid;
    Button addmos;
    TextView mostrar;
    ProgressBar pogrebar;
    Bundle datos;
    DatabaseReference mDatabase;
    FirebaseDatabase firebaseDatabase;
    String nombreCri;
    String nombreAlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mygrid = (GridLayout)findViewById(R.id.grid_resultado);
        addmos = (Button)findViewById(R.id.btn_mostrar);
        mDatabase = FirebaseDatabase.getInstance().getReference();

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
                mDatabase.child("Criterio1").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            mDatabase.child("Criterio1").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Criterio cri = snapshot.getValue(Criterio.class);
                                    nombreCri = cri.getNombreCri();

                                    mostrar.append(""+nombreCri);
                                    mostrar.append("\n");
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

                mDatabase.child("Alterantiva1").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            mDatabase.child("Alterantiva1").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Alternativa alt = snapshot.getValue(Alternativa.class);
                                    nombreAlt = alt.getNombreAlt();

                                    mostrar.append("\r\n");
                                    mostrar.append(""+nombreAlt);

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
                mygrid.addView(mostrar);
            }
    public void finalizar(View view) {
        finish();
    }

    public void InicializarFire()
    {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = firebaseDatabase.getReference();

    }

}
