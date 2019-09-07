package mapper;

import domain.User;

import java.util.List;

/**
 * @author javie
 * @date 2019/8/19 17:02
 */
public interface UserMapper {

    List<User> findAll();
}
