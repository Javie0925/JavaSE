package waitSet;

import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.stream.IntStream;

/**
 * @author javie
 * @date 2019/7/29 21:17
 */
public class WaitSet {

    public static final Object LOCK = new Object();

    private static void work(){
        synchronized (LOCK){
            System.out.println("begin.............................");
            try {
                System.out.println("Thread is coming");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread will go out.");

        }
    }

    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                work();
            }
        }.start();
        try {
            Thread.sleep(2_000);
            synchronized (LOCK) {
                LOCK.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        /*IntStream.rangeClosed(1, 10).forEach((int i) ->{
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    synchronized (LOCK){
                        try{
                            Optional.of("["+Thread.currentThread().getName()+"] will come to wait set.")
                                    .ifPresent(System.out::println);
                            LOCK.wait();
                            Optional.of("["+Thread.currentThread().getName()+"] will leave wait set.")
                                    .ifPresent(System.out::println);
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        });

        try {
            Thread.sleep(5_000);
            System.out.println("============================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        IntStream.rangeClosed(1, 10).forEach(i->{
            synchronized (LOCK){
                LOCK.notify();
            }
        });*/
    }
}
