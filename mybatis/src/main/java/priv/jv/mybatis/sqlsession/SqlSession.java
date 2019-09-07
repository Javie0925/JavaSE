package priv.jv.mybatis.sqlsession;

import java.sql.SQLException;

/**
 * @author javie
 * @date 2019/8/19 12:19
 * 自定义Mybatis中和数据库交互的核心类
 * 它可以创建dao接口的代理对象
 */
public interface SqlSession {

    /**
     * 根据参数创建一个代理实现类
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);


    /**
     * 释放资源
     */
    void close() throws SQLException;
}
