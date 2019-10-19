package com.example.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity
{
    private static final String LOG_TAG = OrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }
    public void displayToast(String message)
    {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view)
    {
        boolean checked =((RadioButton) view).isChecked();
        switch(view.getId())
        {
            case R.id.same_day_radioButton:
                if (checked)
                    displayToast(getString(R.string.chosen) + getString(R.string.same_day_radioButton));
                break;
            case R.id.next_day_radioButton:
                if(checked)
                    displayToast(getString(R.string.chosen) + getString(R.string.next_day_radioButton));
                break;
            case R.id.pick_up_radioButton:
                if(checked)
                    displayToast(getString(R.string.chosen) + getString(R.string.pick_up_radioButton));
                break;
            default:
                Log.d(LOG_TAG, getString(R.string.nothing_clicked));
                break;
        }
    }
}
