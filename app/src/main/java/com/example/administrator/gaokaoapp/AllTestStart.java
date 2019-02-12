package com.example.administrator.gaokaoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AllTestStart extends AppCompatActivity implements View.OnClickListener{

    TextView p, p1, tip, title = null;
    Button start = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_test_start);
        p = findViewById(R.id.p0);
        p1 = findViewById(R.id.p1);
        tip = findViewById(R.id.question_tip);
        title = findViewById(R.id.question_title);
        start = findViewById(R.id.test_start);
        start.setOnClickListener(this);
        switch (getIntent().getStringExtra("question-class")){
            case "society-test": {
                p.setText(getResources().getText(R.string.society_start));
                p1.setText(getResources().getText(R.string.society_start_1));
                tip.setText(getResources().getText(R.string.society_start_tip));
                title.setText("社会适应能力测试");
                break;
            }
            case "temper-type": {
                p.setText(getResources().getText(R.string.temper_start));
                p1.setText(getResources().getText(R.string.temper_start_1));
                tip.setText(getResources().getText(R.string.temper_start_tip));
                title.setText("气质类型测试");
                break;
            }
            case "spm": {
                break;
            }
            case "16pf": {
                break;
            }
            case "sds": {
                break;
            }
        }
    }

    @Override
    public void onClick(View v){
        switch (getIntent().getStringExtra("question-class")){
            case "spm": {
                startActivity(new Intent(AllTestStart.this, temper_type_test.class));
                break;
            }
            case "16pf": {
                startActivity(new Intent(AllTestStart.this, three_fragment_a01.class));
                break;
            }
            case "society-test": {
                startActivity(new Intent(AllTestStart.this, SocialTest.class));
                break;
            }
            case "temper-type": {
                startActivity(new Intent(AllTestStart.this, temper_type_test.class));
                break;
            }
            case "sds": {
                startActivity(new Intent(AllTestStart.this, three_fragment_a01.class));
                break;
            }
            default: break;
        }
    }
}
