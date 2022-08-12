package pers.xumeng.androidstudy.navigation.bar;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.NavigationActivityBottomNavigationBarBinding;

public class BottomNavigationBarActivity extends AppCompatActivity {

  private NavigationActivityBottomNavigationBarBinding binding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.navigation_activity_bottom_navigation_bar);
  }

}
