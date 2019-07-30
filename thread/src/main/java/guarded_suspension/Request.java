package guarded_suspension;

/**
 * @author javie
 * @date 2019/7/30 21:38
 */
public class Request {
    final private String value;

    public Request(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
