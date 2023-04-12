package pers.xumeng.androidstudy.http.request.scheme1;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import pers.xumeng.androidstudy.http.request.Result;

public class UserRepository1 {

  private final MutableLiveData<String> message;

  public UserRepository1(MutableLiveData<String> message) {
    this.message = message;
  }

  public void login(String userName, String password, MutableLiveData<Result<String>> loginResult) {
    HttpRequestManager.login(userName, password, new HttpRequestCallback<String>() {
      @Override
      public void onSuccess(@NonNull Result<String> result) {
        loginResult.postValue(result);
      }

      @Override
      public void onFailure(String message) {
        UserRepository1.this.message.postValue(message);
      }
    });
  }

}
