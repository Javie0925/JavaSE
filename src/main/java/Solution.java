import sun.security.krb5.SCDynamicStoreConfig;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    /**
     * 交换数组里n和0的位置
     *
     * @param array
     *            数组
     * @param len
     *            数组长度
     * @param n
     *            和0交换的数
     */
    // 不要修改以下函数内容
    public void swapWithZero(int[] array, int len, int n) {
        int temp = array[0];
        array[0] = array[n];
        array[n] = temp;
    }
    // 不要修改以上函数内容


    /**
     * 通过调用swapWithZero方法来排
     *
     * @param array
     *            存储有[0,n)的数组
     * @param len
     *            数组长度
     */
    public void sort(int[] array, int len) {
        // 完成这个函数
        for(int i=array.length-1;i>=1;i--){
            for(int j=i;j>=1;j--){
                if(array[j]>array[0]){
                    swapWithZero(array, len, j);
                }
            }
            swapWithZero(array, len, i);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        sc.hasNext();
        while (sc.hasNext()){
            System.out.println(sc.next());
        }
    }
}


