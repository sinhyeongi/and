package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class minigame_1 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minigame_1);
        qr();
        click();



    }
    private void qr(){
        sharedPreferences = getSharedPreferences("game_1",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        btn = (Button) findViewById(R.id.game1_home);
    }
    private void click(){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.game1_home:
                        Intent intent = new Intent(view.getContext(),MainActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        btn.setOnClickListener(onClickListener);
    }
}
