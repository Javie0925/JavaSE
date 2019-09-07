package active_object;

/**
 * @author javie
 * @date 2019/8/1 12:25
 */

/**
 * {@link ActiveObject#makeString(int, char)}
 */
public class MakeStringRequest extends MethodRequest {

    private final int count;

    private final char fillChar;

    public MakeStringRequest(Servant servant, FutureResult futureRequest,int count,char fillChar) {
        super(servant, futureRequest);
        this.count = count;
        this.fillChar = fillChar;

    }

    @Override
    public void execute() {
        Result result = servant.makeString(count, fillChar);
        futureRequest.setResult(result);
    }
}
