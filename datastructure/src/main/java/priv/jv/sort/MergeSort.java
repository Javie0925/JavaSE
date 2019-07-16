package priv.jv.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/7/3 19:00
 */
public class MergeSort {

    @Test
    public void fun(){
        int[] arr = {4,3,5,6,8,2,0,9,7,1};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr,int s,int e){

        if (s==e)return;
        int mid = (s+e)/2;
        int start_ = mid+1;
        int start = s;
        int end = e;
        // 左边归并
        mergeSort(arr,start,mid);
        // 右边
        mergeSort(arr, start_, end);
        // 排序
        int[] newArr = new int[e-s+1];
        for (int i=0;i<=e-s;i++){
            // 左边取完
            if (start>mid){
                for (int j=start_;j<=end;j++){
                    newArr[i] = arr[j];
                    i++;
                }
                break;
            }
            // 右边取完
            if (start_>end){
                for (int j=start;j<=mid;j++){
                    newArr[i] = arr[j];
                    i++;
                }
                break;
            }
            // 左边大于右边
            if (arr[start]>arr[start_]){
                newArr[i] = arr[start_];
                start_++;
                continue;
            }
            // 右边大于左边
            if (arr[start_]>arr[start]){
                newArr[i] = arr[start];
                start++;
            }
        }
        for (int i=0;i<newArr.length;i++){
            arr[s]=newArr[i];
            s++;
        }

    }
}
