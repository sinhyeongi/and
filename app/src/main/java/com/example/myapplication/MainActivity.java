package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    private state frag_state = new state();
    private save frag_save = new save();
    RelativeLayout relativeLayout;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    FrameLayout frameLayout;
    int i =0,frag_control=1;
    BottomNavigationView bottomNavigationView;
    Button mimi,raid;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Q_L();

        //bottom click event
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.main:
                        frameLayout.setVisibility(View.GONE);
                        relativeLayout.setVisibility(View.VISIBLE);
                        return true;
                    case R.id.state:
                        if(frag_control == 2){
                            if_transaction();
                            return false;
                        }else {
                            else_transaction(frag_state);
                            frag_control = 2;
                            return true;
                        }
                    case R.id.save:
                        if(frag_control == 3){
                            if_transaction();
                            return false;
                        }else {
                            else_transaction(frag_save);
                            frag_control = 3;
                            return true;
                        }
                }
                return false;
            }
        });//bottom click event end
        //미니게임 버튼 클릭 이벤트
        mimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //미니게임 버튼 이벤트 끝
    }
    //main end

    //클릭이벤트
    public void onClick(View v){

        switch (v.getId()){
            case R.id.main_btn:

                return;
            case R.id.btn_raid:
                return;
        }
    }
    private void clicklistenerload(){

    }
    private void if_transaction(){
        relativeLayout.setVisibility(View.VISIBLE);
        frameLayout.setVisibility(View.GONE);
        frag_control = 0;
        return;
    }

    private void else_transaction(Fragment fragment){
        relativeLayout.setVisibility(View.GONE);
        frameLayout.setVisibility(View.VISIBLE);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commitAllowingStateLoss();
        return;
    }

    private void Q_L(){
        sharedPreferences = getSharedPreferences("main",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        mimi = (Button)findViewById(R.id.main_btn);
        raid = (Button)findViewById(R.id.btn_raid);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        bottomNavigationView = findViewById(R.id.navigationView);
        frameLayout = (FrameLayout) findViewById(R.id.frame);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative);
        return;
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}