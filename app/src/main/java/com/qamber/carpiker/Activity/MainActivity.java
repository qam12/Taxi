package com.qamber.carpiker.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.qamber.carpiker.Adapter.AdapterCountry;
import com.qamber.carpiker.Model.Modelcountry;
import com.qamber.carpiker.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<Modelcountry> arrayList=new ArrayList<>();
    AdapterCountry adapterCountry;
    RecyclerView recyclerView;
    ImageView iv_continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_continue=(ImageView)findViewById(R.id.iv_continue);
        iv_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.rv_people_attending);
        arrayList.add(new Modelcountry(this, "Pakistan", ""));
        arrayList.add(new Modelcountry(this, "Panama", ""));
        arrayList.add(new Modelcountry(this, "Palastine", ""));
        arrayList.add(new Modelcountry(this, "Palau", ""));
        arrayList.add(new Modelcountry(this, "Papua New Guinea", ""));
        arrayList.add(new Modelcountry(this, "Pakistan", ""));
        arrayList.add(new Modelcountry(this, "Panama", ""));
        arrayList.add(new Modelcountry(this, "Palastine", ""));
        arrayList.add(new Modelcountry(this, "Palau", ""));
        arrayList.add(new Modelcountry(this, "Papua New Guinea", ""));
        adapterCountry = new AdapterCountry(this, arrayList);
        recyclerView.setAdapter(adapterCountry);


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
