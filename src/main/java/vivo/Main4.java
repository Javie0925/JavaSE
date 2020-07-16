package vivo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Welcome to vivo !
 * 运矿
 */

public class Main4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
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

    private static int solution(int[] input) {

        // TODO Write your code here
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<input.length;i++){
            if (!list.contains(input[i])){
                list.add(input[i]);
            }
        }
        Collections.sort(list);
        while (list.size()>2){
            int min = list.get(1)-list.get(0);
            int pos = 1;
            int size = list.size();

            for (int i=2;i<size;i++){
                if (list.get(i)-list.get(i-1)<min){
                    pos = i;
                }
            }
            int remove = list.remove(pos);
            int remove1 = list.remove(pos - 1);
            int res = Math.abs(remove-remove1);
            if (res>0)
                list.add(res);
            Collections.sort(list);
        }
        int abs = Math.abs(list.get(1) - list.get(0));
        if (abs==1){
            return 1;
        }else {
            return abs-1;
        }
    }
}