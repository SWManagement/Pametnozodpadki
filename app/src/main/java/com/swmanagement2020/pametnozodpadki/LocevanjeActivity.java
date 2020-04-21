package com.swmanagement2020.pametnozodpadki;


import android.content.Context;
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

import java.util.HashMap;

public class LocevanjeActivity extends AppCompatActivity {
//    Podlaga za spodnje fragmente
    public static final String TAG = "VpisiLocuj Activity";
    public static  HashMap <String, Integer> ODPADKI = new HashMap<>();
    public static  HashMap <Integer, String> KANTE = new HashMap<>();

    public static HashMap<String, Integer> insertOdpadki (HashMap<String, Integer> odpadki, String[] tip, int KID){
        for (int i = 0; i < tip.length ; i++) {
            odpadki.put(tip[i], KID);
        }
        return odpadki;
    }

    public static HashMap<String, Integer> fillOdpadki (HashMap<String, Integer> odpadki){
        int KID; // => Kanta ID
        String[] odpadkiEmbalaza = new String[]{ "peki papir", "alu folija", "konzerva tune", "tetrapak", "palčke za ušesa"}; // KID = 1
        String[] odpadkiSteklo = new String[] {"kozarec"}; // KID = 2
//        String[] odpadkiPapir = new String[0];        // KID = 3
//        String[] odpadkiBio = new String[0];          // KID = 4
        String[] odpadkiZbirni = new String[]{"stiropor","gradbeni material","aerosol pršilec"};       // KID = 5
        String[] odpadkiOstali = new String[]{"kosti", "baterije", "zgoščenka","avtomobilsko steklo", "papirnat robček","gobica za pomivanje posode"}; // KID = 6

        insertOdpadki( odpadki , odpadkiEmbalaza, 1);
        insertOdpadki( odpadki , odpadkiSteklo, 2);
//        insertOdpadki( odpadki , odpadkiPapir, 3);
//        insertOdpadki( odpadki , odpadkiBio, 4);
        insertOdpadki( odpadki , odpadkiZbirni, 5);
        insertOdpadki( odpadki , odpadkiOstali, 6);

        return odpadki;
    }

    public static HashMap<Integer, String> fillKante (HashMap<Integer, String> kante){
        String[] KANTE = new String[] {"embalaža", "steklo", "papir", "Bio odpadki", "Zbirni center", "Preostanek odpadkov"};
        int KID;
        for (int i = 0; i < KANTE.length ; i++) {
            KID = i + 1;
            kante.put(KID, KANTE[i]);
        }
        return kante;
    }

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
        String regija = prefs.getString("regija", "Osrednjeslovenska" );
        String izpis  = String.format("Trenunto ločuješ v %s regija", regija);
        TextView kjeLocujem = findViewById(R.id.trenutnoLocevanje);
        kjeLocujem.setText(izpis);
//        NAPOLNI "DB" z podatki onCreate Locevanje
        ODPADKI = fillOdpadki(ODPADKI);
        KANTE   = fillKante(KANTE);
    }
//  Fragmenti oziroma step by step funkcionalnosti -> 1. vpisi, 2. isci , itd.
    public static class Vpisi extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_isci, container, false);
        }
    }
    public void NajdiOdpadek (View view, Context context) {
        EditText odpadekView = (EditText) findViewById(R.id.Odpadek_name);
        String odpadek = odpadekView.getText().toString();
//        fetch odpadek v bazi
//          TODO
//        if found pokazi fetchej še kanto
//          TODO
//        if not found report not found
//          TODO
    }
}

