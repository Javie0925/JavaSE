package priv.jv.tcp;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author javie
 * @date 2019/6/23 22:23
 */
public class TCPServer {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(20000);
            Scanner scanner = new Scanner(System.in);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            //OutputStream outputStream = socket.getOutputStream();

            while (true) {
                // 接收
                byte[] bytes = new byte[1024];
                int len = inputStream.read(bytes);
                System.out.print(socket.getInetAddress().getHostAddress()+":");
                System.out.println(new String(bytes,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
