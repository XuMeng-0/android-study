package pers.xumeng.androidstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pers.xumeng.androidstudy.camera.RequestImageActivity;
import pers.xumeng.androidstudy.finishandstartactivity.ActivityA;
import pers.xumeng.androidstudy.requestpermission.RequestPermissionActivity;

public class MainActivity extends AppCompatActivity {

  private String[] content = {"finish and start activity", "exit application", "force exit and status restore", "use camera", "request permission"};

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ListView lvContent = findViewById(R.id.lv_content);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_activity_main, content);

    lvContent.setAdapter(adapter);
    lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        startActivity(getTargetActivity(position));
        finish();
      }
    });
  }

  private Intent getTargetActivity(int position) {
    Intent intent = new Intent();
    Class<? extends AppCompatActivity> targetActivityClass = null;
    switch (content[position]) {
      case "finish and start activity": {
        targetActivityClass = ActivityA.class;
      }
      break;

      case "exit application": {
        targetActivityClass = pers.xumeng.androidstudy.exit.ActivityA.class;
      }
      break;

      case "force exit and status restore": {
        targetActivityClass = pers.xumeng.androidstudy.statusrestore.ActivityA.class;
      }
      break;

      case "use camera": {
        targetActivityClass = RequestImageActivity.class;
      }
      break;

      case "request permission": {
        targetActivityClass = RequestPermissionActivity.class;
      }
      break;
    }
    assert targetActivityClass != null;
    return intent.setClass(this, targetActivityClass);
  }

}
