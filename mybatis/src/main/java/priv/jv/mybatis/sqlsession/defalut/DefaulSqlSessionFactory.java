package priv.jv.mybatis.sqlsession.defalut;

import priv.jv.mybatis.cfg.Configuration;
import priv.jv.mybatis.sqlsession.SqlSession;
import priv.jv.mybatis.sqlsession.SqlSessionFactory;

import java.sql.Connection;

/**
 * @author javie
 * @date 2019/8/19 13:13
 */
public class DefaulSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;
    private Connection conn;

    public DefaulSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于打开一个新的SqlSession对象
     *
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
