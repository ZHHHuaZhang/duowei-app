package com.example.administrator.gaokaoapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class TestResultCheck extends AppCompatActivity implements View.OnClickListener {

    ImageButton returnButton;
    Button iq, like, temper, pf, society;
    TextView resultShow;
    String white = "#9f9f9f", pressed = "#37b1d4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result_check);
        resultShow = findViewById(R.id.resultInfo_change);
        returnButton = findViewById(R.id.fanhui_bt);
        iq = findViewById(R.id.iq_check);
        like = findViewById(R.id.like_check);
        temper = findViewById(R.id.temper_check);
        pf = findViewById(R.id.pf_check);
        society = findViewById(R.id.society_check);
        resultShow.setText(AllResult.resultExtra[0]);

        iq.setOnClickListener(this);
        like.setOnClickListener(this);
        temper.setOnClickListener(this);
        pf.setOnClickListener(this);
        society.setOnClickListener(this);
        returnButton.setOnClickListener(this);
    }

    void refreshColor(){
        iq.setBackgroundColor(Color.parseColor(white));
        like.setBackgroundColor(Color.parseColor(white));
        temper.setBackgroundColor(Color.parseColor(white));
        pf.setBackgroundColor(Color.parseColor(white));
        society.setBackgroundColor(Color.parseColor(white));
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.iq_check:{
                resultShow.setText(AllResult.resultExtra[0]);
                break;
            }
            case R.id.like_check:{
                resultShow.setText(AllResult.resultExtra[1]);
                break;
            }
            case R.id.temper_check:{
                resultShow.setText(AllResult.resultExtra[2]);
                break;
            }
            case R.id.pf_check:{
                resultShow.setText(AllResult.resultExtra[3]);
                break;
            }
            case R.id.society_check:{
                resultShow.setText(AllResult.resultExtra[4]);
                break;
            }
            case R.id.fanhui_bt:{
                onBackPressed();
                break;
            }
            default:{
                break;
            }
        }
        refreshColor();
        v.setBackgroundColor(Color.parseColor(pressed));
    }
}
