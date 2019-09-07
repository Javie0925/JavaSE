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
        // selectSort(arr);
        heap(arr);
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
    // 堆排序
    public void heap(int[] arr){

        for (int i=arr.length-1;i>0;i--){
            heapSort(arr,(i-1)/2,i);
        }
    }

    public void heapSort(int[] arr,int index,int end){

        for (;index>=0;index--){
            heapSort_(arr,index,end);
        }
        System.out.println("before:"+Arrays.toString(arr));
        int temp = arr[0];
        arr[0] = arr[end];
        arr[end] = temp;
        System.out.println("after: "+Arrays.toString(arr));
    }

    public void heapSort_(int[] arr,int index,int end){
        int left = 2*index+1;
        int right = 2*index+2;
        if (arr[left]>arr[index]){
            int temp = arr[index];
            arr[index] = arr[left];
            arr[left] = temp;
        }
        if (right<=end && arr[right]>arr[index]){
            int temp = arr[index];
            arr[index] = arr[right];
            arr[right] = temp;
        }
    }
}
