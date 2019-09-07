package work_thread;

import java.util.Random;

/**
 * @author javie
 * @date 2019/7/31 23:44
 */
public class WorkerThread extends Thread {

    private final Channel channel;

    private final static Random random = new Random(System.currentTimeMillis());

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true){
            Request take = channel.take();
            take.execute();
            try {
                this.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
