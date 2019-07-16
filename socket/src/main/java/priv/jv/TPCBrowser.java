package priv.jv;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author javie
 * @date 2019/6/26 20:15
 */
public class TPCBrowser {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(30000);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            int len = 0;
            byte[] bytes = new byte[1024*1024];
            len=inputStream.read(bytes);
            if (len!=-1)
            System.out.println(new String(bytes,0,len));
            // 输出
            PrintWriter out =
                    new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            out.println("hello!");
            out.println("hello!");
            out.println("hello!");
            out.println("hello!");
            out.println("hello!");
            out.println("hello!");
            out.println("hello!");
            System.out.println("#################");
            // 关资源
            out.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
