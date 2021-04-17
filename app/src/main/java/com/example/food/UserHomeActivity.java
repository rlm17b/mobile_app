package com.example.food;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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


        if(i.getStringExtra("name") == null){

            n.setText("No Current Recipe");
            in.setText("Search for a new recipe");


        }
        else{
            n.setText(i.getStringExtra("name"));
            in.setText(i.getStringExtra("instruct"));
        }



        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);
        Button b3 = (Button)findViewById(R.id.button3);

        Toast.makeText(getApplicationContext(), "The backdrop may take more than one try to respond. It does not scroll back down", Toast.LENGTH_LONG).show();

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

                String[] TO = {""};
                String[] CC = {""};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                finish();

            }
        });


    }
}
