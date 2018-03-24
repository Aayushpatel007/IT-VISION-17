package com.patel.aayush.vision.CheckRegStatus;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.patel.aayush.vision.Dashboard;
import com.patel.aayush.vision.R;
import com.patel.aayush.vision.Tech.TechEvent;

public class CheckRegistation extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView m1,m2,t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_registation);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        editText=(EditText)findViewById(R.id.nameedid);
        m1=(TextView)findViewById(R.id.main1);
        m2=(TextView)findViewById(R.id.main2);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"fonts/Raleway-Bold.ttf");
        m1.setTypeface(typeface);
        m2.setTypeface(typeface);
        Typeface second=Typeface.createFromAsset(getAssets(),"fonts/Raleway-Regular.ttf");
        t2.setTypeface(second);
        t1.setTypeface(second);
        t3.setTypeface(second);

        button=(Button)findViewById(R.id.checkbuttonid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CheckRegistation.this,DetailsReg.class);
                intent.putExtra("id",editText.getText().toString());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(CheckRegistation.this, Dashboard.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);
        finish();
    }
}
