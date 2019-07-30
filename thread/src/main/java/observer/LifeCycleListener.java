package observer;

/**
 * @author javie
 * @date 2019/7/30 14:28
 */
public interface LifeCycleListener {

    void onEvent(ObserverableRunnable.RunnableEvent event);

}
