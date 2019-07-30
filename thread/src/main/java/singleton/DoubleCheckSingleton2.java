package singleton;

/**
 * @author javie
 * @date 2019/7/29 20:00
 */
public class DoubleCheckSingleton2 {

    /**
     * double check 可以懒加载，解决了懒加载多线程问题，但是如果重排序，会发生NullPointerException
     */
    private static volatile DoubleCheckSingleton2 doubleCheckSingleton;

    private DoubleCheckSingleton2(){

    }

    public static DoubleCheckSingleton2 getDoubleCheckSingleton() {
        if (null == doubleCheckSingleton){
            synchronized (SingletonObject1.class){
                if (null==doubleCheckSingleton){
                    doubleCheckSingleton = new DoubleCheckSingleton2();
                }
            }
        }
        return doubleCheckSingleton;
    }
}
