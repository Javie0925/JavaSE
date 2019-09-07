package thread_local;

import java.util.HashMap;
import java.util.Map;

/**
 * @author javie
 * @date 2019/7/31 0:25
 */
public class ThreadLocalSimulator<T> {

    private final Map<Thread,T> storage = new HashMap<>();



    public void set(T t){
        synchronized (this){
            storage.put(Thread.currentThread(), t);
        }
    }

    public T get(){
        synchronized (this){
            T value = storage.get(Thread.currentThread());
            if (value==null)
                return initialValue();
            return value;

        }
    }

    public T initialValue(){
        return null;
    }
}
