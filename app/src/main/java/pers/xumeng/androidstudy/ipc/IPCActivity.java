package pers.xumeng.androidstudy.ipc;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.IpcActivityIpcBinding;

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
    Toast.makeText(this, "使用 Messenger 进行 IPC", Toast.LENGTH_SHORT).show();
  }

}
