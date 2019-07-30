package read_write_lock;

import java.util.Arrays;

/**
 * @author javie
 * @date 2019/7/30 17:24
 */
public class SharedData {

    private final char[] buffer;

    private final ReadWriteLock lock = new ReadWriteLock();

    public SharedData(int size) {
        this.buffer = new char[size];
        for(int i=0;i<size;i++){
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        try{
            lock.readLock();
            return doRead();
        }finally {
            lock.readUnlock();
        }
    }

    private char[] doRead() {
        char[] newBuffer = Arrays.copyOf(buffer, buffer.length);
        slowly(50);
        return newBuffer;
    }

    public void write(char c) throws InterruptedException {
        try{
            lock.writeLock();
            this.doWrite(c);
        }finally {
            lock.writeUnlock();
        }
    }

    private void doWrite(char c) {
        for (int i=0;i<buffer.length;i++){
            buffer[i] = c;
            slowly(10);
        }
    }

    private void slowly(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
