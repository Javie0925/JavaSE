package priv.jv.sort2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/7/22 15:12
 */
public class BubbleSort {

    @Test
    public void fun(){
        int[] arr = {98,4,3,6,7,9,1};
        //bubbleSort(arr);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void bubbleSort(int[] arr){

        for(int i=arr.length-1;i>=0;i--){
            for(int j=1;j<=i;j++){
                if (arr[j-1]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public void quickSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            int start = i+1;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[i]){
                    if (start == i){
                        start ++ ;
                    }else{
                        int temp = arr[start];
                        arr[start] = arr[j];
                        arr[j] = temp;
                        start++;
                    }
                }
            }
            int temp = arr[start-1];
            arr[start-1] = arr[i];
            arr[i] = temp;
        }
    }

}
