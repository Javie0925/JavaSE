package my_classloader;

import java.lang.reflect.Method;

/**
 * 测试
 * @author javie
 * @date 2019/8/2 11:36
 */
public class Test {

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("SimpleClassLoader");
        Class<?> aClass = myClassLoader.loadClass("my_classloader.MyObject");
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());

        Object obj = aClass.newInstance();
        Method hello = aClass.getMethod("hello");
        Object result = hello.invoke(obj);
        System.out.println(result);
    }
}
