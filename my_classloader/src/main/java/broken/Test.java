package broken;

/**
 * @author javie
 * @date 2019/8/3 15:28
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        SimpleClassLoader classLoader = new SimpleClassLoader("SimpleClassLoader");
        Class<?> aClass = classLoader.loadClass("my_classloader.MyObject");
        System.out.println(aClass.getClassLoader());

    }
}
