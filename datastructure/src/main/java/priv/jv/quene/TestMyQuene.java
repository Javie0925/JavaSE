package priv.jv.quene;

import org.junit.Test;

/**
 * @author javie
 * @date 2019/7/4 20:39
 */
public class TestMyQuene {

    @Test
    public void fun(){

        MyQuene myQuene = new MyQuene();
        myQuene.poll();
        myQuene.add(1);
        myQuene.add(5);
        myQuene.add(6);
        myQuene.add(2);
        System.out.println(myQuene);
        System.out.println(myQuene.poll());
        System.out.println(myQuene);
    }
}
