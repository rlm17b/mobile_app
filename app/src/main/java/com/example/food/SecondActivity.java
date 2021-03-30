package com.example.food;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner p = (Spinner)findViewById(R.id.protein);
        Spinner se = (Spinner)findViewById(R.id.seasoning);
        Spinner si = (Spinner)findViewById(R.id.side);

        String pro = p.getSelectedItem().toString();
        String sea = se.getSelectedItem().toString();
        String sid = si.getSelectedItem().toString();

        Button button = (Button)findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //need to query table to get name/instructions, and show it on third activity
            }
        });


    }
}
