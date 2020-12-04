package pers.xumeng.androidstudy.finishandstartactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.util.LogUtil;

public class ActivityA extends AppCompatActivity {

  private static final String CLASS_NAME = ActivityA.class.getSimpleName();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LogUtil.e(CLASS_NAME, "==== onCreate =====");
    setContentView(R.layout.finish_start_activity_a);
    Button btnStartActivityB = findViewById(R.id.finish_start_btn_start_b);
    btnStartActivityB.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(ActivityA.this, ActivityB.class));
      }
    });
  }

  @Override
  protected void onStart() {
    super.onStart();
    LogUtil.e(CLASS_NAME, "==== onStart =====");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    LogUtil.e(CLASS_NAME, "==== onRestart =====");
  }

  @Override
  protected void onResume() {
    super.onResume();
    LogUtil.e(CLASS_NAME, "==== onResume =====");
  }

  @Override
  protected void onPause() {
    super.onPause();
    LogUtil.e(CLASS_NAME, "===== onPause =====");
  }

  @Override
  protected void onStop() {
    super.onStop();
    LogUtil.e(CLASS_NAME, "===== onStop =====");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    LogUtil.e(CLASS_NAME, "===== onDestroy =====");
  }
}
