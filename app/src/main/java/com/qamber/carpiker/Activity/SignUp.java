package com.qamber.carpiker.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.qamber.carpiker.R;

public class SignUp extends AppCompatActivity {
    Spinner spn_birth,spn_gender;
    TextView tv_signup;
    ImageView iv_continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        spn_birth = (Spinner) findViewById(R.id.spn_birth);

        tv_signup=(TextView)findViewById(R.id.tv_signup);
        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });
        ArrayAdapter<String> adapter_sor = new ArrayAdapter<String>(this,
                R.layout.row_layout_spn, R.id.tv_tittle,getResources().getStringArray(R.array.spn_eventtype));
        spn_birth.setAdapter(adapter_sor);
        spn_birth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {


                String  item = parent.getItemAtPosition(pos).toString();

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        spn_gender = (Spinner) findViewById(R.id.spn_gender);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.row_layout_spn, R.id.tv_tittle,getResources().getStringArray(R.array.spn_gendere));
        spn_gender.setAdapter(adapter);
        spn_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {


                String  item = parent.getItemAtPosition(pos).toString();

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        iv_continue=(ImageView)findViewById(R.id.iv_continue);
        iv_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUp.this,EnterPhone.class);
                startActivity(intent);
            }
        });
    }
}
