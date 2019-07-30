package observer;

import java.util.List;

/**
 * @author javie
 * @date 2019/7/30 15:03
 */
public class ThreadLifeCycleObserver implements LifeCycleListener {

    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids){
        if (ids==null || ids.isEmpty()){
            return;
        }
        ids.stream().forEach(id->new Thread(new ObserverableRunnable(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RunnableState.RUNNING,Thread.currentThread(),null));
                    System.out.println("query for the id:"+id);
                    int i = 10/0;
                    notifyChange(new RunnableEvent(RunnableState.DONE,Thread.currentThread(),null));
                }catch (Exception e){
                    notifyChange(new RunnableEvent(RunnableState.ERROR,Thread.currentThread(),e));
                }
            }
        },id).start());
    }

    @Override
    public void onEvent(ObserverableRunnable.RunnableEvent event) {
        synchronized (LOCK){
            System.out.println("The runnable ["+event.getThread().getName()+"] date changed and state is ["+event.getState()+"]" );
            if (event.getCause()!=null){
                System.out.println("The runnable ["+event.getThread().getName()+"] process failed." );
                event.getCause().printStackTrace();
            }
        }
    }
}

