package pers.xumeng.androidstudy.util;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

  private int activityCode;
  private boolean isEnableStatusRestore = false;

  @Override
  protected void onStop() {
    super.onStop();
    SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    if (isEnableStatusRestore) {
      editor.putInt("activityCode", activityCode);
    } else {
      int invalidActivityCode = 0;
      editor.putInt("activityCode", invalidActivityCode);
    }
    editor.apply();
  }

  public int getActivityCode() {
    return activityCode;
  }

  public void setActivityCode(int activityCode) {
    this.activityCode = activityCode;
  }

  public void enableStatusRestore() {
    this.isEnableStatusRestore = true;
  }

  public void disableStatusRestore() {
    this.isEnableStatusRestore = false;
  }
}
