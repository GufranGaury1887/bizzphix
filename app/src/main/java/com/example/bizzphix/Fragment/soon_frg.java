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
import com.example.bizzphix.Fragment_soon.Banner;
import com.example.bizzphix.Fragment_soon.Branding;
import com.example.bizzphix.Fragment_soon.Letter_head;
import com.example.bizzphix.Fragment_soon.Logo;
import com.example.bizzphix.Fragment_soon.Visiting_card;
import com.example.bizzphix.R;
import com.example.bizzphix.ViewpagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class soon_frg extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soon_frg,container,false);
        addFragment(view);
        return view;
    }

    private void addFragment(View view) {

        tabLayout = view.findViewById(R.id.tabLayout1);
        viewPager = view.findViewById(R.id.viewPager);
        ViewpagerAdapter adapter = new ViewpagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Branding(),"Branding");
        adapter.addFragment(new Letter_head(),"Letter head");
        adapter.addFragment(new Banner()," Banner");
        adapter.addFragment(new Visiting_card(),"Visiting card");
        adapter.addFragment(new Logo(),"Logo");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}