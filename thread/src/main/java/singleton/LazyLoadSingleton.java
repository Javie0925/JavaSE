package singleton;

/**
 * @author javie
 * @date 2019/7/29 19:55
 */
public class LazyLoadSingleton {

    /**
     * 缺点，多线程下会有问题
     */
    private static LazyLoadSingleton lazyLoadSingleton;

    private LazyLoadSingleton(){

    }

    public static LazyLoadSingleton getLazyLoadSingleton() {
        if (lazyLoadSingleton==null)
            lazyLoadSingleton = new LazyLoadSingleton();
        return lazyLoadSingleton;
    }
}
