package com.patel.aayush.vision.workshops;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.patel.aayush.vision.R;
import com.patel.aayush.vision.Tech.TechEventsDetails;

public class WorkshopDetail extends AppCompatActivity {
TextView name,content,about,aboutinfo,main1,pmain,pnomain,contact;
    ImageView imageView,callid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop_detail);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        name=(TextView)findViewById(R.id.nameid);
        contact=(TextView)findViewById(R.id.t10);
        callid=(ImageView)findViewById(R.id.callid);
        pmain=(TextView)findViewById(R.id.pricemain);
        pnomain=(TextView)findViewById(R.id.pricenonmain);
        imageView=(ImageView)findViewById(R.id.eventimgid);
        content=(TextView)findViewById(R.id.content);
        about=(TextView)findViewById(R.id.about);
        aboutinfo=(TextView)findViewById(R.id.aboutinfo);
        main1=(TextView)findViewById(R.id.main1);
        name.setText(getIntent().getExtras().getString("name"));
        content.setText(getIntent().getExtras().getString("content"));
        about.setText(getIntent().getExtras().getString("about"));
        aboutinfo.setText(getIntent().getExtras().getString("aboutinfo"));
        pnomain.setText(getIntent().getExtras().getString("price"));
        Intent intent = getIntent();
        String name1 = intent.getExtras().getString("name");
        if (name1.equals(getString(R.string.w1name))) {
            imageView.setImageResource(R.drawable.wkmaac);
        }
        if (name1.equals(getString(R.string.w2name))) {
            imageView.setImageResource(R.drawable.wkhack);
        }

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Bold.ttf");
        name.setTypeface(typeface);
        main1.setTypeface(typeface);
        about.setTypeface(typeface);
        pmain.setTypeface(typeface);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
        content.setTypeface(typeface1);
        aboutinfo.setTypeface(typeface1);
        pnomain.setTypeface(typeface1);
        callid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent my_callIntent = new Intent(Intent.ACTION_CALL);
                    my_callIntent.setData(Uri.parse("tel:" + contact.getText().toString()));
                    //here the word 'tel' is important for making a call...
                    if (ActivityCompat.checkSelfPermission(WorkshopDetail.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    startActivity(my_callIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Error in your phone call", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(WorkshopDetail.this,Workshops.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);
    }
}
