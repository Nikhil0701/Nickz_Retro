package com.example.nickz_retro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nickz_retro.Nickz.Example;

public class Nickz_Adapter extends RecyclerView.Adapter<Nickz_Adapter.MyHolder> {

    Example example;
    Context context;
    MyHolder holder;

    public Nickz_Adapter(Context context, Example example) {
        this.example=example;
        this.context=context;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(context);
        View row =inflater.inflate(R.layout.single_row, null, false);
        holder=new MyHolder(row);
        return (holder);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.views.setText("Views : "+example.getHits().get(position).getViews());
        holder.Likes.setText("Likes : "+example.getHits().get(position).getLikes());
        holder.downloads.setText("Downloads : "+example.getHits().get(position).getDownloads());
        Glide.with(context).asGif().load(example.getHits().get(position).getVideos().getSmall()).error(R.drawable.ic_launcher_background).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return example.getHits().size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView views;
        TextView Likes;
        TextView downloads;

            public MyHolder(@NonNull View itemView) {
                super(itemView);

                imageView=(ImageView) itemView.findViewById(R.id.ImageView);
                views= (TextView) itemView.findViewById(R.id.textView);
                Likes=(TextView) itemView.findViewById(R.id.textView2);
                downloads=(TextView) itemView.findViewById(R.id.textView3);
            }
        }
}
