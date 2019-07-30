package singleton;

/**
 * @author javie
 * @date 2019/7/29 19:55
 */
public class LazyLoadSingleton2 {

    /**
     * 加对象锁的懒加载单例模式，性能不好
     */
    private static LazyLoadSingleton2 lazyLoadSingleton;

    private LazyLoadSingleton2(){

    }

    public static synchronized LazyLoadSingleton2 getLazyLoadSingleton() {
        if (lazyLoadSingleton==null)
            lazyLoadSingleton = new LazyLoadSingleton2();
        return lazyLoadSingleton;
    }
}
