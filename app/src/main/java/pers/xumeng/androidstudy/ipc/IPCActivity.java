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
import pers.xumeng.androidstudy.ipc.messenger.MessengerActivity;

public class IPCActivity extends AppCompatActivity {

  private IpcActivityIpcBinding binding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("IPC 方式");
    }
    binding = DataBindingUtil.setContentView(this, R.layout.ipc_activity_ipc);
    binding.setListener(this);
  }

  public void startMessengerActivity() {
    startActivity(new Intent(this, MessengerActivity.class));
  }

  public void startBookManagerActivity() {
    startActivity(new Intent(this, BookManagerActivity.class));
  }

}
