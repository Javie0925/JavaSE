package singleton;

/**
 * @author javie
 * @date 2019/7/29 19:50
 */
public class SingletonObject1 {

    /**
     * 缺点：不能懒加载
     */

    private static final SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1(){

    }

    public static SingletonObject1 getInstance() {
        return instance;
    }
}
