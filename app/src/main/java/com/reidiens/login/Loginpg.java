package com.reidiens.login;


import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Loginpg extends AppCompatActivity implements View.OnClickListener{

    Button register1;
    EditText email1, pass1;
    TextView sgup1, forgotpass1;
    UserLocalStore userLocalStore;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpg);

        //creation of login

        email1 = (EditText)findViewById(R.id.email);
        pass1 = (EditText)findViewById(R.id.pass);
        sgup1 = (TextView)findViewById(R.id.sgup);
        forgotpass1 = (TextView)findViewById(R.id.fpass);
        register1 = (Button)findViewById(R.id.register);

        register1.setOnClickListener(this);
        sgup1.setOnClickListener(this);
        forgotpass1.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);



        //change font to Neutra Display Light
        Typeface myFont = Typeface.createFromAsset(getAssets(),"Neutra.ttf");

        email1.setTypeface(myFont);
        pass1.setTypeface(myFont);
        forgotpass1.setTypeface(myFont);
        register1.setTypeface(myFont);
        TextView myDhacc = (TextView)findViewById(R.id.dhacc);
        myDhacc.setTypeface(myFont);
        sgup1.setTypeface(myFont);



    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
               String email = email1.getText().toString();
               String password = pass1.getText().toString();
                User user = new User(email, password);




                authenticate(user);


                break;
            //call personal info page
            case R.id.sgup:

                startActivity(new Intent(this,personalinfo.class));

                //forgot password logic is not used in alpha
            case R.id.fpass:

                //startActivity(new Intent(this,personalinfo.class));
        }
    }
       private void authenticate(User user){
        if (user == null){
            showErrorMessage();
        }else {
            logUserIn(user);
        }

    }


    private void showErrorMessage() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Loginpg.this);
        dialogBuilder.setMessage("Incorrect user details");
        dialogBuilder.setPositiveButton("Ok", null);
        dialogBuilder.show();
    }

    private void logUserIn(User user) {

        userLocalStore.storeUserData(user);
        userLocalStore.setUserLoggedIn(true);

        startActivity(new Intent(this, firstpg.class));
    }


}
