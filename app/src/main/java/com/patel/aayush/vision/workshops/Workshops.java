package com.patel.aayush.vision.workshops;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.patel.aayush.vision.Dashboard;
import com.patel.aayush.vision.R;
import com.patel.aayush.vision.Tech.TechEvent;

public class Workshops extends AppCompatActivity {

    ImageView w1,w2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        w1=(ImageView)findViewById(R.id.w1id);
        w2=(ImageView)findViewById(R.id.w2id);
        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Workshops.this,WorkshopDetail.class);
                intent.putExtra("name",getString(R.string.w1name));
                intent.putExtra("price",getString(R.string.w1price));
                intent.putExtra("about",getString(R.string.w1about));
                intent.putExtra("aboutinfo",getString(R.string.w1aboutinfo));
                intent.putExtra("content",getString(R.string.w1content));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        w2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Workshops.this,WorkshopDetail.class);
                intent.putExtra("name",getString(R.string.w2name));
                intent.putExtra("about",getString(R.string.w2about));
                intent.putExtra("price",getString(R.string.w2price));
                intent.putExtra("aboutinfo",getString(R.string.w2aboutinfo));
                intent.putExtra("content",getString(R.string.w2content));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Workshops.this, Dashboard.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);
        finish();
    }
}
