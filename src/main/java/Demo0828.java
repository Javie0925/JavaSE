import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author javie
 * @date 2019/8/28 11:00
 */
public class Demo0828 {

    private final static ReentrantLock LOCK = new ReentrantLock();

    public static int num = 100;

    public static void main(String[] args) throws IOException, InterruptedException {

        new Thread(()->{
            ThreadGroup group = Thread.currentThread().getThreadGroup();
            while (true) {
                try {
                    Thread[] threads = new Thread[group.activeCount()];
                    group.enumerate(threads);
                    for (int i=0;i<threads.length;i++){
                        System.out.print(threads[i].getName()+">>>");
                    }
                    System.out.println();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(group.getName()+"--activeCount: "+group.activeCount());
            }
        }).start();

        new Thread(()->{
            while (num-->=0) {
                System.out.println(num);
            }
        }).start();
        System.out.println("=======================================");
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
    }

}
