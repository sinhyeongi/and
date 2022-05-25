package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    private main main_frag;
    private state frag_state;
    private save frag_save;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_frag = new main();
        frag_state = new state();
        frag_save = new save();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,main_frag).commitAllowingStateLoss();
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        //bottom click event
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            FragmentTransaction transaction;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.main:
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame,main_frag);
                        transaction.commitAllowingStateLoss();
                        return true;
                    case R.id.state:
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame,frag_state);
                        transaction.commitAllowingStateLoss();
                        return true;
                    case R.id.save:
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame,frag_save);
                        transaction.commitAllowingStateLoss();
                        return true;
                }
                return false;
            }
            //bottom click event end
        });
    }
    //main end

}