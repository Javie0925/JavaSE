package guarded_suspension;

import java.util.Random;

/**
 * @author javie
 * @date 2019/7/30 21:44
 */
public class ClientThread  extends Thread{

    private final RequestQuene requestQuene;

    private final Random random;

    private final String sendValue;

    public ClientThread(RequestQuene requestQuene,String sendValue) {
        this.requestQuene = requestQuene;
        this.random = new Random(System.currentTimeMillis());
        this.sendValue = sendValue;
    }

    @Override
    public void run() {
        for (int i = 0;i<10;i++){
            System.out.println("Client -> request "+sendValue);
            requestQuene.putRequest(new Request(sendValue));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
