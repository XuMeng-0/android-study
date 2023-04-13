package pers.xumeng.androidstudy.http.request.scheme3;

import io.reactivex.rxjava3.core.Single;
import pers.xumeng.androidstudy.http.request.LoginParam;
import pers.xumeng.androidstudy.http.request.Result;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

  @POST("user/login")
  Single<Result<String>> login(@Body LoginParam loginParam);

}
