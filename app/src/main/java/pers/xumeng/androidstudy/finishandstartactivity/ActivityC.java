package pers.xumeng.androidstudy.finishandstartactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.util.LogUtil;

public class ActivityC extends AppCompatActivity {

  private static final String CLASS_NAME = ActivityC.class.getSimpleName();

  private Button btnFinish;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LogUtil.e(CLASS_NAME, "===== onCreate =====");
    setContentView(R.layout.finish_start_activity_c);
    btnFinish = findViewById(R.id.finish_start_btn_finish);
    btnFinish.setOnClickListener(listener);
  }

  @Override
  protected void onStart() {
    super.onStart();
    LogUtil.e(CLASS_NAME, "===== onStart =====");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    LogUtil.e(CLASS_NAME, "===== onRestart =====");
  }

  @Override
  protected void onResume() {
    super.onResume();
    LogUtil.e(CLASS_NAME, "===== onResume =====");
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

  private View.OnClickListener listener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      finish();
    }
  };

}
