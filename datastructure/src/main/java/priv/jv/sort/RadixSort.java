package priv.jv.sort;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;
import priv.jv.quene.MyQuene;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/7/3 21:43
 */
public class RadixSort {

    @Test
    public void fun(){
        int[] arr = {344,23985,324,12,6,879,123,90};
        System.out.println(Arrays.toString(arr));
        radixSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void radixSort(int[] arr){

        //获取最大数
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        // 判断最大数的位数
        int len = (max+"").length();
        // 创建二维数组
        int[][] __arr = new int[10][arr.length];
        // 创建一维数组存储二维数组长度
        int[] _arr = new int[10];
        // 进行排序
        // 外循环控制基数排序次数
        for(int i = 0;i<len;i++){
            // 存入二维数组
            for (int j=0;j<arr.length;j++){
                int num = (int) ((arr[j]/(Math.pow(10.0, 0.1+i-0.1)))%10);
                System.out.println("num:"+num);
                __arr[num][_arr[num]]=arr[j];
                _arr[num] +=1;
            }
            // 打印
            System.out.println("###############");
            System.out.println("_arr:"+Arrays.toString(_arr));
            for (int s=0;s<10;s++){
                System.out.println(s+":"+Arrays.toString(__arr[s]));
            }
            // 从二维数组中取出
            int m = 0; // 标记arr位置
            for (int k=0;k<10;k++){
                for (int n=0;n<_arr[k];n++){
                    arr[m] = __arr[k][n];
                    m++;
                }
            }
            System.out.println("第"+i+"次："+Arrays.toString(arr));
            // 将_arr清零
            _arr = new int[10];
        }

        return;
    }

    /**
     * 基数排序改进版
     * @param arr
     */
    public void radixSort2(int[] arr){

        //获取最大数
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        // 判断最大数的位数
        int len = (max+"").length();
        // 创建队列数组
        MyQuene[] queneArr = new MyQuene[10];
        // 初始化队列
        for (int i=0;i<queneArr.length;i++){
            queneArr[i] = new MyQuene();
        }
        // 进行排序
        // 外循环控制基数排序次数
        for(int i = 0;i<len;i++){
            // 存入队列数组
            for (int j=0;j<arr.length;j++){
                int num = (int) ((arr[j]/(Math.pow(10.0, 0.1+i-0.1)))%10);
                System.out.println("num:"+num);
                queneArr[num].add(arr[j]);
                System.out.println(queneArr[num]);
            }
            // 打印
            System.out.println("###############");
            for (int s=0;s<10;s++){
                System.out.println(s+":"+queneArr[s]);
            }
            // 从二维数组中取出
            int m = 0; // 标记arr位置
            for (int k=0;k<10;k++){
                while (!queneArr[k].isEmpty()){
                    arr[m] = queneArr[k].poll();
                    m++;
                }
            }
            System.out.println("第"+i+"次："+Arrays.toString(arr));
        }

        return;
    }
}
