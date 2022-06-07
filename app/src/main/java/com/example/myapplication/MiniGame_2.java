package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MiniGame_2 extends AppCompatActivity {
    Button btn;
    TextView textView;
    Random random = new Random();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minigame_2);
        qq();
        btn.setOnClickListener(onClickListener);
    }
    private void qq(){
        btn = findViewById(R.id.MiniGame2_btn);
        textView = findViewById(R.id.MiniGame2_tv);
        sharedPreferences = getSharedPreferences("main",MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        Intent intent;
        int money = 0,money2 = 0;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.MiniGame2_btn:
                    btn.setClickable(false);
                    money2 = sharedPreferences.getInt("money",0);
                    money = random.nextInt(100);
                    btn.setText("+ money : "+String.valueOf(money));
                    money2 += money;
                    editor.putInt("money",money2);
                    editor.commit();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    },3000);

                    break;
            }
        }
    };
}
