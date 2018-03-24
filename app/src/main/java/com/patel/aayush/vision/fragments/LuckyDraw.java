package com.patel.aayush.vision.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.patel.aayush.vision.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aayush on 22-08-2017.
 */

public class LuckyDraw extends Fragment {
    Button register;
    String name;
    String status;
    EditText nameed, phoneed, ided;
    SharedPreferences preferences;
    String st;
    TextView deptv, yeartv,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    Spinner depsipnner, yearspinner;
    String url = "https://caseous-audit.000webhostapp.com/newluckdraw.php";
    String[] depatments = {"IT", "MECHANICAL", "E.C", "ELECTRICAL", "C.E", "AERONAUTICAL", "I.C", "CIVIL", "M.C.A", "ARCHITECTURE"};
    String[] years = {"FY", "SY", "TY", "LY"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.luckydraw, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameed = view.findViewById(R.id.ln);
        phoneed = view.findViewById(R.id.lp);
        ided = view.findViewById(R.id.lid);

        deptv = (TextView) view.findViewById(R.id.deptv);
        yeartv = (TextView) view.findViewById(R.id.yeartv);
        t1 = (TextView) view.findViewById(R.id.text1);
        t2 = (TextView) view.findViewById(R.id.text2);
        t3 = (TextView) view.findViewById(R.id.text3);
        t4 = (TextView) view.findViewById(R.id.text4);
        t5 = (TextView) view.findViewById(R.id.text5);
        t6 = (TextView) view.findViewById(R.id.text6);t8 = (TextView) view.findViewById(R.id.text8);
        t9 = (TextView) view.findViewById(R.id.text9);
        t7 = (TextView) view.findViewById(R.id.text7);
        final Typeface typeface=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Bold.ttf");
        t1.setTypeface(typeface);
        Typeface typeface1=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Bold.ttf");
        t6.setTypeface(typeface1);
        Typeface typeface2=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Bold.ttf");
        t8.setTypeface(typeface2);
        Typeface second=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Regular.ttf");
        t2.setTypeface(second);
        Typeface second1=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Regular.ttf");
        t3.setTypeface(second1);
        Typeface second3=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Regular.ttf");
        t4.setTypeface(second3);
        Typeface second4=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Regular.ttf");
        t5.setTypeface(second4);
        Typeface second5=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Regular.ttf");
        t7.setTypeface(second5);
        t9.setTypeface(second5);



        deptv.setText("IT");
        deptv.setVisibility(View.GONE);
        yeartv.setVisibility(View.GONE);
        depsipnner = (Spinner) view.findViewById(R.id.departmentspinner);
        yearspinner = (Spinner) view.findViewById(R.id.yearspinner);
        ArrayAdapter<String> dataadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, depatments);
        depsipnner.setAdapter(dataadapter);
        ArrayAdapter<String> dataa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, years);
        yearspinner.setAdapter(dataa);
        depsipnner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                deptv.setText(depsipnner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        yearspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                yeartv.setText(yearspinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        register = (Button) view.findViewById(R.id.registerid);
        preferences = getActivity().getSharedPreferences("vision", Context.MODE_PRIVATE);
        name = preferences.getString("name", "noname");
        status = preferences.getString("status", "nostatus");
        if (status.equals("yes")) {
            st = "Yes student";
        }
        if (status.equals("no")) {
            st = "No student";
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "sdhsjhdjshdj", Toast.LENGTH_SHORT).show();
        //        Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
          //      Toast.makeText(getActivity(), st, Toast.LENGTH_SHORT).show();
////////////////////////////////////////////
if(status.equals("yes")) {

    if (validate() == true) {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait..");
        progressDialog.show();
        progressDialog.setCancelable(false);

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("yespresent")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    View view1 = getActivity().getLayoutInflater().inflate(R.layout.dialog_luckydrawpresent, null);
                    TextView main = (TextView) view1.findViewById(R.id.main1);
                    TextView t = (TextView) view1.findViewById(R.id.t1);
                    Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Bold.ttf");
                    main.setTypeface(typeface);
                    Typeface second = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Regular.ttf");
                    t.setTypeface(second);

                    builder.setView(view1);
                    AlertDialog dialog = builder.create();
                    dialog.show();

                    //Toast.makeText(getActivity(),"yespresent",Toast.LENGTH_SHORT).show();


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    View view1 = getActivity().getLayoutInflater().inflate(R.layout.dialog_luckydrawabsent, null);
                    TextView main = (TextView) view1.findViewById(R.id.main1);
                    TextView t = (TextView) view1.findViewById(R.id.t1);
                    Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Bold.ttf");
                    main.setTypeface(typeface);
                    Typeface second = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Regular.ttf");
                    t.setTypeface(second);

                    builder.setView(view1);
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
                progressDialog.dismiss();
                nameed.setText("");
                phoneed.setText("");
                ided.setText("");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Registration Failed.Check your Internet connection and try again.", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                //   System.out.println("Data is " + it.next());

                final Map<String, String> params = new HashMap<String, String>();
                params.put("name", nameed.getText().toString());
                params.put("department", deptv.getText().toString());
                params.put("year", yeartv.getText().toString());
                params.put("phoneno", phoneed.getText().toString());
                params.put("id", ided.getText().toString().toLowerCase());
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
}
else{

    Toast.makeText(getActivity(),"You cannot participate in this event as Lucky Draw event is only for SVIT students.",Toast.LENGTH_SHORT).show();
}
            }
        });

    }

    public boolean validate() {
        boolean valid = true;

        //Integer nn=Integer.valueOf(phoneed.getText().toString());

        if (nameed.getText().toString().isEmpty()) {
            nameed.setError("Please enter name ");
            valid = false;
        } else {
            nameed.setError(null);
        }

        if (phoneed.getText().toString().isEmpty()) {
            phoneed.setError("Please enter valid phone no");
            valid = false;
        } else {
            phoneed.setError(null);
        }
        if (ided.getText().toString().isEmpty()) {
            ided.setError("Please enter valid ID no");
            valid = false;
        } else {
            ided.setError(null);
        }

        return valid;
    }


}

