package pers.xumeng.androidstudy.ipc.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;

import androidx.annotation.Nullable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookManagerService extends Service {

  private static final String TAG = BookManagerService.class.getSimpleName();

  private final CopyOnWriteArrayList<Book> bookList = new CopyOnWriteArrayList<>();
  private final Binder binder = new IBookManager.Stub() {
    @Override
    public List<Book> getBookList() throws RemoteException {
      SystemClock.sleep(5000);
      return bookList;
    }

    @Override
    public void addBook(Book book) throws RemoteException {
      bookList.add(book);
    }
  };

  @Override
  public void onCreate() {
    super.onCreate();
    bookList.add(new Book(1, "Android"));
    bookList.add(new Book(2, "iOS"));
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return binder;
  }

}
