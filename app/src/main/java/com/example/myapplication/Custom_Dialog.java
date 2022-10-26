package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Custom_Dialog {
    Dialog dl;
    public void Dialog(Context context){
        dl = new Dialog(context);
        dl.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dl.setContentView(R.layout.raid_select);
        WindowManager.LayoutParams layoutParams = dl.getWindow().getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        Button button = (Button) dl.findViewById(R.id.raid2_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getraid2btn();
            }
        });
        dl.getWindow().setAttributes((WindowManager.LayoutParams)layoutParams);
        dl.show();
    }
    public boolean getraid2btn(){
        return true;
    }

}
