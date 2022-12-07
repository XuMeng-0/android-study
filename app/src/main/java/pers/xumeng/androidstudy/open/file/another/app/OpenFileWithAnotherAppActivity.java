package pers.xumeng.androidstudy.open.file.another.app;

import android.os.Bundle;

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
  }

}
