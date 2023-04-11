package pers.xumeng.androidstudy.http.request.scheme2;

import androidx.lifecycle.MutableLiveData;

import pers.xumeng.androidstudy.http.request.LoginParam;
import pers.xumeng.androidstudy.http.request.Result;

public class UserRepository2 {

  private final MutableLiveData<String> message;
  private final UserService userService = GlobalRetrofit.retrofit.create(UserService.class);


  public UserRepository2(MutableLiveData<String> message) {
    this.message = message;
  }


  public void login(String userName, String password, MutableLiveData<Result<String>> loginResult) {
    userService.login(new LoginParam(userName, password)).enqueue(new HttpRequestCallback<String>() {
      @Override
      public void onSuccess(Result<String> result) {
        loginResult.setValue(result);
      }

      @Override
      public void onFailure(String message) {
        UserRepository2.this.message.setValue(message);
      }
    });
  }

}
