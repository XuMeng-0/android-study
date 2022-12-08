package pers.xumeng.androidstudy.open.file.another.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.AnotherActivityOpenFileAnotherAppBinding;

public class OpenFileWithAnotherAppActivity extends AppCompatActivity {

  private AnotherActivityOpenFileAnotherAppBinding binding;
  private File file;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("其他应用打开文件");
    }
    binding = DataBindingUtil.setContentView(this, R.layout.another_activity_open_file_another_app);
    binding.setListener(this);
  }


  public void save() {
    String content = binding.anotherEtFileContent.getText().toString();
    if (content.isEmpty()) {
      Toast.makeText(this, "请输入文字后再试", Toast.LENGTH_SHORT).show();
      return;
    }
    boolean isSuccessful = saveStringToFile(content);
    String message;
    if (isSuccessful) {
      message = "已成功保存到文件";
    } else {
      message = "保存到文件失败";
    }
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  private boolean saveStringToFile(String content) {
    try {
      File cacheDir = getExternalCacheDir();
      file = new File(cacheDir, "temp.txt");
      if (!file.exists()) {
        if (!file.createNewFile()) {
          Toast.makeText(this, "文件创建失败", Toast.LENGTH_SHORT).show();
        }
      }
      FileWriter fileWriter = new FileWriter(file);
      fileWriter.write(content);
      fileWriter.flush();
      fileWriter.close();
      return true;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  public void openWithAnotherApp() {
    if (file == null) {
      Toast.makeText(this, "请先将文本框的内容保存到文件再试", Toast.LENGTH_SHORT).show();
      return;
    }
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setDataAndType(Uri.fromFile(file), "text/plain");
    Intent chooser = Intent.createChooser(intent, "选择打开文件的应用");
    try {
      startActivity(chooser);
    } catch (ActivityNotFoundException exception) {
      Toast.makeText(this, "未找到可以打开此类文件的应用", Toast.LENGTH_SHORT).show();
      exception.printStackTrace();
    }
  }

  public void openWithAnotherAppChooseDefault() {
    if (file == null) {
      Toast.makeText(this, "请先将文本框的内容保存到文件再试", Toast.LENGTH_SHORT).show();
      return;
    }
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setDataAndType(Uri.fromFile(file), "text/plain");
    try {
      startActivity(intent);
    } catch (ActivityNotFoundException exception) {
      Toast.makeText(this, "未找到可以打开此类文件的应用", Toast.LENGTH_SHORT).show();
      exception.printStackTrace();
    }
  }

}
