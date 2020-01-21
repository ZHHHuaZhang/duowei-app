package com.example.administrator.gaokaoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Intent registerFake;
    EditText userName, userPW;
    Button login;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.layout_menu_login3 );
        registerFake = new Intent(Register.this, main.class);
        userName = findViewById(R.id.number1);
        userPW = findViewById(R.id.number2);
        login = findViewById(R.id.dengluzhuce);
        back = findViewById(R.id.return_bt);
        login.setOnClickListener(this);
        back.setOnClickListener(this);

        Toast.makeText(this, "用户名至少6个字符:)", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        String[] registerInfo = {userName.getText().toString(), userPW.getText().toString()};
        switch (v.getId()){
            case R.id.dengluzhuce:{
                if(!(registerInfo[0].length()<6||registerInfo[1].isEmpty())) {
//                    registerFake.putExtra("user-login", registerInfo);
//                    startActivity(registerFake);
                    main.testUsers.put(registerInfo[0], registerInfo[1]);
                    main.curTestUser = registerInfo[0];
                    main.unlogin_drawer.setVisibility(View.GONE);
                    main.name_drawer.setText(main.curTestUser.substring(0, 5));
                    one_fragment.userInfo_short.setText(main.curTestUser.substring(0,5) + "\n" + "高考分数: ___分");
                    Toast.makeText(this, "register success", Toast.LENGTH_LONG).show();
                    onBackPressed();
                }
                break;
            }
            case R.id.return_bt:{
                onBackPressed();
                break;
            }
            default:{
                break;
            }
        }
    }
}
