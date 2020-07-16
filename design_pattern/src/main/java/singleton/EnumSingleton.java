package singleton;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

/**
 * @author javie
 * @date 2019/9/11 14:06
 */
public class EnumSingleton {

    private EnumSingleton(){

    }

    enum InnerEnum{
        INSTANCE
        ;

        private final EnumSingleton instance;
        private InnerEnum(){
            instance = new EnumSingleton();
        }
        private EnumSingleton getInstance(){
            return instance;
        }
    }

    public static EnumSingleton getInstance(){
        return InnerEnum.INSTANCE.getInstance();
    }
}
