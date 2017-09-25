package com.kuri.armr;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button loginMainButton;
    FirebaseAuth firebaseAuth;
    TextInputLayout loginInputEmail;
    TextInputLayout loginPassEmail;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        loginInputEmail = (TextInputLayout) findViewById(R.id.loginInputEmail);
        loginPassEmail = (TextInputLayout) findViewById(R.id.loginInputPass);
        loginMainButton = (Button) findViewById(R.id.loginMainButton);

        loginMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginEmail = loginInputEmail.getEditText().getText().toString().trim();
                String loginPass = loginPassEmail.getEditText().getText().toString().trim();
                progressDialog.setTitle("Logging in....");
                progressDialog.setMessage("Just a moment....We are giving you the access.");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                userLogin(loginEmail, loginPass);
            }
        });
    }

    public void userLogin(String loginEmail, String loginPass){


        firebaseAuth.signInWithEmailAndPassword(loginEmail, loginPass)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            Intent goToControlsPage = new Intent(LoginActivity.this, ControlsActivity.class);
                            startActivity(goToControlsPage);
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this, "Something went wrong....Please Enter information again", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                });

    }
}
