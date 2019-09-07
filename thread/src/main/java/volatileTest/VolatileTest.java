package volatileTest;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author javie
 * @date 2019/7/29 22:04
 */
public class VolatileTest {

    private  static int INIT_VALUE=0;
    private final static int MAX_LIMIT = 50;

    public static void main(String[] args) {
        new Thread(()->{
            int localValue = INIT_VALUE;
            while (localValue<MAX_LIMIT){
                if (localValue!=INIT_VALUE){
                    System.out.printf("The localValue update to [%d]\n",INIT_VALUE);
                    localValue = INIT_VALUE;
                }else {
                    System.out.println("localValue: "+localValue+",INIT_VALUE: "+INIT_VALUE);
                }
            }
        },"READ").start();
        new Thread(()->{
            int localValue = INIT_VALUE;
            while (localValue<MAX_LIMIT){
                System.out.printf("Update the localValue  to [%d]\n",++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"UPDATE").start();
    }
}
