package Demo;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author javie
 * @date 2019/7/12 22:20
 */
public class Demo {

    @Test
    public void fun(){
        ArrayList<User> users = new ArrayList<User>();
        while(true){
            users.add(new User());
        }
    }

}
