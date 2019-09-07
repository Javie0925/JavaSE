package thread_local;

import java.util.Random;

/**
 * @author javie
 * @date 2019/7/31 0:13
 */
public class ThreadLocalComplexTest {
    private final static ThreadLocal threadLocal = new ThreadLocal();

    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
           threadLocal.set("Javie");
            try {
                System.out.println(threadLocal.get());
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            threadLocal.set("Cathy");
            try {
                System.out.println(threadLocal.get());
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("==============================");
        System.out.println(threadLocal.get());
    }
}
