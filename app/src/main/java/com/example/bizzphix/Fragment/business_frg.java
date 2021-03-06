package com.example.bizzphix.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bizzphix.Fragment_business.Education;
import com.example.bizzphix.Fragment_business.Grocery;
import com.example.bizzphix.Fragment_business.Health;
import com.example.bizzphix.Fragment_business.Taxtile;
import com.example.bizzphix.Fragment_business.coming1;
import com.example.bizzphix.Fragment_business.coming2;
import com.example.bizzphix.Fragment_business.coming3;
import com.example.bizzphix.R;
import com.example.bizzphix.ViewpagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class business_frg extends Fragment{

    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_business_frg,container,false);
        addFragment(view);
        return view;


    }

    private void addFragment(View view) {

        tabLayout = view.findViewById(R.id.tabLayout1);
        viewPager = view.findViewById(R.id.viewPager);
        ViewpagerAdapter adapter = new ViewpagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Grocery(),"Grocery");
        adapter.addFragment(new Health(),"Health");
        adapter.addFragment(new Education(),"Education");
        adapter.addFragment(new Taxtile(),"Textile");
        adapter.addFragment(new coming1(),"coming 1");
        adapter.addFragment(new coming2(),"coming 2");
        adapter.addFragment(new coming3(),"coming 3");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}