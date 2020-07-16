package vivo;

import java.io.*;
import java.util.ArrayList;

/**
 * Welcome to vivo !
 * 排队分配员工号
 */

public class Main2 {

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
        StringBuilder sb = new StringBuilder();
        int total = input[0];
        int num = input[1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1;i<=total;i++){
            list.add(i);
        }
        int cur = 0;
        while (!list.isEmpty()){
            int size = list.size();
            cur += num;
            if (cur<=size){
                Integer remove = list.remove(cur-1);
                sb.append(remove.toString()+" ");
                cur -= 1;
                if (cur<=0){
                    cur = list.size();
                }
            }else{
                cur = cur%size;
                if (cur==0){
                    cur = size;
                }
                Integer remove = list.remove(cur - 1);
                sb.append(remove.toString()+" ");
                cur -= 1;
                if (cur<=0){
                    cur = list.size();
                }
            }
        }
        return sb.toString().trim();
    }

}