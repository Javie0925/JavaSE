package singleton;

/**
 * @author javie
 * @date 2019/9/11 13:59
 */
public class DoubleCheckSingleton {
    private static DoubleCheckSingleton instance;

    private DoubleCheckSingleton(){

    }

    public static DoubleCheckSingleton getInstance(){
        if (instance==null){
            synchronized(DoubleCheckSingleton.class){
                if (instance==null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
