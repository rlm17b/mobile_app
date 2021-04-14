package com.example.food;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {
    Cursor mCursor;

    String[] mProjection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);

        EditText editText = (EditText)findViewById(R.id.edittext);
        String name = editText.getText().toString().trim();

        String[] mSelectionArgs = { name };

        mProjection = new String[] {
                FoodContentProvider.COLUMN_NAME,
                FoodContentProvider.COLUMN_INSTRUCTION
        };

        String mSelectionClause = FoodContentProvider.COLUMN_NAME + " = ? ";

        mCursor = getContentResolver().query(FoodContentProvider.CONTENT_URI, mProjection, mSelectionClause, mSelectionArgs, null);;
    }
}
