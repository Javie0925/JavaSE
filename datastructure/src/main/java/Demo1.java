import org.junit.Test;
import priv.jv.Solution;
import sun.nio.cs.ISO_8859_2;
import sun.nio.cs.US_ASCII;
import sun.nio.cs.ext.Big5;
import sun.nio.cs.ext.GB18030;
import sun.nio.cs.ext.GBK;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * @author javie
 * @date 2019/7/13 16:13
 */
public class Demo1 {

    Object obj = null;

    @Test
    public void fun() {
        Demo1 demo1 = new Demo1();
        Demo1 demo2 = new Demo1();

        demo1.obj = demo2;
        demo2.obj = demo1;

        demo1 = null;
        demo2 = null;

        "".getBytes();
        System.out.println(false||true);
    }

    public void add() {
        int i = 100086;
        add();
    }
    public void add1() {
        int i = 100086;
        add();
    }
}
