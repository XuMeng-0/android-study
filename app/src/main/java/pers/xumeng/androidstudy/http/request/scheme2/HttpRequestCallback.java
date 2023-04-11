package pers.xumeng.androidstudy.http.request.scheme2;

import androidx.annotation.NonNull;

import pers.xumeng.androidstudy.http.request.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpRequestCallback<DATA> implements Callback<Result<DATA>> {

  public static final int HTTP_REQUEST_SUCCESS_CODE = 600;

  @Override
  public void onResponse(@NonNull Call<Result<DATA>> call, Response<Result<DATA>> response) {
    Result<DATA> result = response.body();
    if (result == null) {
      onFailure(call, new Exception("body is null"));
      return;
    }
    if (result.code != HTTP_REQUEST_SUCCESS_CODE) {
      onFailure(result.message);
      return;
    }
    onSuccess(result);
  }

  @Override
  public void onFailure(@NonNull Call<Result<DATA>> call, Throwable t) {
    onFailure(t.getMessage());
  }

  public void onSuccess(Result<DATA> result) {

  }

  public void onFailure(String message) {

  }

}
