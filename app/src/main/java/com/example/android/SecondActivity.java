package com.example.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    public static final String EXTRA_REPLY = "com.example.android.extra.REPLY";
    public static final String LOG_TAG = SecondActivity.class.getSimpleName();
    private EditText reply;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
        reply = findViewById(R.id.editText_second);
    }


    public void returnReply(View view)
    {
        String replymessage = reply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, replymessage);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        finish();
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
