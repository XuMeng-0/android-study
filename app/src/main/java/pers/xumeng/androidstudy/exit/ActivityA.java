package pers.xumeng.androidstudy.exit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pers.xumeng.androidstudy.R;

public class ActivityA extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.exit_activity_a);

    Button startActivityBtn = findViewById(R.id.exit_btn_start_activity_b);
    startActivityBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(ActivityA.this, ActivityB.class));
      }
    });
  }
}
