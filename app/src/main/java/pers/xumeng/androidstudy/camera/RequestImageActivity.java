package pers.xumeng.androidstudy.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.util.LogUtil;

public class RequestImageActivity extends AppCompatActivity {

  private static final int REQUEST_IMAGE_CAPTURE = 1;
  private static final int REQUEST_TAKE_PHOTO = 2;
  private static final int REQUEST_TAKE_PHOTO_ADD_TO_GALLERY = 3;
  private static final String CLASS_NAME = RequestImageActivity.class.getSimpleName();

  private ImageView imageView;
  private String currentPhotoPath;

  private View.OnClickListener listener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      if (view.getId() == R.id.camera_btn_start_activity_return_image) {
        takePictureReturnThumbnailImage();
      }
      if (view.getId() == R.id.camera_btn_start_activity_save_to_file) {
        takePictureSaveToFile();
      }
      if (view.getId() == R.id.camera_btn_start_activity_add_to_gallery) {
        takePictureAddToGallery();
      }
    }
  };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.camera_activity_request_image);
    imageView = findViewById(R.id.camera_iv_show_image);
    Button returnImageBtn = findViewById(R.id.camera_btn_start_activity_return_image);
    returnImageBtn.setOnClickListener(listener);
    Button saveToFileBtn = findViewById(R.id.camera_btn_start_activity_save_to_file);
    saveToFileBtn.setOnClickListener(listener);
    Button addToGalleryBtn = findViewById(R.id.camera_btn_start_activity_add_to_gallery);
    addToGalleryBtn.setOnClickListener(listener);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
      Bundle extras = data.getExtras();
      if (extras == null) {
        LogUtil.e(CLASS_NAME, "extras is null");
        return;
      }
      Bitmap imageBitmap = (Bitmap) extras.get("data");
      imageView.setImageBitmap(imageBitmap);
    }
    if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
      addPictureToGallery();
      if (data == null) {
        LogUtil.e(CLASS_NAME, "data is null");
      }
      File file = new File(currentPhotoPath);
      Uri contentUri = Uri.fromFile(file);
      imageView.setImageURI(contentUri);
    }
    if (requestCode == REQUEST_TAKE_PHOTO_ADD_TO_GALLERY && resultCode == RESULT_OK) {
      addPictureToGallery();
      if (data == null) {
        LogUtil.e(CLASS_NAME, "data is null");
      }
      File file = new File(currentPhotoPath);
      Uri contentUri = Uri.fromFile(file);
      imageView.setImageURI(contentUri);
    }
  }

  private void takePictureReturnThumbnailImage() {
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
      startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }
  }

  private void takePictureSaveToFile() {
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    // Ensure that there's a camera activity to handle the intent
    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
      // Create the File where the photo should go
      File photoFile = null;
      try {
        photoFile = createImageFile();
      } catch (IOException ex) {
        LogUtil.e(CLASS_NAME, "Error occurred while creating the File");
        ex.printStackTrace();
      }
      // Continue only if the File was successfully created
      if (photoFile != null) {
        Uri photoURI = FileProvider.getUriForFile(this, "pers.xumeng.androidstudy.fileprovider", photoFile);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
      }
    }
  }

  private File createImageFile() throws IOException {
    // Create an image file name
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = "JPEG_" + timeStamp + "_";
    File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    if (storageDir != null) {
      LogUtil.e(CLASS_NAME, "getExternalFilesDir(Environment.DIRECTORY_PICTURES) path:" + storageDir.getAbsolutePath());
    }
    File image = File.createTempFile(imageFileName,  /* prefix */
            ".jpg",         /* suffix */
            storageDir      /* directory */);

    // Save a file: path for use with ACTION_VIEW intents
    currentPhotoPath = image.getAbsolutePath();
    LogUtil.e(CLASS_NAME, "currentPhotoPath:" + currentPhotoPath);
    return image;
  }

  private void takePictureAddToGallery() {
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    // Ensure that there's a camera activity to handle the intent
    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
      // Create the File where the photo should go
      File photoFile = null;
      try {
        photoFile = createPublicDirectoryImageFile();
      } catch (IOException ex) {
        ex.printStackTrace();
        //LogUtil.e(CLASS_NAME, "Error occurred while creating the File");
      }
      // Continue only if the File was successfully created
      if (photoFile != null) {
        Uri photoURI = FileProvider.getUriForFile(this, "pers.xumeng.androidstudy.fileprovider", photoFile);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO_ADD_TO_GALLERY);
      }
    }
  }

  private File createPublicDirectoryImageFile() throws IOException {
    // Create an image file name
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = "JPEG_" + timeStamp + "_";
    File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    if (storageDir != null) {
      LogUtil.e(CLASS_NAME, "Environment.getExternalStoragePublicDirectory" + "(Environment.DIRECTORY_PICTURES) path:" + storageDir.getAbsolutePath());
    }
    File image = File.createTempFile(imageFileName,  /* prefix */
            ".jpg",         /* suffix */
            storageDir      /* directory */);

    // Save a file: path for use with ACTION_VIEW intents
    currentPhotoPath = image.getAbsolutePath();
    LogUtil.e(CLASS_NAME, "currentPhotoPath:" + currentPhotoPath);
    return image;
  }

  private void addPictureToGallery() {
    Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
    File file = new File(currentPhotoPath);
    Uri contentUri = Uri.fromFile(file);
    mediaScanIntent.setData(contentUri);
    this.sendBroadcast(mediaScanIntent);
  }


}
