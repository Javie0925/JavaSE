package thread_per_message;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author javie
 * @date 2019/7/31 21:20
 */
public class MessageHandler {

    private final static Random random = new Random(System.currentTimeMillis());

    private final static Executor executor = Executors.newFixedThreadPool(5);

    public void request(Message message){
        executor.execute(()->{
            String value = message.getValue();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the message will be handled by "+Thread.currentThread().getName()+" "+value);
        });
    }
    public void shutDown(){
        ((ExecutorService) executor).shutdown();
    }
}
