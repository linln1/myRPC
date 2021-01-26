package client;

import org.apache.commons.io.IOUtils;
import pojo.Invocation;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;

public class HttpClient {
    public String post(String hostname, int port, Invocation invocation) throws IOException {
        //1.连接
        URL url = new URL("http", hostname, port, "/client");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setDoOutput(true);

        //2.发送调用请求
        OutputStream outputStream = urlConnection.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(invocation);
        objectOutputStream.flush();
        objectOutputStream.close();

        //3.将输入流反序列化，获取RPC 结果
        InputStream inputStream = urlConnection.getInputStream();
        return IOUtils.toString(inputStream);
    }
}
