package com.example.food;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_layout);
        //get data from db to show recipe name/instructions
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Email_Recipe:
                createEmailDialog();
                break;
            case R.id.New_Search:
                createSearchDialog();
                break;
            case R.id.Profile:
                createProfileDialog();
                break;

        }
        return true;
    }

    private void createSearchDialog() {
        Intent intent = new Intent(getApplicationContext(), FoodSearchActivity.class);
        startActivity(intent);
    }

    private void createEmailDialog() {
        //create a fragment and layout file to use this info to send email
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"Recepient"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Message body");
        //allow user to email recipe
    }

    private void createProfileDialog(){
        Intent intent = new Intent(getApplicationContext(), UserHomeActivity.class);
      //  startActivity(intent);
    }
}
