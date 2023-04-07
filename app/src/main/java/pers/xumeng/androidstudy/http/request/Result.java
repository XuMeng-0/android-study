package pers.xumeng.androidstudy.http.request;

public class Result<DATA> {

  public int code;
  public String message;
  public DATA data;

  @Override
  public String toString() {
    return "Result{" +
        "code=" + code +
        ", message='" + message + '\'' +
        ", data=" + data +
        '}';
  }

}
