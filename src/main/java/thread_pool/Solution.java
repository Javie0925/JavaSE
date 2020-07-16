package thread_pool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author javie
 * @date 2019/9/10
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer> lastLine = new ArrayList<>();
        for(int i=0;i<6;i++){
            // 打印空格
            for (int j=5;j-i>0;j--){
                System.out.print(" ");
            }
            // 打印数字
            if (i==0){
                System.out.println(1);
            }else if (i==1){
                System.out.println("1 1");
                lastLine.add(1);
                lastLine.add(1);
            }else{
                List<Integer> thisLine = new ArrayList<>();
                for (int k=0;k<=i;k++){
                    if (k==0){
                        System.out.print("1 ");
                        thisLine.add(1);
                    }else if(k==i){
                        System.out.println("1");
                        thisLine.add(1);
                        lastLine = thisLine;
                    }else{
                        int thisInt = lastLine.get(k-1) + lastLine.get(k);
                        System.out.print(thisInt+" ");
                        thisLine.add(thisInt);
                    }
                }
            }
        }
    }

    protected int getInt(){
        return 6;
    }
}
