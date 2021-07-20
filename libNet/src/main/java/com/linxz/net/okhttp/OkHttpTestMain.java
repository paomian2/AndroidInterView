package com.linxz.net.okhttp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Linxz
 * 创建日期：2021年04月05日 7:17 PM
 * version：
 * 描述：
 */
class OkHttpTestMain {

    //建立好socket之后，多次使用(多路复用)

    public void socketTest(){
        try {
            URL url=new URL("http://itnewers.com:8080/");
            String host=url.getHost();
            int port=url.getPort();
            SocketAddress socketAddress=new InetSocketAddress(host,port);
            Socket socket=new Socket();
            socket.connect(socketAddress);

            OutputStreamWriter streamWriter = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter bufferedWriter = new BufferedWriter(streamWriter);
            bufferedWriter.write("GET " + "/linxz-user/" + " HTTP/1.1\r\n");
            bufferedWriter.write("Host: " + url.getHost() + "\r\n");
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();

            BufferedInputStream streamReader = new BufferedInputStream(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(streamReader, "utf-8"));
            String line;
            while((line = bufferedReader.readLine())!= null)
            {
                System.out.println(line);
            }
            bufferedReader.close();
            bufferedWriter.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void okHttpTest(){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url("").get().build();
        Call call=okHttpClient.newCall(request);
       // call.execute();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
