package sort;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/9/7 14:23
 */
public class Sort {

    /**
     * 1.冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for (int i=arr.length-1;i>=1;i--){
            for (int j=1;j<=i;j++){
                if (arr[j-1]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    /**
     * 2.快速排序
     * @param arr
     * @param from
     * @param to
     */
    public static void quickSort(int[] arr,int from,int to){

        // 递归结束条件
        if(from+1>=to || to > arr.length){
            return;
        }
        // 分界
        int mid = from+1;
        for(int i=mid;i<to;i++){
            if (arr[i]<arr[from]){
                if (i==mid){
                    mid++;
                    continue;
                }else {
                    int temp = arr[i];
                    arr[i] = arr[mid];
                    arr[mid] = temp;
                    mid++;
                }
            }
        }
        int temp = arr[from];
        arr[from] = arr[mid-1];
        arr[mid-1] = temp;
        // 递归左边
        quickSort(arr,from,mid);
        // 递归右边
        quickSort(arr,mid,to);
    }

    /**
     * 3.简单插入排序
     * @param arr
     */
    public static void simpleInsertSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            if (arr[i]>=arr[i-1])
                continue;
            for (int j=i;j>0;j--){
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    /**
     * 4.希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr){
        for(int i=arr.length/2;i>0;i/=2){
            for (int j=i;j<arr.length;j+=i){
                if (arr[j]<arr[j-i]){
                    for (int k=j;k-i>=0;k-=i){
                        if (arr[k]<arr[k-i]){
                            int temp = arr[k];
                            arr[k] = arr[k-i];
                            arr[k-i] = temp;
                        }
                    }
                }
            }
        }
    }

    /**
     * 5.选择排序
     * @param arr
     */
    public static void selecttionSort(int[] arr){

        for (int i=0;i<arr.length-1;i++){
            int min = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[min]){
                    min = j;
                }
            }
            if (min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 6.堆排序
     * @param arr
     */
    public static void heapSort(int[] arr){

        for (int i=arr.length-1;i>0;i--){

            for (int j=i;j>0;){
                int parent = (j-1)/2;
                int left = parent*2+1;
                int right = parent*2+2;
                if (arr[left]>arr[parent]){
                    int temp = arr[left];
                    arr[left] = arr[parent];
                    arr[parent] = temp;
                }
                if (right<=j && arr[right]>arr[parent]){
                    int temp = arr[right];
                    arr[right] = arr[parent];
                    arr[parent] = temp;
                }
                j = parent*2;
            }

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 7.归并排序
     * @param arr
     * @param from
     * @param to
     */
    public static void mergeSort(int[] arr,int from,int to){

        if (from+1>=to){
            return;
        }

        int mid = (from+to)/2;
        // 左边排序
        mergeSort(arr,from ,mid);
        // 右边排序
        mergeSort(arr,mid,to);
        // 归并整理
        int[] nArr = new int[to-from];
        int len = 0;
        int i1 = from,i2 = mid;
        while ( i1<mid && i2<to ){
            if (arr[i1]<arr[i2]){
                nArr[len++] = arr[i1++];
            }else{
                nArr[len++] = arr[i2++];
            }
        }
        if (i1==mid){
            for (int i=i2;i<to;i++){
                nArr[len++] = arr[i];
            }
        }else {
            for (int i=i1;i<mid;i++){
                nArr[len++] = arr[i];
            }
        }
        for (int i=from,j=0;j<nArr.length;i++,j++){
            arr[i] = nArr[j];
        }
    }

    /**
     * 8.基数排序
     * @param arr
     */
    public static void radixSort(int[] arr){
        int[][] arrs = new int[10][arr.length];
        int[] count = new int[10];
        // 找到最大的数
        int max = Integer.MIN_VALUE;
        for (int i:arr){
            max = Math.max(max, i);
        }
        // 确定最大位数
        int len = (max+"").length();
        for (int i=0;i<len;i++){
            // 放入
            for (int j=0;j<arr.length;j++){
                int radis = (arr[j]/((int)Math.pow(10, i)))%10;
                arrs[radis][count[radis]++] = arr[j];
            }
            // 取出
            int len2 = 0;
            for (int k=0;k<arrs.length;k++){
                for (int l=0;l<count[k];l++){
                    arr[len2++] = arrs[k][l];
                }
            }
        }
    }
}
