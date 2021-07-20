package com.linxz.androidinterview.IPC;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.linxz.androidinterview.R;


/**
 * @author Linxz
 * 创建日期：2021年04月13日 3:39 PM
 * version：
 * 描述：
 */
public class SocketIPCActivity extends AppCompatActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_ipc_socket);

      //  initClient();
        initServer();
    }




    /**客户端*/
    private SocketClient socketClient;
    private void initClient(){
        socketClient=new SocketClient();
        socketClient.clintValue(this,IPUtils.getIPAddress(this),6666);
        socketClient.openClientThread ();
        onClientMessageBack();

        findViewById(R.id.tvClient).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                socketClient.sendMsg("你好呀,我是Client!");
            }
        });
    }

    @SuppressLint("HandlerLeak")
    private void onClientMessageBack(){
        SocketClient.mHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Toast.makeText(SocketIPCActivity.this,"Client端接到消息啦"+msg.obj.toString(),Toast.LENGTH_LONG).show();
            }
        };
    }




    private SocketServer serverSocket;
    /***服务端*/
    private void initServer(){
        serverSocket=new SocketServer(6666);
        serverSocket.beginListen();
        onServerMessageBack();
        findViewById(R.id.tvServer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","你好呀，我是Server!");
                serverSocket.sendMessage("你好呀，我是Server!");
            }
        });
    }


    @SuppressLint("HandlerLeak")
    private void onServerMessageBack(){
        SocketServer.ServerHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Toast.makeText(SocketIPCActivity.this,"Server端接到消息啦"+msg.obj.toString(),Toast.LENGTH_LONG).show();
            }
        };
    }

}
