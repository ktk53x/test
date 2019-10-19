package com.example.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class StyleThemeActivity extends AppCompatActivity
{
    private int score1;
    private int score2;
    private TextView scoreText1;
    private TextView scoreText2;

    private final String STATE_SCORE_1 = "Team1 score";
    private final String STATE_SCORE_2 = "Team2 score";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_theme);

        scoreText1 = findViewById(R.id.score_1);
        scoreText2 = findViewById(R.id.score_2);
        if(savedInstanceState != null)
        {
            score1 = savedInstanceState.getInt(STATE_SCORE_1);
            score2 = savedInstanceState.getInt(STATE_SCORE_2);

            scoreText1.setText(String.valueOf(score1));
            scoreText2.setText(String.valueOf(score2));
        }
        else
        {
            score1 = Integer.parseInt(scoreText1.getText().toString());
            score2 = Integer.parseInt(scoreText2.getText().toString());
        }
    }

    public void decreaseScore(View view)
    {
        int viewID = view.getId();
        switch (viewID)
        {
            case R.id.decreaseTeam1:
                score1--;
                scoreText1.setText(String.valueOf(score1));
                break;
            case R.id.decreaseTeam2:
                score2--;
                scoreText2.setText(String.valueOf(score2));
        }
    }

    public void increaseScore(View view)
    {
        int viewID = view.getId();
        switch (viewID)
        {
            case R.id.increaseTeam1:
                score1++;
                scoreText1.setText(String.valueOf(score1));
                break;
            case R.id.increaseTeam2:
                score2++;
                scoreText2.setText(String.valueOf(score2));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SCORE_1, score1);
        outState.putInt(STATE_SCORE_2, score2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_style_theme, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES)
        {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }
        else
        {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.night_mode)
        {
        }
        return false;
    }
}
