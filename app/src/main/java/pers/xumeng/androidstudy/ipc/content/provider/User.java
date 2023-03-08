package pers.xumeng.androidstudy.ipc.content.provider;

import androidx.annotation.NonNull;

public class User {

  public static final int USER_SEX_MALE = 1;

  public int id;
  public String name;
  public boolean isMale;

  @NonNull
  @Override
  public String toString() {
    return "User { id = " + id + ", name= " + name + ", isMale = " + isMale + "}";
  }

}
