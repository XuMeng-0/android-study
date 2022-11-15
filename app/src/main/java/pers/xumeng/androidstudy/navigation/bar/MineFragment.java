package pers.xumeng.androidstudy.navigation.bar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.NavigationFragmentMineBinding;

public class MineFragment extends Fragment {

  private NavigationFragmentMineBinding binding;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = DataBindingUtil.inflate(inflater, R.layout.navigation_fragment_mine, container, false);
    return binding.getRoot();
  }
}
