package pers.xumeng.androidstudy.single.variable.multiple.state;

import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.SingleActivitySingleVariableMultipleStateBinding;
import pers.xumeng.androidstudy.util.LogUtil;

public class SingleVariableMultipleStateActivity extends AppCompatActivity {

  private static final String TAG = SingleVariableMultipleStateActivity.class.getSimpleName();
  private SingleActivitySingleVariableMultipleStateBinding binding;
  private final FavouriteBallGamesHelper ballGamesHelper = new FavouriteBallGamesHelper();


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    int layoutId = R.layout.single_activity_single_variable_multiple_state;
    binding = DataBindingUtil.setContentView(this, layoutId);
    binding.setListener(this);
    setCheckBoxChangedChangeListener();
  }

  public void setCheckBoxChangedChangeListener() {
    binding.singleCbFootball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        ballGamesHelper.setFootballCheckedState(isChecked);
      }
    });

    binding.singleCbBasketball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        ballGamesHelper.setBasketballCheckedState(isChecked);
      }
    });

    binding.singleCbTableTennis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        ballGamesHelper.setTableTennisCheckedState(isChecked);
      }
    });

    binding.singleCbTennis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        ballGamesHelper.setTennisCheckedState(isChecked);
      }
    });

    binding.singleCbVolleyball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        ballGamesHelper.setVolleyballCheckedState(isChecked);
      }
    });

    binding.singleCbBadminton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        ballGamesHelper.setBadmintonCheckedState(isChecked);
      }
    });
  }

  public void confirm() {
    String result = "选中的项目 : \n";
    if (ballGamesHelper.footballIsChecked()) {
      LogUtil.e(TAG, "isChecked : football");
      result += "足球";
    }
    if (ballGamesHelper.basketballIsChecked()) {
      LogUtil.e(TAG, "isChecked : basketball");
      result += " 篮球";
    }
    if (ballGamesHelper.tableTennisIsChecked()) {
      LogUtil.e(TAG, "isChecked : table tennis");
      result += " 乒乓球";
    }
    if (ballGamesHelper.tennisIsChecked()) {
      LogUtil.e(TAG, "isChecked : tennis");
      result += " 网球";
    }
    if (ballGamesHelper.volleyballIsChecked()) {
      LogUtil.e(TAG, "isChecked : volleyball");
      result += " 排球";
    }
    if (ballGamesHelper.badmintonIsChecked()) {
      LogUtil.e(TAG, "isChecked : badminton");
      result += " 羽毛球";
    }
    binding.singleTvResult.setText(result);
  }

}
