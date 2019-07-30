import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author javie
 * @date 2019/7/29 9:57
 */
public class Demo0729 {
    @Test
    public void fun(){
        BigDecimal decimal = new BigDecimal(99l);
        BigDecimal decimal2 = new BigDecimal(99.1);
        BigDecimal divide = decimal.divide(decimal2);
        System.out.println(divide);
        double d = 9d;
        Stack<Object> stack = new Stack<>();
        stack.empty();
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        ArrayList<Object> list = new ArrayList<>();
//        Arrays.asList()
//        list.toArray()
//                list.indexOf()
        ReentrantLock reentrantLock = new ReentrantLock();
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        new Object();
    }
}
