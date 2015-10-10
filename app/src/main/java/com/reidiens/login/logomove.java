package com.reidiens.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.animation.TranslateAnimation;

public class logomove extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logomove);

        ImageView logo = (ImageView) findViewById(R.id.logot); //moving of logo to top

        TranslateAnimation animation = new TranslateAnimation(0, 0, 0, -300);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        logo.startAnimation(animation);
        Thread login = new Thread() {
            @Override
            public void run() {     // calling login page
                try {
                    sleep(4000);
                    Intent startLogin = new Intent(getApplicationContext(), Loginpg.class);
                    startActivity(startLogin);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        };
        login.start();
    }

    }
