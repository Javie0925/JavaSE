package work_thread;

import java.util.Random;

/**
 * @author javie
 * @date 2019/8/1 0:35
 */
public class TransportThread extends Thread {

    private final Channel channel;

    private final static Random random = new Random(System.currentTimeMillis());

    public TransportThread(String name,Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            for (int i = 0;true;i++){
                Request request = new Request(getName(),i);
                this.channel.put(request);
                this.random.nextInt(1000);
            }
        }catch (Exception e){

        }
    }
}
