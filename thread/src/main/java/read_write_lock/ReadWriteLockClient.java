package read_write_lock;

/**
 * @author javie
 * @date 2019/7/30 18:02
 */
public class ReadWriteLockClient {

    public static void main(String[] args) {
        final SharedData sharedData = new SharedData(10);
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        //---------------------------
        new WriteWorker(sharedData,"qwertyuiop").start();
        new WriteWorker(sharedData,"QWERTYUIOP").start();
    }
}
