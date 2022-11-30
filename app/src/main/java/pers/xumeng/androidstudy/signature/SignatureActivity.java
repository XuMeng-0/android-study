package pers.xumeng.androidstudy.signature;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.SignatureActivitySignatureBinding;
import pers.xumeng.androidstudy.util.LogUtil;

public class SignatureActivity extends AppCompatActivity {

  private static final String TAG = SignatureActivity.class.getSimpleName();
  private SignatureActivitySignatureBinding binding;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("签名控件的使用");
    }
    binding = DataBindingUtil.setContentView(this, R.layout.signature_activity_signature);
    binding.setListener(this);
  }


  public void attemptSaveSignature() {
    verifyStoragePermission();
  }

  private void saveSignature() {
    Bitmap signatureBitmap = binding.signatureSSignature.getSignatureBitmap();
    if (addJpgSignatureToGallery(signatureBitmap)) {
      Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
      clearSignature();
    } else {
      Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
    }
  }

  private boolean addJpgSignatureToGallery(Bitmap signature) {
    boolean result = false;
    try {
      String fileName = String.format(Locale.CHINA, "Signature_%d.jpg", System.currentTimeMillis());
      File photo = new File(createAlbumStorageDirectory(), fileName);
      saveBitmapToJPG(signature, photo);
      scanMediaFile(photo);
      result = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  private File createAlbumStorageDirectory() {
    // Get the directory for the user's public pictures directory.
    File parentDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    File directory = new File(parentDirectory, "Signature");
    boolean successful = directory.mkdirs();
    if (!successful) {
      LogUtil.e(TAG, "Directory not created");
    }
    return directory;
  }

  private void saveBitmapToJPG(Bitmap bitmap, File photo) throws IOException {
    Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(newBitmap);
    canvas.drawColor(Color.WHITE);
    canvas.drawBitmap(bitmap, 0, 0, null);
    OutputStream stream = new FileOutputStream(photo);
    newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
    stream.close();
  }

  private void scanMediaFile(File photo) {
    Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
    Uri contentUri = Uri.fromFile(photo);
    mediaScanIntent.setData(contentUri);
    sendBroadcast(mediaScanIntent);
  }

  public void clearSignature() {
    binding.signatureSSignature.clear();
  }

  private static final int REQUEST_EXTERNAL_STORAGE = 1;

  private void verifyStoragePermission() {
    // Check if we have write permission
    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

    String[] PERMISSIONS_STORAGE = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    if (permission != PackageManager.PERMISSION_GRANTED) {
      // We don't have permission so prompt the user
      ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
    } else {
      saveSignature();
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == REQUEST_EXTERNAL_STORAGE) {
      // If request is cancelled, the result arrays are empty.
      if (grantResults.length <= 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
        Toast.makeText(this, "无法将图片保存到手机", Toast.LENGTH_SHORT).show();
      } else {
        saveSignature();
      }
    }
  }
}
