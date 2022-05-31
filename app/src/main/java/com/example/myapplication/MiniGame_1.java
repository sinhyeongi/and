package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
/*
저장 MiniGame

*/

public class MiniGame_1 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button btn;
    ImageView[] imageView = new ImageView[6];
    int[] RandomImg = {R.drawable.card_1,R.drawable.card_2,R.drawable.card_3,R.drawable.card_d};
    //MiniGame_card
    Random random = new Random();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minigame_1);
        qr();click();




    }
    //onCreate end

    private void qr(){
        sharedPreferences = getSharedPreferences("MiniGame",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        btn = (Button) findViewById(R.id.MiniGame_home);
        for (int a = 0;a<6;a++){
            imageView[a] = findViewById(getResources().getIdentifier("MiniGame_card"+(a+1),"id",getPackageName()));
        }
    }
    //클릭이벤트
    private void click(){
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.MiniGame_home:
                        Intent intent = new Intent(view.getContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;

                }
            }
        };
        View.OnTouchListener onTouchListener = new View.OnTouchListener() {
            int Ch_card,Ch_card2;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (view.getId()){
                    case R.id.MiniGame_card1:
                        if(view.getId() == Ch_card){
                            imageView[0].setImageResource(R.drawable.card_d);
                            Ch_card = 0;
                            Ch_card2 = R.drawable.card_d;
                            break;
                        }
                        Ch_card = R.id.MiniGame_card1;
                        Ch_card2 = R.drawable.card_1;
                        imageView[0].setImageResource(R.drawable.card_1);
                        break;
                    case R.id.MiniGame_card2:
                        if (view.getId() != Ch_card && Ch_card2 == R.drawable.card_1){
                            imageView[1].setImageResource(R.drawable.card_1);
                            Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
                            Ch_card2 = R.drawable.card_d;
                            Ch_card = view.getId();
                            break;
                        }else if(view.getId() == Ch_card && Ch_card == Ch_card2){
                            Toast.makeText(getApplicationContext(),"ok2",Toast.LENGTH_SHORT).show();
                            break;
                        }
                        if(view.getId() == Ch_card){
                            imageView[1].setImageResource(R.drawable.card_d);
                            Ch_card = 0;
                            Ch_card2 = R.drawable.card_d;
                            break;
                        }
                        Ch_card = R.id.MiniGame_card2;
                        Ch_card2 = R.drawable.card_1;
                        imageView[1].setImageResource(R.drawable.card_1);
                        break;
                    case R.id.MiniGame_card3:
                        imageView[2].setImageResource(R.drawable.card_1);
                        break;
                    case R.id.MiniGame_card4:
                        imageView[3].setImageResource(R.drawable.card_1);
                        break;
                    case R.id.MiniGame_card5:
                        imageView[4].setImageResource(R.drawable.card_1);
                        break;
                    case R.id.MiniGame_card6:
                        imageView[5].setImageResource(R.drawable.card_1);
                        break;
                }
                return false;
            }
        };
        btn.setOnClickListener(onClickListener);
        for (int i=0;i<6;i++){
            imageView[i].setOnTouchListener(onTouchListener);
            imageView[i].setImageResource(R.drawable.card_d);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
