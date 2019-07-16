package jconsole;

import java.util.ArrayList;

/**
 * @author javie
 * @date 2019/7/13 21:47
 */
public class TestJConsole {

    public static void main(String[] args) {

        fill(1000);
    }

    private static void fill(int i) {
        ArrayList<String> list = new ArrayList<String>();
        for (int j=0;i<=i;i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add("hello world!");

        }
    }
}
