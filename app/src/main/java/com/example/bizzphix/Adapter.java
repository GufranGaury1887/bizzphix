package com.example.bizzphix;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.firestore.auth.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends FirebaseRecyclerAdapter<Member, Adapter.ViewHolder> {



    Context context;

    public Adapter(@NonNull FirebaseRecyclerOptions<Member> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Member model) {
        holder.mtitletv.setText(model.getTitle());

        try {

            Picasso.get().load(model.getImage()).into(holder.mImagetv);

        }
        catch (Exception e)
        {

            Glide.with(context).load(model.getImage()).into(holder.mImagetv);

        }


        Picasso.get().load(model.getImage()).into(holder.mImagetv);

        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        holder.view.startAnimation(animation);
        holder.mImagetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,ClickeditemActivity.class);
                intent.putExtra("urlToImage",model.getImage());
                context.startActivity(intent);

            }
        });

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image, parent, false);

        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView mImagetv;
        TextView mtitletv;
        View view;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            view = itemView;
            mtitletv = itemView.findViewById(R.id.rTitleView);
            mImagetv = itemView.findViewById(R.id.rImageView);
//            itemView.setOnClickListener((this));

        }


//        @Override
//        public void onClick(View view) {
//            int position = getAbsoluteAdapterPosition();
//            Toast.makeText(context, "position"+position, Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(context,ClickeditemActivity.class);
//            context.startActivity(intent);
//        }
    }



}
