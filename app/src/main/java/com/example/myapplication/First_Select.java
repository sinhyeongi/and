package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class First_Select extends AppCompatActivity {
    Button btn_load,btn_new,btn_exit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_select);
        btn_exit = (Button) findViewById(R.id.btn_exit);
        btn_new = (Button) findViewById(R.id.btn_new);
        btn_load = (Button) findViewById(R.id.btn_load);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        Intent intent;
        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.btn_load:
                    intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                case R.id.btn_new:
                    intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                case R.id.btn_exit:
                    finishAffinity();
                    return;
            }
        }
    };
}
