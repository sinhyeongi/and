package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class raid_select extends AppCompatActivity {
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.raid_select);
        Q_l();

    }
    public void Q_l(){
        Button button[] = new Button[3];
        for(int i=0; i<3;i++){
            button[i] = findViewById(getResources().getIdentifier("raid"+(i+1)+"_btn","id",getPackageName()));
            button[i].setOnClickListener(onClickListener);
        }
        Log.v("ok","ok");
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.raid1_btn:
                    Change_Home(raid1.class);
                    break;
                case R.id.raid2_btn:
                    Change_Home(raid2.class);
                    break;
                case R.id.raid3_btn:
                    Change_Home(raid3.class);
                    break;
                default:
                    return;
            }
        }

    };
    private void Change_Home(Class aClass){
        Intent intent = new Intent(getApplicationContext(),aClass);
        startActivity(intent);
        finish();
    }
}
