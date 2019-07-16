package priv.jv;

import org.junit.Test;

/**
 * @author javie
 * @date 2019/7/2 18:20
 */
public class HanoiTower {

    @Test
    public void fun(){
        hanoi(3,'A','B','C');
    }

    public void hanoi(int n,char from,char in,char to){
        if (n==1){
            System.out.println(from+"→"+to);
        }else if (n==2){
            System.out.println(from+"→"+to+","+from+"→"+in+","+to+"→"+from+","+in+"→"+to+","+from+"→"+to);
        }else{
            hanoi(n-1,from,to,in);
            System.out.println(from+"→"+to);
            hanoi(n-1, in, from, to);
        }
    }

}
