package active_object;

/**
 * @author javie
 * @date 2019/8/1 13:58
 */

public final class ActiveObjectFactory {

    public ActiveObjectFactory() {

    }

    public static ActiveObject createActiveObject(){
        Servant servant = new Servant();
        ActivationQuene activationQuene = new ActivationQuene();
        SchedulerThread schedulerThread = new SchedulerThread(activationQuene);
        ActiveObjectProxy activeObjectProxy = new ActiveObjectProxy(schedulerThread, servant);
        schedulerThread.start();
        return activeObjectProxy;
    }
}
