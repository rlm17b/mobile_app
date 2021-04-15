package com.example.food;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserHomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backdrop_layout);
        //home screen after login, implement backdrop
        TextView g = (TextView)findViewById(R.id.uTextView);
        Intent i = getIntent();
        g.setText(i.getStringExtra("user"));

        TextView n = (TextView)findViewById(R.id.n1Tv);
        TextView in = (TextView)findViewById(R.id.inTv);

        Bundle extras = i.getExtras();

        if(extras.containsKey("name")){

            n.setText(i.getStringExtra("name"));
            in.setText(i.getStringExtra("instruct"));

        }
        else{
            n.setText("No Current Recipe");
            in.setText("Search for a new recipe");
        }



        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);
        Button b3 = (Button)findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FoodSearchActivity.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EmailFragment e = new EmailFragment();
                FragmentManager f = getFragmentManager();
                FragmentTransaction mtrans = f.beginTransaction();
                mtrans.commit();

            }
        });


    }
}
