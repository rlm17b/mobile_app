package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FoodSearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button)findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner p = (Spinner)findViewById(R.id.protein);
                Spinner se = (Spinner)findViewById(R.id.seasoning);
                Spinner si = (Spinner)findViewById(R.id.side);


                String sid = si.getSelectedItem().toString();
                String pro = p.getSelectedItem().toString();
                String sea = se.getSelectedItem().toString();

                if(pro.equals("none")){
                    Toast.makeText(getApplicationContext(), "Missing protein", Toast.LENGTH_SHORT).show();
                }
                else if(sea.equals("none")){
                    Toast.makeText(getApplicationContext(), "Missing seasonings", Toast.LENGTH_SHORT).show();
                }
                else {
                    //need to query table to get name/instructions, and show it on third activity
                    Intent intent = new Intent(getApplicationContext(), RecipeActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}
