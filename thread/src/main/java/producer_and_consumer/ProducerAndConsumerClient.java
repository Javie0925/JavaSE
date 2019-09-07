package producer_and_consumer;

import java.util.stream.IntStream;

/**
 * @author javie
 * @date 2019/7/31 20:29
 */
public class ProducerAndConsumerClient {

    public static void main(String[] args) {
        MessageQuene quene = new MessageQuene();
        new ProducerThread(quene,1).start();
        new ProducerThread(quene,2).start();
        new ConsumerThread(quene,1).start();
        new ConsumerThread(quene,2).start();
        new ConsumerThread(quene,3).start();
    }
}
