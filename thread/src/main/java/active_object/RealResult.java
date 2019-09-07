package active_object;

/**
 * @author javie
 * @date 2019/8/1 11:53
 */
public class RealResult implements Result {

    private final Object resultVlue;

    public RealResult(Object resultVlue) {
        this.resultVlue = resultVlue;
    }

    @Override
    public Object getResultValue() {
        return resultVlue;
    }


}
