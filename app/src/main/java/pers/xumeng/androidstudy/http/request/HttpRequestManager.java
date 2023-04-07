package pers.xumeng.androidstudy.http.request;

import com.google.gson.JsonObject;

import okhttp3.Callback;

public class HttpRequestManager {

  public static void login(String userName, String password, Callback callback) {
    final String url = "/user/login";
    JsonObject requestParam = new JsonObject();
    requestParam.addProperty("userName", userName);
    requestParam.addProperty("password", password);
    HttpRequest.post(url, requestParam.toString(), callback);
  }

}
