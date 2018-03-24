package com.patel.aayush.vision.Tech;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.patel.aayush.vision.Dashboard;
import com.patel.aayush.vision.R;

public class TechEvent extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    ImageView enginus, it, vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_event);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        enginus = (ImageView) findViewById(R.id.engima);
        it = (ImageView) findViewById(R.id.ingenioustreasureid);
        vp = (ImageView) findViewById(R.id.virtualplacementid);
        enginus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TechEvent.this, TechEventsDetails.class);
                intent.putExtra("name", getString(R.string.enigmaname));
                intent.putExtra("amount",getString(R.string.enigmaprice));
                intent.putExtra("contactname",getString(R.string.enigmacontactname));
                intent.putExtra("contactno",getString(R.string.enigmacontact));
                intent.putExtra("img", R.drawable.techeng);
                intent.putExtra("tagline", getString(R.string.enigmatagline));
                intent.putExtra("desc", getString(R.string.enigmadesc));
                intent.putExtra("r1", getString(R.string.enigmaround1));
                intent.putExtra("r2", getString(R.string.enigmaround2));
                intent.putExtra("r3", getString(R.string.enigmaround3));
                intent.putExtra("rules", getString(R.string.enigmarules));
                intent.putExtra("jc", getString(R.string.enigmajc));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TechEvent.this, TechEventsDetails.class);
                intent.putExtra("img", R.drawable.techit);
                intent.putExtra("name", getString(R.string.itname));
                intent.putExtra("tagline", getString(R.string.ittagline));
                intent.putExtra("amount",getString(R.string.itprice));

                intent.putExtra("contactname",getString(R.string.itcontactname));
                intent.putExtra("contactno",getString(R.string.itcontact));
                intent.putExtra("desc", getString(R.string.ittagline));
                intent.putExtra("r1", getString(R.string.itround1));
                intent.putExtra("r2", getString(R.string.itround2));
                intent.putExtra("r3", getString(R.string.itround3));
                intent.putExtra("rules", getString(R.string.itrules));
                intent.putExtra("jc", getString(R.string.itjc));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        vp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TechEvent.this, TechEventsDetails.class);
                intent.putExtra("img", R.drawable.techvp);
                intent.putExtra("name", getString(R.string.vpname));

                intent.putExtra("contactname",getString(R.string.vpcontactname));
                intent.putExtra("contactno",getString(R.string.vpcontact));
                intent.putExtra("amount",getString(R.string.vpprice));
                intent.putExtra("tagline", getString(R.string.vptagline));
                intent.putExtra("desc", getString(R.string.vpdesc));
                intent.putExtra("r1", getString(R.string.vpround1));
                intent.putExtra("r2", getString(R.string.vpround2));
                intent.putExtra("r3", getString(R.string.vpround3));
                intent.putExtra("rules", getString(R.string.vprules));
                intent.putExtra("jc", getString(R.string.vpjc));
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Intent intent = new Intent(TechEvent.this, Dashboard.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);
        finish();

    }
}
