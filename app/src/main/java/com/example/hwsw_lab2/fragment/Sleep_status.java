package com.example.hwsw_lab2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hwsw_lab2.R;


public class Sleep_status extends Fragment {

    private Button week_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_sleep_status, container, false);

        week_btn = (Button) v.findViewById(R.id.toggle_sleep_week);

        week_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sleep_status_week sleep_status_week = new sleep_status_week();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, sleep_status_week);
                transaction.commit();
            }
        });




        return v;
    }


}