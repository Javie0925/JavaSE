package observer;

/**
 * @author javie
 * @date 2019/7/30 14:22
 */
public abstract class ObserverableRunnable implements Runnable {

    protected LifeCycleListener listener;


    public ObserverableRunnable(final LifeCycleListener listener){
        this.listener = listener;
    }

    protected void notifyChange(final RunnableEvent event){
        listener.onEvent(event);
    }

    public enum RunnableState{
        RUNNING,ERROR,DONE;
    }

    public static class RunnableEvent{
        private final RunnableState state;

        private final Thread thread;

        private final Throwable throwable;

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return throwable;
        }

        public RunnableEvent(RunnableState state, Thread thread, Throwable throwable) {
            this.state = state;
            this.thread = thread;
            this.throwable = throwable;
        }
    }
}
