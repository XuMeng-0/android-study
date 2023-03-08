package pers.xumeng.androidstudy.ipc.content.provider;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.IpcActivityBookProviderVisitBinding;

public class BookProviderVisitActivity extends AppCompatActivity {

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
  }

  public void query() {
    Uri uri = Uri.parse("content://pers.xumeng.androidstudy.book.provider");
    getContentResolver().query(uri, null, null, null, null);
  }

}
