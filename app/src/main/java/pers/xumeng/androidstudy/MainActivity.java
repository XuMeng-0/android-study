package pers.xumeng.androidstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pers.xumeng.androidstudy.finishandstartactivity.ActivityA;

public class MainActivity extends AppCompatActivity {

  private String[] content = {"finish and startActivity", "exit application"};

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
        if("finish and startActivity".equals(content[position])){
          startActivity(new Intent(MainActivity.this, ActivityA.class));
          finish();
        }else{
          //TODO
          Toast.makeText(MainActivity.this, "exit application", Toast.LENGTH_LONG).show();
        }
      }
    });
  }

}
