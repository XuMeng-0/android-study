package pers.xumeng.androidstudy.finishandstartactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.util.LogUtil;

public class ActivityA extends AppCompatActivity {

  private static final String CLASS_NAME = ActivityA.class.getSimpleName();


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LogUtil.e(CLASS_NAME, "==== onCreate =====");
    setContentView(R.layout.finish_start_activity_a);

    Button btnFinishFirst = findViewById(R.id.finish_start_btn_finish_first);
    btnFinishFirst.setOnClickListener(listener);
    Button btnFinishLast = findViewById(R.id.finish_start_btn_finish_last);
    btnFinishLast.setOnClickListener(listener);
    Button btnDelayFinishFirst = findViewById(R.id.finish_start_btn_delay_finish_first);
    btnDelayFinishFirst.setOnClickListener(listener);
    Button btnDelayFinishLast = findViewById(R.id.finish_start_btn_delay_finish_last);
    btnDelayFinishLast.setOnClickListener(listener);
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

  private void executeTimeConsumingTask() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private View.OnClickListener listener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      switch (view.getId()) {
        case R.id.finish_start_btn_finish_first: {
          finish();
          startActivity(new Intent(ActivityA.this, ActivityB.class));
        }
        break;
        case R.id.finish_start_btn_finish_last: {
          startActivity(new Intent(ActivityA.this, ActivityB.class));
          finish();
        }
        break;
        case R.id.finish_start_btn_delay_finish_first: {
          finish();
          executeTimeConsumingTask();
          startActivity(new Intent(ActivityA.this, ActivityB.class));
        }
        break;
        case R.id.finish_start_btn_delay_finish_last: {
          startActivity(new Intent(ActivityA.this, ActivityB.class));
          executeTimeConsumingTask();
          finish();
        }
        break;
        default: {

        }
      }
    }
  };

}