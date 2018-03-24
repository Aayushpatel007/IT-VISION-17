package com.patel.aayush.vision;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final SharedPreferences preferences = getSharedPreferences("FirstCheck",MODE_PRIVATE);
        final boolean isFirst = preferences.getBoolean("check",false);

        new android.os.Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (!isFirst){
                    preferences.edit().putBoolean("check",true).commit();
                    Intent intent = new Intent(Splash.this,UserInfo.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
                else {
                    Intent intent = new Intent(Splash.this, Dashboard.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
                finish();
            }

        },1000);


    }
}
