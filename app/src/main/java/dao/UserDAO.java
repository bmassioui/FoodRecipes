package dao;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import models.User;

public class UserDAO {

    private SQLiteDatabase db;

    public UserDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public void insert(User user) {
        ContentValues values = new ContentValues();
        values.put(Config.KEY_USERNAME, user.getUsername());
        values.put(Config.KEY_EMAIL, user.getEmail());
        values.put(Config.KEY_PASSWORD, user.getPassword());

        insert(values);
    }

    private long insert(ContentValues values) {
        return db.insert(Config.TABLE_NAME, null, values);
    }

    /**
     * Try to get User by Email and Pwd
     *
     * @param email user email
     * @param pwd user pwd
     * @return User?
     */
    public User getByEmail(String email, String pwd){
        try(Cursor cursor = db.query(true, Config.TABLE_NAME, new String[]{Config.KEY_ID, Config.KEY_USERNAME, Config.KEY_EMAIL, Config.KEY_PASSWORD}, Config.KEY_EMAIL + "=? AND " + Config.KEY_PASSWORD + "=?", new String[]{email, pwd},null, null, null, null)){
            return extractUserFromCursor(cursor);
        }
    }

    /**
     * Try to get User by UserName and Pwd
     *
     * @param userName user username
     * @param pwd user pwd
     * @return User?
     */
    public User getByUserName(String userName, String pwd){
        try(Cursor cursor = db.query(true, Config.TABLE_NAME, new String[]{Config.KEY_ID, Config.KEY_USERNAME, Config.KEY_EMAIL, Config.KEY_PASSWORD}, Config.KEY_USERNAME + "=? AND " + Config.KEY_PASSWORD + "=?", new String[]{userName, pwd},null, null, null, null)){
            return extractUserFromCursor(cursor);
        }
    }

    private User extractUserFromCursor(Cursor cursor) {
        if (cursor.moveToFirst()) {
            return new User(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );
        }

        return null;
    }

    public static class Config {
        public static final String TABLE_NAME = "users";
        public static final String KEY_ID = "id";
        public static final String KEY_USERNAME = "username";
        public static final String KEY_EMAIL = "email";
        public static final String KEY_PASSWORD = "password";

        public static final String CREATE_TABLE_STATEMENT =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        KEY_USERNAME + " TEXT NOT NULL, " +
                        KEY_EMAIL + " TEXT NOT NULL, " +
                        KEY_PASSWORD + " TEXT NOT NULL)";
    }
}

