package com.example.android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>
{
    private final LinkedList<String> wordList;
    private LayoutInflater inflater;
    private lets_send_some_data portal;

    WordListAdapter(Context context, LinkedList<String> wordList, lets_send_some_data portal)
    {
        inflater = LayoutInflater.from(context);
        this.wordList = wordList;
        this.portal = portal;
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        final TextView wordItemView;
        final WordListAdapter adapter;

        WordViewHolder(View itemView, WordListAdapter adapter)
        {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            int position = getLayoutPosition();
            String element = wordList.get(position);
            portal.send(position);
            wordList.set(position, "Clicked! " + element);
            adapter.notifyDataSetChanged();
        }
    }


    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View itemView = inflater.inflate(R.layout.wordlist_item, viewGroup, false);
        return new WordViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder wordViewHolder, int i)
    {
        String current = wordList.get(i);
        wordViewHolder.wordItemView.setText(current);
    }

    @Override
    public int getItemCount()
    {
        return wordList.size();
    }
}
