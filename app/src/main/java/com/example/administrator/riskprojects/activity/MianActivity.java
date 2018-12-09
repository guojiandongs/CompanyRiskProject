package com.example.administrator.riskprojects.activity;

import android.os.Bundle;

import com.example.administrator.riskprojects.BaseActivity;
import com.example.administrator.riskprojects.R;
import com.example.administrator.riskprojects.net.NetClient;

public class MianActivity extends BaseActivity {

    protected NetClient netClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
    }

    private void initView(){

    }
    private void setView() {

    }
}
