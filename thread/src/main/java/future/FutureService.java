package future;

import java.util.function.Consumer;

/**
 * @author javie
 * @date 2019/7/30 20:25
 */
public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer){
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(()->{
            T result = task.call();
            asynFuture.done(result);
            consumer.accept(result);
        }).start();
        return asynFuture;
    }
}
