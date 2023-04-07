package pers.xumeng.androidstudy.http.request;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

public class HttpRequest {

  private static final String BASE_URL = "http://192.168.43.218:8080";
  private static final OkHttpClient client = new OkHttpClient.Builder()
      .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
      .build();

  private static final MediaType mediaTypeJson = MediaType.parse("application/json; charset=utf-8");

  public static void post(String url, String requestParam, Callback callback) {
    final Request request = new Request.Builder()
        .url(BASE_URL + url)
        .post(RequestBody.create(requestParam, mediaTypeJson))
        .build();
    client.newCall(request).enqueue(callback);
  }

}
