package pers.xumeng.androidstudy.ipc.content.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import pers.xumeng.androidstudy.util.LogUtil;

public class BookProvider extends ContentProvider {

  private static final String TAG = BookProvider.class.getSimpleName();

  @Override
  public boolean onCreate() {
    LogUtil.e(TAG, "onCreate, current thread : " + Thread.currentThread().getName());
    return false;
  }

  @Nullable
  @Override
  public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
    LogUtil.e(TAG, "query, current thread : " + Thread.currentThread().getName());
    return null;
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
    return null;
  }

  @Override
  public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
    return 0;
  }

  @Override
  public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
    return 0;
  }
}
