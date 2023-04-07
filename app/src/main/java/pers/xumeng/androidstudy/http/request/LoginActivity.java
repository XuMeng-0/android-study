package pers.xumeng.androidstudy.http.request;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.HttpActivityLoginBinding;
import pers.xumeng.androidstudy.util.LogUtil;

public class LoginActivity extends AppCompatActivity {

  private static final String TAG = LoginActivity.class.getSimpleName();

  private HttpActivityLoginBinding binding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("HTTP 通信方式");
    }
    binding = DataBindingUtil.setContentView(this, R.layout.http_activity_login);
    binding.setListener(this);
  }


  public void login() {
    String userName = binding.userLoginEtAccount.getText().toString();
    String password = binding.userLoginEtPassword.getText().toString();

    if (userName.isEmpty() || password.isEmpty()) {
      Toast.makeText(this, "请填写账号或密码", Toast.LENGTH_SHORT).show();
      return;
    }

    HttpRequestManager.login(userName, password, new HttpRequestCallback<String>() {
      @Override
      public void onSuccess(@NonNull Result<String> result) {
        LogUtil.i(TAG, "result : " + result);
      }

      @Override
      public void onFailure(String message) {
        LogUtil.i(TAG, "message : " + message);
      }
    });
  }

}
