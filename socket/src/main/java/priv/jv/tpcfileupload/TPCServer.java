package priv.jv.tpcfileupload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author javie
 * @date 2019/6/26 17:46
 */
public class TPCServer {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(10086);
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(new TPCRun(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
