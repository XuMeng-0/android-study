package pers.xumeng.androidstudy.ipc.messenger;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.IpcActivityMessengerBinding;

public class MessengerActivity extends AppCompatActivity {

  private IpcActivityMessengerBinding binding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("使用 Messenger 进行 IPC");
    }
    binding = DataBindingUtil.setContentView(this, R.layout.ipc_activity_messenger);
  }

}
