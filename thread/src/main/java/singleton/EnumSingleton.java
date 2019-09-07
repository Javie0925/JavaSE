package singleton;

/**
 * @author javie
 * @date 2019/7/29 20:27
 */
public class EnumSingleton {

    /**
     * 枚举方式的单例
     * 枚举的构造函数是私有的
     * 枚举类是final的
     */

    private EnumSingleton(){

    }

    /**
     * 枚举类是线程安全的，而且类只会被装载一次
     */
    private enum Singleton{

        INSTANCE;

        private final EnumSingleton instance;

        Singleton(){
            instance = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return instance;
        }
    }

    public static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
}
