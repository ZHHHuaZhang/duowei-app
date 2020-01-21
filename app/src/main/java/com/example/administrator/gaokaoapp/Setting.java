package com.example.administrator.gaokaoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Setting extends AppCompatActivity implements View.OnClickListener{

    ImageButton returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        returnButton = findViewById(R.id.fanhui_bt);
        returnButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.fanhui_bt:{
                onBackPressed();
                break;
            }
            default:{
                break;
            }
        }
    }
}
