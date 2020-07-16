package thread_pool;

import java.util.LinkedList;

/**
 * @author javie
 * @date 2019/9/10 11:27
 */
public class ThreadPool {

    private int min;

    private int max;

    private int active;

    private final LinkedList<Thread> threadList = new LinkedList<>();

    private final static int DEFAULT_POOL_SIZE = 10;

    public ThreadPool(Runnable runnable){

        for (int i=0;i<DEFAULT_POOL_SIZE;i++){
            threadList.addLast(new Thread(runnable));
        }
    }

    public Thread getThread(){
        Thread thread = threadList.removeFirst();
        this.active -=1;
        return thread;
    }

    public int size(){
        return threadList.size();
    }
}
