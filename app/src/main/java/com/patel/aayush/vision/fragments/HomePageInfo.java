package com.patel.aayush.vision.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.patel.aayush.vision.R;

/**
 * Created by aayush on 29-08-2017.
 */

public class HomePageInfo extends Fragment {

    public static final String apikey = "AIzaSyD34B1tBXAUzRf8VR43j9TWao4CLnouIeM";
    public static final String videoid = "aJ7BoNG-r2c";
    FragmentActivity myContext;
    WebView webView;
    TextView textView;
    TextView t1,t2,t3,t4,t5;
    ImageView youtube,web;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepageinfo, container, false);
                return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //YouTubePlayerView youTubePlayerView= (YouTubePlayerView) view.findViewById(R.id.youtube_player);
        ConnectivityManager connMgr = (ConnectivityManager) getActivity()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        textView=(TextView)view.findViewById(R.id.textid);
        t1=(TextView)view.findViewById(R.id.textmain);
        youtube=(ImageView)view.findViewById(R.id.youtubelink);
        web=(ImageView)view.findViewById(R.id.websitelink);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ynaIe7ZUSCY&feature=youtu.be")));
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.itvision17.tk/")));
            }
        });
        t2=(TextView)view.findViewById(R.id.text2);
        t3=(TextView)view.findViewById(R.id.text3);
        t4=(TextView)view.findViewById(R.id.text4);
        t5=(TextView)view.findViewById(R.id.text5);
        Typeface typeface=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Bold.ttf");
        t1.setTypeface(typeface);
        Typeface second=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Regular.ttf");
        t2.setTypeface(second);
        Typeface typeface1=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Bold.ttf");
        t3.setTypeface(typeface1);
        Typeface typeface2=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Regular.ttf");
        t4.setTypeface(typeface2);
        Typeface typeface3=Typeface.createFromAsset(getActivity().getAssets(),"fonts/Raleway-Bold.ttf");
        t5.setTypeface(typeface3);

        textView.setVisibility(View.VISIBLE);
        try {
            if (networkInfo != null && networkInfo.isConnected()) {
                textView.setVisibility(View.GONE);
                webView = (WebView) view.findViewById(R.id.webid);
                webView.getSettings().setJavaScriptEnabled(true);
                String myvieo = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ynaIe7ZUSCY\" frameborder=\"0\" allowfullscreen></iframe>";
                webView.loadData(myvieo, "text/html", "utf-8");
                webView.setWebChromeClient(new WebChromeClient() {

                });

            } else {
                webView.setVisibility(View.GONE);


            }
        }
        catch (Exception e)
        {

        }


    }


}
