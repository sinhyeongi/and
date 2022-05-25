package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    private main main_frag = new main();
    private state frag_state = new state();
    private save frag_save = new save();
    TextView textView;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int i =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,main_frag).commitAllowingStateLoss();
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);

        new Thread(new Runnable() {
            @Override
            public void run() {
            i++;
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
        this.text(i);
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
    public void text(int i){
        main_frag.setTextView(String.valueOf(i));
    }
}