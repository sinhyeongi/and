package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Select_Characters extends AppCompatActivity {
    Button char_m,char_f;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_characters);
        sharedPreferences = getSharedPreferences("main",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        char_f = (Button) findViewById(R.id.btn_cha_f);
        char_m = (Button) findViewById(R.id.btn_cha_m);
        char_f.setOnClickListener(onClickListener);
        char_m.setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_cha_f:
                    editor.putInt("Character",R.drawable.cha_f);
                    editor.commit();
                    Change_view(MainActivity.class);
                    finish();
                    break;

                case R.id.btn_cha_m:
                    editor.putInt("Character",R.drawable.cha_m);
                    editor.commit();
                    Change_view(MainActivity.class);
                    finish();
                    break;
            }
        }
    };
    public void Change_view(Class aClass){
        Intent intent = new Intent(getApplicationContext(),aClass);
        startActivity(intent);

    }
}
