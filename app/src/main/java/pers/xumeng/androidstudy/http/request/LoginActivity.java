package pers.xumeng.androidstudy.http.request;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.HttpActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

  private HttpActivityLoginBinding binding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("HTTP 通信方式");
    }
    binding = DataBindingUtil.setContentView(this, R.layout.http_activity_login);
  }


}
