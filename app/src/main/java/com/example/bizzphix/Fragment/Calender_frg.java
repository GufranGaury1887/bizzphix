package com.example.bizzphix.Fragment;

import static a.a.b.d.b.k.H;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.media.metrics.Event;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.bizzphix.R;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Calender_frg extends Fragment {
    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat ("MMMM- yyyy", Locale.getDefault());


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calender_frg, container, false);


//        final ActionBar actionBar = getActivity().getActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(false);
//        actionBar.setTitle(null);
//
//        compactCalendar = view.findViewById(R.id.compactcalendar_view);
//        compactCalendar.setUseThreeLetterAbbreviation(true);
//
//        // set event
//
//        Event ev1 = new Event(Color.RED, 1643436255000L, "Happy");
//           compactCalendar.addEvent(ev1);
//
//        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
//            @Override
//            public void onDayClick(Date dateClicked) {
//                Context context = getContext();
//
//                if (dateClicked.toString().compareTo("Saturday, January 29, 2022 12:00:00 AM") == 0) {
//                    Toast.makeText(context, "Happy", Toast.LENGTH_SHORT).show();
//
//                }else {
//                    Toast.makeText(context, "No Event Planned for the day", Toast.LENGTH_SHORT).show();
//
//                }
//
//
//            }
//
//            @Override
//            public void onMonthScroll(Date firstDayOfNewMonth) {
//                actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
//
//            }
//        });
        return view;
    }
}
