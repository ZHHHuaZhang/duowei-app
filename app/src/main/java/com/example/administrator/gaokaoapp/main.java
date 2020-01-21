package com.example.administrator.gaokaoapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class main extends AppCompatActivity {
    //定义三个Fragment的对象~
    private one_fragment fg1;
    private two_fragment fg2;
    private three_fragment fg3;
    //定义三个图片按钮~
    private ImageButton imageButton1,imageButton2,imageButton3, logout;
    DrawerLayout drawerLayout1;
    RelativeLayout drawer;

    TextView registerEntrance;
    public static TextView name_drawer;
    Button loginEntrance;

    EditText userName, password = null;
    public static RelativeLayout unlogin_drawer = null;

    public static HashMap testUsers = new HashMap<String, String>();
    public static String curTestUser = "";
    //public static TextView userInfo_short;

    //定义侧滑栏的按钮~
    private ImageButton imageButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );

        //让EditText出现的软键盘老实点~
        getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN );


        initView();
        initcehualan();
        if(getIntent().hasExtra( "back" )){
            imageButton3.performClick();
        }
    }

    //通过按钮启动侧滑栏~
    private void initcehualan() {
        imageButton4=findViewById( R.id.cehualan );
        imageButton4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout1.openDrawer( drawer);
            }
        } );
    }

    //Fragment 栏目的代码
    private void initView() {
        imageButton1 = findViewById( R.id.wode );
        imageButton2 = findViewById( R.id.gaokaozixun );
        imageButton3 = findViewById( R.id.zhuanyeceping );
        logout = findViewById(R.id.tuichu2);
        userName = findViewById(R.id.yonghuming);
        password = findViewById(R.id.jianpan);
        registerEntrance = findViewById(R.id.zhuce);
        loginEntrance = findViewById(R.id.denglu);
        drawerLayout1 = findViewById( R.id.drawerlayout1 );
        drawer = findViewById(R.id.drawer);
        unlogin_drawer = findViewById(R.id.unlogin_drawer);
        name_drawer = findViewById(R.id.name_drawer);

        loginEntrance.setOnClickListener(l);
        registerEntrance.setOnClickListener(l);
        imageButton1.setOnClickListener( l );
        imageButton2.setOnClickListener( l );
        imageButton3.setOnClickListener( l );
        logout.setOnClickListener(l);
        imageButton1.performClick();
        imageButton3.performClick();
        imageButton2.performClick();
    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.wode:
                    xuanze(0);
                    break;
                case R.id.gaokaozixun:
                    xuanze(1);
                    break;
                case R.id.zhuanyeceping:
                    xuanze(2);
                    break;
                case R.id.denglu:{
                    String userName_input = userName.getText().toString();
                    String password_input = password.getText().toString();
                    Object check_o = testUsers.get(userName_input);
                    String check =  check_o== null?"":check_o.toString();
                    //Toast.makeText(main.this, check + "//" + password_input, Toast.LENGTH_LONG).show();
                    if(!(password_input.isEmpty()) && check.equals(password_input)) {
                        curTestUser = userName_input;
                        name_drawer.setText(curTestUser.substring(0, 5));
                        drawerLayout1.closeDrawer(drawer);
                        unlogin_drawer.setVisibility(View.GONE);
                        one_fragment.userInfo_short.setText(curTestUser.substring(0,5) + "\n" + "高考分数: ___分");
                        Toast.makeText(main.this, "login success", Toast.LENGTH_LONG).show();
                        userName.setText("");
                        password.setText("");
                    }
                    else{
                        Toast.makeText(main.this, "用户名或密码错误", Toast.LENGTH_LONG).show();
                    }
                    break;
                }
                case R.id.zhuce:{
                    startActivity(new Intent(main.this, Register.class));
                    break;
                }
                case R.id.tuichu2:{
                    curTestUser = "";
                    drawerLayout1.closeDrawer( drawer);
                    Toast.makeText(main.this, "logout success", Toast.LENGTH_LONG).show();
                    unlogin_drawer.setVisibility(View.VISIBLE);
                    one_fragment.userInfo_short.setText("");
                    userName.setText("");
                    password.setText("");
                }
                default:
                    break;
            }
        }
        private void xuanze(int index) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            clean();
            switch (index) {
                case 0:
                    imageButton1.setImageResource(R.drawable.p2);
                    if (fg1 == null) {
                        fg1 = new one_fragment();
                        transaction.add(R.id.a1,fg1);
                    }
                    hideFragments(transaction);
                    transaction.show(fg1);
                    break;
                case 1:
                    imageButton2.setImageResource(R.drawable.g2);
                    if (fg2 == null) {
                        fg2 = new two_fragment();
                        transaction.add(R.id.a1, fg2);
                    }
                    hideFragments(transaction);
                    transaction.show(fg2);
                    break;
                case 2:
                    imageButton3.setImageResource(R.drawable.m2);
                    if (fg3 == null) {
                        fg3 = new three_fragment();
                        transaction.add(R.id.a1, fg3);
                    }
                    hideFragments(transaction);
                    transaction.show(fg3);
                    break;
            }
            transaction.commit();
        }
        private void hideFragments(FragmentTransaction transaction) {
            if (fg1 != null) {
                transaction.hide(fg1);
            }
            if (fg2 != null) {
                transaction.hide(fg2);
            }
            if (fg3 != null) {
                transaction.hide(fg3);
            }
        }
        private void clean() {
            imageButton1.setImageResource(R.drawable.p);
            imageButton2.setImageResource(R.drawable.g);
            imageButton3.setImageResource(R.drawable.m);
        }
    };
}
