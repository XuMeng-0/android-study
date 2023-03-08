package pers.xumeng.androidstudy.ipc.content.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BookProviderDbHelper extends SQLiteOpenHelper {

  public static final String BOOK_TABLE_NAME = "book";
  public static final String USER_TABLE_NAME = "user";

  private static final String DB_NAME = "book_provider.db";
  private static final int DB_VERSION = 1;

  private static final String createBookTable = "CREATE TABLE IF NOT EXISTS " + BOOK_TABLE_NAME
      + "(_id INTEGER PRIMARY KEY, name TEXT)";
  private static final String createUserTable = "CREATE TABLE IF NOT EXISTS " + USER_TABLE_NAME
      + "(_id INTEGER PRIMARY KEY, name TEXT, sex INT)";


  public BookProviderDbHelper(@Nullable Context context) {
    super(context, DB_NAME, null, DB_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(createBookTable);
    db.execSQL(createUserTable);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }
}
