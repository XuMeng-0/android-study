package pers.xumeng.androidstudy.http.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import pers.xumeng.androidstudy.http.request.scheme1.UserRepository;

public class LoginViewModel extends ViewModel {

  private final MutableLiveData<Result<String>> loginResult = new MutableLiveData<>();
  private final MutableLiveData<String> message = new MutableLiveData<>();
  private final UserRepository repository = new UserRepository(message);


  public LiveData<Result<String>> getLoginResult() {
    return loginResult;
  }

  public LiveData<String> getMessage() {
    return message;
  }

  public void login(String userName, String password) {
    if (userName.isEmpty() || password.isEmpty()) {
      message.setValue("请填写账号或密码");
      return;
    }

    repository.login(userName, password, loginResult);
  }

}
