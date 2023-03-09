package pers.xumeng.androidstudy.ipc.socket;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import pers.xumeng.androidstudy.util.LogUtil;

public class TCPServerService extends Service {

  private static final String TAG = TCPServerService.class.getSimpleName();

  private boolean serviceIsActive = true;
  private final String[] definedMessages = new String[]{
      "你好啊",
      "请问你叫什么名字呀？",
      "今天北京天气不错啊",
      "你知道吗？我可是可以和多个人同时聊天的哦",
      "据说爱笑的人运气不会太差，不知道真假。",
      "有道理，然后呢？",
      "我认同你的观点",
      "后来怎么样了？"
  };

  @Override
  public void onCreate() {
    new Thread(new TCPServer()).start();
    super.onCreate();
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onDestroy() {
    serviceIsActive = false;
    super.onDestroy();
  }

  private class TCPServer implements Runnable {
    @Override
    public void run() {
      ServerSocket serverSocket;
      try {
        serverSocket = new ServerSocket(8688);
      } catch (IOException e) {
        LogUtil.e(TAG, "Establish TCP server failed, port : 8688");
        e.printStackTrace();
        return;
      }

      while (serviceIsActive) {
        try {
          final Socket client = serverSocket.accept();
          new Thread() {
            @Override
            public void run() {
              try {
                responseClient(client);
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
          }.start();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private void responseClient(Socket client) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
    printWriter.println("欢迎来到聊天室");
    while (serviceIsActive) {
      String messageFromClient = bufferedReader.readLine();
      LogUtil.i(TAG, "Message from client : " + messageFromClient);
      if (messageFromClient == null) { // 客户端断开连接
        break;
      }
      int i = new Random().nextInt(definedMessages.length);
      String responseMessage = definedMessages[i];
      printWriter.println(responseMessage);
      LogUtil.i(TAG, "Message response to client : " + responseMessage);
    }
    LogUtil.w(TAG, "Client quit.");
    bufferedReader.close();
    printWriter.close();
    client.close();
  }

}
