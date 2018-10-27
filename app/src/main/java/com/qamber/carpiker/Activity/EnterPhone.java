package com.qamber.carpiker.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.qamber.carpiker.R;

public class EnterPhone extends AppCompatActivity {
    Spinner spn_phn;
    ImageView iv_continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_phone);

        spn_phn = (Spinner) findViewById(R.id.spn_phn);

        iv_continue=(ImageView)findViewById(R.id.iv_continue);
        iv_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EnterPhone.this,EnterCode.class);
                startActivity(intent);
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.row_layout_spn, R.id.tv_tittle,getResources().getStringArray(R.array.spn_phn));
        spn_phn.setAdapter(adapter);
        spn_phn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {


                String  item = parent.getItemAtPosition(pos).toString();

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
