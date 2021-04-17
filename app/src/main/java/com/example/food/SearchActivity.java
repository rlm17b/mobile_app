package com.example.food;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {
    Cursor mCursor;

    String[] mProjection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        EditText editText = (EditText) findViewById(R.id.edittext);

        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editText.getText().toString().trim();

                String[] mSelectionArgs = {name};

                mProjection = new String[]{
                        FoodContentProvider.COLUMN_NAME,
                        FoodContentProvider.COLUMN_INSTRUCTION
                };

                String mSelectionClause = FoodContentProvider.COLUMN_NAME + " = ? ";
                Toast.makeText(getApplicationContext(), "Wrong name, try again.", Toast.LENGTH_SHORT).show();

                // mCursor = getContentResolver().query(FoodContentProvider.CONTENT_URI, mProjection, mSelectionClause, mSelectionArgs, null);

            }


        });

        Button home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserHomeActivity.class);
                startActivity(intent);

            }
        });
    }


}
