package observer;

import java.util.ArrayList;

/**
 * @author javie
 * @date 2019/7/30 15:25
 */
public class ThreadLifeCycleClient {

    public static void main(String[] args) {
        ThreadLifeCycleObserver observer = new ThreadLifeCycleObserver();
        ArrayList<String> list = new ArrayList<>();
        list.add("thread1");
        list.add("thread2");
        list.add("thread3");
        list.add("thread4");
        observer.concurrentQuery(list);
    }
}
