package priv.jv.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/7/3 14:34
 */
public class TransSort {

    @Test
    public void fun(){
        int[] arr = {11,21,-1,3,45,3,4,31,5,2,8,3,0,9,8,7};
        //quickSort(arr, 0, arr.length-1);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int start_, int end_){

        //结束条件
        if (start_>=end_)return;

        int base = arr[start_];
        int start = start_;
        int end = end_;
        while (start<end){
            //从右向左
            while (start<end) {
                if (arr[end] < base) {
                    arr[start] = arr[end];
                    start++;
                    break;
                } else {
                    end--;
                }
            }
            //从左向右
            while (start<end){
                if (arr[start]>base){
                    arr[end] = arr[start];
                    end--;
                    break;
                }else {
                    start++;
                }
            }
        }
        if (start==end){
            arr[start] = base;
            //递归,左边
            quickSort(arr, start_, start);
            //右边
            quickSort(arr,start+1, end_);
        }
    }

    public void bubbleSort(int[] arr){

        for (int i=arr.length-1;i>=0;i--){
            for (int j=0;j+1<=i;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
