package com.example.bizzphix.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bizzphix.Fragment_general.Anniversary;
import com.example.bizzphix.Fragment_general.Birthday;
import com.example.bizzphix.Fragment_general.Motivational;
import com.example.bizzphix.Fragment_general.Thanks_Note;
import com.example.bizzphix.Fragment_general.Trending;
import com.example.bizzphix.Fragment_general.good_M_N_wishes;
import com.example.bizzphix.Fragment_general.offer_zone;
import com.example.bizzphix.R;
import com.example.bizzphix.ViewpagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class general_frg extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_business_frg,container,false);
        addFragment(view);
        return view;
    }

    private void addFragment(View view) {

        tabLayout = view.findViewById(R.id.tabLayout1);
        viewPager = view.findViewById(R.id.viewPager);
        ViewpagerAdapter adapter = new ViewpagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Trending(),"Trending");
        adapter.addFragment(new Motivational(),"Motivational");
        adapter.addFragment(new good_M_N_wishes(),"Today wishes");
        adapter.addFragment(new Anniversary(),"Anniversary");
        adapter.addFragment(new Birthday(),"Birthday");
        adapter.addFragment(new Thanks_Note(),"Thanks Note");
        adapter.addFragment(new offer_zone(),"Offer Zone");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}