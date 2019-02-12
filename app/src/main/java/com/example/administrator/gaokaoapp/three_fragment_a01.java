package com.example.administrator.gaokaoapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class three_fragment_a01 extends AppCompatActivity {

    private TextView textView1;
    private Button BTN_a;
    private Button BTN_b;
    private Button BTN_c;
    private Button btn_shang;
    private  Button btn_next;
    static  int i=0;
    static char[] answer = new char[187];
    public void strinng(String[] arr_text1,String[] arr_text1_a,String[] arr_text1_b,String[] arr_text1_c,int a){

        textView1.setText(arr_text1[a].toString());
        BTN_a.setText(arr_text1_a[a].toString());
        BTN_b.setText(arr_text1_b[a].toString());
        BTN_c.setText(arr_text1_c[a].toString());
    }
    public void button_color(Button a,Button b,Button c){
        a.setBackground(new ColorDrawable(Color.rgb(127,255,212)));
        b.setBackground(new ColorDrawable(Color.rgb(230,230,250)));
        c.setBackground(new ColorDrawable(Color.rgb(230,230,250)));
    }
    public void button_color1(Button a,Button b,Button c){
        a.setBackground(new ColorDrawable(Color.rgb(230,230,250)));
        b.setBackground(new ColorDrawable(Color.rgb(230,230,250)));
        c.setBackground(new ColorDrawable(Color.rgb(230,230,250)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState  );
        setContentView( R.layout.activity_social_test );
        Resources res = this.getResources();

        final String[] arr_text1 = res.getStringArray(R.array.pf_text1);
        final String[] arr_text1_a = res.getStringArray(R.array.pf_text1_a);
        final String[] arr_text1_b = res.getStringArray(R.array.pf_text1_b);
        final String[] arr_text1_c = res.getStringArray(R.array.pf_text1_c);
        textView1 = findViewById(R.id.text1);
        BTN_a = findViewById(R.id.text1_a);
        BTN_b = findViewById(R.id.text1_b);
        BTN_c = findViewById(R.id.text1_c);
        btn_shang = findViewById(R.id.shang);
        btn_next = findViewById(R.id.next);
        button_color1(BTN_a,BTN_b,BTN_c);
        strinng(arr_text1,arr_text1_a,arr_text1_b,arr_text1_c,i);
        btn_shang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(i==0){
                    Toast.makeText(getApplicationContext(), "已经是第一题了！",Toast.LENGTH_SHORT).show();
                }
                else{
                    i--;
                    strinng(arr_text1,arr_text1_a,arr_text1_b,arr_text1_c,i);
                    if(answer[i]=='a'){
                        button_color(BTN_a,BTN_b,BTN_c);
                    }
                    else if(answer[i]=='b'){
                        button_color(BTN_b,BTN_a,BTN_c);
                    }
                    else if(answer[i]=='c'){
                        button_color(BTN_c,BTN_b,BTN_a);
                    }
                }

            }
        });
        btn_next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (i==19){
                    Intent intent=new Intent(three_fragment_a01.this,SocialTestResult.class);
                    startActivity(intent);
                }
                if(i<=19&&(answer[i]!='a'&&answer[i]!='b'&&answer[i]!='c')){
                    Toast.makeText(getApplicationContext(), "你并没有做出回答！",Toast.LENGTH_SHORT).show();;
                }
                if(i<19 &&(answer[i]=='a'||answer[i]=='b'||answer[i]=='c')){
                    i++;
                    strinng(arr_text1,arr_text1_a,arr_text1_b,arr_text1_c,i);
                    button_color1(BTN_a,BTN_b,BTN_c);
                }
                if(i==19){
                    btn_next.setText("提交");
                }

//                else{
//                    i++;
//                    strinng(arr_text1,arr_text1_a,arr_text1_b,arr_text1_c,i);
//                    button_color1(BTN_a,BTN_b,BTN_c);
//                    if (i==20){
//                        Intent intent=new Intent(SocialTest.this,SocialTestResult.class);
//                        startActivity(intent);
//                    }
//                }


            }
        });

        BTN_a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer[i] = 'a';
                button_color(BTN_a,BTN_b,BTN_c);
            }
        });
        BTN_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer[i] = 'b';
                button_color(BTN_b,BTN_a,BTN_c);
            }
        });
        BTN_c.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer[i] = 'c';
                button_color(BTN_c,BTN_b,BTN_a);
            }
        });




    }
}