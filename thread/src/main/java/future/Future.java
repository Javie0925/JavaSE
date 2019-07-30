package future;

/**
 * @author javie
 * @date 2019/7/30 20:23
 */
public interface Future<T> {

    T get() throws InterruptedException;
}
