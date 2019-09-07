package work_thread;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/7/31 23:41
 */
public class Channel {

    private final static int MAX_REQUEST = 100;

    private final Request[] requestQuene;

    private int head;

    private int tail;

    private int count;

    private final WorkerThread[] workerPool;

    public Channel(int workers) {
        this.requestQuene = new Request[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        this.workerPool = new WorkerThread[workers];
        this.init();
    }

    private void init() {
        for (int i=0;i<workerPool.length;i++){
            workerPool[i] = new WorkerThread("Worker - "+i,this);
        }
    }

    /**
     * push switch to start all of workers to work.
     */
    public void startWorker(){
        Arrays.asList(workerPool)
                .forEach(WorkerThread::start);
    }

    public synchronized void put(Request request){
        while (this.count>MAX_REQUEST) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.requestQuene[tail] = request;
        this.tail = (tail+1)%requestQuene.length;
        this.count++;
        this.notifyAll();
    }

    public synchronized Request take(){
        while (this.count<=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            Request request = this.requestQuene[head];
            this.head = (head+1)%requestQuene.length;
            this.count--;
            this.notifyAll();
            return request;
    }
}
