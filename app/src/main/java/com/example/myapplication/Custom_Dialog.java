package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;

public class Custom_Dialog {
    Dialog dl;
    Button button,button2,button3;
    public void Dialog(Context context){
        dl = new Dialog(context);
        dl.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dl.setContentView(R.layout.raid_select);
        WindowManager.LayoutParams layoutParams = dl.getWindow().getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        button = (Button) dl.findViewById(R.id.raid1_btn);
        button2 = (Button) dl.findViewById(R.id.raid2_btn);
        button3 = (Button) dl.findViewById(R.id.raid3_btn);
        button2.setClickable(false);button3.setClickable(false);
        dl.getWindow().setAttributes((WindowManager.LayoutParams)layoutParams);
        dl.show();
    }
    public void Chang_button(int i){
        if (i == 1){
            button2.setClickable(true);
        }
        if (i == 2){
            button3.setClickable(true);
        }

    }

}

