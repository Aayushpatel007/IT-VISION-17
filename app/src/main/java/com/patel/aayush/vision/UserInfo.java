package com.patel.aayush.vision;

import android.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class UserInfo extends AppCompatActivity {
    Button button;
    EditText name;
    RadioGroup radioGroup;
    SharedPreferences.Editor editor;
    String status;
TextView m1,t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        button = (Button) findViewById(R.id.addbuttonid);
        name = (EditText) findViewById(R.id.nameid);
        m1=(TextView)findViewById(R.id.mainid);
        t1=(TextView)findViewById(R.id.t1);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Bold.ttf");
        m1.setTypeface(typeface);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
        t1.setTypeface(typeface1);

        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                //Log.v(TAG,"Permission is granted");
            } else {

                //Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CALL_PHONE}, 1);
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            //Log.v(TAG,"Permission is granted");
        }

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("vision", MODE_PRIVATE);
        editor = preferences.edit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                if (i == R.id.yesid) {
                    status = "yes";
                } else if (i == R.id.noid) {
                    status = "no";
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

if(status!=null) {
    editor.putString("name", name.getText().toString());
    editor.putString("status", status.toString());
    editor.apply();
    Intent intent = new Intent(UserInfo.this, Introslides.class);
    startActivity(intent);
    finish();
}


            }
        });

    }
}
