package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;

/**
 * @author javie
 * @date 2019/8/16 11:24
 */
public class JdbcUtils {

    private static String driveName;
    private static String username;
    private static String password;
    private static String url;
    private static Connection connection;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private static LinkedList<Connection> connectionList = new LinkedList<>();
    private static final int INITSIZE = 10;
    private static int size = INITSIZE;

    static {

        Properties properties = new Properties();
        InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driveName = properties.getProperty("driverName");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        url = properties.getProperty("url");
        try {
            Class.forName(driveName);
            for (int i=0;i<size;i++){
                connection = DriverManager.getConnection(url, username, password);
                connectionList.add(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setSize(int size) {
        JdbcUtils.size = size;
    }

    public static Connection getConnection(){
        if (!connectionList.isEmpty()){
            Connection connection = connectionList.removeFirst();
            threadLocal.set(connection);
            return connection;
        }else {
            Connection connection = getNewConnection();
            threadLocal.set(connection);
            return connection;
        }

    }

    private static Connection getNewConnection() {

        try {
            connection = DriverManager.getConnection(url, username, password);
            size++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection){

        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(){
        connectionList.add(threadLocal.get());
        threadLocal.remove();
    }
}
