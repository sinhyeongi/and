package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Select_new extends AppCompatActivity {
    Button ez,normal,hard,btn_none;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_new);

        sharedPreferences = getSharedPreferences("main",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        ez = (Button) findViewById(R.id.btn_ez);
        normal = (Button) findViewById(R.id.btn_normal);
        hard = (Button) findViewById(R.id.btn_hard);
        btn_none = (Button) findViewById(R.id.btn_no_play);
        ez.setOnClickListener(onClickListener);
        normal.setOnClickListener(onClickListener);
        hard.setOnClickListener(onClickListener);

    }
    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.btn_ez:
                    First_setting();
                    editor.putInt("difficulty",1);
                    editor.commit();
                    Change_view(Select_Characters.class);
                    break;
                case R.id.btn_normal:
                    First_setting();
                    editor.putInt("difficulty",2);
                    editor.commit();
                    Change_view(Select_Characters.class);
                    break;
                case R.id.btn_hard:
                    First_setting();
                    editor.putInt("difficulty",3);
                    editor.commit();
                    Change_view(Select_Characters.class);
                    break;
                case R.id.btn_no_play:
                    break;


            }
        }
    };
    public void Change_view(Class aClass){
        Intent intent = new Intent(getApplicationContext(),aClass);
        startActivity(intent);
        finish();

    }
    public void First_setting(){
        editor.putInt("money", 0);
        editor.putInt("Level", 0);
        editor.putInt("Character", 0);
        editor.putInt("HP",100);
        editor.putInt("HP_btn",1);
        editor.commit();
    }
}
