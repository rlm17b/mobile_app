package com.example.food;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FoodContentProvider extends ContentProvider {
    public final static String DBNAME = "food.db";
    public final static String TABLE_NAME = "recipe";
    public final static String COLUMN_PROTEIN = "proteins";
    public final static String COLUMN_SEASONING = "seasonings";
    public final static String COLUMN_SIDE = "sides";
    public final static String COLUMN_NAME = "name";
    public final static String COLUMN_INSTRUCTION = "instructions";


    public static final String Authority = "com.example.food";
    public static final Uri CONTENT_URI = Uri.parse("content://com.example.food.provider/" + TABLE_NAME);

    private static UriMatcher sUriMatcher;
    private MainDatabaseHelper mOpenHelper;

    private static final String SQL_CREATE_MAIN = "CREATE TABLE " +
            TABLE_NAME +  // Table's name
            "(" +            // The columns in the table
            COLUMN_PROTEIN +
            "TEXT, " +
            COLUMN_SEASONING +
            " TEXT," +
            COLUMN_SIDE +
            " TEXT," +
            COLUMN_NAME +
            " TEXT PRIMARY KEY," +
            COLUMN_INSTRUCTION +
            " TEXT)";

    @Override
    public boolean onCreate() {
        getContext().deleteDatabase(DBNAME);
        mOpenHelper = new MainDatabaseHelper(getContext());


        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return mOpenHelper.getReadableDatabase().query(TABLE_NAME, projection, selection, selectionArgs,
                null, null, sortOrder);
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String proteins = values.getAsString(COLUMN_PROTEIN).trim();
        String seasonings = values.getAsString(COLUMN_SEASONING).trim();
        String sides = values.getAsString(COLUMN_SIDE).trim();
        String name = values.getAsString(COLUMN_NAME).trim();
        String instructions = values.getAsString(COLUMN_INSTRUCTION).trim();

        if (proteins.equals("") || seasonings.equals("") || name.equals("") || sides.equals("") || instructions.equals(""))
            return null;


        long id = mOpenHelper.getWritableDatabase().insert(TABLE_NAME, null, values);

        return Uri.withAppendedPath(CONTENT_URI, "");
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return mOpenHelper.getWritableDatabase().delete(TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return mOpenHelper.getWritableDatabase().update(TABLE_NAME, values, selection, selectionArgs);
    }

    protected static final class MainDatabaseHelper extends SQLiteOpenHelper {
        MainDatabaseHelper(Context context) {
            super(context, DBNAME, null, 1);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_MAIN);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
            onCreate(db);
        }
    }
}