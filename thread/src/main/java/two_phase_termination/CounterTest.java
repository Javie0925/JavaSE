package two_phase_termination;

/**
 * @author javie
 * @date 2019/7/31 22:43
 */
public class CounterTest {

    public static void main(String[] args) throws InterruptedException {
        CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();
        Thread.sleep(5_000);
        counterIncrement.close();
    }
}
