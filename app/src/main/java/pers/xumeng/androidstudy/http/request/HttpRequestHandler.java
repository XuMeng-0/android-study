package pers.xumeng.androidstudy.http.request;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

public class HttpRequestHandler<ACTIVITY extends Activity> extends Handler {

  private final WeakReference<ACTIVITY> reference;

  public HttpRequestHandler(ACTIVITY activity) {
    super(Looper.getMainLooper());
    reference = new WeakReference<>(activity);
  }

  @Override
  public void handleMessage(@NonNull Message msg) {
    super.handleMessage(msg);
    ACTIVITY activity = reference.get();
    if (activity == null) {
      return;
    }
    handleMessage(activity, msg);
  }

  public void handleMessage(ACTIVITY activity, Message msg) {

  }

  public void sendMessage(int what, String message) {
    Message handlerMessage = Message.obtain();
    handlerMessage.what = what;
    handlerMessage.obj = message;
    sendMessage(handlerMessage);
  }

  public <DATA> void sendMessage(int what, Result<DATA> result) {
    Message message = Message.obtain();
    message.what = what;
    message.obj = result;
    sendMessage(message);
  }

}
