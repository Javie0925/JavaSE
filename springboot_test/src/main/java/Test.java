import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Date;

/**
 * @author javie
 * @个人网站: http://jvblog.nat100.top
 * @date 2020/3/28 23:15
 */
public class Test {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setName("jv");
        user.setAge(25);
        user.setBirthday(new Date());
        user.setGender("male");
        String json = mapper.writeValueAsString(user);
        System.out.println(json);
        System.out.println("----------------------");
        User user1 = mapper.readValue(json, User.class);
        System.out.println(user);

    }
}
