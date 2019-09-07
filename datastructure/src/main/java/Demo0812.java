
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author javie
 * @date 2019/8/13 0:21
 */
public class Demo0812 {

    private int count = 0;

    @Test
    public void main()  {

        int[] arr = new int[1];
        hello(arr);
        System.out.println(arr[0]);
    }

    public void hello(int[] arr){
        if (count++>1000)
            return;
        arr[0] += 1;
        hello(arr);
        arr[0] -= 1;
    }
}
