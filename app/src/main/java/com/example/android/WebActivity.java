package com.example.android;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity
{

    public static final String LOG_TAG = WebActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Intent intent = getIntent();
        Uri uri = intent.getData();
        if(uri != null)
        {
            String uri_string = "URI: " + uri.toString();
            TextView textView = findViewById(R.id.text_uri_message);
            textView.setText(uri_string);
        }
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }


    @Override
    public void onRestart()
    {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }


    @Override
    public void onResume()
    {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }


    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }


    @Override
    public void onStop()
    {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }


    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

}
