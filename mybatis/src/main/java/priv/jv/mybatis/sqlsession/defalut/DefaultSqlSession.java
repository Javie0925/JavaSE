package priv.jv.mybatis.sqlsession.defalut;

import priv.jv.mybatis.cfg.Configuration;
import priv.jv.mybatis.cfg.Mapper;
import priv.jv.mybatis.sqlsession.SqlSession;
import priv.jv.mybatis.sqlsession.proxy.MapperProxy;
import priv.jv.mybatis.utils.DataSourceUtil;
import priv.jv.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author javie
 * @date 2019/8/19 13:16
 */
public class DefaultSqlSession implements SqlSession {

    private final Connection conn;

    private Configuration cfg;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        this.conn = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 根据参数创建一个代理实现类
     * @param daoInterfaceClass dao的接口字节码
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {

        Map<String, Mapper> mappers = cfg.getMappers();

        T t = (T)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(),conn));


        return t;
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        try {
            if (conn!=null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
