package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
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

        Uri mNewUri;

        ContentValues mNewValues = new ContentValues();


        //recipe 1

        mNewValues.put(FoodContentProvider.COLUMN_PROTEIN, "chicken".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SEASONING, "salt, black pepper".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SIDE, "none".trim());
        mNewValues.put(FoodContentProvider.COLUMN_NAME, "Grilled Chicken".trim());
        mNewValues.put(FoodContentProvider.COLUMN_INSTRUCTION, ("spread a tsp of each seasoning on" +
                " each side of the chicken, then cook each side on the stove at medium high for six minutes").trim());

        mNewUri = getContentResolver().insert(
                FoodContentProvider.CONTENT_URI, mNewValues);


        //recipe 2

        mNewValues.put(FoodContentProvider.COLUMN_PROTEIN, "chicken".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SEASONING, "salt, black pepper, garlic powder, onion powder".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SIDE, "none".trim());
        mNewValues.put(FoodContentProvider.COLUMN_NAME, "Grilled Garlic Chicken".trim());
        mNewValues.put(FoodContentProvider.COLUMN_INSTRUCTION, ("spread a tsp of each seasoning on and 1 tbsp of garlic" +
                " each side of the chicken, then cook each side on the stove at medium high for six minutes").trim());

        mNewUri = getContentResolver().insert(
                FoodContentProvider.CONTENT_URI, mNewValues);

        //recipe 3

        mNewValues.put(FoodContentProvider.COLUMN_PROTEIN, "chicken".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SEASONING, "salt, black pepper, garlic powder, onion powder, chili powder".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SIDE, "none".trim());
        mNewValues.put(FoodContentProvider.COLUMN_NAME, "Grilled Spicy Chicken".trim());
        mNewValues.put(FoodContentProvider.COLUMN_INSTRUCTION, ("spread a tsp of each seasoning on" +
                " each side of the chicken, then cook each side on the stove at medium high for five minutes").trim());

        mNewUri = getContentResolver().insert(
                FoodContentProvider.CONTENT_URI, mNewValues);


        //recipe 4

        mNewValues.put(FoodContentProvider.COLUMN_PROTEIN, "steak".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SEASONING, "salt, black pepper, garlic powder, onion powder, chili powder".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SIDE, "none".trim());
        mNewValues.put(FoodContentProvider.COLUMN_NAME, "Steak".trim());
        mNewValues.put(FoodContentProvider.COLUMN_INSTRUCTION, ("spread a tsp of salt and pepper, spread 2 tsp of garlic, onion, and chilli on" +
                " each side of the steak, then cook each side on the stove at medium high for three minutes" +
                ", then base the steak with butter on medium low for a minute").trim());

        mNewUri = getContentResolver().insert(
                FoodContentProvider.CONTENT_URI, mNewValues);



        //recipe 5

        mNewValues.put(FoodContentProvider.COLUMN_PROTEIN, "chicken".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SEASONING, "salt, black pepper, garlic powder, onion powder".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SIDE, "pasta".trim());
        mNewValues.put(FoodContentProvider.COLUMN_NAME, "Chicken Alfredo".trim());
        mNewValues.put(FoodContentProvider.COLUMN_INSTRUCTION, ("spread a tsp of each seasoning on" +
                " each side of the chicken, then cook each side on the stove at medium high for six minutes," +
                "then boil water and cook the pasta, drain, heat heavy cream with tbp of each seasoning on medium low," +
                "add parmesan cheese, mix and pour both the pasta and chicken in the alfredo sauce").trim());

        mNewUri = getContentResolver().insert(
                FoodContentProvider.CONTENT_URI, mNewValues);



        //recipe 6

        mNewValues.put(FoodContentProvider.COLUMN_PROTEIN, "ground beef".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SEASONING, "salt, black pepper, garlic powder, onion powder, chili powder".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SIDE, "pasta".trim());
        mNewValues.put(FoodContentProvider.COLUMN_NAME, "Spaghetti".trim());
        mNewValues.put(FoodContentProvider.COLUMN_INSTRUCTION, ("spread a 2 tbp of each seasoning on" +
                " the ground beef, then cook on the stove at medium high until browned, boil water, cook the pasta" +
                "drain, heat up marinara sauce, mix the pasta and beef with the sauce").trim());

        mNewUri = getContentResolver().insert(
                FoodContentProvider.CONTENT_URI, mNewValues);


        //recipe 7

        mNewValues.put(FoodContentProvider.COLUMN_PROTEIN, "steak".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SEASONING, "salt, black pepper, garlic powder, onion powder".trim());
        mNewValues.put(FoodContentProvider.COLUMN_SIDE, "potatoes".trim());
        mNewValues.put(FoodContentProvider.COLUMN_NAME, "Steak and Fries".trim());
        mNewValues.put(FoodContentProvider.COLUMN_INSTRUCTION, ("spread a tsp of each seasoning on" +
                " each side of the steak, then cook each side on the stove at medium high for 3 minutes," +
                "then cut potatoes, add seasoning and drizzle vegetable oil, cook in oven until crispy").trim());

        mNewUri = getContentResolver().insert(
                FoodContentProvider.CONTENT_URI, mNewValues);







        EditText eMail = (EditText)findViewById(R.id.email);
        submit = (Button)findViewById(R.id.enter);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String email = eMail.getText().toString();
                    if (valid(email) == true) {
                        Toast.makeText(getApplicationContext(), "Welcome to the Food app", Toast.LENGTH_SHORT).show();
                        //setContentView(R.layout.activity_main);
                        Intent intent = new Intent(getApplicationContext(), FoodSearchActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "This is an invalid email address", Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }

    private boolean valid(String emailID){
        if(emailID.contains("@gmail.com")){
            return true;
        }
        else{
            return false;
        }
    }
}