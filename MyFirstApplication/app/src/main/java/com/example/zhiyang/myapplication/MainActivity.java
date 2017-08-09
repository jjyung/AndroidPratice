package com.example.zhiyang.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button pressMeBtn;
    private TextView helloWorldTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pressMeBtn = (Button) findViewById(R.id.pressMeBtn);
        helloWorldTextView = (TextView) findViewById(R.id.helloWorldTextView);

        pressMeBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                helloWorldTextView.setText("Stay Hungry, Stay Foolish.");
            }
        });
    }


}
