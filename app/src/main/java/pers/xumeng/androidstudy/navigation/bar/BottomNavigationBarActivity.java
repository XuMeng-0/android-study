package pers.xumeng.androidstudy.navigation.bar;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.navigation.NavigationBarView;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.NavigationActivityBottomNavigationBarBinding;

public class BottomNavigationBarActivity extends AppCompatActivity {

  private NavigationActivityBottomNavigationBarBinding binding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    int layoutId = R.layout.navigation_activity_bottom_navigation_bar;
    binding = DataBindingUtil.setContentView(this, layoutId);
    binding.mainFragmentContainer.setAdapter(new FragmentAdapter(this));
    binding.mainFragmentContainer.setUserInputEnabled(false);
    setNavigationItemSelectedListener();
  }

  private void setNavigationItemSelectedListener() {
    binding.mainNavigationBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        String itemTitle = (String) item.getTitle();
        switch (itemTitle) {
          case "主页": {
            binding.mainFragmentContainer.setCurrentItem(0);
          }
          break;
          case "联系人": {
            binding.mainFragmentContainer.setCurrentItem(1);
          }
          break;
          case "我的": {
            binding.mainFragmentContainer.setCurrentItem(2);
          }
          break;
        }
        return true;
      }
    });
  }

}
