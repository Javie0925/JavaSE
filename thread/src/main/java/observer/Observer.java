package observer;

/**
 * @author javie
 * @date 2019/7/30 14:05
 */
public abstract class Observer {

    protected Subject subject;

    public Observer(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();
}
