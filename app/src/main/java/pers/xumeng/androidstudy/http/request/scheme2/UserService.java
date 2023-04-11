package pers.xumeng.androidstudy.http.request.scheme2;

import pers.xumeng.androidstudy.http.request.LoginParam;
import pers.xumeng.androidstudy.http.request.Result;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

  @POST("user/login")
  Call<Result<String>> login(@Body LoginParam loginParam);

}
