package priv.jv.mybatis.sqlsession;

/**
 * @author javie
 * @date 2019/8/19 12:18
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
