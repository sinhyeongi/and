package com.example.myapplication;
//주사위 게임
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MiniGame_3 extends AppCompatActivity {
    Button[] btn = new Button[10];
    Random random = new Random();
    ImageView imageView;
    int i = random.nextInt(3);
    Toast toast;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minigame_3);

        qq();
    }
    //OnclickListener
    View.OnClickListener onClickListener = new View.OnClickListener() {
        Intent intent;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.MiniGame_num0:
                    if (Integer.parseInt(btn[0].getText().toString()) == i){
                        btn[0].setClickable(false);

                        Toast.makeText(getApplicationContext(),"정답입니다!",Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(R.drawable.card_d);
                        Delay();
                        break;
                    }
                case R.id.MiniGame_num1:
                    if (Integer.parseInt(btn[1].getText().toString()) == i){
                        btn[1].setClickable(false);
                        Toast.makeText(getApplicationContext(),"정답입니다!",Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(R.drawable.card_1);
                        Delay();
                        break;
                    }
                case R.id.MiniGame_num2:
                    if (Integer.parseInt(btn[2].getText().toString()) == i){
                        btn[2].setClickable(false);
                        Toast.makeText(getApplicationContext(),"정답입니다!",Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(R.drawable.card_2);
                        Delay();
                        break;
                    }
                case R.id.MiniGame_num3:
                    if (Integer.parseInt(btn[3].getText().toString()) == i){
                        btn[3].setClickable(false);
                        Toast.makeText(getApplicationContext(),"정답입니다!",Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(R.drawable.card_3);
                        Delay();
                        break;
                    }
                case R.id.MiniGame_num4:
                case R.id.MiniGame_num5:
                case R.id.MiniGame_num6:
                case R.id.MiniGame_num7:
                case R.id.MiniGame_num8:
                case R.id.MiniGame_num9:
                    Toast.makeText(getApplicationContext(),"틀렸습니다!",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    //End onCreate
    private void qq(){
        imageView = (ImageView) findViewById(R.id.MiniGame3_img);
        for (int a = 0; a<10;a++){
            btn[a] = findViewById(getResources().getIdentifier("MiniGame_num"+a,"id",getPackageName()));
            btn[a].setOnClickListener(onClickListener);
        }

    }
    private void Delay(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }


}
