package com.example.bizzphix.Fragment_general;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bizzphix.Adapter;
import com.example.bizzphix.Member;
import com.example.bizzphix.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Trending extends Fragment {

    RecyclerView tdRecyclerview;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("gufran", "onCreateView");

        View view = inflater.inflate(R.layout.fragment_trending, null);

        tdRecyclerview = view.findViewById(R.id.tdrecyclerview);
        tdRecyclerview.setHasFixedSize(true);


        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        linearLayoutManager.removeAllViews();
        tdRecyclerview.setLayoutManager(linearLayoutManager);

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Trending");




        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("gufran", "onstart");



        FirebaseRecyclerOptions<Member> options =
                new FirebaseRecyclerOptions.Builder<Member>()
                        .setQuery(reference, Member.class)
                        .build();


        adapter = new Adapter(options, getContext());
        adapter.notifyDataSetChanged();
        tdRecyclerview.setAdapter(adapter);

        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();

        Log.d("gufran", "onStop");
    }
}
