package pers.xumeng.androidstudy.http.request.scheme3;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import pers.xumeng.androidstudy.http.request.Result;

public class HttpRequestObserver<DATA> implements SingleObserver<Result<DATA>> {

  public static final int HTTP_REQUEST_SUCCESS_CODE = 600;

  @Override
  public void onSubscribe(@NonNull Disposable d) {

  }

  @Override
  public void onSuccess(@NonNull Result<DATA> result) {
    if (result.code != HTTP_REQUEST_SUCCESS_CODE) {
      onRequestFailure(result.message);
      return;
    }
    onRequestSuccess(result);
  }

  @Override
  public void onError(@NonNull Throwable e) {
    onRequestFailure(e.getMessage());
  }

  public void onRequestFailure(String message) {

  }

  public void onRequestSuccess(Result<DATA> result) {

  }

}
