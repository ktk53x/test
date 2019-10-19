package com.example.android;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    public static final String EXTRA_MESSAGE = "com.example.android.extra.MESSAGE";
    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;


    private TextView replyHeadTextView;
    private TextView replyTextView;
    private EditText messageEditText;
    private EditText websiteEditText;
    private EditText locationEditText;
    private EditText shareTextEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");


        messageEditText = findViewById(R.id.editText_main);
        replyHeadTextView = findViewById(R.id.text_header_reply);
        replyTextView = findViewById(R.id.text_message_reply);
        websiteEditText = findViewById(R.id.website_edittext);
        locationEditText = findViewById(R.id.location_edittext);
        shareTextEditText = findViewById(R.id.share_edittext);


        if(savedInstanceState != null)
        {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if(isVisible)
            {
                replyHeadTextView.setVisibility(View.VISIBLE);
                replyTextView.setText(savedInstanceState.getString("reply_text"));
                replyTextView.setVisibility(View.VISIBLE);
            }
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


    public void launchSecondActivity(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = messageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST)
        {
            if(resultCode == RESULT_OK)
            {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                replyHeadTextView.setVisibility(View.VISIBLE);
                replyTextView.setText(reply);
                replyTextView.setVisibility(View.VISIBLE);
            }
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "onSaveInstanceState");
        if(replyHeadTextView.getVisibility() == View.VISIBLE)
        {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", replyTextView.getText().toString());
        }
    }


    public void openWebsite(View view)
    {
        String url = websiteEditText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d("Implicit Intents", "can't handle this!");
        }

    }


    public void openLocation(View view)
    {
        String loc = locationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent =  new Intent(Intent.ACTION_VIEW, addressUri);
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d("ImplicitIntents", "can't handle this intent!");
        }
    }


    public void shareText(View view)
    {
        String txt = shareTextEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();

    }

    public void launchCalculatorActivity(View view)
    {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }

    public void launchUserInputActivity(View view)
    {
        Intent intent = new Intent(this, UserInputActivity.class);
        startActivity(intent);
    }

    public void launchScrollActivity(View view)
    {
        Intent intent = new Intent(this, ScrollActivity.class);
        startActivity(intent);
    }

    public void launchTabNavigationActivity(View view)
    {
        Intent intent = new Intent(this, TabNavigationActivity.class);
        startActivity(intent);
    }

    public void launchRecyclerViewActivity(View view)
    {
        Intent intent = new Intent(this, RecyclerActivity.class);
        startActivity(intent);
    }

    public void launchStyleThemeActivity(View view)
    {
        Intent intent = new Intent(this, StyleThemeActivity.class);
        startActivity(intent);
    }

    public void launchMaterialMeActivity(View view)
    {
        Intent intent = new Intent(this, MaterialMeActivity.class);
        startActivity(intent);
    }
}
