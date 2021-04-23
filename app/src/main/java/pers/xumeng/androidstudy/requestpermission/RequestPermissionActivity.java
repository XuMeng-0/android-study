package pers.xumeng.androidstudy.requestpermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import pers.xumeng.androidstudy.R;

public class RequestPermissionActivity extends AppCompatActivity {

  private static final int REQUEST_CODE = 1;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.request_permission_activity_request_permission);
    Button requestPermissionBtn = findViewById(R.id.request_permission_btn_request_permission);
    requestPermissionBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (ContextCompat.checkSelfPermission(RequestPermissionActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
          // You can use the API that requires the permission.
          Toast.makeText(RequestPermissionActivity.this, "写入数据", Toast.LENGTH_LONG).show();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
          if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            // In an educational UI, explain to the user why your app requires this
            // permission for a specific feature to behave as expected. In this UI,
            // include a "cancel" or "no thanks" button that allows the user to
            // continue using your app without granting the permission.
            Toast.makeText(RequestPermissionActivity.this, "需要保存数据，请授予应用将数据写入外部存储的权限", Toast.LENGTH_LONG).show();
          } else {
            // You can directly ask for the permission.
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
          }
        }
      }
    });
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    switch (requestCode) {
      case REQUEST_CODE:
        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
          // Permission is granted. Continue the action or workflow
          // in your app.
          Toast.makeText(RequestPermissionActivity.this, "写入数据", Toast.LENGTH_LONG).show();
        } else {
          // Explain to the user that the feature is unavailable because
          // the features requires a permission that the user has denied.
          // At the same time, respect the user's decision. Don't link to
          // system settings in an effort to convince the user to change
          // their decision.
          Toast.makeText(RequestPermissionActivity.this, "由于您拒绝了写入外部存储的权限，保存数据的功能无法实现", Toast.LENGTH_LONG).show();
        }
        return;
    }
    // Other 'case' lines to check for other
    // permissions this app might request.
  }

}
