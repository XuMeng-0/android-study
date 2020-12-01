package pers.xumeng.androidstudy.finishandstartactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pers.xumeng.androidstudy.R;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

}