package observer;

/**
 * @author javie
 * @date 2019/7/30 14:16
 */
public class ObserClient {

    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);

        subject.setState(10);
        subject.setState(5);
        subject.setState(0);
    }
}
