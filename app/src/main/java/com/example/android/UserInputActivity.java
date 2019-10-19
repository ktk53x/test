package com.example.android;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UserInputActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    public static final String LOG_TAG = UserInputActivity.class.getSimpleName();

    private EditText passwordEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private Spinner spinner;
    private TextView emailTextView;
    private TextView phoneLabelText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);


        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");


        Intent intent = getIntent();


        passwordEditText = findViewById(R.id.ui_password_editText);
        emailEditText = findViewById(R.id.ui_email_editText);
        phoneEditText = findViewById(R.id.ui_phone_editText);
        emailTextView = findViewById(R.id.ui_email_textView);
        phoneLabelText = findViewById(R.id.ui_phoneLabelText_textView);
        spinner = findViewById(R.id.ui_spinner);
        button = findViewById(R.id.ui_OnClickListener_button);


        if(spinner != null)
        {
            spinner.setOnItemSelectedListener(this);
        }


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ui_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        if(spinner != null)
        {
            spinner.setAdapter(adapter);
        }


        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String listening = "Listening...";
                Toast.makeText(UserInputActivity.this, listening, Toast.LENGTH_SHORT).show();
            }
        });
        if(savedInstanceState != null)
        {

            String password = savedInstanceState.getString("password");
            String email = savedInstanceState.getString("email");
            String phone = savedInstanceState.getString("phone");


            if(password != null)
            {
                passwordEditText.setText(password);
            }
            if(email != null)
            {
                emailEditText.setText(email);
                emailTextView.setText(email);
                emailTextView.setVisibility(View.VISIBLE);
            }
            if(phone != null)
            {
                phoneEditText.setText(phone);
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


    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        Log.d(LOG_TAG, "onSaveInstanceState");


        String password = passwordEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phone = phoneEditText.getText().toString();

        if(!password.isEmpty())
        {
            outState.putString("password", password);
        }
        if(!email.isEmpty())
        {
            outState.putString("email", email);
        }
        if(!phone.isEmpty())
        {
            outState.putString("phone", phone);
        }

    }


    public void showText(View view)
    {
        EditText editText;
        int buttonId = view.getId();
        switch(buttonId)
        {
            case R.id.ui_password_button:
                editText = findViewById(R.id.ui_password_editText);
                break;
            case R.id.ui_email_button:
                editText = findViewById(R.id.ui_email_editText);
                break;
            case R.id.ui_phone_button:
                editText = findViewById(R.id.ui_phone_editText);
                break;
            default:
                editText = null;
        }
        if(editText != null)
        {
            String showString = editText.getText().toString();
            Toast.makeText(this, showString, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String spinnerLabel = parent.getItemAtPosition(position).toString();
        String phone = phoneEditText.getText().toString();
        String phoneLabel = phone + " - " + spinnerLabel;
        if(!phone.isEmpty())
            phoneLabelText.setText(phoneLabel);

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        Log.d(LOG_TAG, "onNothingSelected");
    }


    public void onClickShowAlert(View view)
    {
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(UserInputActivity.this);
        myAlertBuilder.setTitle(R.string.ui_alert_button);
        myAlertBuilder.setMessage(R.string.ui_alert_message);
        myAlertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "Pressed OK", Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "Pressed Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.show();

    }


    public void processDatePickerResult(int year, int month, int day)
    {
        String month_string = Integer.toString(month+1);
        String day_string  = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_SHORT).show();

    }


    public void showDatePickerDialog(View view)
    {
        DialogFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), getString(R.string.ui_date_picker));
    }


    public void processTimePickerResult(int hourOfDay, int minute)
    {
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        String timeMessage = (hour_string + ":" + minute_string);
        Toast.makeText(this, "Time: " + timeMessage, Toast.LENGTH_SHORT).show();
    }


    public void showTimePickerDialog(View view)
    {
        DialogFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.show(getSupportFragmentManager(), getString(R.string.ui_time_picker));
    }


    public void launchImagesActivity(View view)
    {
        Intent intent = new Intent(this, ImagesActivity.class);
        startActivity(intent);
    }
}
