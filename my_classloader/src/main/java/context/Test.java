package context;

import my_classloader.MyClassLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author javie
 * @date 2019/8/4 21:44
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        Thread.currentThread().setContextClassLoader(new MyClassLoader("MyClassLoader"));
        System.out.println(Thread.currentThread().getContextClassLoader());

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("");
    }
}
