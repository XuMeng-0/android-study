package pers.xumeng.androidstudy.ipc.content.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import pers.xumeng.androidstudy.util.LogUtil;

public class BookProvider extends ContentProvider {

  public static final String AUTHORITY = "pers.xumeng.androidstudy.book.provider";
  public static final Uri BOOK_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/book");
  public static final Uri USER_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/user");
  public static final int BOOK_URI_CODE = 0;
  public static final int USER_URI_CODE = 1;

  private static final String TAG = BookProvider.class.getSimpleName();

  private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

  static {
    uriMatcher.addURI(AUTHORITY, "book", BOOK_URI_CODE);
    uriMatcher.addURI(AUTHORITY, "user", USER_URI_CODE);
  }

  private Context context;
  private SQLiteDatabase database;

  @Override
  public boolean onCreate() {
    LogUtil.e(TAG, "onCreate, current thread : " + Thread.currentThread().getName());
    context = getContext();
    // 在实际项目中，不应该在主线程做耗时的数据库操作
    initProviderData();
    return false;
  }

  private void initProviderData() {
    database = new BookProviderDbHelper(context).getWritableDatabase();
    database.execSQL("delete from " + BookProviderDbHelper.BOOK_TABLE_NAME);
    database.execSQL("delete from " + BookProviderDbHelper.USER_TABLE_NAME);

    database.execSQL("insert into " + BookProviderDbHelper.BOOK_TABLE_NAME + " values(3,'Android')");
    database.execSQL("insert into " + BookProviderDbHelper.BOOK_TABLE_NAME + " values(4,'iOS')");
    database.execSQL("insert into " + BookProviderDbHelper.BOOK_TABLE_NAME + " values(5,'HTML5')");

    database.execSQL("insert into " + BookProviderDbHelper.USER_TABLE_NAME + " values(1,'zhangsan',1)");
    database.execSQL("insert into " + BookProviderDbHelper.USER_TABLE_NAME + " values(2,'lisi',0)");
  }

  @Nullable
  @Override
  public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
    LogUtil.e(TAG, "query, current thread : " + Thread.currentThread().getName());
    String table = getTableName(uri);
    if (table == null) {
      throw new IllegalArgumentException("Unsupported URI : " + uri);
    }
    return database.query(table, projection, selection, selectionArgs, null, null, sortOrder, null);
  }

  @Nullable
  @Override
  public String getType(@NonNull Uri uri) {
    LogUtil.e(TAG, "getType, current thread : " + Thread.currentThread().getName());
    return null;
  }

  @Nullable
  @Override
  public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
    LogUtil.e(TAG, "insert, current thread : " + Thread.currentThread().getName());
    String table = getTableName(uri);
    if (table == null) {
      throw new IllegalArgumentException("Unsupported URI : " + uri);
    }
    database.insert(table, null, values);
    context.getContentResolver().notifyChange(uri, null);
    return uri;
  }

  @Override
  public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
    String table = getTableName(uri);
    if (table == null) {
      throw new IllegalArgumentException("Unsupported URI : " + uri);
    }
    int count = database.delete(table, selection, selectionArgs);
    if (count > 0) {
      context.getContentResolver().notifyChange(uri, null);
    }
    return count;
  }

  @Override
  public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
    String table = getTableName(uri);
    if (table == null) {
      throw new IllegalArgumentException("Unsupported URI : " + uri);
    }
    int row = database.update(table, values, selection, selectionArgs);
    if (row > 0) {
      context.getContentResolver().notifyChange(uri, null);
    }
    return row;
  }

  private String getTableName(Uri uri) {
    String tableName = null;
    switch (uriMatcher.match(uri)) {
      case BOOK_URI_CODE: {
        tableName = BookProviderDbHelper.BOOK_TABLE_NAME;
        break;
      }
      case USER_URI_CODE: {
        tableName = BookProviderDbHelper.USER_TABLE_NAME;
        break;
      }
      default:
        break;
    }
    return tableName;
  }

}
