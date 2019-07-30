package singleton;

/**
 * @author javie
 * @date 2019/7/29 20:22
 */
public class InstanceHolderSingleton {

    /**
     * 被static修饰的变量只会被加载一次，而且严格保证线程执行顺序。
     */
    private InstanceHolderSingleton(){

    }

    public static class InstanceHolder{
        private final static InstanceHolderSingleton INSTANCE_HOLDER_SINGLETON = new InstanceHolderSingleton();
    }

    public InstanceHolderSingleton getInstance(){
        return InstanceHolder.INSTANCE_HOLDER_SINGLETON;
    }
}
