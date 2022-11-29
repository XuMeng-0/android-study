package pers.xumeng.androidstudy.signature;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.SignatureActivitySignatureBinding;

public class SignatureActivity extends AppCompatActivity {

  private SignatureActivitySignatureBinding binding;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.signature_activity_signature);
  }

}
