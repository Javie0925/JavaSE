package two_phase_termination;

import java.util.Random;

/**
 * @author javie
 * @date 2019/7/31 22:38
 */
public class CounterIncrement  extends Thread{

    private volatile boolean terminated = false;

    private int counter = 0;

    private Random random = new Random(System.currentTimeMillis());
    @Override
    public void run() {
        try {
            while (!terminated){
                System.out.println(Thread.currentThread().getName()+"   "+counter++);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.clean();
        }
    }

    public void clean(){
        System.out.println("do clean work for the secend phase. current counter "+counter);
    }

    public void close(){
        this.terminated = true;
        this.interrupt();
    }
}
