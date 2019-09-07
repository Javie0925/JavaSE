package jdbc;

import utils.JdbcUtils;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author javie
 * @date 2019/8/16 11:22
 */
public class Test2 {

    public static void main(String[] args)  {

        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
    }
}
