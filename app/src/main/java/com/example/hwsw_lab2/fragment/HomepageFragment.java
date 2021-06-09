package com.example.hwsw_lab2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.hwsw_lab2.R;

public class HomepageFragment extends Fragment {

    private ImageButton sleep_session, sleep_env,bedtime_routine, other_factors;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_homepage, container, false);
        sleep_session = (ImageButton) v.findViewById(R.id.sleep_quality_Btn);
        bedtime_routine = (ImageButton) v.findViewById(R.id.bedtime_routine_Btn);

        sleep_session.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sleep_status sleep_status = new Sleep_status();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, sleep_status);
                transaction.commit();
            }
        });

        bedtime_routine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bedtime_routine bedtime_routine = new Bedtime_routine();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, bedtime_routine);
                transaction.commit();

            }
        });


        return v;
    }
}