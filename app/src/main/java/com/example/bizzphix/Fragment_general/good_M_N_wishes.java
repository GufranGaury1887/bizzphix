package com.example.bizzphix.Fragment_general;

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


public class good_M_N_wishes extends Fragment {

    RecyclerView mnRecyclerview;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_good__m__n_wishes, null);

        mnRecyclerview = view.findViewById(R.id.mnrecyclerview);
        mnRecyclerview.setHasFixedSize(true);

        mnRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Good M N W");

        FirebaseRecyclerOptions<Member> options =
                new FirebaseRecyclerOptions.Builder<Member>()
                        .setQuery(reference, Member.class)
                        .build();

        adapter = new Adapter(options,getContext());
        mnRecyclerview.setAdapter(adapter);

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