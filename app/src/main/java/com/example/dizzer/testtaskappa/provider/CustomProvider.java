package com.example.dizzer.testtaskappa.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Dizzer on 2/23/2018.
 */

public class CustomProvider extends ContentProvider {

    public static final String CONTENT_AUTHORITY = "com.example.dizzer.testtaskappa.provider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    private static final String IMAGES_PATH = "images";
    public static final Uri CONTENT_URI_IMAGES = BASE_CONTENT_URI.buildUpon().appendPath(IMAGES_PATH).build();

    public static final int IMAGE = 1001;
    public static final int IMAGE_ID = 1002;

    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(CONTENT_AUTHORITY,IMAGES_PATH,IMAGE);
        uriMatcher.addURI(CONTENT_AUTHORITY,IMAGES_PATH +"/*",IMAGE_ID);
    }

    private CustomDB mCustomDB;

    @Override
    public boolean onCreate() {
        mCustomDB = new CustomDB(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        SQLiteDatabase database = mCustomDB.getReadableDatabase();
        int mUriMather = uriMatcher.match(uri);
        Cursor cursor;
        Context context = getContext();
        assert context != null;
        switch (mUriMather) {
            case IMAGE:
                cursor = database.query(CustomDB.IMAGE_TABLE_NAME, strings, s, strings1, null, null, s1);
                cursor.setNotificationUri(context.getContentResolver(), uri);
                return cursor;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase database = mCustomDB.getWritableDatabase();
        int mUriMather = uriMatcher.match(uri);
        Uri resultUri;
        Context context = getContext();
        assert context != null;
        switch (mUriMather) {
            case IMAGE:
                long insertImage = database.insert(CustomDB.IMAGE_TABLE_NAME, null, contentValues);
                resultUri = ContentUris.withAppendedId(uri,insertImage);
                context.getContentResolver().notifyChange(uri, null, false);
                return resultUri;
            default:
                return null;
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    private static class CustomDB extends SQLiteOpenHelper{

        private static final String DB_NAME = "AppA.db";
        private static final int DB_VERSION = 1;

        private static final String IMAGE_TABLE_NAME = "images";

        private static final String IMAGE_ID = "_id";
        private static final String IMAGE_LINK = "link";
        private static final String IMAGE_STATUS = "status";
        private static final String IMAGE_TIME = "time";

        private static final String SQL_CREATE_TABLE_IMAGE = "CREATE TABLE " + IMAGE_TABLE_NAME
                + " ("
                + IMAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + IMAGE_LINK + " TEXT,"
                + IMAGE_STATUS + " INTEGER,"
                + IMAGE_TIME + " DATE)";

        private static final String SQL_DROP_TABLE_IMAGE = "DROP TABLE " + IMAGE_TABLE_NAME;

        public CustomDB(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(SQL_CREATE_TABLE_IMAGE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(SQL_DROP_TABLE_IMAGE);
            onCreate(sqLiteDatabase);
        }
    }
}
