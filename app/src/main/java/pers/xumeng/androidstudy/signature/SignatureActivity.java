package pers.xumeng.androidstudy.signature;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.SignatureActivitySignatureBinding;

public class SignatureActivity extends AppCompatActivity {

  private SignatureActivitySignatureBinding binding;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("签名控件的使用");
    }
    binding = DataBindingUtil.setContentView(this, R.layout.signature_activity_signature);
    binding.setListener(this);
  }


  public void saveSignature() {
    Toast.makeText(this, "保存", Toast.LENGTH_SHORT).show();
  }

  public void clearSignature() {
    binding.signatureSSignature.clear();
  }

}
