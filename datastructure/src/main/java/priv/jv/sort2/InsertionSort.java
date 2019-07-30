package priv.jv.sort2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/7/22 15:53
 */
public class InsertionSort {

    @Test
    public void fun(){
        int[] arr = {5,2,4,1,0,9,7,3,8};
        //insertionSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // 简单插入排序
    public void insertionSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int k = i;
            for (int j=i-1;j>=0;j--){
                if (arr[j]>arr[k]){
                    int temp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = temp;
                    k--;
                }else{
                    break;
                }
            }
        }
    }

    // 希尔排序
    public void shellSort(int[] arr){
        for (int i=arr.length/2;i>0;i/=2){
            for(int j=i;j<arr.length;j++){
                for (int l=j,k=l-i;k>=0;l=k,k-=i){
                    if (arr[k]>arr[l]){
                        int temp = arr[k];
                        arr[k] = arr[l];
                        arr[l] = temp;
                    }else{
                        break;
                    }
                }

            }
        }
    }
}
