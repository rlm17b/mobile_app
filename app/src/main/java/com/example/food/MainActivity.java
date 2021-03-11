package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);
        final EditText editText = new EditText(this);
        String email = editText.getText().toString();
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("mail", email);
        //startActivity(intent);
    }
}