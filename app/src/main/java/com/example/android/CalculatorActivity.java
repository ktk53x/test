package com.example.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity
{

    public static final String LOG_TAG = CalculatorActivity.class.getSimpleName();
    private Calculator calculator;
    private EditText firstNumberEditText;
    private EditText secondNumberEditText;
    private TextView resultTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        calculator = new Calculator();
        resultTextView = findViewById(R.id.result_textView);
        firstNumberEditText = findViewById(R.id.first_number_editText);
        secondNumberEditText = findViewById(R.id.second_number_editText);

        if(savedInstanceState != null)
        {
            firstNumberEditText.setText(savedInstanceState.getString("first_number"));
            secondNumberEditText.setText(savedInstanceState.getString("second_number"));
            resultTextView.setText(savedInstanceState.getString("result"));
        }
    }


    public void onAdd(View view)
    {
        compute(Calculator.Operator.ADD);
    }


    public void onSub(View view)
    {
        compute(Calculator.Operator.SUB);
    }


    public void onMul(View view)
    {
        compute(Calculator.Operator.MUL);
    }


    public void onDiv(View view)
    {
        try
        {
            compute(Calculator.Operator.DIV);
        }
        catch(IllegalArgumentException iae)
        {
            Log.e(LOG_TAG, "IllegalArgumentException", iae);
            resultTextView.setText(getString(R.string.computationError));
        }
    }


    private void compute(Calculator.Operator operator)
    {
        double firstNumber;
        double secondNumber;

        try
        {
            firstNumber = getNumber(firstNumberEditText);
            secondNumber = getNumber(secondNumberEditText);
        }
        catch(NumberFormatException nfe)
        {
            Log.e(LOG_TAG, "NumberFormatException", nfe);
            resultTextView.setText(getString(R.string.computationError));
            return;
        }

        String result;
        switch(operator)
        {
            case ADD:
                result = String.valueOf(calculator.add(firstNumber, secondNumber));
                break;
            case SUB:
                result = String.valueOf(calculator.sub(firstNumber, secondNumber));
                break;
            case DIV:
                result = String.valueOf(calculator.div(firstNumber, secondNumber));
                break;
            case MUL:
                result = String.valueOf(calculator.mul(firstNumber, secondNumber));
                break;
            default:
                result = getString(R.string.computationError);
                break;
        }
        resultTextView.setText(result);
    }


    private static Double getNumber(EditText numberEditText)
    {
        String numberText = getNumberText(numberEditText);
        return Double.valueOf(numberText);
    }


    private static String getNumberText(EditText numberEditText)
    {
        return numberEditText.getText().toString();
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        Log.d(LOG_TAG, "onSaveInstanceState");

        if(!resultTextView.getText().toString().isEmpty())
        {
            outState.putString("first_number", getNumberText(firstNumberEditText));
            outState.putString("second_number", getNumberText(secondNumberEditText));
            outState.putString("result", resultTextView.getText().toString());
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
