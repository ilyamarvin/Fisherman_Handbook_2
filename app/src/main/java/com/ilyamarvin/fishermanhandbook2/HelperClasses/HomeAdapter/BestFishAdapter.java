package com.ilyamarvin.fishermanhandbook2.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ilyamarvin.fishermanhandbook2.R;

import java.util.ArrayList;

public class BestFishAdapter extends RecyclerView.Adapter<BestFishAdapter.BestFishViewHolder> {

    ArrayList<BestFishHelperClass> bestFishLocations;

    public BestFishAdapter(ArrayList<BestFishHelperClass> bestFishLocations) {
        this.bestFishLocations = bestFishLocations;
    }

    @NonNull
    @Override
    public BestFishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.best_fish_card, parent, false);
        BestFishViewHolder bestFishViewHolder = new BestFishViewHolder(view);
        return bestFishViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BestFishViewHolder holder, int position) {

        BestFishHelperClass bestFishHelperClass = bestFishLocations.get(position);

        holder.image.setImageResource(bestFishHelperClass.getImage());
        holder.title.setText(bestFishHelperClass.getTitle());
        holder.desc.setText(bestFishHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return bestFishLocations.size();
    }

    public static class BestFishViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;

        public BestFishViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.best_fish_image);
            title = itemView.findViewById(R.id.best_fish_title);
            desc = itemView.findViewById(R.id.best_fish_desc);
        }
    }
}
