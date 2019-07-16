package priv.jv.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author javie
 * @date 2019/7/3 17:19
 */
public class SelectSort {

    @Test
    public void fun(){
        int[] arr = {4,3,5,6,8,2,0,9,7,1};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void selectSort(int[] arr){

        for (int i=0;i<arr.length;i++){

            int min = i;

            //找到最小值
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[min]){
                    min = j;
                }
            }
            // 换位
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
    }
}
