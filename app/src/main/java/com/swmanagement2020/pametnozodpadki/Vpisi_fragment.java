package com.swmanagement2020.pametnozodpadki;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Vpisi_fragment extends Fragment {
//    Tukaj bo koda, ki bo namenjena vpisovanju oziroma skeniranju podatkov na podlagi katerih bo nasledni fragment "isci" iskal po bazi
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_isci, container, false);
    }
}
