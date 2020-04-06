package com.swmanagement2020.pametnozodpadki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar functionality under Toolbar comment
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }
//    Vpisi in locuj
    public void VpisiLocuj(View view){
        Intent intent = new Intent(this, VpisiLocujActivity.class);
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
            Log.d(TAG, "Settings pressed");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
