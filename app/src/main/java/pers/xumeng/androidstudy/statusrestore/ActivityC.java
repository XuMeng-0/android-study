package pers.xumeng.androidstudy.statusrestore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.util.ActivityCodeUtil;
import pers.xumeng.androidstudy.util.BaseActivity;

public class ActivityC extends BaseActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.setActivityCode(ActivityCodeUtil.STATUS_RESTORE_ACTIVITY_C);
    super.enableStatusRestore();
    setContentView(R.layout.status_restore_activity_c);
    Button startActivityBtn = findViewById(R.id.status_restore_btn_start_activity_a);
    startActivityBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(ActivityC.this, ActivityA.class));
      }
    });
  }
}
