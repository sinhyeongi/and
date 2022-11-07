package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class First_Select extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_select);
        Button btn_load,btn_new,btn_exit;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;
        btn_exit = (Button) findViewById(R.id.btn_exit);
        btn_new = (Button) findViewById(R.id.btn_new);
        btn_load = (Button) findViewById(R.id.btn_load);
        btn_exit.setOnClickListener(onClickListener);
        btn_new.setOnClickListener(onClickListener);
        btn_load.setOnClickListener(onClickListener);
        sharedPreferences = getSharedPreferences("main",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt("money",0);
        editor.putInt("Level",0);
        editor.putInt("HP",0);
        editor.putInt("atk",1);
        editor.putInt("defence",0);
        editor.putInt("luk",0);
        editor.putInt("HP_btn",0);
        editor.putInt("atk_btn",0);
        editor.putInt("defence_btn",0);
        editor.putInt("luk_btn",0);
        editor.putInt("boss_clear",0);
        editor.commit();
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        Intent intent;
        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.btn_load:
                    intent = new Intent(getApplicationContext(),Select_load.class);
                    startActivity(intent);
                    finish();
                    return;
                case R.id.btn_new:
                    intent = new Intent(getApplicationContext(),Select_new.class);
                    startActivity(intent);
                    finish();
                    return;
                case R.id.btn_exit:
                    finishAffinity();
                    return;
            }
        }
    };

}
