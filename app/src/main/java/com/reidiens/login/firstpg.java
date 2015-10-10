package com.reidiens.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class firstpg extends AppCompatActivity implements View.OnClickListener {

    Button logout;
    UserLocalStore userLocalStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpg);

        logout = (Button) findViewById(R.id.logout);

        logout.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);

    }

    //login page auth
    @Override
    protected void onStart() {
        super.onStart();

        if (authenticate() == true) {
            displayPage();
        } else {
            startActivity(new Intent(this, Loginpg.class));
        }
    }


    private boolean authenticate() {
        return userLocalStore.getUserLoggedIn();

    }

    private void displayPage() {
        User user = userLocalStore.getLoggedInUser();
        startActivity(new Intent(this, firstpg.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.logout:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);

                startActivity(new Intent(this, Loginpg.class));
        }
    }
}
