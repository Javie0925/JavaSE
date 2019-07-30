package priv.jv.sort2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/7/29 17:42
 */
public class SelectSort {

    @Test
    public void test(){
        int[] arr = {5,3,2,8,0,4,1,9};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void selectSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            int min = i;
            for (int j=i+1;j<arr.length;j++){
                min = arr[j]<arr[min]?j:min;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
