package vivo;

import java.util.Scanner;

/**
 * @author javie
 * @date 2019/9/22 16:14
 */
public class Main {

    private static int sum = 0;
    private static int steps = 0;

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            sum = 0;
            steps = 0;
            min = Integer.MAX_VALUE;
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int[] ints = new int[split.length];
            for (int i=0;i<split.length;i++){
                ints[i] = Integer.parseInt(split[i]);
            }
            go(ints, 0);
            System.out.println(min);
        }
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
