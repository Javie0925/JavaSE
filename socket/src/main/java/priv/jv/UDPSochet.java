package priv.jv;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author javie
 * @date 2019/6/23 14:38
 */
public class UDPSochet {

    public static void main(String[] args) {
        try {
            Send send = new Send(new DatagramSocket(),10000);
            Rec rec = new Rec(new DatagramSocket(10002),10002);
            Thread thread = new Thread(send);
            Thread thread1 = new Thread(rec);
            thread.start();
            thread1.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
