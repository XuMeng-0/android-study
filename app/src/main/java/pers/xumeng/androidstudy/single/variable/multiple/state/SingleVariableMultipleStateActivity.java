package pers.xumeng.androidstudy.single.variable.multiple.state;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.SingleActivitySingleVariableMultipleStateBinding;

public class SingleVariableMultipleStateActivity extends AppCompatActivity {

  private SingleActivitySingleVariableMultipleStateBinding binding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    int layoutId = R.layout.single_activity_single_variable_multiple_state;
    binding = DataBindingUtil.setContentView(this, layoutId);
  }
}
