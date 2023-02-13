package pers.xumeng.androidstudy.ipc.messenger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.IpcActivityMessengerBinding;
import pers.xumeng.androidstudy.util.LogUtil;

public class MessengerActivity extends AppCompatActivity {

  private static final String TAG = MessengerActivity.class.getSimpleName();

  private IpcActivityMessengerBinding binding;

  private final ServiceConnection connection = new ServiceConnection() {

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
      Messenger serviceMessenger = new Messenger(service);
      Message msg = Message.obtain(null, MessengerConstants.MSG_FROM_CLIENT);
      Bundle data = new Bundle();
      data.putString(MessengerConstants.MSG_NAME_MSG, "Hello, this is client");
      msg.setData(data);
      msg.replyTo = receiveMessenger;
      try {
        serviceMessenger.send(msg);
      } catch (RemoteException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

  };


  private final Messenger receiveMessenger = new Messenger(new MessengerHandler());

  private static class MessengerHandler extends Handler {

    @Override
    public void handleMessage(@NonNull Message msg) {
      if (msg.what == MessengerConstants.MSG_FROM_SERVICE) {
        String message = msg.getData().getString(MessengerConstants.MSG_NAME_REPLY);
        LogUtil.e(TAG, "receive message from service : " + message);
      } else {
        super.handleMessage(msg);
      }
    }

  }


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("使用 Messenger 进行 IPC");
    }
    binding = DataBindingUtil.setContentView(this, R.layout.ipc_activity_messenger);
    Intent intent = new Intent(this, MessengerService.class);
    bindService(intent, connection, Context.BIND_AUTO_CREATE);
  }

  @Override
  protected void onDestroy() {
    unbindService(connection);
    super.onDestroy();
  }

}
