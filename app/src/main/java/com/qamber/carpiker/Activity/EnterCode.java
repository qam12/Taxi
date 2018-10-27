package com.qamber.carpiker.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.qamber.carpiker.R;

public class EnterCode extends AppCompatActivity {
    ImageView iv_continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_code);

        iv_continue=(ImageView)findViewById(R.id.iv_continue);
        iv_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EnterCode.this,MainFragmentActivity.class);
                startActivity(intent);
            }
        });
    }
}
