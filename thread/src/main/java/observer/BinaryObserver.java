package observer;

/**
 * @author javie
 * @date 2019/7/30 14:11
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal String:"+Integer.toOctalString(subject.getState()));
    }
}
