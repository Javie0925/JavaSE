package vivo;

import java.io.*;

/**
 * Welcome to vivo !
 * 跳箱子
 */

public class Main1 {

    private static int sum = 0;
    private static int steps = 0;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static String solution(int[] input) {

        // TODO Write your code here
        sum = 0;
        steps = 0;
        min = Integer.MAX_VALUE;
        go(input, 0);
        if (min == Integer.MAX_VALUE){
            min = -1;
        }
        return min+"";
    }
    public static void go(int[] ints,int pos){

        if (ints[pos]==0){
            return;
        }

        if (pos>=ints.length){
            return;
        }
        if (pos+1==ints.length){
            min = Math.min(min, steps);
            return;
        }
        if (sum+ints[pos]>=ints.length-1){

            min = Math.min(min, steps+1);
            return;
        }

        for (int j=1;j<=ints[pos];j++){
            steps++;
            sum += j;
            go(ints, pos+j);
            steps--;
            sum -= j;
        }

    }

}