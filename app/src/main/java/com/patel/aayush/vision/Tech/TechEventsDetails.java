package com.patel.aayush.vision.Tech;

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

import com.patel.aayush.vision.Nontech.Nontech;
import com.patel.aayush.vision.R;

public class TechEventsDetails extends AppCompatActivity {
    TextView ename, etagline, edesc, er1, er2, er3, erules, ejc, t1, t2, t3, t4, t5, t6, t7, t10, t11, pricemain, pricenonmain, contactno;
    ImageView imageView, callid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_events_details);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageView = (ImageView) findViewById(R.id.eventimgid);
        ename = (TextView) findViewById(R.id.enameid);
        pricemain = (TextView) findViewById(R.id.pricemain);
        pricenonmain = (TextView) findViewById(R.id.pricenonmain);
        etagline = (TextView) findViewById(R.id.etaglineid);
        edesc = (TextView) findViewById(R.id.edescid);
        er1 = (TextView) findViewById(R.id.eround1id);
        callid = (ImageView) findViewById(R.id.callid);
        er2 = (TextView) findViewById(R.id.eround2id);
        contactno = (TextView) findViewById(R.id.t10);
        er3 = (TextView) findViewById(R.id.eround3id);
        erules = (TextView) findViewById(R.id.erulesid);
        ejc = (TextView) findViewById(R.id.ejudgingcriteriaid);
        t2 = (TextView) findViewById(R.id.text2);

        t3 = (TextView) findViewById(R.id.text3);
        t4 = (TextView) findViewById(R.id.text4);
        t5 = (TextView) findViewById(R.id.text5);
        t6 = (TextView) findViewById(R.id.text6);
        t7 = (TextView) findViewById(R.id.text7);
        t1 = (TextView) findViewById(R.id.t9);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Bold.ttf");
        ename.setTypeface(typeface);
        t2.setTypeface(typeface);
        t3.setTypeface(typeface);
        t4.setTypeface(typeface);
        t5.setTypeface(typeface);
        t6.setTypeface(typeface);
        t7.setTypeface(typeface);
        t1.setTypeface(typeface);
        t1.setTypeface(typeface);
        pricemain.setTypeface(typeface);

        Typeface second = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
        etagline.setTypeface(second);
        edesc.setTypeface(second);
        er1.setTypeface(second);
        pricenonmain.setTypeface(second);
        er2.setTypeface(second);
        er3.setTypeface(second);
        erules.setTypeface(second);
        ejc.setTypeface(second);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        if (name.equals("Enigma")) {
            imageView.setImageResource(R.drawable.techeng);
        }
        if (name.equals("Virtual Placement")) {
            imageView.setImageResource(R.drawable.techvp);
        }
        if (name.equals("I.T. – Ingenious treasure")) {
            imageView.setImageResource(R.drawable.techit);
        }
        if (name.equals(getString(R.string.n1name))) {
            imageView.setImageResource(R.drawable.cinevistaneww);
        }
        if (name.equals(getString(R.string.n3name))) {
            imageView.setImageResource(R.drawable.batwin);
        }
        if (name.equals(getString(R.string.n2name))) {
            imageView.setImageResource(R.drawable.bb);
        }

        System.out.println(name);
        ename.setText(name);
        etagline.setText(intent.getExtras().getString("tagline"));
        edesc.setText(intent.getExtras().getString("desc"));
        er1.setText(intent.getExtras().getString("r1"));
        er2.setText(intent.getExtras().getString("r2"));
        pricenonmain.setText(intent.getExtras().getString("amount"));
        er3.setText(intent.getExtras().getString("r3"));
        erules.setText(intent.getExtras().getString("rules"));
        ejc.setText(intent.getExtras().getString("jc"));
        t1.setText(intent.getExtras().getString("contactname"));
        contactno.setText(intent.getExtras().getString("contactno"));
        callid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent my_callIntent = new Intent(Intent.ACTION_CALL);
                    my_callIntent.setData(Uri.parse("tel:" + contactno.getText().toString()));
                    //here the word 'tel' is important for making a call...
                    if (ActivityCompat.checkSelfPermission(TechEventsDetails.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        if(ename.getText().toString().equals("I.T. – Ingenious treasure") || ename.getText().toString().equals("Virtual Placement") || ename.getText().toString().equals("Enigma")) {
            Intent intent = new Intent(TechEventsDetails.this, TechEvent.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);
            finish();
        }
        if(ename.getText().toString().equals(getString(R.string.n1name))||ename.getText().toString().equals(getString(R.string.n2name))|| ename.getText().toString().equals(getString(R.string.n3name)) ){
            Intent intent = new Intent(TechEventsDetails.this, Nontech.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_righ);
            finish();
        }



    }
}
