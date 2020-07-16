package singleton;

/**
 * @author javie
 * @date 2019/9/11 14:01
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){

    }

    public static class Inner{

        private static InnerClassSingleton instance = new InnerClassSingleton();

    }

    public static InnerClassSingleton getInstance(){
        return Inner.instance;
    }
}
