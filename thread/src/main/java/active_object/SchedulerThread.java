package active_object;

/**
 * @author javie
 * @date 2019/8/1 13:48
 */
public class SchedulerThread extends Thread {

    private final ActivationQuene activationQuene;

    public SchedulerThread(ActivationQuene activationQuene) {
        this.activationQuene = activationQuene;
    }

    public void invoke(MethodRequest request){
        this.activationQuene.put(request);
    }

    @Override
    public void run() {
        while (true){
            activationQuene.take().execute();
        }
    }
}
