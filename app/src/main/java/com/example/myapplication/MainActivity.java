package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    private state frag_state = new state();
    private save frag_save = new save();
    RelativeLayout relativeLayout;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    FrameLayout frameLayout;
    int i =0,frag_control=1;
    BottomNavigationView bottomNavigationView;
    Button mimi,raid;
    FragmentTransaction transaction;
    Random random = new Random();
    ImageView imageView;
    TextView textView;
    //스레드
    Thread money = new Thread(new Runnable() {
        int ch=0;
        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted())
                {
                    Q_L();
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run() {
                            ch = Integer.parseInt(textView.getText().toString()) + 1;
                            textView.setText(String.valueOf(ch));
                        }
                    });
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Thread.interrupted();
        }
    });
    Thread first = new Thread(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(getApplicationContext(),First_Layout.class);
            startActivity(intent);
        }
    });
    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Q_L();
        BtnEventLoad();
        textView.setText(String.valueOf(sharedPreferences.getInt("money",0)));

        imageView.setImageResource(sharedPreferences.getInt("ch_Img", R.drawable.ic_launcher_foreground));
        Glide.with(this).load(Return_ImgId(sharedPreferences.getInt("Character", R.drawable.ic_launcher_foreground))).into(imageView);

        money.setDaemon(true);
        money.start();
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());


    }
    //main end

    //bottom click event
    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.main:
                    frameLayout.setVisibility(View.GONE);
                    relativeLayout.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    frag_control = 0;
                    return true;
                case R.id.state:
                    if(frag_control == 2){
                        if_transaction();
                        return false;
                    }else {
                        else_transaction(frag_state);
                        frag_control = 2;
                        return true;
                    }
                case R.id.save:
                    if (frag_control == 3){
                        if_transaction();
                        return false;
                    }else {
                        else_transaction(frag_save);
                        frag_control = 3;
                        return true;
                    }
            }
            return false;
        }
    }
    //이미지 아이디값 반환
    private int Return_ImgId(int img) {
        int[] R_Img = {R.drawable.cha_f, R.drawable.cha_m, R.drawable.ic_launcher_foreground};
        for (int R_i = 0; R_Img.length > R_i; i++) {
            if (img == R_Img[i]) {
                return R_Img[i];
            }

        }
        return R.drawable.cha_m;
    }

    //버튼 클릭 이벤트
   View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.main_btn:
                    ChangeHome(MiniGame_1.class);
                    return;
                case R.id.btn_raid:
                    return;
            }
        }
    };
    //intent 화면 전환
    public void ChangeHome(Class aClass){
        Intent intent = new Intent(getApplicationContext(), aClass);
        startActivity(intent);
        finish();
    }

    private void BtnEventLoad(){
        raid.setOnClickListener(onClickListener);
        mimi.setOnClickListener(onClickListener);
    }

    private void if_transaction(){
        relativeLayout.setVisibility(View.VISIBLE);
        frameLayout.setVisibility(View.GONE);
        imageView.setVisibility(View.VISIBLE);
        frag_control = 0;
    }

    private void else_transaction(Fragment fragment){
        relativeLayout.setVisibility(View.GONE);
        frameLayout.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commitAllowingStateLoss();
    }
    //저장 함수

    private void Q_L(){
        sharedPreferences = getSharedPreferences("main",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        mimi = (Button)findViewById(R.id.main_btn);
        raid = (Button)findViewById(R.id.btn_raid);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        bottomNavigationView = findViewById(R.id.navigationView);
        frameLayout = (FrameLayout) findViewById(R.id.frame);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative);
        imageView = (ImageView) findViewById(R.id.ch_Img);
        textView = (TextView) findViewById(R.id.main_money);

        return;
    }
    //save
    public void btn_save(){
        editor.putInt("money",Integer.parseInt(textView.getText().toString()));
        editor.putInt("Level",1);
        editor.commit();
    }
    @Override
    protected void onPause() {
        super.onPause();
        btn_save();
        money.interrupt();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        btn_save();
        money.interrupt();
    }
}