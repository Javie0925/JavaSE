package priv.jv;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

/**
 * @author javie
 * @date 2019/7/26 14:22
 */
public class Demo0726 {

    public static void main(String[] args) throws InterruptedException {


        String str = "9";
        switch (str){
            case "1":
                System.out.println(1);
            case "2":
                System.out.println(2);
            case "3":
                System.out.println(3);
            case "4":
                System.out.println(4);
                break;
            case "5":
                System.out.println(5);
            default:
                System.out.println("default");
        }
    }
}
