package com.satyam.workshopproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.PublicKey;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DatabaseName = "BookLibrary.db";
    private static final int DatabaseVersion = 1;
    private static final String Table_name = "users";
    private static final String PersonId = "_id";
    private static final String PersonMobile = "person_mobile";
    private static final String PersonPassword = "person_Password";
//    private static final String PersonName = "Name";


    DatabaseHelper(Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + Table_name + " (" + PersonId + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PersonMobile + " TEXT, "
                + PersonPassword + " TEXT);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(sqLiteDatabase);
    }

    void SignUp(String personMobile, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PersonMobile, personMobile);
        cv.put(PersonPassword, password);

        long res = db.insert(Table_name, null, cv);
        if (res == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show();
        }

    }

    boolean matchData(String personMobile, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from users where "+PersonMobile+" = ? and "+PersonPassword+" = ?", new String[]{personMobile, password});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }


}
