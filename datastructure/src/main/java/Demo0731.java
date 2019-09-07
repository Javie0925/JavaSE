import java.util.StringTokenizer;

/**
 * @author javie
 * @date 2019/7/31 10:31
 */
public abstract class Demo0731 extends Demo0730 {

    boolean flag;

    public boolean getFlag(){
        return super.flag;
    }

    public void hello(){
        new Thread(()->{
            this.getClass().getSuperclass();
            System.out.println("hello");
        }, "hello").start();
    }
}

class Test{
    public static void main(String[] args) {
        // Demo0731 demo0731 = new Demo0731();
        StringTokenizer tokener = new StringTokenizer("ksldfjl,ksadjf",",");
        String s = tokener.nextToken();
        tokener.countTokens();
    }
}