package producer_and_consumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author javie
 * @date 2019/7/31 19:56
 */
public class ProducerThread extends Thread{

    private final MessageQuene messageQuene;

    private final static Random random = new Random(System.currentTimeMillis());

    private final static AtomicInteger counter = new AtomicInteger(0);

    public ProducerThread(MessageQuene messageQuene,int seq){
        super("PRODUCER"+seq);
        this.messageQuene = messageQuene;
    }

    @Override
    public void run() {

        while (true){
            try {
                Message message = new Message("Message-" + counter.getAndIncrement());
                messageQuene.put(message);
                System.out.println(Thread.currentThread().getName()+" put message "+message.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
