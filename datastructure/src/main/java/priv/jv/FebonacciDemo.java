package priv.jv;

import com.sun.istack.internal.NotNull;
import javafx.beans.DefaultProperty;
import org.junit.Test;

/**
 * @author javie
 * @date 2019/7/2 17:46
 */
public class FebonacciDemo {

    @Test
    public void fun(){
        System.out.println(febonacci_(20));
    }

    public void febonacci(int n1, int n2){
        if (n2>1000)return;
        System.out.println(n2);
        febonacci(n2, n1+n2);
    }

    /**
     * 返回第i项值
     * @param i
     */
    public int febonacci_(int i){
        if (i==1||i==2){
            return 1;
        }
        return febonacci_(i-1)+febonacci_(i-2);
    }

}
