

import priv.jv.dao.UserDao;
import priv.jv.domain.User;
import priv.jv.mybatis.io.Resources;
import priv.jv.mybatis.sqlsession.SqlSession;
import priv.jv.mybatis.sqlsession.SqlSessionFactory;
import priv.jv.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author javie
 * @date 2019/8/19 11:02
 */
public class TestMybatis {

    public static void main(String[] args) throws Exception {

        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(stream);

        SqlSession session = factory.openSession();

        UserDao mapper = session.getMapper(UserDao.class);
        List<User> list = mapper.findAll();
        list.forEach(u->{
            System.out.println(u);
        });
    }
}
