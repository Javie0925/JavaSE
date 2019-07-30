package myThreadPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author javie
 * @date 2019/7/28 11:20
 */
public class SimpleThreadPool extends Thread{

    private int size;

    private final int queneSize;

    private static volatile int seq = 0;

    /**
     * 线程名前缀
     */
    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL";

    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    /**
     * 任务队列
     */
    private final static LinkedList<Runnable> TASK_QUENE = new LinkedList<Runnable>();

    private final static List<WorkerTask> THREAD_QUENE = new ArrayList<WorkerTask>();

    private final DiscardPolicy discardPolicy;

    private volatile boolean destory = false;

    private int min;

    private int max;

    private int active;

    /*public static final DiscardPolicy DEFAULT_DISCARD_POLICY = ()->{
        throw new DiscardException("Discard this task.");
    };*/
    public static final DiscardPolicy DEFAULT_DISCARD_POLICY = new DiscardPolicy() {
        @Override
        public void discard() throws DiscardException {
            throw new DiscardException("Discard this task.");
        }
    };

    /**
     * 默认任务队列长度
     */
    private final static int DEFAULT_TASK_QUENE_SIZE = 2000;

    public SimpleThreadPool(int min,int active,int max,int queneSize,DiscardPolicy discardPolicy) {
        this.min = min;
        this.active = active;
        this.max = max;
        this.queneSize = queneSize;
        this.discardPolicy = discardPolicy;
        init();
    }


    public SimpleThreadPool() {
        this(4,8,12,DEFAULT_TASK_QUENE_SIZE,DEFAULT_DISCARD_POLICY);
    }

    /**
     * init method
     */
    private void init() {
        for (int i=0;i<min;i++){
            createWorkerTask();
        }
        this.size = min;
        this.start();
    }
    /**
     *
     */
    private void createWorkerTask(){
        WorkerTask task = new WorkerTask(GROUP,THREAD_PREFIX+seq++);
        task.start();
        THREAD_QUENE.add(task);
    }

    public void submit(Runnable task) {
        if (destory){
            throw new IllegalStateException("Thread pool has already been isDestory.");
        }
        synchronized (TASK_QUENE){
            if (TASK_QUENE.size()>queneSize){
                System.out.println("discard this task:"+task);
                // return;
                this.discardPolicy.discard();
            }
            TASK_QUENE.addLast(task);
            TASK_QUENE.notifyAll();
        }
    }

    @Override
    public void run() {
        while(!destory){
            System.out.printf("#####Pool#Min:%d,Active:%d,Max:%d,Current:%d,QueneSize:%d#####\n",min,active,max,size,TASK_QUENE.size());
            try {
                Thread.sleep(1_000);
                if (TASK_QUENE.size()>active && size<active){ // 扩容
                    for (int i=size;i<active;i++){
                        createWorkerTask();
                    }
                    size = active;
                    System.out.println("$$$PoolSize increases to active.$$$");
                }else if (TASK_QUENE.size()>max && size<max){
                    for (int i=size;i<max;i++){
                        createWorkerTask();
                    }
                    size = max;
                    System.out.println("$$$PoolSize increases to max.$$$");
                }
                if (TASK_QUENE.isEmpty() && size>active){ // 释放线程
                    synchronized (THREAD_QUENE){
                        System.out.println("============reduce===========");
                        int releaseSize = size - active;
                        for (Iterator<WorkerTask> it = THREAD_QUENE.iterator();it.hasNext();){
                            if (releaseSize<=0)
                                break;
                            WorkerTask next = it.next();
                            if (next.getTaskState()==TaskState.BLOCKED) {
                                next.close();
                                next.interrupt();
                                it.remove();
                                releaseSize--;
                                this.size--;
                            }
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getQueneSize() {
        return queneSize;
    }

    public boolean isDestory(){
        return this.destory;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getActive() {
        return active;
    }

    /**
     * 自定义异常
     */
    public static class DiscardException extends RuntimeException{

        public DiscardException(String msg){
            super(msg);
        }
    }

    /**
     * 拒绝策略接口
     */
    public interface DiscardPolicy{
        void discard() throws DiscardException;
    }

    /**
     * 关闭线程池方法
     * @throws InterruptedException
     */
    public void shutDown() throws InterruptedException {
        while (!TASK_QUENE.isEmpty()){
            Thread.sleep(50);
        }
        synchronized (THREAD_QUENE) {
            int initVal = THREAD_QUENE.size();
            while (initVal > 0) {
                for (WorkerTask task : THREAD_QUENE) {
                    TaskState taskState = task.getTaskState();
                    task.getName();
                    if (task.getTaskState() == TaskState.BLOCKED) {
                        task.interrupt();
                        task.close();
                        initVal--;
                    } else {
                        Thread.sleep(10);
                    }
                }
            }
            this.destory = true;
            System.out.println("Thread pool disposed.");
        }
    }

    /**
     * 任务状态枚举类
     */
    private enum TaskState{
        FREE,RUNNING,BLOCKED,DEAD

    }

    /**
     * 自定义线程
     * 定义成private为了不让外界知道
     */
    private static class WorkerTask extends Thread{

        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup threadGroup,String name){

            super(threadGroup,name);
        }

        public TaskState getTaskState() {
            return taskState;
        }

        public void close(){
            this.taskState = TaskState.DEAD;
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState!=TaskState.DEAD){
                Runnable task = null;
                synchronized (TASK_QUENE){
                    while (TASK_QUENE.isEmpty()){ // 任务队列为空
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUENE.wait();
                        } catch (InterruptedException e) {
                            System.out.println("-------------->closed.<---------------");
                            break OUTER;
                        }
                    }
                    // 任务队列不为空，一个任务开始执行，并从任务列表中移除
                    task = TASK_QUENE.removeFirst();
                }
                if (task!=null){
                    taskState = TaskState.RUNNING;
                    task.run();
                    taskState = TaskState.FREE;
                }

            }

        }
    }

    public static void main(String[] args) {
        SimpleThreadPool threadPool = new SimpleThreadPool();
        for (int i=0;i<40;i++){
            int b = i;
            try {
                threadPool.submit(() -> {
                    System.out.println("task [" + b + "] served by " + Thread.currentThread() + " start.");
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("task [" + b + "] served by " + Thread.currentThread() + " finish.");
                });
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            Thread.sleep(5_000);
            threadPool.shutDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
