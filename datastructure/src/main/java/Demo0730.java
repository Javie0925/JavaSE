import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

/**
 * @author javie
 * @date 2019/7/30 14:53
 */
public class Demo0730 {

    @Test
    public void fun(){
        Object o = new Object();
        try {
                 Object clone = this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}

