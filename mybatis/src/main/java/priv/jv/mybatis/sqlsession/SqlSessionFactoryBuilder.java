package priv.jv.mybatis.sqlsession;

import priv.jv.mybatis.cfg.Configuration;
import priv.jv.mybatis.sqlsession.defalut.DefaulSqlSessionFactory;
import priv.jv.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author javie
 * @date 2019/8/19 12:16
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据字节输入流来构建一个SqlSessionFactory
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){

        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);

        return new DefaulSqlSessionFactory(cfg);
    }

}
