package active_object;

/**
 * @author javie
 * @date 2019/8/1 1:22
 */

/**
 * 对应ActiveObject每一个方法
 */
public abstract class MethodRequest {

    protected final Servant servant;

    protected final FutureResult futureRequest;

    public MethodRequest(Servant servant, FutureResult futureRequest) {
        this.servant = servant;
        this.futureRequest = futureRequest;
    }

    public abstract void execute();
}
