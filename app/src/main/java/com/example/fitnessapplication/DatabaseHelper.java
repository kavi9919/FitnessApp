package com.example.fitnessapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "UserProfile.db";
    private static final String TABLE_NAME = "user_profiles";
    private static final String COL_ID = "id";
    private static final String COL_EMAIL = "email";
    private static final String COL_FIRST_NAME = "first_name";
    private static final String COL_LAST_NAME = "last_name";
    private static final String COL_AGE = "age";
    private static final String COL_GENDER = "gender";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_EMAIL + " TEXT, " +
                COL_FIRST_NAME + " TEXT, " +
                COL_LAST_NAME + " TEXT, " +
                COL_AGE + " INTEGER, " +
                COL_GENDER + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertUserProfile(UserProfile userProfile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EMAIL, userProfile.getEmail());
        contentValues.put(COL_FIRST_NAME, userProfile.getFirstName());
        contentValues.put(COL_LAST_NAME, userProfile.getLastName());
        contentValues.put(COL_AGE, userProfile.getAge());
        contentValues.put(COL_GENDER, userProfile.getGender());
        return db.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getUserProfileById(long userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ID + " = ?", new String[]{String.valueOf(userId)});
    }

    public int removeUserProfile(long userId) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_ID + " = ?", new String[]{String.valueOf(userId)});
    }
}
