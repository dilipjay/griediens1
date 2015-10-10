package com.reidiens.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class splash extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread logo = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent startLogin = new Intent(getApplicationContext(), logomove.class);
                    startActivity(startLogin);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        };
        logo.start();
    }
}

