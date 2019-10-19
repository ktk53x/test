package com.example.android;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;


public class RecyclerActivity extends AppCompatActivity implements lets_send_some_data
{

    private final LinkedList<String> wordList = new LinkedList<>();
    private int count = 0;
    private RecyclerView recyclerView;
    private WordListAdapter adapter;
    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        for(int i = 0; i < 20; i++)
        {
            wordList.addLast("Word " + count++);
            Log.d("WordList", wordList.getLast());
        }

        recyclerView = findViewById(R.id.recyclerView);
        displayText = findViewById(R.id.display_text);
        adapter = new WordListAdapter(this, wordList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int wordListSize = wordList.size();
                wordList.addLast("+ Word " + wordListSize);
                recyclerView.getAdapter().notifyItemInserted(wordListSize);
                recyclerView.smoothScrollToPosition(wordListSize);
            }
        });
    }

    @Override
    public void send(int pos)
    {
        displayText.setText(wordList.get(pos));
    }
}
