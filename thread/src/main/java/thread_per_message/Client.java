package thread_per_message;

import java.util.stream.IntStream;

/**
 * @author javie
 * @date 2019/7/31 21:24
 */
public class Client {

    public static void main(String[] args) {
        MessageHandler handler = new MessageHandler();
        IntStream.rangeClosed(1, 10).forEach(i->{
            handler.request(new Message(i+""));
        });

        handler.shutDown();
    }
}
