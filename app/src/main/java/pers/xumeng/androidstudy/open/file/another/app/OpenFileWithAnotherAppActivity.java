package pers.xumeng.androidstudy.open.file.another.app;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.AnotherActivityOpenFileAnotherAppBinding;

public class OpenFileWithAnotherAppActivity extends AppCompatActivity {

  private AnotherActivityOpenFileAnotherAppBinding binding;


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
    Toast.makeText(this, "保存", Toast.LENGTH_SHORT).show();
  }

  public void openWithAnotherApp() {
    Toast.makeText(this, "用其他应用打开", Toast.LENGTH_SHORT).show();
  }

  public void openWithAnotherAppChooseDefault() {
    Toast.makeText(this, "用其他应用打开并选择默认应用", Toast.LENGTH_SHORT).show();
  }

}
