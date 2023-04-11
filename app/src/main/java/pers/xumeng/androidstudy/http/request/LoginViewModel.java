package pers.xumeng.androidstudy.http.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import pers.xumeng.androidstudy.http.request.scheme1.UserRepository1;
import pers.xumeng.androidstudy.http.request.scheme2.UserRepository2;

public class LoginViewModel extends ViewModel {

  private final MutableLiveData<Result<String>> loginResult = new MutableLiveData<>();
  private final MutableLiveData<String> message = new MutableLiveData<>();
  private final UserRepository1 repository1 = new UserRepository1(message);
  private final UserRepository2 repository2 = new UserRepository2(message);


  public LiveData<Result<String>> getLoginResult() {
    return loginResult;
  }

  public LiveData<String> getMessage() {
    return message;
  }

  public void login1(String userName, String password) {
    if (userName.isEmpty() || password.isEmpty()) {
      message.setValue("请填写账号或密码");
      return;
    }

    repository1.login(userName, password, loginResult);
  }

  public void login2(String userName, String password) {
    if (userName.isEmpty() || password.isEmpty()) {
      message.setValue("请填写账号或密码");
      return;
    }

    repository2.login(userName, password, loginResult);
  }

}
