package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;

public class raid1 extends AppCompatActivity {
    SeekBar seekBar;
    int i;
    Toast toast = null;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ImageView boss,ch;
    TextView textView,boss_tx;
    ConstraintLayout constraintLayout;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.raid1);
        Q_L();
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });


    }
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                i -= sharedPreferences.getInt("atk",1);
                if (i<0) {i =0;}
                if(i == 0){
                    seekBar.setProgress(i);
                    boss_tx.setText(String.valueOf(i));
                    Toast.makeText(this,"clear",Toast.LENGTH_SHORT).show();
                    editor.putInt("boss_clear",1);
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                }
                if (Integer.parseInt(String.valueOf(textView.getText().toString()))<=0){
                    Toast.makeText(this,"fail",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                }
                seekBar.setProgress(i);
                boss_tx.setText(String.valueOf(i));
                textView.setText(String.valueOf(Integer.parseInt(textView.getText().toString())-1));
                break;
        }
        return true;
    }
    public void Q_L(){
        seekBar = (SeekBar) findViewById(R.id.raid1_seekbar);
        sharedPreferences = getSharedPreferences("main",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        boss = (ImageView) findViewById(R.id.boss_ch);
        ch = (ImageView) findViewById(R.id.raid_ch);
        textView = (TextView) findViewById(R.id.raid_ch_tx);
        boss_tx = (TextView) findViewById(R.id.raid_boss_hp);
        textView.setText(String.valueOf(sharedPreferences.getInt("HP",0)));
        i = boss_hp(sharedPreferences.getInt("difficulty",0));
        seekBar.setMax(i);
        boss_tx.setText(String.valueOf(i));
        ch.setImageResource(sharedPreferences.getInt("Character", R.drawable.ic_launcher_foreground));
        Glide.with(this).load(sharedPreferences.getInt("Character", R.drawable.ic_launcher_foreground)).into(ch);
        boss.setImageResource(R.drawable.raid1_boss);
        Glide.with(this).load(R.drawable.raid1_boss).into(boss);
        constraintLayout = (ConstraintLayout) findViewById(R.id.raid_background);
        constraintLayout.setBackgroundResource(R.drawable.raid1);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("종료");
        builder.setMessage("종료하시겠습니까?");
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });
        builder.setNegativeButton("메인화면", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setPositiveButton("종료", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });

        builder.show();
    }
    public int boss_hp(int i){
        switch (i){
            case 0:
                return i=100;
            case 1:
                return i=500;
            case 2:
                return i=1000;
            default:
                return i=9999999;
        }

    }
}
