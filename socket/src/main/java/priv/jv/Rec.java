package priv.jv;

import java.net.*;

/**
 * @author javie
 * @date 2019/6/23 14:48
 */
public class Rec implements Runnable {

    private DatagramSocket datagramSocket;
    private int recPort;

    public Rec(DatagramSocket datagramSocket,int recPort){
        this.datagramSocket = datagramSocket;
        this.recPort = recPort;
    }

    public void run() {
        try {
            while (true) {
                byte[] data = new byte[1024 * 64];
                DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
                datagramSocket.receive(datagramPacket);
                byte[] bytes = datagramPacket.getData();
                System.out.println(datagramPacket.getAddress()+":"+new String(bytes,0,bytes.length));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
