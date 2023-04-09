package com.example.hackathon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.Model.Dogs;
import com.example.hackathon.R;

import java.util.ArrayList;

public class Dogs_Adapter extends RecyclerView.Adapter<Dogs_Adapter.viewHolder>{

    ArrayList<Dogs> list;
    Context context;
    Dogs_Adapter (Context context, ArrayList<Dogs> list){
        this.context = context;
    }

    public Dogs_Adapter(ArrayList<Dogs> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.activity_model, parent , false);
        viewHolder v = new viewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Dogs model = list.get(position);
        holder.image.setImageResource(model.getPic());
        holder.location.setText(model.getLocation());
        holder.description.setText(model.getDescription());
        holder.map.setText(model.getMap());
        setAnimation(holder.itemView, position);

        switch (position){
            case 0:
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent intent = new Intent(Dogs_Adapter.this, Information_Activity.class);
                    }
                });

                break;


            default:
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView location, description;

        Button map;

        CardView cardView;
        public viewHolder(@NonNull View iteamView) {
            super(iteamView);

            image = iteamView.findViewById(R.id.imageView);
            location = iteamView.findViewById(R.id.location);
            description = iteamView.findViewById(R.id.description);
            cardView = iteamView.findViewById(R.id.card);
            map = iteamView.findViewById(R.id.map);

//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Intent intent = new Intent(Dogs_Adapter.this, Information_Activity.class);
//                    Toast.makeText(context,"Done", Toast.LENGTH_LONG);
//                }
//            });
//            iteamView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(context,"Done",Toast.LENGTH_LONG);
//                }
//            });
        }


    }

    private void setAnimation(View view, int position){
        Animation slideIn = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        view.startAnimation(slideIn);
    }
}
