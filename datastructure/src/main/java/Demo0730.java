import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

/**
 * @author javie
 * @date 2019/7/30 14:53
 */
public class Demo0730 {

    public static final boolean flag = false;

    private String name;

    private int age;

    private String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

