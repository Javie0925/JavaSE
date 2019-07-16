package priv.jv.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/7/5 20:47
 */
public class HeapSort {

    @Test
    public void fun(){
        int[] arr={4,7,8,3,2,0,1,22,33,81,90};
        System.out.println(Arrays.toString(arr));
        for (int k=arr.length;k>1;k--) {
            // 排序
            for (int i = (arr.length - 1) / 2; i >= 0; i--) {
                maxHeap(arr,k,i);
            }
            // 交换位置
            int max = arr[0];
            arr[0] = arr[k-1];
            arr[k-1] = max;
        }
        System.out.println(Arrays.toString(arr));

    }

    public void maxHeap(int[] arr,int size,int i){
        // 左子结点
        int leftNode = 2*i+1;
        // 右子结点
        int rightNode = 2*i+2;
        // 比较左结点
        if (leftNode<size&&arr[i]<arr[leftNode]){
            int temp = arr[i];
            arr[i] = arr[leftNode];
            arr[leftNode] = temp;
            // 子树重新排序
            if (2*leftNode+1<size){
                maxHeap(arr, size, leftNode);
            }
        }
        // 比较右子结点
        if (rightNode<size && arr[rightNode]>arr[i]){
            int temp = arr[i];
            arr[i] = arr[rightNode];
            arr[rightNode] = temp;
            // 子树重新排序
            if (2*rightNode+2<size){
                maxHeap(arr,size, rightNode);
            }
        }

    }
}
