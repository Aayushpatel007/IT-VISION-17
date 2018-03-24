package com.patel.aayush.vision.Aboutus;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.patel.aayush.vision.Dashboard;
import com.patel.aayush.vision.R;
import com.patel.aayush.vision.Tech.TechEvent;

public class Teamit extends AppCompatActivity {

    TextView m1,m2,m3,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t40,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamit);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        m1=(TextView)findViewById(R.id.main1);
        m2=(TextView)findViewById(R.id.main2);
        m3=(TextView)findViewById(R.id.main3);
        t1=(TextView)findViewById(R.id.t1);
        t40=(TextView)findViewById(R.id.t40);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        t5=(TextView)findViewById(R.id.t5);
        t6=(TextView)findViewById(R.id.t6);
        t7=(TextView)findViewById(R.id.t7);
        t8=(TextView)findViewById(R.id.t8);
        t9=(TextView)findViewById(R.id.t9);
        t10=(TextView)findViewById(R.id.t10);
        t11=(TextView)findViewById(R.id.t11);
        t12=(TextView)findViewById(R.id.t12);
        t13=(TextView)findViewById(R.id.t13);
        t14=(TextView)findViewById(R.id.t14);
        t15=(TextView)findViewById(R.id.t15);
        t16=(TextView)findViewById(R.id.t16);
        t17=(TextView)findViewById(R.id.t17);
        t18=(TextView)findViewById(R.id.t18);
        t19=(TextView)findViewById(R.id.t19);
        t20=(TextView)findViewById(R.id.t20);
        t21=(TextView)findViewById(R.id.t21);
        t22=(TextView)findViewById(R.id.t22);
        t23=(TextView)findViewById(R.id.t23);
        t24=(TextView)findViewById(R.id.t24);
        t25=(TextView)findViewById(R.id.t25);
        t26=(TextView)findViewById(R.id.t26);
        t27=(TextView)findViewById(R.id.t27);
        t28=(TextView)findViewById(R.id.t28);
        t29=(TextView)findViewById(R.id.t29);
        t30=(TextView)findViewById(R.id.t30);
        t32=(TextView)findViewById(R.id.t32);
        t33=(TextView)findViewById(R.id.t33);
        t31=(TextView)findViewById(R.id.t31);

        Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/Raleway-Bold.ttf");
        m1.setTypeface(typeface);
        m2.setTypeface(typeface);
        m3.setTypeface(typeface);
        Typeface second=Typeface.createFromAsset(getAssets(),"fonts/Raleway-Regular.ttf");
        t1.setTypeface(second);
        t2.setTypeface(second);
        t3.setTypeface(second);
        t4.setTypeface(second);
        t5.setTypeface(second);
        t6.setTypeface(second);
        t7.setTypeface(second);
        t8.setTypeface(second);
        t9.setTypeface(second);
        t40.setTypeface(second);
        t10.setTypeface(second);
        t11.setTypeface(second);
        t12.setTypeface(second);
        t13.setTypeface(second);
        t14.setTypeface(second);
        t15.setTypeface(second);
        t16.setTypeface(second);
        t17.setTypeface(second);
        t18.setTypeface(second);
        t19.setTypeface(second);
        t20.setTypeface(second);
        t21.setTypeface(second);
        t22.setTypeface(second);
        t23.setTypeface(second);
        t24.setTypeface(second);
        t25.setTypeface(second);
        t26.setTypeface(second);
        t27.setTypeface(second);
        t28.setTypeface(second);
        t29.setTypeface(second);
        t30.setTypeface(second);
        t31.setTypeface(second);
        t32.setTypeface(second);
        t33.setTypeface(second);





    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Teamit.this,Dashboard.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);


    }
}
