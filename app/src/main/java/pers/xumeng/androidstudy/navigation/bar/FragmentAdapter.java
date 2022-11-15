package pers.xumeng.androidstudy.navigation.bar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStateAdapter {

  private final ArrayList<Fragment> fragments;

  public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
    super(fragmentActivity);
    fragments = new ArrayList<>();
    fragments.add(new HomeFragment());
    fragments.add(new ContactFragment());
    fragments.add(new MineFragment());
  }

  @NonNull
  @Override
  public Fragment createFragment(int position) {
    return fragments.get(position);
  }

  @Override
  public int getItemCount() {
    return fragments.size();
  }

}
