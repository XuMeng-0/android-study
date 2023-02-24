package pers.xumeng.androidstudy.ipc.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.util.List;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.IpcActivityBookManagerBinding;
import pers.xumeng.androidstudy.util.LogUtil;

public class BookManagerActivity extends AppCompatActivity {

  private static final String TAG = BookManagerActivity.class.getSimpleName();
  private IpcActivityBookManagerBinding binding;

  private ServiceConnection connection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
      IBookManager bookManager = IBookManager.Stub.asInterface(service);
      try {
        List<Book> bookList = bookManager.getBookList();
        LogUtil.e(TAG, "list type : " + bookList.getClass().getCanonicalName());
        LogUtil.e(TAG, "book list : " + bookList);

        Book newBook = new Book(3, "Android 开发艺术探索");
        bookManager.addBook(newBook);
        LogUtil.e(TAG, "add book : " + newBook);

        bookList = bookManager.getBookList();
        LogUtil.e(TAG, "book list : " + bookList);
      } catch (RemoteException e) {
        e.printStackTrace();
      }

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
  };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("使用 AIDL 进行 IPC");
    }
    binding = DataBindingUtil.setContentView(this, R.layout.ipc_activity_book_manager);
    Intent intent = new Intent(this, BookManagerService.class);
    bindService(intent, connection, Context.BIND_AUTO_CREATE);
  }

  @Override
  protected void onDestroy() {
    unbindService(connection);
    super.onDestroy();
  }

}
