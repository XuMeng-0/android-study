package pers.xumeng.androidstudy.ipc.socket;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import pers.xumeng.androidstudy.R;
import pers.xumeng.androidstudy.databinding.IpcActivityTcpClientBinding;
import pers.xumeng.androidstudy.util.LogUtil;

public class TCPClientActivity extends AppCompatActivity {

  private static final String TAG = TCPClientActivity.class.getSimpleName();

  private static final int MESSAGE_SOCKET_CONNECTED = 1;
  private static final int MESSAGE_RECEIVE_NEW_MESSAGE = 2;

  private IpcActivityTcpClientBinding binding;
  private Socket clientSocket;
  private PrintWriter printWriter;

  private final Handler handler = new Handler(Looper.getMainLooper()) {
    @Override
    public void handleMessage(@NonNull Message msg) {
      switch (msg.what) {
        case MESSAGE_SOCKET_CONNECTED: {
          binding.socketBtnSend.setEnabled(true);
          break;
        }
        case MESSAGE_RECEIVE_NEW_MESSAGE: {
          String message = (String) msg.obj;
          String messages = binding.socketTvMessageContainer.getText().toString() + message;
          binding.socketTvMessageContainer.setText(messages);
          break;
        }
        default:
          break;
      }
    }
  };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("使用 Socket 进行 IPC");
    }
    binding = DataBindingUtil.setContentView(this, R.layout.ipc_activity_tcp_client);
    binding.setListener(this);
    startService(new Intent(this, TCPServerService.class));
    new Thread() {
      @Override
      public void run() {
        connectTCPServer();
      }
    }.start();
  }

  private void connectTCPServer() {
    Socket socket = null;
    while (socket == null) {
      try {
        socket = new Socket("localhost", 8688);
        clientSocket = socket;
        printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        handler.sendEmptyMessage(MESSAGE_SOCKET_CONNECTED);
        LogUtil.w(TAG, "Connect to server success");
      } catch (IOException e) {
        SystemClock.sleep(1000);
        LogUtil.e(TAG, "Connect to TCP server failed, retry ...");
        e.printStackTrace();
      }
    }

    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      while (!TCPClientActivity.this.isFinishing()) {
        String message = bufferedReader.readLine();
        LogUtil.i(TAG, "Received message : " + message);
        if (message != null) {
          String time = formatDateTime(System.currentTimeMillis());
          String messageForShow = "Server " + time + " : " + message + "\n";
          handler.obtainMessage(MESSAGE_RECEIVE_NEW_MESSAGE, messageForShow).sendToTarget();
        }
      }
      LogUtil.w(TAG, "Quit ...");
      bufferedReader.close();
      printWriter.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String formatDateTime(long time) {
    return new SimpleDateFormat("(HH:mm:ss)", Locale.CHINA).format(new Date(time));
  }

  public void sendMessage() {
    final String message = binding.socketEtMsg.getText().toString();
    if (TextUtils.isEmpty(message) || printWriter == null) {
      return;
    }
    printWriter.println(message);
    binding.socketEtMsg.setText("");
    String time = formatDateTime(System.currentTimeMillis());
    final String messageForShow = "Client " + time + " : " + message + "\n";
    String messages = binding.socketTvMessageContainer.getText().toString() + messageForShow;
    binding.socketTvMessageContainer.setText(messages);
  }

  @Override
  protected void onDestroy() {
    if (clientSocket != null) {
      try {
        clientSocket.shutdownInput();
        clientSocket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    super.onDestroy();
  }

}
