package com.swmanagement2020.pametnozodpadki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "SWManagement";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar functionality under Toolbar comment
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
//      Pridobivanje informacij iz settingsov
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        Log.d(TAG, "onCreate: " + prefs.getAll()); -> izpiše se selectana regija
    }

//    Locevanje -> zamenjaj aktivity
    public void goLocevanje(View view){
        Intent intent = new Intent(this, LocevanjeActivity.class);
        startActivity(intent);
    }
// Toolbar
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        Action based on toolbar Item selected
        if (item.getItemId() == R.id.settings_btn) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
