package priv.jv.stack;

/**
 * 栈类
 * @author javie
 * @date 2019/7/10 17:17
 */
public class MyStack {

    private int[] arr = new int[10];

    private int size;

    /**
     * 进栈方法
     */
    public void push(int value){
        // 判断数组长度
        if (size==arr.length){ //长度用尽，扩展长度
            int[] newArr = new int[size * 2];
            for (int i=0;i<size;i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        // 将数据压入栈顶
        arr[size++] = value;
    }

    /**
     * 出栈方法
     */
    public int pop(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("此栈已经为空");
        }
        int value = arr[size-1];
        size--;
        return value;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public int peek(){
        return arr[size-1];
    }

    /**
     * 查看栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 查看栈大小
     * @return
     */
    public int size(){
        return size;
    }
}
