package priv.jv.mybatis.utils;

import priv.jv.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author javie
 * @date 2019/8/19 14:50
 */
public class DataSourceUtil {

    public static Connection getConnection(Configuration cfg){
        Connection connection = null;
        try {
            Class.forName(cfg.getDriver());
            connection = DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
