package priv.jv.dao;

import priv.jv.annotation.Select.Select;
import priv.jv.domain.User;

import java.util.List;

/**
 * @author javie
 * @date 2019/8/19 14:57
 */
public interface UserDao {

    @Select("select * from user")
    List<User> findAll();
}
