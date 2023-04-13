package pers.xumeng.androidstudy.http.request.scheme3;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GlobalRetrofit {

  private static final OkHttpClient client = new OkHttpClient.Builder()
      .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
      .build();

  public static final Retrofit retrofit = new Retrofit.Builder()
      .baseUrl("http://192.168.43.218:8080/")
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
      .client(client)
      .build();
}
