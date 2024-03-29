package pers.xumeng.androidstudy.ipc;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.IpcActivityIpcBinding;
import pers.xumeng.androidstudy.ipc.aidl.BookManagerActivity;
import pers.xumeng.androidstudy.ipc.content.provider.BookProviderVisitActivity;
import pers.xumeng.androidstudy.ipc.messenger.MessengerActivity;
import pers.xumeng.androidstudy.ipc.socket.TCPClientActivity;

public class IPCActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("IPC 方式");
    }
    IpcActivityIpcBinding binding = DataBindingUtil.setContentView(this, R.layout.ipc_activity_ipc);
    binding.setListener(this);
  }

  public void startMessengerActivity() {
    startActivity(new Intent(this, MessengerActivity.class));
  }

  public void startBookManagerActivity() {
    startActivity(new Intent(this, BookManagerActivity.class));
  }

  public void startBookProviderVisitActivity() {
    startActivity(new Intent(this, BookProviderVisitActivity.class));
  }

  public void startTCPClientActivity() {
    startActivity(new Intent(this, TCPClientActivity.class));
  }

}
