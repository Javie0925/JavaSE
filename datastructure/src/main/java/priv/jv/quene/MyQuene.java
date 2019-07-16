package priv.jv.quene;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/7/4 20:06
 */
public class MyQuene {

    private int[] arr = new int[10];
    private int size=0;

    public void add(int i){
        // 判断长度
        if (this.size ==arr.length){
            // 长度不够，增加长度
            int[] newArr = new int[this.size *2];
            for (int j=0;j<arr.length;j++){
                newArr[j] = arr[j];
            }
            arr = newArr;
        }
        // 添加元素
        arr[size] = i;
        // 修改长度
        this.size +=1;
    }

    /**
     * 取一个元素
     * @return
     */
    public int poll(){
        if (this.size==0){
            throw new IndexOutOfBoundsException("[队列已无内容]");
        }
        int dst = arr[0];
        for (int i=0;i<size-1;i++){
            arr[i] = arr[i+1];
        }
        // 修改长度
        size -=1;
        return dst;
    }

    /**
     * 获取队列长度
     * @return
     */
    public int size(){
        return this.size;
    }

    @Override
    public String toString() {
        int[] newArr = new int[size];
        for (int i = 0; i< size; i++){
            newArr[i] = arr[i];
        }
        return Arrays.toString(newArr);
    }

    public boolean isEmpty(){
        return this.size==0;
    }
}
