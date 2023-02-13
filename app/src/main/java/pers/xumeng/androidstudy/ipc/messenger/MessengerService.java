package pers.xumeng.androidstudy.ipc.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import pers.xumeng.androidstudy.util.LogUtil;

public class MessengerService extends Service {

  private static final String TAG = MessengerService.class.getSimpleName();

  private static class MessengerHandler extends Handler {

    @Override
    public void handleMessage(@NonNull Message msg) {
      if (msg.what == MessengerConstants.MSG_FROM_CLIENT) {
        String message = msg.getData().getString(MessengerConstants.MSG_NAME_MSG);
        LogUtil.e(TAG, "receive message from client : " + message);

        Messenger client = msg.replyTo;
        Message replyMessage = Message.obtain(null, MessengerConstants.MSG_FROM_SERVICE);
        Bundle data = new Bundle();
        data.putString(MessengerConstants.MSG_NAME_REPLY, "Hello, this is service");
        replyMessage.setData(data);
        try {
          client.send(replyMessage);
        } catch (RemoteException e) {
          e.printStackTrace();
        }
      } else {
        super.handleMessage(msg);
      }
    }

  }

  private final Messenger messenger = new Messenger(new MessengerHandler());

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return messenger.getBinder();
  }

}
