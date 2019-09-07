package priv.jv.sort2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/8/12 23:41
 */
public class MergeSort {

    @Test
    public void main() {
        int[] arr = {5,3,2,8,0,4,1,9,-1,89,87,32,56,12,21};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr){
        mergeSort_(arr, 0, arr.length-1);
    }

    public void mergeSort_(int[] arr,int from,int to){
        if (to-from==1){
            if (arr[from]>arr[to]){
                int temp = arr[from];
                arr[from] = arr[to];
                arr[to] =temp;
                return;
            }
        }
        if (from>=to)
            return;
        int mid = (from+to)/2;
        // 左半部分排序
        mergeSort_(arr,from,mid);
        // 右半部分排序
        mergeSort_(arr, mid+1, to);
        // 整合
        int[] tempArr = new int[to-from+1];
        int index = 0;
        for (int i=from,j=mid+1;i<=mid && j<=to;){
            if (arr[i]<=arr[j]){
                tempArr[index++] = arr[i++];
            }else{
                tempArr[index++] = arr[j++];
            }
            if (j>to){
                while(i<=mid){
                    tempArr[index++] = arr[i++];
                }
            }else if (i>mid){
                while (j<=to){
                    tempArr[index++] = arr[j++];
                }
            }
        }
        index -= 1;
        while (from<=to){
            arr[to--] = tempArr[index--];
        }
    }
}
