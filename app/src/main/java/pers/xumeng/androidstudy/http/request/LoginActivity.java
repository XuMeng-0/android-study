package pers.xumeng.androidstudy.http.request;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.gson.JsonObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
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

    JsonObject requestParam = new JsonObject();
    requestParam.addProperty("userName", userName);
    requestParam.addProperty("password", password);

    final OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build();
    final MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
    final RequestBody requestBody = RequestBody.create(requestParam.toString(), mediaType);
    final Request request = new Request.Builder()
        .url("http://192.168.43.218:8080/user/login")
        .post(requestBody)
        .build();
    client.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(@NonNull Call call, @NonNull IOException e) {
        LogUtil.e(TAG, e.getMessage());
      }

      @Override
      public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
        ResponseBody responseBody = response.body();
        if (responseBody != null) {
          String responseString = responseBody.string();
          LogUtil.i(TAG, "response body : " + responseString);
        }
      }
    });
  }

}
