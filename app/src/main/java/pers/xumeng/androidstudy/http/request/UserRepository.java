package pers.xumeng.androidstudy.http.request;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class UserRepository {

  private final MutableLiveData<String> message;

  public UserRepository(MutableLiveData<String> message) {
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
        UserRepository.this.message.postValue(message);
      }
    });
  }

}
