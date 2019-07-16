package priv.jv;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Scanner;

/**
 * @author javie
 * @date 2019/6/23 14:38
 */
public class Send implements Runnable {

    private DatagramPacket datagramPacket;
    private DatagramSocket datagramSocket;
    private int sendPort;

    public Send(DatagramSocket datagramSocket,int sendPort){
        this.datagramSocket = datagramSocket;
        this.sendPort = sendPort;
    }

    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String s = scanner.nextLine();
                if ("886".equals(s)){
                    break;
                }
                byte[] data = new byte[1024*64];
                datagramPacket = new DatagramPacket(data,data.length,InetAddress.getByName("192.168.1.255"),sendPort);
                datagramPacket.setData(s.getBytes());
                datagramSocket.send(datagramPacket);

            }
            datagramSocket.close();
            System.out.println("发送端关闭！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
