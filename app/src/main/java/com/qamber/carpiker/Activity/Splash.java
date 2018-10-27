package com.qamber.carpiker.Activity;

import android.content.Intent;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qamber.carpiker.R;
import com.qamber.carpiker.Utilities.MySplashActivity;

import static com.facebook.internal.CallbackManagerImpl.RequestCodeOffset.Login;

public class Splash extends MySplashActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


     /*           pref = PreferenceManager.getDefaultSharedPreferences(Splash.this);
                String ab=pref.getString("EMAIL","");
                String cb=pref.getString("USERID","");
                if(pref.getString("EMAIL","").equals("")&& pref.getString("USERID","").equals("")){*/
                    Intent intent=new Intent(Splash.this,MainActivity.class);
                    startActivity(intent);
                    finish();



            }
        },2000);
    }
}
