import thread_pool.Solution;

import java.util.Scanner;

public class Solution118 extends Solution{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nextLine = null;
        StringBuilder sb = new StringBuilder();
        while (!"".equals(nextLine = sc.nextLine())){
            sb.append(nextLine);
        }
        System.out.println();
        int[] ints = new int[10];
        int[] ints1 = new int[10];
        System.out.println(ints.equals(ints));
        int[] clone = ints.clone();
    }
}