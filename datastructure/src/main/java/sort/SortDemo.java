package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author javie
 * @date 2019/9/7 14:28
 */
public class SortDemo {

    private static int[][] arrs = new int[10][10];

    static {
        Random random = new Random(System.currentTimeMillis());
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                arrs[i][j] = random.nextInt(10);
            }
        }
    }

    public static void main(String[] args) {

        for (int i=0;i<10;i++){
            System.out.print(Arrays.toString(arrs[i])+"    >>>    ");
            // Sort.bubbleSort(arrs[i]);
            // Sort.quickSort(arrs[i],0,arrs[i].length);
            // Sort.simpleInsertSort(arrs[i]);
            // Sort.shellSort(arrs[i]);
            // Sort.selecttionSort(arrs[i]);
            // Sort.heapSort(arrs[i]);
            // Sort.mergeSort(arrs[i],0,arrs[i].length);
            Sort.radixSort(arrs[i]);
            System.out.println(Arrays.toString(arrs[i]));
        }
    }

}
