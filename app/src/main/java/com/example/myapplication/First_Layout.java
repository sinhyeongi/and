package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class First_Layout extends AppCompatActivity {
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        relativeLayout = (RelativeLayout) findViewById(R.id.first_click);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(getApplicationContext(),First_Select.class);
            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
