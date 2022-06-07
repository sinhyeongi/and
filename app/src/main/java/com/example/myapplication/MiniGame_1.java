package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
    int[] Ch_Img = new int[6];
    //MiniGame_card
    Random random = new Random();
    int clear = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minigame_1);
        qr();
        Ch_Img = Return_RandImg(RandomImg);
        clear = 0;
        click();

    }
    //onCreate end
    public int[] Return_RandImg(int[] i){
        int card[] = new int[6];
        int r =  random.nextInt(1);
        int num = (card.length/2)-1;

        for(int a = 0; a<card.length/2;a++){
            card[a] = random.nextInt(i.length-1);


        }
        if (r == 0)
        {
            for (int a = card.length/2; a< card.length; a++){
                card[a] = card[num--];

            }

        }else
        {
            num = 0;
            for (int a = card.length/2; a< card.length; a++){
                card[a] = card[num++];

            }

        }

        return card;
    }
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
            int i =0, i2;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (view.getId()){
                    case R.id.MiniGame_card1:
                        i2 = 0;
                        imageView[i2].setImageResource(R.drawable.card_d);
                        i += 1;
                        break;
                    case R.id.MiniGame_card2:
                        i2 = 1;
                        imageView[i2].setImageResource(R.drawable.card_d);
                        i += 1;
                        break;
                    case R.id.MiniGame_card3:
                        i2 = 2;
                        imageView[i2].setImageResource(R.drawable.card_d);
                        i += 1;
                        break;
                    case R.id.MiniGame_card4:
                        i2 = 3;
                        imageView[i2].setImageResource(R.drawable.card_d);
                        i += 1;
                        break;
                    case R.id.MiniGame_card5:
                        i2 = 4;
                        imageView[i2].setImageResource(R.drawable.card_d);
                        i += 1;
                        break;
                    case R.id.MiniGame_card6:
                        i2 = 5;
                        imageView[i2].setImageResource(R.drawable.card_d);
                        i += 1;
                        break;
                }
                if (i == 6){
                    Toast.makeText(getApplicationContext(),"Clear! money + 25",Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            editor.putInt("money",sharedPreferences.getInt("money",0)+25);
                            editor.commit();
                            startActivity(intent);
                            finish();
                        }
                    },1000);
                }
                return false;
            }

        };
        btn.setOnClickListener(onClickListener);
        for (int i=0;i<6;i++){
            imageView[i].setOnTouchListener(onTouchListener);
            imageView[i].setImageResource(RandomImg[Ch_Img[i]]);
        }
    }
    private void bitmap(int i,int i2){
        Drawable drawable, drawable1;
        drawable = imageView[i].getDrawable();
        drawable1 = imageView[i2].getDrawable();
        Bitmap bitmap, bitmap1;
        bitmap = ((BitmapDrawable)drawable).getBitmap();
        bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
        if (bitmap.equals(bitmap1)){
            imageView[i].setVisibility(View.INVISIBLE);
            imageView[i2].setVisibility(View.INVISIBLE);
        }

    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}
