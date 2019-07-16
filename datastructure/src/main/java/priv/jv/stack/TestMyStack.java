package priv.jv.stack;

import org.junit.Test;

/**
 * @author javie
 * @date 2019/7/10 17:31
 */
public class TestMyStack {

    @Test
    public void fun(){
        MyStack stack = new MyStack();
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
