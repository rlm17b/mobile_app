package com.example.food;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class RecipeActivity extends AppCompatActivity {

    Cursor mCursor;

    String[] mProjection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_layout);



        Intent intent = getIntent();
        String pro = intent.getStringExtra("protein");
        String sea = intent.getStringExtra("seasoning");
        String sid = intent.getStringExtra("side");


        String mSelectionClause = FoodContentProvider.COLUMN_PROTEIN + " = ? " + " AND " +
                FoodContentProvider.COLUMN_SIDE + " = ? " + " AND " + FoodContentProvider.COLUMN_SEASONING
                + " = ? ";

        String[] mSelectionArgs = { pro.trim(),
                sea.trim(), sid.trim() };

        mProjection = new String[] {
                FoodContentProvider.COLUMN_NAME,
                FoodContentProvider.COLUMN_INSTRUCTION
        };


        mCursor = getContentResolver().query(FoodContentProvider.CONTENT_URI, mProjection, mSelectionClause, mSelectionArgs, null);;


        TextView n = (TextView)findViewById(R.id.nameTextView);
        TextView i = (TextView)findViewById(R.id.instructionsTextView);


            n.setText("No Recipe");
            i.setText("Try doing a new search with different food items");

       // n.setText(mCursor.getString(4));
       // i.setText(mCursor.getString(5));

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
            case R.id.Save:
                createSaveDialog();
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
        EmailFragment e = new EmailFragment();
        FragmentManager f = getFragmentManager();
        FragmentTransaction mtrans = f.beginTransaction();
        mtrans.commit();


        //allow user to email recipe
    }

    private void createProfileDialog(){
        Intent intent = new Intent(getApplicationContext(), UserHomeActivity.class);
        startActivity(intent);
    }

    private void createSaveDialog(){
        Intent intent = new Intent(getApplicationContext(), UserHomeActivity.class);
        //intent.putExtra("name", mCursor.getString(0));
       // intent.putExtra("instruct", mCursor.getString(1));
        startActivity(intent);
    }

}
