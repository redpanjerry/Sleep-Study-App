package com.example.hwsw_lab2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hwsw_lab2.R;



public class Edit_profile extends Fragment {


    private ImageView pika_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        pika_btn = (ImageView) v.findViewById(R.id.pika_img);

        pika_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profile2 profile2 = new Profile2();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, profile2);
                transaction.commit();
            }
        });

        return v;
    }
}