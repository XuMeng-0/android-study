package pers.xumeng.androidstudy.http.request;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.HttpActivityLoginBinding;
import pers.xumeng.androidstudy.util.LogUtil;

public class LoginActivity extends AppCompatActivity {

  private static final String TAG = LoginActivity.class.getSimpleName();
  private LoginViewModel viewModel;
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
    viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    subscribeToModel();
  }

  private void subscribeToModel() {
    viewModel.getLoginResult().observe(this, this::handleLoginSuccess);
    viewModel.getMessage().observe(this, this::toastMessage);
  }


  private void toastMessage(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  private void handleLoginSuccess(Result<String> result) {
    toastMessage(result.message);
    LogUtil.i(TAG, "token : " + result.data);
    // save token
    // start main activity
  }


  public void login1() {
    String userName = binding.userLoginEtAccount.getText().toString();
    String password = binding.userLoginEtPassword.getText().toString();

    viewModel.login1(userName, password);
  }

  public void login2() {
    String userName = binding.userLoginEtAccount.getText().toString();
    String password = binding.userLoginEtPassword.getText().toString();

    viewModel.login2(userName, password);
  }

}
