package com.patel.aayush.vision.fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.patel.aayush.vision.CheckRegStatus.CheckRegistation;
import com.patel.aayush.vision.Dashboard;
import com.patel.aayush.vision.Nontech.Nontech;
import com.patel.aayush.vision.R;
import com.patel.aayush.vision.Tech.TechEvent;
import com.patel.aayush.vision.workshops.Workshops;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by aayush on 22-08-2017.
 */

public class Home extends Fragment {

    ImageView tech, nontech, wk;
    TextView t1, t2, t3;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homepageevents, container, false);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tech = (ImageView) view.findViewById(R.id.techbuttonid);
        wk = (ImageView) view.findViewById(R.id.nworkshopid);

        nontech = (ImageView) view.findViewById(R.id.nontechbuttonid);
        t1 = (TextView) view.findViewById(R.id.textmain);
        t2 = (TextView) view.findViewById(R.id.text1);
        t3 = (TextView) view.findViewById(R.id.clckhereid);

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Bold.ttf");
        t1.setTypeface(typeface);
        Typeface second = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Raleway-Regular.ttf");
        t2.setTypeface(second);
        t3.setTypeface(second);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CheckRegistation.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        //            getActivity().finish();
      //          getActivity().finish();
            }
        });
        wk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Workshops.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
          //      getActivity().finish();
            }
        });
        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), TechEvent.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            //    getActivity().finish();
            }
        });
        nontech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Nontech.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
              //  getActivity().finish();
            }
        });

    }

}





