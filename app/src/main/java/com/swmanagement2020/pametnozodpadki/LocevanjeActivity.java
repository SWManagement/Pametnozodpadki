package com.swmanagement2020.pametnozodpadki;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

public class LocevanjeActivity extends AppCompatActivity {
//    Podlaga za spodnje fragmente
    public static final String TAG = "VpisiLocuj Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locevanje);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
//      Vzami regijo iz Sharedpreferences na kreacijo tega acitivitya
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String regija = prefs.getString("regija", "" );
        String izpis  = String.format("Trenunto ločuješ v %s regija", regija);
        TextView kjeLocujem = findViewById(R.id.trenutnoLocevanje);
        kjeLocujem.setText(izpis);
    }
//  Fragmenti oziroma step by step funkcionalnosti -> 1. vpisi, 2. isci , itd.
    public static class Vpisi extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_isci, container, false);
        }
    }
}

