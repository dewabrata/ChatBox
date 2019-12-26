package com.juara.chatbox;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterListSimple extends RecyclerView.Adapter<AdapterListSimple.ViewHolder> {

    public static int TYPE_SENDER =0;
    public static int TYPE_RECEIVER =1;


    List<ModelChat> data;
    Context context;


    public AdapterListSimple(Context context, List<ModelChat> data){


        this.data = data;
        this.context = context;

    }


    @Override
    public int getItemViewType(int position) {

        if(data.get(position).getType()==TYPE_SENDER){
            return TYPE_SENDER;

        }else
        {
            return TYPE_RECEIVER;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        if(viewType == TYPE_SENDER ){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_kanan, parent, false);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_kiri, parent, false);
        }

        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        TextView txtNama = holder.txtNama;
        ImageView image = holder.image;

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ContactActivity.class);
                intent.putExtra("data",data.get(position));
                context.startActivity(intent);
            }
        });

        txtNama.setText(data.get(position).getText());
        Picasso.get().load(data.get(position).getImage()).into(image);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView txtNama;
        public ImageView image;
        public LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            txtNama = (TextView) itemView.findViewById(R.id.txtName);
            image = (ImageView)itemView.findViewById(R.id.imageView);
            parentLayout = (LinearLayout)itemView.findViewById(R.id.parentLayout);

        }

    }


}
