package pers.xumeng.androidstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import pers.xumeng.androidstudy.camera.RequestImageActivity;
import pers.xumeng.androidstudy.finishandstartactivity.ActivityA;
import pers.xumeng.androidstudy.ipc.IPCActivity;
import pers.xumeng.androidstudy.navigation.bar.BottomNavigationBarActivity;
import pers.xumeng.androidstudy.open.file.another.app.OpenFileWithAnotherAppActivity;
import pers.xumeng.androidstudy.requestpermission.RequestPermissionActivity;
import pers.xumeng.androidstudy.signature.SignatureActivity;
import pers.xumeng.androidstudy.single.variable.multiple.state.SingleVariableMultipleStateActivity;

public class MainActivity extends AppCompatActivity {

  private final HashMap<String, Class<? extends AppCompatActivity>> activityMap =
      new HashMap<String, Class<? extends AppCompatActivity>>() {{
        put("finish and start activity", ActivityA.class);
        put("exit application", pers.xumeng.androidstudy.exit.ActivityA.class);
        put("force exit and status restore", pers.xumeng.androidstudy.statusrestore.ActivityA.class);
        put("use camera", RequestImageActivity.class);
        put("request permission", RequestPermissionActivity.class);
        put("navigation bar", BottomNavigationBarActivity.class);
        put("single variable multiple state", SingleVariableMultipleStateActivity.class);
        put("signature", SignatureActivity.class);
        put("open file with another app", OpenFileWithAnotherAppActivity.class);
        put("ipc", IPCActivity.class);
      }};
  private final String[] content = activityMap.keySet().toArray(new String[0]);


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
        startActivity(buildStartTargetActivityIntent(position));
        finish();
      }
    });
  }

  private Intent buildStartTargetActivityIntent(int position) {
    Intent intent = new Intent();
    Class<? extends AppCompatActivity> targetActivityClass = activityMap.get(content[position]);
    assert targetActivityClass != null;
    return intent.setClass(this, targetActivityClass);
  }

}
