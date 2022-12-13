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

public class Adapter extends RecyclerView.Adapter<Adapter.PlayerViewnHolder>  {

    private Context mCtx;
    private List<Productos> productosList;
    public Adapter(Context mCtx, List<Productos>productosList){
        this.mCtx=mCtx;
        this.productosList=productosList;
    }
    @NonNull
@Override
    public PlayerViewnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.lista,null);

        return new PlayerViewnHolder(view);
    }

@Override
    public void onBindViewHolder(@NonNull PlayerViewnHolder holder, int position) {
        Productos productos=productosList.get(position);
            Glide.with(mCtx);
            holder.tv1.setText(productos.getCodigo());
        holder.tv2.setText(productos.getNombreProducto());
        holder.tv3.setText(productos.getDescripcion());
        holder.tv4.setText(productos.getPrecioCompra());
        holder.tv5.setText(productos.getPrecioventa());
        holder.tv6.setText(productos.getExistencia());
    }



   @Override
    public int getItemCount() {return productosList.size();}

    static class PlayerViewnHolder extends  RecyclerView.ViewHolder{
        TextView tv1,tv2,tv3,tv4,tv5,tv6;

        public PlayerViewnHolder(@NonNull View itemView) {
            super(itemView);

            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
            tv3=itemView.findViewById(R.id.tv3);
            tv4=itemView.findViewById(R.id.tv4);
            tv5=itemView.findViewById(R.id.tv5);
            tv6=itemView.findViewById(R.id.tv6);

        }
    }
}
