package com.example.zhiyang.myapplication.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhiyang.myapplication.R;
import com.example.zhiyang.myapplication.util.GlobalData;

public class MainActivity extends AppCompatActivity {
    private Button pressMeBtn, demoBtn;
    private TextView helloWorldTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        pressMeBtn = (Button) findViewById(R.id.pressMeBtn);
        demoBtn = (Button) findViewById(R.id.demoBtn);
        helloWorldTextView = (TextView) findViewById(R.id.helloWorldTextView);

        if (GlobalData.isLogin(getApplicationContext())) {
            helloWorldTextView.setText("Hello, " + GlobalData.getSharePreferences(getApplicationContext(), GlobalData.emailKey) + ".");
        }

        pressMeBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                helloWorldTextView.setText("Stay Hungry, Stay Foolish.");
            }
        });

        demoBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DemoActivity.class);
                startActivity(intent);
            }
        });
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_menu_logout:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void logout() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.action_logout)
                .setMessage("Sure to logout?")
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        GlobalData.clearLogin(getApplicationContext());
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("Cancel", null).show();

    }

}
