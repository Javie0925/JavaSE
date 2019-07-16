package priv.jv.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/7/3 15:42
 */
public class InsertSort {

    @Test
    public void fun(){
        int[] arr = {4,3,5,6,8,2,0,9,7,1};
        System.out.println(Arrays.toString(arr));
        //insertSort(arr);
        shellSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public void insertSort(int[] arr){

        for (int i=1;i<arr.length;i++){
            int temp = arr[i];
            for (int j=i;j>=0;j--){
                if (j==0){
                    arr[0] = temp;
                    break;
                }
                if (arr[j-1]>temp){
                    arr[j] = arr[j-1];
                }else {
                    arr[j] = temp;
                    break;
                }
            }
        }
    }

    public void shellSort(int[] arr){

        for (int i=arr.length/2;i>0;i/=2){
            for (int j=i;j<arr.length;j++){
                for (int k=j;k-i>=0;k-=i){
                    if (arr[k-i]>arr[k]){
                        int temp = arr[k];
                        arr[k] = arr[k-i];
                        arr[k-i] = temp;
                    }
                }
            }
        }
    }

}
