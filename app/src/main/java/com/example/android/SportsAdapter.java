package com.example.android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder>
{
    private ArrayList<Sport> sportsData;
    private Context context;
    private ImageView sportsImage;

    SportsAdapter(Context context, ArrayList<Sport> sportsData)
    {
        this.sportsData = sportsData;
        this.context = context;
    }

    @NonNull
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.ViewHolder viewHolder, int i)
    {
        Sport currentSport = sportsData.get(i);
        viewHolder.bindTo(currentSport);
        //Glide.with(context).load(currentSport.getImageResource()).into(viewHolder.sportsImage);
    }

    @Override
    public int getItemCount()
    {
        return sportsData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView titleText;
        private TextView infoText;
        private ImageView sportsImage;

        ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            titleText = itemView.findViewById(R.id.titleMe);
            infoText = itemView.findViewById(R.id.subTitle);
            sportsImage = itemView.findViewById(R.id.sportsImage);
        }

        void bindTo(Sport currentSport)
        {
            titleText.setText(currentSport.getTitle());
            infoText.setText(currentSport.getInfo());
            sportsImage.setImageResource(currentSport.getImageResource());
        }
    }
}


