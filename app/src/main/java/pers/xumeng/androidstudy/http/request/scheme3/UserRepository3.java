package pers.xumeng.androidstudy.http.request.scheme3;

import androidx.lifecycle.MutableLiveData;

import pers.xumeng.androidstudy.http.request.Result;

public class UserRepository3 {

  private final MutableLiveData<String> message;

  public UserRepository3(MutableLiveData<String> message) {
    this.message = message;
  }

  public void login(String userName, String password, MutableLiveData<Result<String>> loginResult) {
    message.setValue("此功能尚未完成");
  }

}
