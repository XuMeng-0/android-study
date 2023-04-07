package pers.xumeng.androidstudy.http.request;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

public abstract class HttpRequestCallback<DATA> implements Callback {

  public static final int HTTP_REQUEST_SUCCESS_CODE = 600;

  @Override
  public void onFailure(@NonNull Call call, @NonNull IOException e) {
    onFailure(e.getMessage());
  }

  @Override
  public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
    ResponseBody body = response.body();
    if (body == null) {
      onFailure(call, new IOException("body is null"));
      return;
    }
    Gson gson = new Gson();
    Result<DATA> result = gson.fromJson(body.string(), new TypeToken<Result<DATA>>() {
    }.getType());
    if (result.code != HTTP_REQUEST_SUCCESS_CODE) {
      onFailure(result.message);
      return;
    }
    onSuccess(result);
  }

  public void onSuccess(@NonNull Result<DATA> result) {

  }

  public void onFailure(String message) {

  }

}
