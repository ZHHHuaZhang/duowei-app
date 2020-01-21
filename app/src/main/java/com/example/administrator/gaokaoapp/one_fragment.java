package com.example.administrator.gaokaoapp;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class one_fragment extends Fragment implements View.OnClickListener{

    Intent entrance = null;
    ImageButton mse, tre, hte, hpe, cbe, ste = null;
    public static TextView userInfo_short = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        mse = getActivity().findViewById(R.id.message_entrance);
        tre = getActivity().findViewById(R.id.test_r_entrance);
        hte = getActivity().findViewById(R.id.history_entrance);
        hpe = getActivity().findViewById(R.id.help_entrance);
        cbe = getActivity().findViewById(R.id.callback_entrance);
        ste = getActivity().findViewById(R.id.setting_entrance);
        userInfo_short = getActivity().findViewById(R.id.userInfo_short);

        mse.setOnClickListener(this);
        tre.setOnClickListener(this);
        hte.setOnClickListener(this);
        hpe.setOnClickListener(this);
        cbe.setOnClickListener(this);
        ste.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.message_entrance:{
                entrance = new Intent(getActivity(), MyMessage.class);
                break;
            }
            case R.id.test_r_entrance:{
                entrance = new Intent(getActivity(), TestResultCheck.class);
                break;
            }
            case R.id.history_entrance:{
                entrance = new Intent(getActivity(), MyMessage.class);
                break;
            }
            case R.id.help_entrance:{
                entrance = new Intent(getActivity(), MyMessage.class);
                break;
            }
            case R.id.callback_entrance:{
                entrance = new Intent(getActivity(), ProblemCallBack.class);
                break;
            }
            case R.id.setting_entrance:{
                entrance = new Intent(getActivity(), Setting.class);
                break;
            }
            default:{
                break;
            }
        }
        if(!entrance.equals(null)){
            startActivity(entrance);
        }
    }
}
