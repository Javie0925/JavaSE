package singleton;

/**
 * @author javie
 * @date 2019/9/11 13:56
 */
public class LazyloadSingleton {

    private static LazyloadSingleton instance;

    private LazyloadSingleton(){

    }

    public static synchronized LazyloadSingleton getInstance(){
        if (instance==null){
            instance = new LazyloadSingleton();
            return instance;
        }else {
            return instance;
        }
    }
}
