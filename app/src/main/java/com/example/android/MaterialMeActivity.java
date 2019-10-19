package com.example.android;

import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class MaterialMeActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private ArrayList<Sport> sportsData;
    private SportsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_me);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sportsData = new ArrayList<>();

        adapter = new SportsAdapter(this, sportsData);
        recyclerView.setAdapter(adapter);

        initializeData();


    }

    private void initializeData()
    {
        String[] sportsList = getResources().getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);

        sportsData.clear();

        for(int i = 0; i < sportsList.length; i++)
            sportsData.add(new Sport(sportsList[i], sportsInfo[i], sportsImageResources.getResourceId(i, 0)));

        sportsImageResources.recycle();

        adapter.notifyDataSetChanged();
    }
}
