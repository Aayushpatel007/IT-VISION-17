package com.patel.aayush.vision.Nontech;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.patel.aayush.vision.Dashboard;
import com.patel.aayush.vision.R;
import com.patel.aayush.vision.Tech.TechEvent;
import com.patel.aayush.vision.Tech.TechEventsDetails;

public class Nontech extends AppCompatActivity {

    CardView cinewista, bat2win, bigbazar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nontech);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        cinewista = (CardView) findViewById(R.id.cinewista);
        bat2win = (CardView) findViewById(R.id.b2win);
        bigbazar = (CardView) findViewById(R.id.bigbazar);

        cinewista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nontech.this, TechEventsDetails.class);
                intent.putExtra("name", getString(R.string.n1name));
                intent.putExtra("img", R.drawable.cinevistaneww);
                intent.putExtra("amount",getString(R.string.n1aprice));
                intent.putExtra("tagline", getString(R.string.n1tagline));
                intent.putExtra("desc", getString(R.string.n1aboutevent));
                intent.putExtra("r1", getString(R.string.n1round1));
                intent.putExtra("r2", getString(R.string.n1round2));
                intent.putExtra("r3", getString(R.string.n1round3));
                intent.putExtra("rules", getString(R.string.n1rules));

                intent.putExtra("contactname",getString(R.string.n1contactname));
                intent.putExtra("contactno",getString(R.string.n1contact));
                intent.putExtra("jc", getString(R.string.n1jc));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        bigbazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nontech.this, TechEventsDetails.class);
                intent.putExtra("name", getString(R.string.n2name));

                intent.putExtra("contactname",getString(R.string.n2contactname));
                intent.putExtra("contactno",getString(R.string.n2contact));
                intent.putExtra("img", R.drawable.bb);
                intent.putExtra("amount",getString(R.string.n2price));
                intent.putExtra("tagline", getString(R.string.n2tagline));
                intent.putExtra("desc", getString(R.string.n2aboutevent));
                intent.putExtra("r1", getString(R.string.n2round1));
                intent.putExtra("r2", getString(R.string.n2round2));
                intent.putExtra("r3", getString(R.string.n2round3));
                intent.putExtra("rules", getString(R.string.n2rules));
                intent.putExtra("jc", getString(R.string.n2jc));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });
        bat2win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Nontech.this, TechEventsDetails.class);
                intent.putExtra("name", getString(R.string.n3name));
                intent.putExtra("img", R.drawable.batwin);

                intent.putExtra("contactname",getString(R.string.n3contactname));
                intent.putExtra("contactno",getString(R.string.n3contact));
                intent.putExtra("amount",getString(R.string.n3price));
                intent.putExtra("tagline", getString(R.string.n3tagline));
                intent.putExtra("desc", getString(R.string.n3aboutevent));
                intent.putExtra("r1", getString(R.string.n3round1));
                intent.putExtra("r2", getString(R.string.n3round2));
                intent.putExtra("r3", getString(R.string.n3round3));
                intent.putExtra("rules", getString(R.string.n3rules));
                intent.putExtra("jc", getString(R.string.n3jc));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Nontech.this, Dashboard.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);
        finish();
    }
}
