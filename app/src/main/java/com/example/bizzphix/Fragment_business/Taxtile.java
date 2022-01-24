package com.example.bizzphix.Fragment_business;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bizzphix.Adapter;
import com.example.bizzphix.Member;
import com.example.bizzphix.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Taxtile extends Fragment {

    RecyclerView tRecyclerview;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_taxtile, null);

        tRecyclerview = view.findViewById(R.id.trecyclerview);
        tRecyclerview.setHasFixedSize(true);

        tRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Taxtile");

        FirebaseRecyclerOptions<Member> options =
                new FirebaseRecyclerOptions.Builder<Member>()
                        .setQuery(reference, Member.class)
                        .build();

        adapter = new Adapter(options,getContext());
        tRecyclerview.setAdapter(adapter);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
}