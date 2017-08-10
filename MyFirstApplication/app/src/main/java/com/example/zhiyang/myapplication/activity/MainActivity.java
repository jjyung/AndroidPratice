package com.example.zhiyang.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhiyang.myapplication.R;
import com.example.zhiyang.myapplication.util.GlobalData;

public class MainActivity extends AppCompatActivity {

    private Button pressMeBtn, logoutBtn;
    private TextView helloWorldTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO check login

        pressMeBtn = (Button) findViewById(R.id.pressMeBtn);
        logoutBtn = (Button) findViewById(R.id.logoutBtn);
        helloWorldTextView = (TextView) findViewById(R.id.helloWorldTextView);

        if (GlobalData.isLogin(getApplicationContext())) {
            helloWorldTextView.setText("Hello, " + GlobalData.getSharePreferences(getApplicationContext(), GlobalData.emailKey)+ ".");
        }

        pressMeBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                helloWorldTextView.setText("Stay Hungry, Stay Foolish.");
            }
        });

        logoutBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}
