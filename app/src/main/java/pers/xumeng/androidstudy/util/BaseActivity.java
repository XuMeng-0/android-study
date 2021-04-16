package pers.xumeng.androidstudy.util;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

  private int activityCode;

  @Override
  protected void onStop() {
    super.onStop();
    SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt("activityCode", activityCode);
    editor.apply();
  }

  public int getActivityCode() {
    return activityCode;
  }

  public void setActivityCode(int activityCode) {
    this.activityCode = activityCode;
  }
}
