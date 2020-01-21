package com.example.administrator.gaokaoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.Arrays;
import java.lang.Double;
import java.util.HashMap;

public class AdmitLine extends AppCompatActivity implements View.OnClickListener{

    private static double[] averageA = {0,0,0,0};
    private static double[] averageL = {0,0,0,0};

    private HashMap lineMap = new HashMap<String,Integer>();

    private static TextView percentShow;
    private static String[] universities = null;
    private static String[] universitiesScore = null;
    private static String user_university;

    private static EditText input_mark;
    private static EditText input_university;
    private static EditText input_speciality;

    private static ImageButton backButton;
    private static Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_admit_line );
        percentShow = findViewById(R.id.per_show);
        percentShow.setVisibility(View.GONE);
        universities = getResources().getStringArray(R.array.universities);
        universitiesScore = getResources().getStringArray(R.array.university_scores);
        input_mark = findViewById(R.id.input_mark);
        input_university = findViewById(R.id.input_university);
        input_speciality = findViewById(R.id.input_speciality);
        submitButton = findViewById(R.id.submit_mark);
        backButton = findViewById(R.id.fanhui_bt);
        submitButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    //LD=line Difference线差, AD=Average
    private static String percentCal(double mark, double[] line, double[] average, double[] lowest){
        for(int i = 0; i< Array.getLength(line); i++){
            averageA[i] = average[i] - line[i];
            averageL[i] = lowest[i] - line[i];
            System.out.println(averageA[i] + " -- " + averageL[i]);
        }
        //double averageAA = Arrays.stream(averageA).average().orElse(0);
        //double averageLA = Arrays.stream(averageL).average().orElse(0);
        double averageLA = 0;
        double averageAA = 0;
        double percent = (mark-averageLA)/(averageAA-averageLA)*0.5+0.5;
        // percent = 0.5;
        System.out.println(averageAA + " -- " + averageLA);
        System.out.println(percent);
        NumberFormat nf = NumberFormat.getPercentInstance();
        // nf.setMinimumFractionDigits(1);
        System.out.println(nf.format(percent));
        return nf.format(percent);
    }

    //university line random mode
    private String percentCal(double mark, String universityName, String specialityName){
        double lineA = 573 + Math.random()*(634-573);
        for(int i=0; i< universities.length; i++){
            if(universityName.equals(universities[i])){
                universityName = universities[i];
                lineA = Double.parseDouble(universitiesScore[i]);
                break;
            }
        }
        double lineLA = lineA - (10 + Math.random()*20);
        //Toast.makeText(this,mark+"--"+lineA+"--"+lineLA,Toast.LENGTH_LONG).show();
        double percent = (mark-lineLA)<0?0:(mark-lineLA)/(lineA-lineLA)*0.5;
        percent = percent>0.5?1:percent+0.5;
        NumberFormat nf = NumberFormat.getPercentInstance();
        return mark + "-" + universityName + "-" + specialityName + "--->" + nf.format(percent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.submit_mark:{
                if(!(input_speciality.getText().toString().isEmpty()||input_university.getText().toString().isEmpty()||input_mark.getText().toString().isEmpty())) {
                    percentShow.setText(percentCal(Double.parseDouble(input_mark.getText().toString()), input_university.getText().toString(), input_speciality.getText().toString()));
                    percentShow.setVisibility(View.VISIBLE);
                }
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
    }

}
