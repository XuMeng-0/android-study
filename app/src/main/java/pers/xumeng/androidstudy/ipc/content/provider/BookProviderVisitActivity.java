package pers.xumeng.androidstudy.ipc.content.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.IpcActivityBookProviderVisitBinding;
import pers.xumeng.androidstudy.ipc.aidl.Book;
import pers.xumeng.androidstudy.util.LogUtil;

public class BookProviderVisitActivity extends AppCompatActivity {

  private static final String TAG = BookProviderVisitActivity.class.getSimpleName();

  private IpcActivityBookProviderVisitBinding binding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("使用 ContentProvider 进行 IPC");
    }
    binding = DataBindingUtil.setContentView(this, R.layout.ipc_activity_book_provider_visit);
    binding.setListener(this);
    addBook();
  }

  private void addBook() {
    Uri bookUri = BookProvider.BOOK_CONTENT_URI;
    ContentValues contentValues = new ContentValues();
    contentValues.put("_id", 6);
    contentValues.put("name", "Android 开发艺术探索");
    getContentResolver().insert(bookUri, contentValues);
  }

  public void query() {
    ContentResolver resolver = getContentResolver();
    queryBook(resolver);
    queryUser(resolver);
  }

  private void queryBook(ContentResolver resolver) {
    Uri bookUri = BookProvider.BOOK_CONTENT_URI;
    String[] projection = new String[]{"_id", "name"};
    Cursor cursor = resolver.query(bookUri, projection, null, null, null);
    while (cursor.moveToNext()) {
      Book book = new Book(0, "");
      book.id = cursor.getInt(0);
      book.name = cursor.getString(1);
      LogUtil.e(TAG, "query book : " + book);
    }
    cursor.close();
  }

  private void queryUser(ContentResolver resolver) {
    Uri userUri = BookProvider.USER_CONTENT_URI;
    String[] projection = new String[]{"_id", "name", "sex"};
    Cursor cursor = resolver.query(userUri, projection, null, null, null);
    while (cursor.moveToNext()) {
      User user = new User();
      user.id = cursor.getInt(0);
      user.name = cursor.getString(1);
      user.isMale = cursor.getInt(2) == User.USER_SEX_MALE;
      LogUtil.e(TAG, "query user : " + user);
    }
    cursor.close();
  }

}
