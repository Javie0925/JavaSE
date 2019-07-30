package read_write_lock;

/**
 * @author javie
 * @date 2019/7/30 17:57
 */
public class ReaderWorker extends Thread {
    private final SharedData data;

    public ReaderWorker(SharedData data){
        this.data = data;
    }

    @Override
    public void run() {

        try {
            while (true) {
                char[] readBuff = data.read();
                System.out.println(Thread.currentThread().getName()+" reads "+String.valueOf(readBuff));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
