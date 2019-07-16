package priv.jv.tpcfileupload;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author javie
 * @date 2019/6/26 17:47
 */
public class TPCClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost",10086);
            OutputStream outputStream = socket.getOutputStream();
            File file = new File("C:\\Users\\lenovo\\Desktop\\favicon.png");
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[1024*1024*5];
            int len = 0;
            while ((len = bufferedInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
            socket.shutdownOutput();
            // 接收服务端返回信息
            InputStream socketInputStream = socket.getInputStream();
            while ((len = socketInputStream.read(bytes))!=-1) {
                System.out.println(new String(bytes,0,len));
            }
            // 关闭资源
            outputStream.close();
            socketInputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
