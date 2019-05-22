package com.example.pruebaandroid2.Views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pruebaandroid2.Model.Admin;
import com.example.pruebaandroid2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registerAdmin extends AppCompatActivity implements View.OnClickListener {

    private EditText TextEmail;
    private EditText TextPassword;
    private EditText TextName;
    private EditText TextRUC;
    private Button btnRegistrar;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    DatabaseReference databaseAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_admin);
        databaseAdmin = FirebaseDatabase.getInstance().getReference("Admin");

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);

        TextEmail = (EditText) findViewById(R.id.txt_email);
        TextPassword = (EditText) findViewById(R.id.txt_pass);
        TextName = (EditText) findViewById(R.id.txt_name);
        TextRUC = (EditText) findViewById(R.id.txt_ruc);
        btnRegistrar = (Button) findViewById(R.id.btn_register);

        progressDialog = new ProgressDialog(this);
        btnRegistrar.setOnClickListener(this);
    }

    private void registrarAdmin(){

        //Obtenemos los datos de las cajas de texto
        final String email = TextEmail.getText().toString().trim();
        final String password  = TextPassword.getText().toString().trim();
        String name = TextName.getText().toString().trim();
        String ruc= TextRUC.getText().toString().trim();


        //Verificamos que las cajas de texto no esten vacías
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }
        if(!TextUtils.isEmpty(name)){
        }else{
            Toast.makeText(this,"Falta ingresar el nombre",Toast.LENGTH_LONG).show();
            return;
        }
        if(!TextUtils.isEmpty(ruc)){
            String id = databaseAdmin.push().getKey();
            Admin admin = new Admin(id, name , ruc , email, password);
            databaseAdmin.child("Administradores").child(id).setValue(admin);
        }else{
            Toast.makeText(this,"Falta ingresar el numero de R.U.C",Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            Toast.makeText(registerAdmin.this,"Se ha registrado el usuario con el email: "+ TextEmail.getText(),Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(registerAdmin.this,"No se pudo registrar el usuario ",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    public void VolverA(View view){
        Intent volverA = new Intent(this, MainActivity.class );
        startActivity(volverA);
    }

    @Override
    public void onClick(View v) {
        registrarAdmin();
    }
}
