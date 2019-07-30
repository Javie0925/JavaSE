package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author javie
 * @date 2019/7/30 14:02
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        if (state==this.state)
            return;
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    private void notifyAllObservers(){
        observers.stream().forEach(Observer::update);
    }
}
