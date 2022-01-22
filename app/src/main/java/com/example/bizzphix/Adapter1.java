package com.example.bizzphix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class Adapter1 extends FirebaseRecyclerAdapter<Member_h, Adapter1.ViewHolder_health> {

    Context context;

    public Adapter1(@NonNull FirebaseRecyclerOptions<Member_h> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder_health holder, int position, @NonNull Member_h model) {
        holder.htitletv.setText(model.getTitle());

        try {

            Glide.with(context).load(model.getImage()).into(holder.hImagetv);


        }
        catch (Exception e)
        {
            Picasso.get().load(model.getImage()).into(holder.hImagetv);


        }


        Picasso.get().load(model.getImage()).into(holder.hImagetv);

        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        holder.view.startAnimation(animation);
    }

    @NonNull
    @Override
    public ViewHolder_health onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image, parent, false);

        return new ViewHolder_health(view);
    }

    public class ViewHolder_health extends RecyclerView.ViewHolder{

        ImageView hImagetv;
        TextView htitletv;
        View view;

        public ViewHolder_health(@NonNull View itemView) {

            super(itemView);

            view = itemView;
            htitletv = itemView.findViewById(R.id.hTitleView);
            hImagetv = itemView.findViewById(R.id.hImageView);

        }
    }


}
