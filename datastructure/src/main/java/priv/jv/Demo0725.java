package priv.jv;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author javie
 * @date 2019/7/25 19:37
 */
public class Demo0725 {

    @Test
    public void fun() throws ExecutionException, InterruptedException {
        int taskSize = 15;
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
         List<Future> list = new ArrayList<Future>();
         for (int i = 0; i < taskSize; i++) {
             Callable c = new MyCallable(i + " ");
             // 执行任务并获取Future对象
             Future f = pool.submit(c);
             list.add(f);
         }
         // 关闭线程池
        pool.shutdown();
         // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println("res：" + f.get().toString());
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        int[] ints = new int[10];

    }

    public class MyCallable implements Callable{

        private String msg;

        public MyCallable(String msg){
            this.msg = msg;
        }

        @Override
        public Object call() throws Exception {
            return msg;
        }
    }
}
