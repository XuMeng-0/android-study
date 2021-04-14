package pers.xumeng.androidstudy.statusrestore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.util.ActivityCodeUtil;
import pers.xumeng.androidstudy.util.BaseActivity;

public class ActivityA extends BaseActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.setActivityCode(ActivityCodeUtil.STATUS_RESTORE_ACTIVITY_A);
    setContentView(R.layout.status_restore_activity_a);
    Button startActivityBtn = findViewById(R.id.status_restore_btn_start_activity_b);
    startActivityBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(ActivityA.this, ActivityB.class));
      }
    });
    restoreActivity();
  }

  private void restoreActivity() {
    SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
    int activityCode = sharedPreferences.getInt("activityCode", 0);
    if (activityCode == 0) {
      return;
    }
    if (activityCode == 33) {
      startActivity(new Intent(this, ActivityC.class));
    }
  }
}
