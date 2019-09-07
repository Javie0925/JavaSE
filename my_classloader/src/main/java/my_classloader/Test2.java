package my_classloader;

import java.lang.reflect.Method;

/**
 * @author javie
 * @date 2019/8/3 14:25
 */
public class Test2 {

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader1 = new MyClassLoader("SimpleClassLoader-1");
        MyClassLoader myClassLoader2 = new MyClassLoader(myClassLoader1, "SimpleClassLoader-2");
        myClassLoader2.setDir("F:\\JavaDocuments\\app\\classloader2");
        Class<?> aClass = myClassLoader2.loadClass("my_classloader.MyObject");
        System.out.println(aClass);
        System.out.println((MyClassLoader) aClass.getClassLoader());

    }
}
