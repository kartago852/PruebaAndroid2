package com.example.pruebaandroid2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AlertDialog alertDialogwithradiobutton;
    private EditText TextEmail;
    private EditText TextPassword;
    private Button btnRegistrar;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        TextEmail = (EditText) findViewById(R.id.txt_email);
        TextPassword = (EditText) findViewById(R.id.txt_pass);

        btnRegistrar = (Button) findViewById(R.id.btn_register);

        progressDialog = new ProgressDialog(this);

        btnRegistrar.setOnClickListener(this);
        FirebaseApp.initializeApp(this);

    }
    private void logearUsuario(){

        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = TextEmail.getText().toString().trim();
        String password  = TextPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Verificando en la base de datos...");
        progressDialog.show();

        //login a new user
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            int pos = email.indexOf("@");
                            String user = email.substring(0, pos);
                            Toast.makeText(MainActivity.this,"Bienvenido "+ TextEmail.getText(),Toast.LENGTH_LONG).show();
                            Intent intencion=  new Intent(getApplication(), home.class);
                            intencion.putExtra(home.user, user);
                            startActivity(intencion);
                        }else{

                            Toast.makeText(MainActivity.this,"Datos incorrectos ",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private void registerActivity(){

        CharSequence[] values = {"Administrador", "Proveedor"};
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setTitle("Como desea registrarse");
        alerta.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                switch (i)
                {
                    case 0:
                        startActivity(new Intent(MainActivity.this, registerAdmin.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, registerProvider.class));
                        break;
                }
                alertDialogwithradiobutton.dismiss();
            }
          }
        );
        alertDialogwithradiobutton = alerta.create();
        alertDialogwithradiobutton.show();
    }

    @Override
    public void onClick(View view) {
        //Invocamos al método:
        switch (view.getId()){
            case R.id.btn_register:
                logearUsuario();
                break;
            case R.id.txt_regis:
                registerActivity();
                break;

        }
    }
}
