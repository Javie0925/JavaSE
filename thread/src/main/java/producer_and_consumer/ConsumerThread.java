package producer_and_consumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author javie
 * @date 2019/7/31 19:56
 */
public class ConsumerThread extends Thread{

    private final MessageQuene messageQuene;

    private final static Random random = new Random(System.currentTimeMillis());

    public ConsumerThread(MessageQuene messageQuene, int seq){
        super("Consumer"+seq);
        this.messageQuene = messageQuene;
    }

    @Override
    public void run() {

        while (true){
            try {
                Message message = messageQuene.take();
                System.out.println(Thread.currentThread().getName()+" take message "+message.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
