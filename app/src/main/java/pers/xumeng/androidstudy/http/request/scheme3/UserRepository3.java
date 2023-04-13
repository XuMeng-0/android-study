package pers.xumeng.androidstudy.http.request.scheme3;

import androidx.lifecycle.MutableLiveData;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import pers.xumeng.androidstudy.http.request.LoginParam;
import pers.xumeng.androidstudy.http.request.Result;

public class UserRepository3 {

  private final MutableLiveData<String> message;
  private final UserService userService = GlobalRetrofit.retrofit.create(UserService.class);

  public UserRepository3(MutableLiveData<String> message) {
    this.message = message;
  }

  public void login(String userName, String password, MutableLiveData<Result<String>> loginResult) {
    userService.login(new LoginParam(userName, password))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new HttpRequestObserver<String>() {
          @Override
          public void onRequestSuccess(Result<String> result) {
            loginResult.setValue(result);
          }

          @Override
          public void onRequestFailure(String message) {
            UserRepository3.this.message.setValue(message);
          }
        });
  }

}
