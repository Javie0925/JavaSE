package JDKCountDown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @author javie
 * @date 2019/7/31 20:58
 */
public class MyCountDownClient {

    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {

        final MyCountDown countDownLatch = new MyCountDown(5);
        System.out.println("准备多线程处理任务");

        // the first phase.多线程处理任务

        IntStream.rangeClosed(1,5).forEach(i->
                new Thread(()->{
                    System.out.println(Thread.currentThread().getName()+" is working.");
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.down();
                },String.valueOf(i)).start()
        );

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // the second phase.第一阶段任务处理完毕，执行第二阶段任务

        System.out.println("多线程任务处理结束，准备第二阶段任务。");
        System.out.println("................");
        System.out.println("FINISH");
    }
}
