package JDKCountDown;

/**
 * @author javie
 * @date 2019/7/31 20:54
 */
public class MyCountDown {

    private final int total;

    private int counter = 0;

    public MyCountDown(int total) {
        this.total = total;
    }

    public void down(){
        synchronized (this){
            this.counter++;
            notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this){
            while (this.counter != total){
                this.wait();
            }
        }
    }
}
