package com.patel.aayush.vision.CheckRegStatus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.patel.aayush.vision.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetailsReg extends AppCompatActivity {
    TextView id, name, email, phone, dep, year, total, m1, m2, m3, m4, m5, m6, m7, m8, m9;
    ListView listView;
    List<EventsRegistered> eventsRegisteredList;
    List<String> pricelist;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_reg);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        linearLayout = (LinearLayout) findViewById(R.id.ll);
        linearLayout.setVisibility(View.GONE);
        id = (TextView) findViewById(R.id.infoid);


        listView = (ListView) findViewById(R.id.listid);
        name = (TextView) findViewById(R.id.infoname);
        phone = (TextView) findViewById(R.id.infocontact);
        email = (TextView) findViewById(R.id.infoemail);
        dep = (TextView) findViewById(R.id.infodep);
        year = (TextView) findViewById(R.id.infoyear);
        total = (TextView) findViewById(R.id.infototal);
        m1 = (TextView) findViewById(R.id.main1);
        m2 = (TextView) findViewById(R.id.main2);
        m3 = (TextView) findViewById(R.id.main3);
        m4 = (TextView) findViewById(R.id.main4);
        m5 = (TextView) findViewById(R.id.main5);
        m9 = (TextView) findViewById(R.id.main9);
        m6 = (TextView) findViewById(R.id.main6);
        m7 = (TextView) findViewById(R.id.main7);
        m8 = (TextView) findViewById(R.id.main8);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Bold.ttf");
        m1.setTypeface(typeface);
        m2.setTypeface(typeface);
        m3.setTypeface(typeface);
        m4.setTypeface(typeface);
        m5.setTypeface(typeface);
        m6.setTypeface(typeface);
        m7.setTypeface(typeface);
        m8.setTypeface(typeface);
        Typeface second = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");


        RequestQueue requestQueue = Volley.newRequestQueue(DetailsReg.this);
        Intent intent = getIntent();
        String idid = intent.getExtras().getString("id");
        eventsRegisteredList = new ArrayList<>();
        final ProgressDialog progressDialog = new ProgressDialog(DetailsReg.this);
        progressDialog.setTitle("Fetching Data");
        progressDialog.setMessage("Please wait a minute..");
        progressDialog.setCancelable(false);
        progressDialog.show();
        String urlgetinfo = "https://caseous-audit.000webhostapp.com/tempgetstatus.php?sid=" + idid.toLowerCase();
        pricelist = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlgetinfo, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //ided.setText("");
                    linearLayout.setVisibility(View.GONE);

                    if (response.equals("empty")) {
                        progressDialog.dismiss();
                        linearLayout.setVisibility(View.GONE);
                        final AlertDialog.Builder builder = new AlertDialog.Builder(DetailsReg.this);
                        View view1 = getLayoutInflater().inflate(R.layout.dialog_noentry, null);
                        Button button = view1.findViewById(R.id.cancelbutton);
                        builder.setView(view1);
                        builder.setCancelable(false);
                        final AlertDialog dialog = builder.create();

                        dialog.show();
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });


                    } else {
                        linearLayout.setVisibility(View.VISIBLE);
                        progressDialog.dismiss();
                        //JSONObject jsonObject=new JSONObject(response);
                        JSONObject result = new JSONObject(response);
                        name.setText(result.getString("name"));
                        id.setText(result.getString("collegeid"));
                        email.setText(result.getString("email"));
                        phone.setText(result.getString("phone"));
                        dep.setText(result.getString("department"));
                        year.setText(result.getString("year"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(DetailsReg.this, "Failed fetching data,please check your internet connection and try again", Toast.LENGTH_SHORT).show();
            }
        });
        String urlget = "https://caseous-audit.000webhostapp.com/statuscheck2.php?sid=" + idid.toLowerCase();
        final ProgressDialog progressDialog1 = new ProgressDialog(DetailsReg.this);
        progressDialog1.setTitle("Fetching Data");
        progressDialog1.setMessage("Please wait a minute");
        progressDialog1.show();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlget, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog1.dismiss();
                linearLayout.setVisibility(View.VISIBLE);
                JSONArray jsonArray = null;
                try {
                    jsonArray = response.getJSONArray("result");
                    int n = jsonArray.length();

                    for (int i = 0; i < n; i++) {

                        JSONObject movieObject = jsonArray.getJSONObject(i);
                        String name = movieObject.getString("eventname");
                        String event_price = movieObject.getString("event_price");
                        eventsRegisteredList.add(new EventsRegistered(name, event_price));
                        pricelist.add(event_price);
                        System.out.println(pricelist);
                        CustomAdapter customAdapter = new CustomAdapter();
                        listView.setAdapter(customAdapter);

                    }
                    int to = 0;

                    for (int k = 0; k < pricelist.size(); k++) {
                        to += Integer.parseInt(pricelist.get(k));
                        System.out.println(to);

                    }
                    System.out.println(to);
                    total.setText("" + to);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(DetailsReg.this, "Failed fetching data.Try again and check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);

        requestQueue.add(stringRequest);


    }

    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return eventsRegisteredList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            EventsRegistered n = eventsRegisteredList.get(i);

            view = getLayoutInflater().inflate(R.layout.adapter_eventsregisteredxml, null);
            TextView nametv = view.findViewById(R.id.nameid);
            TextView pricetv = view.findViewById(R.id.priceid);
            nametv.setText(n.eventname);
            pricetv.setText(n.eventprice);


            return view;
        }


    }
}
