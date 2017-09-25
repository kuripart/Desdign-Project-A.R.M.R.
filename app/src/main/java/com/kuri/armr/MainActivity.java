package com.kuri.armr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void openRegisterPageClick(View view) {

        Intent goToRegisterPage = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(goToRegisterPage);
        finish();

    }

    public void openLoginPageClick(View view) {


        Intent goToLoginPage = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(goToLoginPage);
        finish();

    }
 }


