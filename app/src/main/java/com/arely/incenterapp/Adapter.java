package com.arely.incenterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import com.bumptech.glide.Glide;


public class Adapter extends RecyclerView.Adapter<Adapter.PlayerViewHolder>  {

    private Context mCtx;
    private List<Productos> productsList;
    public Adapter(Context mCtx, List<Productos>productsList){
        this.mCtx = mCtx;
        this.productsList = productsList;
    }
    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(mCtx)
                .inflate(R.layout.lista, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Productos products = productsList.get(position);
            Glide.with(mCtx);
            holder.tvName.setText(products.getName());
            holder.tvDescription.setText(products.getDescription());
    }

    @Override
    public int getItemCount() {return productsList.size();}

    static class PlayerViewHolder extends  RecyclerView.ViewHolder{
        TextView tvName, tvDescription;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);

        }
    }
}
