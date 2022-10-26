package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Select_load extends AppCompatActivity {
    Button btn1,btn2,btn3;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_load);
        sharedPreferences = getSharedPreferences("main",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        qq();

        if (sharedPreferences.getInt("Save1_Level",0) > 0){
            textView1.setText(String.valueOf(sharedPreferences.getInt("Save1_Level",0)));
            textView2.setText(String.valueOf(sharedPreferences.getInt("Save1_money",0)));
            textView7.setText(Get_dificul(sharedPreferences.getInt("Save1_difficulty",0)));
        }
        if (sharedPreferences.getInt("Save2_Level",0) > 0){
            textView3.setText(String.valueOf(sharedPreferences.getInt("Save2_Level",0)));
            textView4.setText(String.valueOf(sharedPreferences.getInt("Save2_money",0)));
            textView7.setText(Get_dificul(sharedPreferences.getInt("Save2_difficulty",0)));
        }
        if (sharedPreferences.getInt("Save3_Level",0) > 0){
            textView5.setText(String.valueOf(sharedPreferences.getInt("Save3_Level",0)));
            textView6.setText(String.valueOf(sharedPreferences.getInt("Save3_money",0)));
            textView7.setText(Get_dificul(sharedPreferences.getInt("Save3_difficulty",0)));
        }

        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);

    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        Intent intent;
        @Override
        public void onClick(View view) {
            qq();
            switch (view.getId()){
                case R.id.btn_save1:
                    if (sharedPreferences.getInt("Save1_Level",0) > 0) {
                        editor.putInt("money", sharedPreferences.getInt("Save1_money", 0));
                        editor.putInt("Level", sharedPreferences.getInt("Save1_Level", 0));
                        editor.putInt("Character", sharedPreferences.getInt("Save1_ch_Img", 0));
                        editor.putInt("HP",sharedPreferences.getInt("Save1_HP",100));
                        editor.putInt("atk",sharedPreferences.getInt("Save1_atk",100));
                        editor.putInt("defence",sharedPreferences.getInt("Save1_defence",100));
                        editor.putInt("luk",sharedPreferences.getInt("Save1_luk",100));
                        editor.putInt("HP_btn",sharedPreferences.getInt("Save1_HP_btn",1));
                        editor.putInt("atk_btn",sharedPreferences.getInt("Save1_atk_btn",1));
                        editor.putInt("defence_btn",sharedPreferences.getInt("Save1_defence_btn",1));
                        editor.putInt("luk_btn",sharedPreferences.getInt("Save1_luk_btn",1));
                        editor.putInt("difficulty",sharedPreferences.getInt("Save1_difficulty",-1));
                        editor.commit();

                        ChangeHome(MainActivity.class);
                    }
                    break;
                case R.id.btn_save2:
                    if (sharedPreferences.getInt("Save2_Level",0) > 0) {
                        editor.putInt("money", sharedPreferences.getInt("Save2_money", 0));
                        editor.putInt("Level", sharedPreferences.getInt("Save2_Level", 0));
                        editor.putInt("Character", sharedPreferences.getInt("Save2_ch_Img", 0));
                        editor.putInt("HP",sharedPreferences.getInt("Save2_HP",100));
                        editor.putInt("HP_btn",sharedPreferences.getInt("Save2_HP_btn",1));
                        editor.putInt("difficulty",sharedPreferences.getInt("Save2_difficulty",-1));
                        editor.commit();

                        ChangeHome(MainActivity.class);
                    }
                    break;
                case R.id.btn_save3:
                    if (sharedPreferences.getInt("Save1_Level",0) > 0) {
                        editor.putInt("money", sharedPreferences.getInt("Save3_money", 0));
                        editor.putInt("Level", sharedPreferences.getInt("Save3_Level", 0));
                        editor.putInt("Character", sharedPreferences.getInt("Save3_ch_Img", 0));
                        editor.putInt("HP",sharedPreferences.getInt("Save3_HP",100));
                        editor.putInt("HP_btn",sharedPreferences.getInt("Save3_HP_btn",1));
                        editor.putInt("difficulty",sharedPreferences.getInt("Save3_difficulty",-1));
                        editor.commit();
                        ChangeHome(MainActivity.class);
                    }
                    break;

            }
        }
    };
    public void ChangeHome(Class aClass){
        Intent intent = new Intent(getApplicationContext(), aClass);
        startActivity(intent);
        finish();
    }
    private void qq(){
        btn1 = (Button) findViewById(R.id.btn_save1);
        btn2 = (Button) findViewById(R.id.btn_save2);
        btn3 = (Button) findViewById(R.id.btn_save3);
        textView1 = (TextView) findViewById(R.id.level1);
        textView2 = (TextView) findViewById(R.id.money1);
        textView3 = (TextView) findViewById(R.id.level2);
        textView4 = (TextView) findViewById(R.id.money2);
        textView5 = (TextView) findViewById(R.id.level3);
        textView6 = (TextView) findViewById(R.id.money3);
        textView7 = (TextView) findViewById(R.id.Save1_difi);
        textView8 = (TextView) findViewById(R.id.Save2_difi);
        textView9 = (TextView) findViewById(R.id.Save3_difi);
    }
    public String Get_dificul(int i){
        switch (i){
            case 0:
                return "쉬움";
            case 1:
                return "보통";
            case 2:
                return "어려움";
            default:
                return "err";
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),First_Select.class);
        startActivity(intent);
        finish();
    }
}
