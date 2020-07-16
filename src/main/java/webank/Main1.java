package webank;

import java.util.Scanner;

/**
 * @author javie
 * @date 2019/9/19 16:39
 * 1 2 6 24 120 720 5040 40320 362880 3628800 39916800
 * 1 2 3  4  5   6   7     8      9      10       11
 * 1 2 6 4 2 2 4 2 8 8 8 6 8
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int result = 1;
            for (int j=2;j<=n;j++){
                result = getLast(result*j+"");
            }
            System.out.println(result);
        }
    }

    public static int getLast(String s){

        for (int i=s.length()-1;i>=0;i--){
            if ('0'!=s.charAt(i)){
                return Integer.parseInt(s.substring(i, i+1));
            }
        }
        return 0;
    }
}
