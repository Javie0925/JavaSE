package priv.jv.huffmantree;

import org.junit.Test;

import javax.swing.*;
import java.util.*;

/**
 * @author javie
 * @date 2019/7/6 19:48
 */
public class HuffmanTree {

    @Test
    public void fun(){
        int[] arr = {45,21,6,0,1,5,13,52,90};
        System.out.println(Arrays.toString(arr));
        createHuffmanTree(arr);
    }

    public void createHuffmanTree(int[] arr){

        //创建集合用来保存结点
        List<Node> nodeList = new ArrayList<Node>();

        //将数组中的数变成结点
        for (int i=0;i<arr.length;i++){
            nodeList.add(new Node(arr[i]));
        }
        // 循环处理
        while (nodeList.size()>1){
            // 排序
            Collections.sort(nodeList);
            // 取出值最小的两个,创建新结点
            Node newNode = new Node(nodeList.get(0).getData() + nodeList.get(1).getData());
            newNode.setLeftNode(nodeList.remove(0));
            newNode.setRightNode(nodeList.remove(0));
            // 加入新结点
            nodeList.add(newNode);
        }
            System.out.println(nodeList);

    }



    public void sort(int[] arr){
        this.sort(arr, 0, arr.length-1);
    }

    /**
     * 归并排序
     */

    public void sort(int[] arr,int start,int end){
        //结束条件
        if (start>=end)
            return;
        int mid = (end+start)/2;
        int _start = start;
        int start_ = mid+1;
        //左边归并
        sort(arr, start, mid);
        //右边归并
        sort(arr, mid+1, end);
        //两边排序
        int[] newArr = new int[end - start + 1];
        int i=0;
        for(;_start<=mid && start_<=end;){
            if (arr[_start]<arr[start_]){
                newArr[i] = arr[_start];
                i++;
                _start++;
            }else {
                newArr[i] = arr[start_];
                i++;
                start_++;
                while (_start<=mid && start_<=end){
                    if (arr[_start]>arr[start_]){
                        newArr[i] = arr[start_];
                        i++;
                        start_++;
                    }else {
                        newArr[i] = arr[_start];
                        _start++;
                        i++;
                        break;
                    }
                }
            }
        }
        // 将剩余的数据装进newArr
        if (_start>mid){
            for (int j=start_;j<=end;j++){
                newArr[i++]=arr[j];
            }
        }
        if (start_>end){
            for (int j=_start;j<=mid;j++){
                newArr[i++]=arr[j];
            }
        }
        // 将newArr数据装到arr
        for (int j=0;j<newArr.length;j++){
            arr[start++] = newArr[j];
        }
    }
}
