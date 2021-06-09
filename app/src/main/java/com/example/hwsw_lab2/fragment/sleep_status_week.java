package com.example.hwsw_lab2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hwsw_lab2.R;


public class sleep_status_week extends Fragment {

    private Button day_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_sleep_status_week, container, false);

         day_btn = (Button) v.findViewById(R.id.toggle_sleep_day);

         day_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Sleep_status sleep_status = new Sleep_status();
                 FragmentTransaction transaction = getFragmentManager().beginTransaction();
                 transaction.replace(R.id.fragment_container, sleep_status);
                 transaction.commit();
             }
         });


         return v;
    }
}