package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.concurrent.Delayed;
/*
변경예정

*/

public class MiniGame_1 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int i = 0,sec = 15000,sec2 = 5000;
    TextView textView,textView1,firstTimer;
    ImageView imageView;
    CountDownTimer countDownTimer;
    Handler handler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minigame_1);
        qr();

        textView1.setVisibility(View.GONE);
        textView.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);

        countDownTimer = new CountDownTimer(sec2,1000) {
            @Override
            public void onTick(long l) {
                sec2 = (int) l;
                sec2 = (int) sec2/1000;
                firstTimer.setText(String.valueOf(sec2));
            }

            @Override
            public void onFinish() {
                firstTimer.setVisibility(View.GONE);
                textView1.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
            }
        }.start();

       handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                countDownTimer = new CountDownTimer(sec,1000) {
                    @Override
                    public void onTick(long l) {
                        sec = (int) l;
                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                i = Integer.parseInt( textView.getText().toString());
                                textView.setText(String.valueOf(++i));
                            }
                        });
                        updateCountDownText();
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(getApplicationContext(),"+ Money "+textView.getText().toString(),Toast.LENGTH_SHORT).show();
                        editor.putInt("money",(sharedPreferences.getInt("money",0)+Integer.parseInt(textView.getText().toString()))*2);
                        editor.commit();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }.start();
            }
        },5000);


    }
    //onCreate end
    private void updateCountDownText() {
        sec = (int) (sec/1000);
        textView1.setText(String.valueOf(sec)+" 초");
    }


        private void qr(){
        sharedPreferences = getSharedPreferences("main",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        textView = findViewById(R.id.game1_text);
        textView1 = findViewById(R.id.game1_timer);
        firstTimer = findViewById(R.id.first_timer);
        imageView = findViewById(R.id.text_btn);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }

}
