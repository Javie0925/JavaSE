package producer_and_consumer;

/**
 * @author javie
 * @date 2019/7/31 17:03
 */
public class Message {

    private String data;

    public Message(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
