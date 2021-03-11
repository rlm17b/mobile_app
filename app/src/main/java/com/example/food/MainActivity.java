package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_layout);

        EditText eMail = (EditText)findViewById(R.id.email);
        submit = (Button)findViewById(R.id.enter);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String email = eMail.getText().toString();
                    if (valid(email) == true) {
                        Toast.makeText(getApplicationContext(), "Welcome to the Food app", Toast.LENGTH_SHORT).show();
                        setContentView(R.layout.activity_main);
                    } else {
                        Toast.makeText(getApplicationContext(), "This is an invalid email address", Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }

    private boolean valid(String emailID){
        /*if(emailID ==){
            return true;
        }
        else{
            return false;
        }*/
        return true;
    }
}