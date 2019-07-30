package guarded_suspension;

import java.util.Random;

/**
 * @author javie
 * @date 2019/7/30 21:49
 */
public class ServerThread extends Thread{

    private final RequestQuene requestQuene;

    private final Random random;

    private volatile boolean flag = false;

    public ServerThread(RequestQuene requestQuene) {
        this.requestQuene = requestQuene;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (!flag){
            Request request = requestQuene.getRequest();
            if (null == request){
                System.out.println("Receive empty request.");
                continue;
            }
            System.out.println("Server -> "+request.getValue());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void close(){
        this.flag = true;
        this.interrupt();
    }
}
