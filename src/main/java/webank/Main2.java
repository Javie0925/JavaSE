package webank;

import java.util.Scanner;

/**
 * @author javie
 * @date 2019/9/19 16:39
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int result = 1;
            for (int i=1;i<=n;i++){
                result *= i;
            }
            System.out.println((int)(result%(Math.pow(10, 6)+3)));
        }
    }
}
