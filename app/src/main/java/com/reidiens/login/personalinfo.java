package com.reidiens.login;




import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import android.widget.TextView;
import android.widget.Toast;


public class personalinfo extends AppCompatActivity implements View.OnClickListener {

    ArrayAdapter<CharSequence> adapter;
    Spinner country;


    EditText enName, enEmail, pass1, ph1, ph2, ph3, date, datedd, yer, myadd, zip; //namecc,ccnum, exdt,exdt2, seccd;
    Button register1;
    RadioButton male, female;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);
        replacefnt.replaceDefaultFont(this, "DEFAULT", "Neutra.ttf"); //change of default font

        enName = (EditText) findViewById(R.id.enName);
        enEmail = (EditText) findViewById(R.id.enEmail);
        pass1 = (EditText) findViewById(R.id.pass1);
        datedd = (EditText) findViewById(R.id.datedd);
        yer = (EditText) findViewById(R.id.yer);
        ph1 = (EditText) findViewById(R.id.ph1);
        ph2 = (EditText) findViewById(R.id.ph2);
        ph3 = (EditText) findViewById(R.id.ph3);
        date = (EditText) findViewById(R.id.date);
        myadd = (EditText) findViewById(R.id.myadd);
        zip = (EditText) findViewById(R.id.zip);

        register1 = (Button) findViewById(R.id.register1);

        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);

        register1.setOnClickListener(this);

        //list of country spinner
        country = (Spinner)

                findViewById(R.id.cntry1);


        adapter = ArrayAdapter.createFromResource(this, R.array.country_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        country.setAdapter(adapter);
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()


                                          {

                                              @Override
                                              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                                  Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position) + "selected", Toast.LENGTH_LONG).show();
                                              }

                                              @Override
                                              public void onNothingSelected(AdapterView<?> parent) {

                                              }
                                          }


        );//complete of country spinner code


        //change font to Neutra Display Light
        Typeface myFont = Typeface.createFromAsset(getAssets(), "Neutra.ttf");
        enName.setTypeface(myFont);
        enEmail.setTypeface(myFont);
        TextView myPersonal = (TextView) findViewById(R.id.personalIn);
        myPersonal.setTypeface(myFont);
        TextView myName1 = (TextView) findViewById(R.id.name1);
        myName1.setTypeface(myFont);
        TextView myEmailT = (TextView) findViewById(R.id.emailTx);
        myEmailT.setTypeface(myFont);
        pass1.setTypeface(myFont);
        TextView myPassTx = (TextView) findViewById(R.id.passTx);
        myPassTx.setTypeface(myFont);
        male.setTypeface(myFont);
        female.setTypeface(myFont);
        TextView myS = (TextView) findViewById(R.id.sex);
        myS.setTypeface(myFont);
        date.setTypeface(myFont);
        datedd.setTypeface(myFont);
        yer.setTypeface(myFont);
        TextView myDob = (TextView) findViewById(R.id.dob);
        myDob.setTypeface(myFont);
        TextView myPh = (TextView) findViewById(R.id.ph);
        myPh.setTypeface(myFont);
        ph1.setTypeface(myFont);
        ph2.setTypeface(myFont);
        ph3.setTypeface(myFont);
        myadd.setTypeface(myFont);
        register1.setTypeface(myFont);
        TextView myAdd1 = (TextView) findViewById(R.id.myadd1);
        myAdd1.setTypeface(myFont);
        zip.setTypeface(myFont);
        TextView myZip1 = (TextView) findViewById(R.id.zip1);
        myZip1.setTypeface(myFont);
        TextView myCntry = (TextView) findViewById(R.id.cntry);
        myCntry.setTypeface(myFont);
        register1.setTypeface(myFont);




//code complete for change of font


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register1:


                String email = enEmail.getText().toString();
                String password = pass1.getText().toString();

                User registerData =  new User(email, password);

                startActivity(new Intent(this,Loginpg.class));


                break;


        }

    }


}