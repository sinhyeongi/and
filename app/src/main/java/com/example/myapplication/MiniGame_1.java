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
    int[] Ch_Img = new int[6];
    //MiniGame_card
    Random random = new Random();
    int clear = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minigame_1);
        qr();click();
        Ch_Img = Return_RandImg(RandomImg);
        clear = 0;

    }
    //onCreate end
    public int[] Return_RandImg(int[] i){
        int card[] = new int[6];
        int r =  random.nextInt(1);
        int num = (card.length/2)-1;

        Log.v("r:",""+r);
        for(int a = 0; a<card.length/2;a++){
            card[a] = random.nextInt(i.length-1);
            Log.v("card["+a+"]",""+card[a]);

        }
        if (r == 0)
        {
            for (int a = card.length/2; a< card.length; a++){
                card[a] = card[num--];
                Log.v("card["+a+"]",""+card[a]);
            }

        }else
        {
            num = 0;
            for (int a = card.length/2; a< card.length; a++){
                card[a] = card[num++];
                Log.v("card["+a+"]",""+card[a]);
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
            int Ch_card = 0,Ch_card2 = 0,Ch_ch = 0;
            int i = 0;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (view.getId()){
                    case R.id.MiniGame_card1:
                        Ch_ch = Ch_card;
                        Ch_card = R.id.MiniGame_card1;
                        Ch_card2 = RandomImg[Ch_Img[0]];
                        if(view.getId() == Ch_ch){
                            imageView[0].setImageResource(R.drawable.card_d);
                            Ch_card = 0;
                            Ch_card2 = R.drawable.card_d;
                            break;
                        }
                        if (Ch_card != R.id.MiniGame_card1 && RandomImg[Ch_Img[0]] == Ch_card2){
                            imageView[0].setVisibility(View.INVISIBLE);
                            ToGone(Ch_card);
                            Toast.makeText(getApplicationContext(),"정답",Toast.LENGTH_SHORT).show();
                            Ch_card = 0;
                            Ch_card2 = 0;
                        }
                        if (Ch_ch != R.id.MiniGame_card1 && Ch_card2 != RandomImg[Ch_Img[0]]){
                            imageView[0].setImageResource(R.drawable.card_d);
                        }

                        imageView[0].setImageResource(RandomImg[Ch_Img[0]]);
                        break;
                    case R.id.MiniGame_card2:
                        Ch_ch = Ch_card;
                        Ch_card = R.id.MiniGame_card2;
                        Ch_card2 = RandomImg[Ch_Img[1]];
                        if(Ch_card == R.id.MiniGame_card2){
                            imageView[1].setImageResource(R.drawable.card_d);
                            Ch_card = 0;
                            Ch_card2 = R.drawable.card_d;
                            break;
                        }
                        if (Ch_card != R.id.MiniGame_card2 && RandomImg[Ch_Img[1]] == Ch_card2){
                            imageView[1].setVisibility(View.INVISIBLE);
                            ToGone(Ch_card);
                            Toast.makeText(getApplicationContext(),"정답",Toast.LENGTH_SHORT).show();
                            Ch_card = 0;
                            Ch_card2 = 0;
                        }
                        if (Ch_ch != R.id.MiniGame_card1 && Ch_card2 != RandomImg[Ch_Img[0]]){
                            imageView[1].setImageResource(R.drawable.card_d);
                        }

                        imageView[1].setImageResource(RandomImg[Ch_Img[1]]);
                        break;
                    case R.id.MiniGame_card3:
                        if(Ch_card == R.id.MiniGame_card3){
                            imageView[2].setImageResource(R.drawable.card_d);
                            Ch_card = 0;
                            Ch_card2 = R.drawable.card_d;
                            break;
                        }
                        if (Ch_card != R.id.MiniGame_card3 && RandomImg[Ch_Img[2]] == Ch_card2){
                            imageView[2].setVisibility(View.INVISIBLE);
                            ToGone(Ch_card);
                            Toast.makeText(getApplicationContext(),"정답",Toast.LENGTH_SHORT).show();
                            Ch_card = 0;
                            Ch_card2 = 0;
                        }
                        Ch_card = R.id.MiniGame_card3;
                        Ch_card2 = RandomImg[Ch_Img[2]];
                        imageView[2].setImageResource(RandomImg[Ch_Img[2]]);
                        break;
                    case R.id.MiniGame_card4:
                        if(Ch_card == R.id.MiniGame_card4){
                            imageView[3].setImageResource(R.drawable.card_d);
                            Ch_card = 0;
                            Ch_card2 = R.drawable.card_d;
                            break;
                        }
                        if (Ch_card != R.id.MiniGame_card4 && RandomImg[Ch_Img[3]] == Ch_card2){
                            imageView[3].setVisibility(View.INVISIBLE);
                            ToGone(Ch_card);
                            Toast.makeText(getApplicationContext(),"정답",Toast.LENGTH_SHORT).show();
                            Ch_card = 0;
                            Ch_card2 = 0;
                        }
                        Ch_card = R.id.MiniGame_card4;
                        Ch_card2 = RandomImg[Ch_Img[3]];
                        imageView[3].setImageResource(RandomImg[Ch_Img[3]]);
                        break;
                    case R.id.MiniGame_card5:
                        if(Ch_card == R.id.MiniGame_card5){
                            imageView[4].setImageResource(R.drawable.card_d);
                            Ch_card = 0;
                            Ch_card2 = R.drawable.card_d;
                            break;
                        }
                        if (Ch_card != R.id.MiniGame_card5 && RandomImg[Ch_Img[4]] == Ch_card2){
                            imageView[4].setVisibility(View.INVISIBLE);
                            ToGone(Ch_card);
                            Toast.makeText(getApplicationContext(),"정답",Toast.LENGTH_SHORT).show();
                            Ch_card = 0;
                            Ch_card2 = 0;
                        }
                        Ch_card = R.id.MiniGame_card5;
                        Ch_card2 = RandomImg[Ch_Img[4]];
                        imageView[4].setImageResource(RandomImg[Ch_Img[4]]);
                        break;
                    case R.id.MiniGame_card6:
                        if(Ch_card == R.id.MiniGame_card6){
                            imageView[5].setImageResource(R.drawable.card_d);
                            Ch_card = 0;
                            Ch_card2 = R.drawable.card_d;
                            break;
                        }
                        if (Ch_card != R.id.MiniGame_card4 && RandomImg[Ch_Img[5]] == Ch_card2){
                            imageView[5].setVisibility(View.INVISIBLE);
                            ToGone(Ch_card);
                            Toast.makeText(getApplicationContext(),"정답",Toast.LENGTH_SHORT).show();
                            Ch_card = 0;
                            Ch_card2 = 0;
                        }
                        Ch_card = R.id.MiniGame_card6;
                        Ch_card2 = RandomImg[Ch_Img[5]];
                        imageView[5].setImageResource(RandomImg[Ch_Img[5]]);
                        break;
                }
                if (clear == 6){
                    Toast.makeText(getApplicationContext(),"Clear!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
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
    private void ToGone(int i){
        ImageView imageView;
        imageView = (ImageView) findViewById(i);
        imageView.setVisibility(View.INVISIBLE);
        clear += 2;
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
