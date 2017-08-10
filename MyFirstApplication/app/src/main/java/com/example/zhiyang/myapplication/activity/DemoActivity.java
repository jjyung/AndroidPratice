package com.example.zhiyang.myapplication.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.zhiyang.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoActivity extends AppCompatActivity {

    private Context demoContext = this;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We'll define a custom screen layout here (the one shown above), but
        // typically, you could just use the standard ListActivity layout.
        setContentView(R.layout.activity_demo);

        ListView demoListView = (ListView) findViewById(R.id.demoListView);

        String[] fromColumns = {"name"};
        int[] toViews = {android.R.id.text1};

        adapter = new SimpleAdapter(this, getDataList(), android.R.layout.simple_list_item_1, fromColumns, toViews);
        // Bind to our new adapter.
        demoListView.setAdapter(null);

        TextView headTextView = new TextView(this);
        headTextView.setText("Demo List");
        headTextView.setTextSize(44);
        demoListView.addHeaderView(headTextView);

        demoListView.setAdapter(adapter);
        demoListView.setOnItemClickListener(getItemClickListener());
    }

    private List<HashMap<String, String>> getDataList() {
        List<HashMap<String, String>> dataList = new ArrayList<>();

        HashMap<String, String> element;
        // test1
        element = new HashMap<>();
        element.put("name", "TESTDEMO1");
        dataList.add(element);
        // test2
        element = new HashMap<>();
        element.put("name", "TESTDENO2");
        dataList.add(element);

        return dataList;
    }

    private AdapterView.OnItemClickListener getItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                switch (textView.getText().toString()) {
                    case "TESTDEMO1":
                        new AlertDialog.Builder(demoContext)
                                .setTitle("TESTDEMO1")
                                .setMessage("You clicked textdemo1.")
                                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }).show();
                        break;
                    case "TESTDENO2":
                        new AlertDialog.Builder(demoContext)
                                .setTitle("TESTDEMO2")
                                .setMessage("You clicked textdemo2.")
                                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }).show();
                        break;
                    default:
                }
            }
        };
    }
}
